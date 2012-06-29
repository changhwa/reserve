package com.narratage.reserve.flightinformation.service;

import java.util.Arrays;

import com.narratage.reserve.flightinformation.dao.AirportDao;
import com.narratage.reserve.flightinformation.dao.AirportDistanceDao;
import com.narratage.reserve.flightinformation.domain.Airport;

public class AirportDistanceServiceImpl implements AirportDistanceService {
	private final static int NOT_EXIST_AIRPORT_DISTANCE = -999;

	private AirportDistanceDao airportDistanceDao;
	private AirportDao airportDao;

	public void setAirportDistanceDao(AirportDistanceDao airportDistanceDao) {
		this.airportDistanceDao = airportDistanceDao;
	}

	public void setAirportDao(AirportDao airportDao) {
		this.airportDao = airportDao;
	}

	public double getAirportDistance(String IATA01, String IATA02) {
		// 검색이 제대로 되지 않았을 경우를 대비하여 트랜잭션을 걸어주는게 옳바른 방법인가에 대한 고찰
		// 검색을 많이했다 여부만 체크하기 떄문에, 트랜잭션이 크게 문제될것은 없음
		String[] IATAs = new String[] { IATA01, IATA02 };
		Arrays.sort(IATAs);
		double distance = getDistanceFromDB(IATAs);

		// 값이 존재하지 않을경우 거리를 직접 계산한 뒤 distance를 넣어준다.
		if (distance == NOT_EXIST_AIRPORT_DISTANCE)
			distance = calcDistance(IATAs);

		// 해당 도시의 검색횟수를 하나씩 늘려준다.
		airportDao.updatePlusOneAtQueriedNumber(IATAs[0]);
		airportDao.updatePlusOneAtQueriedNumber(IATAs[1]);

		// 거리값 리턴
		return distance;
	}

	private double getDistanceFromDB(String[] IATAs) {
		// 가독성이 떨어지는 try catch 문장을 따로 처리하여 주자.
		try {
			return airportDistanceDao.getDistance(IATAs[0], IATAs[1]);
			// 테스트를 통해 실제 어떠한 예외가 나오는지 확인해야함.
		} catch (Exception e) {
			return NOT_EXIST_AIRPORT_DISTANCE;
		}
	}

	private double calcDistance(String[] IATAs) {
		// DB에서 두 도시의 정보를 가져온다.
		Airport[] Airports = new Airport[] { airportDao.getAirportInfo(IATAs[0]), airportDao.getAirportInfo(IATAs[1]) };
		double distance = calcDistanceByGeolocation(Airports[0].getLatitude(), Airports[0].getLongtitude(),
				Airports[1].getLatitude(), Airports[1].getLongtitude());
		// 거리정보를 실제 DB에 저장한다. 중복되는 데이터를 없애기 위해 IATA코드를 알파벳순으로 정렬한 뒤 넣어준다.

		airportDistanceDao.addDistance(IATAs[0], IATAs[1], distance);
		return distance;
	}

	public double calcDistanceByGeolocation(double lat1, double long1, double lat2, double long2) {
		double dDistance = Double.MIN_VALUE;
		double dLat1InRad = lat1 * (Math.PI / 180.0);
		double dLong1InRad = long1 * (Math.PI / 180.0);
		double dLat2InRad = lat2 * (Math.PI / 180.0);
		double dLong2InRad = long2 * (Math.PI / 180.0);

		double dLongitude = dLong2InRad - dLong1InRad;
		double dLatitude = dLat2InRad - dLat1InRad;

		double a = Math.pow(Math.sin(dLatitude / 2.0), 2.0) + Math.cos(dLat1InRad) * Math.cos(dLat2InRad)
				* Math.pow(Math.sin(dLongitude / 2.0), 2.0);

		double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));

		Double kEarthRadiusKms = 6376.5;
		dDistance = kEarthRadiusKms * c;

		return dDistance;
	}
}
