package com.narratage.reserve.inform.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.datatype.AirportType;
import com.narratage.reserve.inform.datatype.DateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.util.Table;

public class AirlineScheduleServiceImpl5 implements AirlineScheduleService {

	public static final int LIMIT_TRANSFER_AIRPORT_NUMBER = 3;
	// 36시간 이상 걸리는 경우는 무시한다
	public static final long TRAVEL_LIMIT_DATE = 36 * 60 * 60 * 1000;
	public static final long ONE_DAY = 24 * 60 * 60 * 1000;

	// Table에서 사용되는 상수값 문자열
	private static final String PARENT_INDEX = "PARENT_INDEX";
	private static final String IATA = "IATA";
	private static final String BEGIN_LANDING_DATE = "BEGIN_LANDING_DATE";
	private static final String END_LANDING_DATE = "END_LANDING_DATE";
	private static final String WORKED = "WORKED";

	private static final int ROOT_PARENT_INDEX = Integer.MIN_VALUE;
	private AirlineScheduleDao airlineScheduleDao;

	public void setAirlineScheduleDao(AirlineScheduleDao airlineScheduleDao) {
		this.airlineScheduleDao = airlineScheduleDao;
	}

	public List<AirlineSchedule> getSortedAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate) {
		// Table class를 활용한다. Table에는 총 4개의 컬럼이 필요하다.
		// parentIndex, IATA, BeginLandingDate, EndLandingDate
		// ,해당 String값은 헷갈리기 쉬우므로 상수값으로 지정하여 사용한다.
		Table<Integer, String, Object> routeTable = new Table<Integer, String, Object>();

		int scheduleTableIndex = 0;

		routeTable.put(scheduleTableIndex, PARENT_INDEX, ROOT_PARENT_INDEX);
		routeTable.put(scheduleTableIndex, IATA, toAirportIATA);
		routeTable.put(scheduleTableIndex, BEGIN_LANDING_DATE, startArriveDate);
		routeTable.put(scheduleTableIndex, END_LANDING_DATE, endArriveDate);
		routeTable.put(scheduleTableIndex, WORKED, false);

		// 반복문을 실행하는 동안 아래에 있는 변수명들을 사용한다.
		int tmpParentIndex, tmpIndex;
		String tmpIATA;
		Date tmpBeginDate, tmpEndDate;
		HashMap<String, List<AirlineSchedule>> tmpScheduleMap = new HashMap<String, List<AirlineSchedule>>();

		// List 정렬을 위한 Comparator<T> 정의
		Comparator<AirlineSchedule> scheduleComparator = new Comparator<AirlineSchedule>() {
			public int compare(AirlineSchedule schedule1, AirlineSchedule schedule2) {
				if (schedule1.getTakeOffDate().getTime() >= schedule2.getTakeOffDate().getTime())
					return -1;
				else
					return 1;
			}
		};

		for (int routeIndex = 0; routeIndex < 15; routeIndex++) {
			tmpIndex = scheduleTableIndex;
			tmpParentIndex = (Integer) routeTable.get(routeIndex, PARENT_INDEX);
			tmpIATA = (String) routeTable.get(routeIndex, IATA);
			tmpBeginDate = (Date) routeTable.get(routeIndex, BEGIN_LANDING_DATE);
			tmpEndDate = (Date) routeTable.get(routeIndex, END_LANDING_DATE);

			List<AirlineSchedule> tmpSchedule = airlineScheduleDao.get(AirportType.LANDING, DateType.LANDING, tmpIATA,
					tmpBeginDate, tmpEndDate);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			for(AirlineSchedule s : tmpSchedule){
				System.out.println(s);
			}
			// 결과값을 분류한다.
			tmpScheduleMap.clear();
			tmpScheduleMap = new HashMap<String, List<AirlineSchedule>>();
			for (AirlineSchedule schedule : tmpSchedule) {
				if (!tmpScheduleMap.containsKey(schedule.getTakeOffAirport())) {
					tmpScheduleMap.put(schedule.getTakeOffAirport(), new ArrayList<AirlineSchedule>());
				}
				tmpScheduleMap.get(schedule.getTakeOffAirport()).add(schedule);
			}

			Iterator<String> iter = tmpScheduleMap.keySet().iterator();

			// 부모에 있는 parentIndex들을 체크하여 List에 저장한다.
			List<String> parentsIndexList = new LinkedList<String>();
			parentsIndexList.add(0, tmpIATA);
			int parentIndex = tmpParentIndex;

			while (parentIndex != ROOT_PARENT_INDEX) {
				parentsIndexList.add(0, (String) routeTable.get(parentIndex, IATA));
				parentIndex = (Integer) routeTable.get(tmpParentIndex, PARENT_INDEX);
			}

			// 정상적으로 부모값을 찾아오는지 검증!! 리팩토링하면서 변경 필요
			System.out.println("=======================");
			System.out.println("현재 공항 : " + tmpIATA);
			for (String Iata : parentsIndexList) {
				System.out.println("부모 공항 : " + Iata);
			}
			
			System.out.println("=======================");

			String iteratedIata;
			while (iter.hasNext()) {
				iteratedIata = iter.next();
				// 부모값을 체크하여 이미 한번 거쳤던 공항과 현재 공항이 출발공항일 경우 더이상 길찾기를 진행하지 않도록 한다.
				System.out.println("iteratedIata.equals(fromAirportIATA) : "+ iteratedIata.equals(fromAirportIATA));
				System.out.println("parentsIndexList.contains(iteratedIata))  : "+ parentsIndexList.contains(iteratedIata));
				System.out.println(((iteratedIata.equals(fromAirportIATA) || parentsIndexList.contains(iteratedIata)) == false));
				if (parentsIndexList.contains(iteratedIata) == false) {
					List<AirlineSchedule> tmpInnerScheduleList = tmpScheduleMap.get(iteratedIata);
					
					System.out.println("-------------------------------------------");
					for(AirlineSchedule schedule : tmpInnerScheduleList){
						System.out.println(schedule);
					}
					
					Collections.sort(tmpInnerScheduleList, scheduleComparator);

					scheduleTableIndex += 1;
					// 정렬 뒤 각각의 값에서 나온값을 바탕으로 계층구조 Table에 값을 넣어준다.
					routeTable.put(scheduleTableIndex, PARENT_INDEX, tmpIndex);
					routeTable.put(scheduleTableIndex, IATA, iteratedIata);
					routeTable.put(scheduleTableIndex, BEGIN_LANDING_DATE, new Date(startArriveDate.getTime()
							- TRAVEL_LIMIT_DATE));
					routeTable.put(scheduleTableIndex, END_LANDING_DATE,
							tmpInnerScheduleList.get(tmpInnerScheduleList.size() - 1).getLandingDate());
						
				}
			}
			// 작업이 완료된 뒤 WORKED컬럼값을 TRUE로 변경하여준다.
			routeTable.put(scheduleTableIndex, WORKED, true);
		}
		
		// 최종검증
		System.out.println("========================================");
		for (int idx = 0; idx < routeTable.rowSize(); idx++) {
			System.out.println(idx + " IATA=" + (String) routeTable.get(idx, IATA) + " 출발시간="
					+ (Date) routeTable.get(idx, BEGIN_LANDING_DATE) + " 도착시간="
					+ (Date) routeTable.get(idx, END_LANDING_DATE));
		}

		return null;
	}
}