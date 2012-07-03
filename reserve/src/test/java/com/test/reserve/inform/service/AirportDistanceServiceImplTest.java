package com.test.reserve.inform.service;

import org.junit.Before;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.inform.dao.AirportDao;
import com.narratage.reserve.inform.dao.AirportDistanceDao;
import com.narratage.reserve.inform.dao.CommonDao;
import com.narratage.reserve.inform.domain.Airport;
import com.narratage.reserve.inform.service.AirportDistanceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/narratage/reserve/inform/test-applicationContext.xml")
public class AirportDistanceServiceImplTest {
	@Autowired
	AirportDistanceService airportDistanceService;
	@Autowired
	AirportDao airportDao;
	@Autowired
	AirportDistanceDao airportDistanceDao;
	@Autowired
	CommonDao commonDao;

	Airport[] airports;

	@Before
	public void setUp() {
		this.airports = new Airport[3];
		this.airports[0] = new Airport("ICN", "Seoul", "South Korea", 37.469075, 126.450517, 23, 9, "U", 0);
		this.airports[1] = new Airport("NRT", "Tokyo", "Japan	", 35.764722, 140.386389, 141, 9, "U", 0);
		this.airports[2] = new Airport("LAX", "Los Angeles", "United States", 33.942536, -118.408075, 126, -8, "A", 0);
	}

	@Test
	public void getAirportDistance() {
		commonDao.deleteAll("airport");
		commonDao.deleteAll("airport_distance");

		assertThat(commonDao.getCount("airport"), is(0));
		assertThat(commonDao.getCount("airport_distance"), is(0));

		for (int idx = 0; idx < airports.length; idx++) {
			airportDao.add(airports[idx]);
		}

		// 거리측정 최초 시작
		airportDistanceService.getAirportDistance(airports[0].getIata(), airports[2].getIata());
		airportDistanceService.getAirportDistance(airports[0].getIata(), airports[2].getIata());
		airportDistanceService.getAirportDistance(airports[2].getIata(), airports[0].getIata());
		// 거리측정이 옳바르게 되었는지 확인한다.(값이 0인지 아닌지만 체크한다.)
		assertThat(airportDistanceDao.get(airports[0].getIata(), airports[2].getIata()), not(0d));

		// 거리 측정이 끝난뒤 공항정보에 값을 읽었는지 여부(queried_number)가 늘어나는지 체크한다.
		assertThat(airportDao.get(airports[0].getIata()).getQueriedNumber(), is(3));
		assertThat(airportDao.get(airports[2].getIata()).getQueriedNumber(), is(3));
		
		//시작공항 도착공항이 서로 반대로 되어있어도 결과값은 동일함 count값은 하나만 나와야함
		assertThat(commonDao.getCount("airport_distance"), is(1));
	}
}
