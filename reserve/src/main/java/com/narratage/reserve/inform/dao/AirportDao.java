package com.narratage.reserve.inform.dao;

import java.util.List;

import com.narratage.reserve.inform.domain.Airport;

/**
 * 공항정보를 가져오는 DAO클래스
 * 
 * @author StevePak
 **/

public interface AirportDao {
	/**
	 * @param IATA
	 *            공항코드
	 * @return 공항정보
	 */
	public Airport getAirportInfo(String IATA);

	/**
	 * 공항코드를 param값으로 받으면, 해당 공항의 검색횟수를 1씩 올립니다. 주요 곻항의 경우 조금더 자주 호출됩니다.
	 * 
	 * @param IATA
	 *            공항코드
	 */
	public void updatePlusOneAtQueriedNumber(String IATA);

	/**
	 * @param topLeftLat
	 *            직사각형 왼쪽상단의 위도
	 * @param topLeftLong
	 *            직사각형 왼쪽상단의 경도
	 * @param botRightLat
	 *            직사각형 왼쪽하단의 위도
	 * @param botRightLong
	 *            직사각형 왼쪽하단의 경도
	 * @param MaximumCitiesNumber
	 *            최대 몇개의 공항을 가져올것인가에 대한 정보
	 * @return 공항의 정보를 LIST형태로 반환합니다.
	 */
	public List<Airport> getAirports4Map(double topLeftLat, double topLeftLong, double botRightLat,
			double botRightLong, int MaximumCitiesNumber);

	/**
	 * 테스트를 위한 공항정보 추가
	 * 
	 * @param airport
	 *            공항정보
	 */
	public void addAirport(Airport airport);

}
