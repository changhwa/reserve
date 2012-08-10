package com.narratage.reserve.inform.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.datatype.AirportType;
import com.narratage.reserve.inform.datatype.DateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.util.Table;

@Service("AirlineScheduleService")
public class AirlineScheduleServiceImpl5 implements AirlineScheduleService {
	@Autowired
	private AirlineScheduleDao airlineScheduleDao;

	// 2번이상 비행기를 갈아타지 못하도록 한다.
	public static final int LIMIT_TRANSFER_AIRPORT_NUMBER = 2;

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

	public List<AirlineSchedule> getSortedAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate) {
		// Table class를 활용한다. Table에는 총 4개의 컬럼이 필요하다.
		// parentIndex, IATA, BeginLandingDate, EndLandingDate
		// 해당 String값은 헷갈리기 쉬우므로 상수값으로 지정하여 사용한다.
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

		int routeIndex = 0;
		boolean hasNext = true;

		while (hasNext = true) {

			// 루프문에서 임시로 사용할 변수의 값을 저장한다.
			tmpIndex = scheduleTableIndex;
			tmpParentIndex = (Integer) routeTable.get(routeIndex, PARENT_INDEX);
			tmpIATA = (String) routeTable.get(routeIndex, IATA);
			tmpBeginDate = (Date) routeTable.get(routeIndex, BEGIN_LANDING_DATE);
			tmpEndDate = (Date) routeTable.get(routeIndex, END_LANDING_DATE);

			List<AirlineSchedule> tmpSchedule = airlineScheduleDao.get(AirportType.LANDING, DateType.LANDING, tmpIATA,
					tmpBeginDate, tmpEndDate);

			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			for (AirlineSchedule s : tmpSchedule) {
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

			// 이미 공항을 한번 거쳤는지 체크한다.
			boolean isNotInParentsList = false;
			// 제한횟수보다 환승을 많이 하였는지를 체크한다.
			boolean isNotLimitTransfer = false;

			while (iter.hasNext()) {
				// 다음공항의 IATA값을 가지고 온다.
				iteratedIata = iter.next();

				// 부모값을 체크하여 이미 한번 거쳤던 공항과 현재 공항이 출발공항일 경우 더이상 길찾기를 진행하지 않도록 한다.
				if (parentsIndexList.contains(iteratedIata) == false)
					isNotInParentsList = true;
				// 환승제한보다 적게 움직였거나 환승제한일때 출발공항인 경우만 인정.
				if (parentsIndexList.size() < LIMIT_TRANSFER_AIRPORT_NUMBER
						|| (parentsIndexList.size() < LIMIT_TRANSFER_AIRPORT_NUMBER && iteratedIata
								.equals(fromAirportIATA)))

					if (parentsIndexList.contains(iteratedIata) == false) {
						List<AirlineSchedule> tmpInnerScheduleList = tmpScheduleMap.get(iteratedIata);
						System.out.println("-------------------------------------------");

						for (AirlineSchedule schedule : tmpInnerScheduleList) {
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
						routeTable.put(scheduleTableIndex, WORKED, false);

						if (iteratedIata.equals(toAirportIATA)) {
							routeTable.put(scheduleTableIndex, WORKED, true);
						}
					}
			}
			// 작업이 완료된 뒤 WORKED컬럼값을 TRUE로 변경하여준다.
			routeTable.put(routeIndex, WORKED, true);
		}

		// routeTable의 WORKED컬럼에 아직 작업하지 않은 값이 있는지 확인한다.
		if (routeTable.getByColumn(WORKED).containsValue(false) == true) {
			hasNext = true;
			// 다음에 작업할 인덱스 값을 구해준다.
			Iterator<Integer> workedKeyIter = routeTable.getByColumn(WORKED).keySet().iterator();
			int workedKey;
			Date tmpFastestDate = new Date(Long.MAX_VALUE);
			Date tmpForIterDate;
			while (workedKeyIter.hasNext()) {
				workedKey = workedKeyIter.next();
				if ((Boolean) routeTable.get(workedKey, WORKED) == false) {
					tmpForIterDate = ((Date) routeTable.get(workedKey, END_LANDING_DATE));
					if (tmpForIterDate.getTime() < tmpFastestDate.getTime()) {
						routeIndex = workedKey;
						tmpFastestDate = tmpForIterDate;
					}
				}
			}
		} else {
			hasNext = false;
		}

		// 최종검증
		System.out.println("========================================");
		for (int idx = 0; idx < routeTable.rowSize(); idx++) {
			System.out.println(idx + " IATA=" + (String) routeTable.get(idx, IATA) + " 출발시간="
					+ (Date) routeTable.get(idx, BEGIN_LANDING_DATE) + " 도착시간="
					+ (Date) routeTable.get(idx, END_LANDING_DATE));
		}
		
		
		/********************************************************************/
		/************************길찾기 완료*******************************/
		/********************************************************************/

		//routeTable에서 IATA컬럼이 출발 공항인 경우를 찾습니다.
		//routeTable.getByColumn(fromAirportIATA)
		
		//부모값을 하나씩 찾아가며 해당하는 스케쥴을 들고 오며, 해당하는 값들의 
		
		

		return null;
	}
}