package com.narratage.reserve.inform.dao;

import java.util.Date;
import java.util.List;

import com.narratage.reserve.inform.datatype.AirportType;
import com.narratage.reserve.inform.datatype.DateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;

/**
 * 항공운항정보를 가져오거나 입력합니다.
 * 
 * @author StevePak
 * 
 */
public interface AirlineScheduleDao {
	/**
	 * 하나의 공항을 기준으로 하는 기준 시간 내 모든 운항정보 리스트를 가져옵니다.
	 * 
	 * @param airportType
	 *            이륙공항 착륙공항 기준 선택
	 * @param dateType
	 *            이륙시간 착륙시간 기준 선택
	 * @param airportIATA
	 *            기준공항
	 * @param beginDate
	 *            기준 시작 시간
	 * @param endDate
	 *            기준 종료 시간
	 * @return
	 */
	public List<AirlineSchedule> get(AirportType airportType,
			DateType dateType, String airportIATA, Date beginDate, Date endDate);

	/**
	 * 두개의 공항을 기준으로 하는 기준 시간 내 모든 운항정보 리스트를 가져옵니다.
	 * 
	 * @param dateType
	 *            이륙시간 착륙시간 기준 선택
	 * @param takeOffAirport
	 *            이륙 공항
	 * @param landingAirport
	 *            착륙공항
	 * @param beginDate
	 *            기준 시작시간
	 * @param endDate
	 *            기준 종료시간
	 * @return
	 */
	public List<AirlineSchedule> get(DateType dateType,
			String takeOffAirport, String landingAirport, Date beginDate, Date endDate);

	/**
	 * 항공스케줄 추가
	 * 
	 * @param airlineSchedule
	 */
	public void add(AirlineSchedule airlineSchedule);

}
