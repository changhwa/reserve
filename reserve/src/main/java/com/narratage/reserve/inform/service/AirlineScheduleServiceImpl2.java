package com.narratage.reserve.inform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.datatype.SearchAirportType;
import com.narratage.reserve.inform.datatype.SearchDateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.util.Table;

public class AirlineScheduleServiceImpl2 implements AirlineScheduleService {

	public static final int LIMIT_TRANSFER_AIRPORT_NUMBER = 3;

	// 36시간 이상 걸리는 경우는 무시한다
	public static final long TRAVEL_LIMIT_DATE = 36 * 60 * 60 * 1000;
	public static final long ONE_DAY = 24 * 60 * 60 * 1000;

	private AirlineScheduleDao scheduleDao;

	public void setAirlineScheduleDao(AirlineScheduleDao airlineScheduleDao) {
		// micro DI

		// this.scheduleDao = new AdvancedAirlineScheduleDao();
		// scheduleDao.setAirlineScheduleDao(airlineScheduleDao);
		this.scheduleDao = airlineScheduleDao;
	}

	public List<AirlineSchedule> getSortedAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate) {

		// 도착 공항에서 시작한다.
		// 도착 공항에서는 해당 날짜에 도착할 수 있는 모든 데이터 값을 들고 오며 해당 데이터를 내부 오브젝트에 저장한다.
		scheduleDao.get(SearchAirportType.LANDING, SearchDateType.LANDING, toAirportIATA, endArriveDate, new Date(
				endArriveDate.getTime() + ONE_DAY));

		return null;
	}

	private class HierarchicalSchedules {
		private ArrayList<ArrayList<Integer>> parentsIndexList;
		private ArrayList<Date> takeOffDate;
		private ArrayList<Date> landingDate;
		private ArrayList<String> takeOffIata;
		private ArrayList<String> landingIata;
		private ArrayList<ArrayList<AirlineSchedule>> coreScheduleList;

		// 초기화
		public HierarchicalSchedules() {
			parentsIndexList = new ArrayList<ArrayList<Integer>>();
			takeOffDate = new ArrayList<Date>();
			landingDate = new ArrayList<Date>();
			takeOffIata = new ArrayList<String>();
			landingIata = new ArrayList<String>();
			coreScheduleList = new ArrayList<ArrayList<AirlineSchedule>>();
		}

		// List형태로 값을 받아들인다.
		public void putByAirlineScheduleLists(List<AirlineSchedule> list) {

		}
	}

	// DB에서 일어나는 반복적인 I/O를 줄이는게 가장 큰 목적
	// Table에 저장되어 있는 값을 확인하고 없을 경우에만 DB에 접근하여 필요값을 도출
	// 핵심이 아닌내용 차후 리팩토링시 해당 내용을 완성한다.
	private class AdvancedAirlineScheduleDao implements AirlineScheduleDao {
		Table<String, String, AirlineSchedule> scheduleTable;
		private AirlineScheduleDao airlineScheduleDao;

		public AdvancedAirlineScheduleDao() {
			scheduleTable = new Table<String, String, AirlineSchedule>();
		}

		public void setAirlineScheduleDao(AirlineScheduleDao airlineScheduleDao) {
			this.airlineScheduleDao = airlineScheduleDao;
		}

		public List<AirlineSchedule> get(SearchAirportType airportType, SearchDateType dateType, String airportIATA,
				Date beginDate, Date endDate) {
			List<AirlineSchedule> list = airlineScheduleDao.get(airportType, dateType, airportIATA, beginDate, endDate);
			this.tablePutByList(list);
			return list;
		}

		public List<AirlineSchedule> get(SearchDateType dateType, String takeOffAirport, String landingAirport,
				Date beginDate, Date endDate) {
			return airlineScheduleDao.get(dateType, takeOffAirport, landingAirport, beginDate, endDate);
		}

		public void add(AirlineSchedule airlineSchedule) {
			throw new RuntimeException("Unrunnable method");
		}

		public void tablePutByList(List<AirlineSchedule> scheduleList) {
			for (AirlineSchedule schedule : scheduleList)
				scheduleTable.put(schedule.getTakeOffAirport(), schedule.getLandingAirport(), schedule);
		}

	}
}