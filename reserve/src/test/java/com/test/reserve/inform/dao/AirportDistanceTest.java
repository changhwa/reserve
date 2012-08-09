package com.test.reserve.inform.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.inform.dao.AirportDistanceDao;
import com.narratage.reserve.inform.domain.AirportDistance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/narratage/reserve/inform/test-applicationContext.xml")
public class AirportDistanceTest {

	@Autowired
	AirportDistanceDao airportDistanceDao;

	private AirportDistance airportDistances[];

	@Before
	public void setUp() {
		this.airportDistances = new AirportDistance[2];
		this.airportDistances[0] = new AirportDistance("AAA", "BBB", 1234);
		this.airportDistances[1] = new AirportDistance("CCC", "DDD", 4321);
	}

	@Test
	public void addAndGet() {
		this.airportDistanceDao.add(this.airportDistances[0]);
		double getFormDaoDistance = airportDistanceDao.get(this.airportDistances[0].getFirstAirport(),
				this.airportDistances[0].getSecondAirport());
		assertThat(getFormDaoDistance, is(this.airportDistances[0].getDistance()));
	}
}
