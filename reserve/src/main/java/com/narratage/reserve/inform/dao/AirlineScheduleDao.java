package com.narratage.reserve.inform.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.narratage.reserve.inform.domain.AirlineSchedule;

/**
 * 항공운항정보를 가져오거나 입력합니다.
 * 
 * @author StevePak
 * 
 */
public interface AirlineScheduleDao {

	/**
	 * airlineScheduleNo에 대응되는 schedule정보를 가져옵니다.
	 * 
	 * @param airlineScheduleNo
	 * @return
	 */
	public AirlineSchedule get(int airlineScheduleNo);

	/**
	 * 길을찾고 해당하는 항공 스케쥴을 가져옵니다.
	 * 
	 * @param fromAirportIata
	 *            이륙공항
	 * @param toAirportIata
	 *            도착공항
	 * @param beginArriveDate
	 *            도착시작시간
	 * @param endArriveDate
	 *            도착종료시간
	 */
	public List<HashMap<String, Object>> getPath(String takeOffAirport, String landingAirport, Date beginArriveDate,
			Date endArriveDate);

	/**
	 * 항공스케줄 추가
	 * 
	 * @param airlineSchedule
	 */
	public void add(AirlineSchedule airlineSchedule);

}
