package com.narratage.reserve.inform.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.datatype.AirportType;
import com.narratage.reserve.inform.datatype.DateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.util.Table;

public class AirlineScheduleServiceImpl4 implements AirlineScheduleService {

	public static final int LIMIT_TRANSFER_AIRPORT_NUMBER = 3;

	// 36시간 이상 걸리는 경우는 무시한다
	public static final long TRAVEL_LIMIT_DATE = 36 * 60 * 60 * 1000;
	public static final long ONE_DAY = 24 * 60 * 60 * 1000;

	private AirlineScheduleDao airlineScheduleDao;

	public void setAirlineScheduleDao(AirlineScheduleDao airlineScheduleDao) {
		this.airlineScheduleDao = airlineScheduleDao;
	}

	public List<AirlineSchedule> getSortedAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate) {
		Table<String, String, AirlineSchedule> scheduleTable = new Table<String, String, AirlineSchedule>();
		List<AirlineSchedule> tmpScheduleList = new ArrayList<AirlineSchedule>();
		HashMap<String, List<AirlineSchedule>> tmpScheduleListMap = new HashMap<String, List<AirlineSchedule>>();

		// 시작은 도착공항부터
		FindScheduleList scheduleList = new FindScheduleList();
		scheduleList.add(new HierachicalStorage(0, -1, toAirportIATA, startArriveDate, endArriveDate));

		// DB에서 값을 읽어오며, 해당값을 직접 구현한 Table에 넣는다.
		tmpScheduleList = airlineScheduleDao.get(AirportType.LANDING, DateType.LANDING, toAirportIATA, startArriveDate,
				endArriveDate);
		for (AirlineSchedule schedule : tmpScheduleList) {
			
		}

		return null;
	}

	private class FindScheduleList extends ArrayList<HierachicalStorage> {
		@Override
		public boolean add(HierachicalStorage e) {
			super.add(e);
			Collections.sort(this, new Comparator<HierachicalStorage>() {
				public int compare(HierachicalStorage o1, HierachicalStorage o2) {
					if (o1.getLandingDate().getTime() >= o2.getLandingDate().getTime())
						return -1;
					else
						return 1;
				}
			});
			return true;
		}

		public List<Integer> getParentCodeList(int index) {
			int tmpParentIndex = -1;
			List<Integer> returnList = new ArrayList<Integer>();
			do {
				tmpParentIndex = this.get(index).getParentKey();
				returnList.add(tmpParentIndex);
			} while (tmpParentIndex != -1);
			return returnList;
		}

	}

	private class HierachicalStorage {
		int key;
		int parentKey;
		String iata;
		Date takeOffDate;
		Date landingDate;

		public HierachicalStorage(int key, int parentKey, String iata, Date takeOffDate, Date landingDate) {
			super();
			this.parentKey = parentKey;
			this.iata = iata;
			this.takeOffDate = takeOffDate;
			this.landingDate = landingDate;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public String getIata() {
			return iata;
		}

		public void setIata(String iata) {
			this.iata = iata;
		}

		public Date getTakeOffDate() {
			return takeOffDate;
		}

		public void setTakeOffDate(Date takeOffDate) {
			this.takeOffDate = takeOffDate;
		}

		public Date getLandingDate() {
			return landingDate;
		}

		public void setLandingDate(Date landingDate) {
			this.landingDate = landingDate;
		}

		public int getParentKey() {
			return parentKey;
		}

		public void setParentKey(int parentIdx) {
			this.parentKey = parentIdx;
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

		public List<AirlineSchedule> get(AirportType airportType, DateType dateType, String airportIATA,
				Date beginDate, Date endDate) {
			List<AirlineSchedule> list = airlineScheduleDao.get(airportType, dateType, airportIATA, beginDate, endDate);
			this.tablePutByList(list);
			return list;
		}

		public List<AirlineSchedule> get(DateType dateType, String takeOffAirport, String landingAirport,
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