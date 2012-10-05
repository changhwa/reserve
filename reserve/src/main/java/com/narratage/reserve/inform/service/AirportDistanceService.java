package com.narratage.reserve.inform.service;

/**
 * 거리를 구하는 서비스
 * 
 * @author StevePak
 * 
 */
public interface AirportDistanceService {

	/**
	 * DB SELECT를 통해 해당 값이 있는지 조회한다. 조회가 되었을 경우 Airport 테이블의 조회 횟수에 +1씩을 해준다.
	 * 
	 * @param IATA01
	 *            시작공항
	 * @param IATA02
	 *            종료공항
	 * @return 거리
	 */
	public double getAirportDistance(String IATA01, String IATA02);
}
