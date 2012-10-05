package com.narratage.reserve.inform.dao;

import com.narratage.reserve.inform.domain.AirportDistance;

public interface AirportDistanceDao {
	/**
	 * 두개 공항 사이의 거리를 반환합니다.
	 * 
	 * @param IATA01
	 *            첫번쨰 공항의 IATA
	 * @param IATA02
	 *            두번쨰 공항의 IATA
	 * @return double 거리
	 */
	public double get(String IATA01, String IATA02);

	/**
	 * 두 공항사이의 거리를 입력합니다.
	 * 
	 * @param airportDistance
	 *            도메인
	 */
	public void add(AirportDistance airportDistance);

}
