package com.narratage.reserve.flightinformation.dao;

import java.util.Date;
import java.util.List;

import com.narratage.reserve.flightinformation.domain.AirlineSchedule;

/**
 * 항공운항정보를 가져오거나 입력합니다.
 * 
 * @author StevePak
 * 
 */
public interface AirlineScheduleDao {

	/**
	 * 출발지 공항에서 갈 수 있는 모든 스케쥴중 도착기준 시간 안에 있는 정보를 가져옵니다.
	 * 
	 * @param fromAirpotIATA
	 *            출발공항
	 * @param startArriveDate
	 *            도착기준 시작시간
	 * @param endArriveDate
	 *            도착기준 종료시간
	 * @return
	 */
	public List<AirlineSchedule> getFromAirportAirlineScheduleList(String fromAirpotIATA, Date startArriveDate,
			Date endArriveDate);

	/**
	 * 도착지 공항으로 올 수 있는 모든 스케쥴중 도착기준 시간 안에 있는 정보를 가져옵니다.
	 * 
	 * @param toAirportIATA
	 *            도착공항
	 * @param startArriveDate
	 *            도착기준 시작시간
	 * @param endArriveDate
	 *            도착기준 종료시간
	 * @return
	 */
	public List<AirlineSchedule> getToAirportAirlineScheduleList(String toAirportIATA, Date startArriveDate,
			Date endArriveDate);

	/**
	 * 출발지 공항과 도착지 공항, 도착기준 시간안을 만족하는 모든 스케쥴을 반환합니다.
	 * 
	 * @param fromAirportIATA
	 * @param toAirportIATA
	 * @param startArriveDate
	 * @param endArriveDate
	 * @return
	 */
	public List<AirlineSchedule> getDirectAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate);
}
