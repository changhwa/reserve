package com.narratage.reserve.inform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.datatype.SearchAirportType;
import com.narratage.reserve.inform.datatype.SearchDateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.util.Table;

public class AirlineScheduleServiceImpl implements AirlineScheduleService {

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

		ArrayList<IataDateStorage> fromAirportList = new ArrayList<IataDateStorage>();
		ArrayList<IataDateStorage> toAirportList = new ArrayList<IataDateStorage>();

		ArrayList<AirlineSchedule> scheuleResultList = new ArrayList<AirlineSchedule>();

		// 가장 처음 출발공항은 한개
		fromAirportList
				.add(new IataDateStorage(fromAirportIATA, new Date(endArriveDate.getTime() - TRAVEL_LIMIT_DATE)));
		// 가장 처음 도착공항은 한개
		toAirportList.add(new IataDateStorage(toAirportIATA, endArriveDate));

		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		List<AirlineSchedule> scheduleList = new ArrayList<AirlineSchedule>();
		// 첫번째는 도착공항을 기준으로 값을 조회한다. 24시간 이내의 값만을 조회한다.
		for (int i = 0; i <= fromAirportList.size(); i++) {
			airlineScheduleDao.get(SearchAirportType.LANDING, SearchDateType.LANDING, toAirportList.get(i).getIata(),
					new Date(toAirportList.get(i).getDate().getTime() - ONE_DAY), toAirportList.get(i).getDate());
		}

		// 첫번째 읽어온 값들을 Table클래스에 쌓아둔다.
		for (AirlineSchedule schedule : scheduleList) {
			scheduleTable.put(schedule.getTakeOffAirport(), schedule.getLandingAirport(), schedule);
			System.out.println(schedule);
		}

		// table에서 옳바른 경로값이 나왔는지 여부를 판별하고, 만약 있으면 결과List에 넣는다.
		List<AirlineSchedule> tmpSchedules;
		for (int i = 0; i < fromAirportList.size(); i++) {
			for (int j = 0; j < toAirportList.size(); j++) {
				tmpSchedules = scheduleTable.get(fromAirportList.get(i).getIata(), toAirportList.get(j).getIata());
				scheuleResultList.addAll(tmpSchedules);
				for (AirlineSchedule airlineSchedule : tmpSchedules) {
					System.out.println(airlineSchedule);
				}
			}
		}

		// 완료되었으면 1번경유하는 루트를 찾도록 하자.

		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		return null;
	}

	/*
	 * private class AdvancedAirlineSchedule { HashMap<String[],
	 * List<AirlineSchedule>> coreScheduleList;
	 * 
	 * public AdvancedAirlineSchedule() { this.coreScheduleList = new
	 * HashMap<String[], List<AirlineSchedule>>(); }
	 * 
	 * public void put(List<AirlineSchedule> scheduleList) { for
	 * (AirlineSchedule schedule : scheduleList) { if (coreScheduleList.contain
	 * sKey(new String[2] { schedule.getTakeOffAirport(),
	 * schedule.getLandingAirport() })) {
	 * 
	 * } } }
	 * 
	 * public void get() { List<AirlineSchedule> tmpScheduleList =
	 * airlineScheduleDao.get(ScheduleSearchAirportType.TAKE_OFF_AIRPORT,
	 * ScheduleSearchDateType.TAKE_OFF_DATE, fromAirportIATA, new
	 * Date(endArriveDate.getTime() - TRAVEL_LIMIT_HOUR), endArriveDate); } }
	 */

	private class IataDateStorage {
		String iata;
		Date date;

		public IataDateStorage(String iata, Date date) {
			super();
			this.iata = iata;
			this.date = date;
		}

		public String getIata() {
			return iata;
		}

		public void setIata(String iata) {
			this.iata = iata;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

	}
}