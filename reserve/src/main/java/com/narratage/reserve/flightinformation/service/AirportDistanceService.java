package com.narratage.reserve.flightinformation.service;

public interface AirportDistanceService {
	/*
	 * DB SELECT를 통해 해당 값이 있는지 조회한다. 조회가 되었을 경우 Airport 테이블의 조회 횟수에 +1씩을 해준다.
	 * 조회가 많이 되면 될수록 공항검색에서 나올 가능성이 높아진다.(모든 공항을 보여주면 가독성이 낮아지므로 자주 검색되는 공항만을
	 * 출력하여 주자.)
	 */
	public double getAirportDistance(String IATA01, String IATA02);
}
