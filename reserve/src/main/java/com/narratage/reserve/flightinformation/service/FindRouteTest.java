package com.narratage.reserve.flightinformation.service;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.narratage.reserve.flightinformation.domain.AirlineSchedule;
import com.narratage.reserve.flightinformation.domain.Airport;

public class FindRouteTest {
	public HashMap<String, Airport> AirportMap = new HashMap<String, Airport>();
	public HashMap<String[], AirlineSchedule> AirlineScheduleMap = new HashMap<String[], AirlineSchedule>();

	@Before
	public void setUp(){
	
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public List<AirlineSchedule> getRoute(){
		
		return null;
	}

}
