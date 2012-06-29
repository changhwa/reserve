package com.narratage.reserve.inform.service;

import java.util.List;

import com.narratage.reserve.inform.domain.Airport;

/**
 * 구글맵에서 표시될 도시를 가져오기 위해서 사용합니다. 동시에 DB에 저장된 모든 도시를 가져오는 경우 가독성이 떨어지며, DB에 지나친
 * IO를 발생시킬 가능성이 있습니다. 구글맵의 왼쪽상단의 점과 오른쪽 하단의 점2개를 통해 직사각형을 그릴 수 있고 해당 직사각형 내부의
 * 주요도시만 가져올 수 있도록 합니다. 도시들을 검색할 때 마다, 테이블의 검색횟수 컬럼이 늘어나며, 해당 횟수에 따라 우선순위를 부여한다.
 * (미구현) 몇개의 도시를 불러올건지를 정하는 부분은 XML을 이용해서, 또는 DB에 정보를 가져오는 형태로 구현합니다.
 * 
 * @author StevePak
 **/
public interface AirportService {
	public static final int MAXIMUM_CITIES_NUMBER = 20;
	/**
	 * @param topLeftLat 왼쪽상단의 위도
	 * @param topLeftLong 왼쪽상단의 경도
	 * @param botRightLat 오른쪽 하단의 위도
	 * @param botRightLong 오른쪽 하단의 경도
	 * @return 공항의 리스트를 반환합니다.
	 */
	public List<Airport> getCitiesForMap(double topLeftLat, double topLeftLong, double botRightLat, double botRightLong);
}
