package com.test.reserve.inform.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.inform.dao.AirportDao;
import com.narratage.reserve.inform.domain.Airport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/narratage/reserve/inform/test-applicationContext.xml")
public class AirportDaoTest {

	@Autowired
	AirportDao airportDao;

	private Airport airports[];

	@Before
	public void setUp() {
		this.airports = new Airport[3];
		this.airports[0] = new Airport("ICN", "Seoul", "South Korea", 37.469075, 126.450517, 23, 9, "U", 0);
		this.airports[1] = new Airport("NRT", "Tokyo", "Japan	", 35.764722, 140.386389, 141, 9, "U", 0);
		this.airports[2] = new Airport("LAX", "Los Angeles", "United States", 33.942536, -118.408075, 126, -8, "A", 0);
	}

	@Test
	public void countAndDelete() {
		airportDao.add(airports[0]);
		airportDao.add(airports[1]);
	}

	@Test
	public void getAirportInfo() {
		airportDao.add(airports[0]);
		airportDao.add(airports[1]);
		Airport getFromDaoAirport = airportDao.get(airports[0].getIata());
		simpleAirportCompare(getFromDaoAirport, airports[0]);
	}

	private void simpleAirportCompare(Airport airport1, Airport airport2) {
		assertThat(airport1.getCity(), is(airport2.getCity()));
		assertThat(airport1.getContry(), is(airport2.getContry()));
		assertThat(airport1.getLatitude(), is(airport2.getLatitude()));
		assertThat(airport1.getLongtitude(), is(airport2.getLongtitude()));
		assertThat(airport1.getAltitude(), is(airport2.getAltitude()));
		assertThat(airport1.getTimezone(), is(airport2.getTimezone()));
		assertThat(airport1.getDst(), is(airport2.getDst()));
		assertThat(airport1.getQueriedNumber(), is(airport2.getQueriedNumber()));
	}
}
