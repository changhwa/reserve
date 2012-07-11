package com.test.reserve.inform.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.inform.dao.AirportDao;
import com.narratage.reserve.inform.dao.AirportDistanceDao;
import com.narratage.reserve.inform.dao.CommonDao;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.domain.Airport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/narratage/reserve/inform/test-applicationContext.xml")
public class AirlineScheduleServiceImplTest {
	@Autowired
	AirportDao airportDao;
	@Autowired
	AirportDistanceDao airportDistanceDao;
	@Autowired
	CommonDao commonDao;

	Airport[] airports;
	AirlineSchedule[] schedules;

	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd hhmm");
	ArrayList<AirlineSchedule> scList;

	@Before
	public void setUp() throws ParseException {
		this.airports = new Airport[7];
		this.airports[0] = new Airport("ICN", "Seoul", "South Korea", 37.469075, 126.450517, 23, 9, "U", 0);
		this.airports[1] = new Airport("NRT", "Tokyo", "Japan	", 35.764722, 140.386389, 141, 9, "U", 0);
		this.airports[2] = new Airport("LAX", "Los Angeles", "United States", 33.942536, -118.408075, 126, -8, "A", 0);
		this.airports[3] = new Airport("LBG", "Paris", "France", 48.969444, 2.441389, 218, 1, "E", 0);
		this.airports[4] = new Airport("LTN", "London", "United Kingdom", 51.874722, -0.368333, 526, 0, "E", 0);
		this.airports[5] = new Airport("DEL", "Delhi", "India", 28.5665, 77.103088, 777, 5.5f, "N", 0);
		this.airports[6] = new Airport("CAI", "Cairo", "Egypt", 30.121944, 31.405556, 382, 2, "U", 0);

		scList = new ArrayList<AirlineSchedule>();
		// 인천->도쿄
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120711 0600"), df.parse("20120711 0830"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120711 1600"), df.parse("20120711 1830"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120712 0600"), df.parse("20120712 0830"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120712 1600"), df.parse("20120712 1830"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120713 0600"), df.parse("20120713 0830"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120713 1600"), df.parse("20120713 1830"), "500", 5000));
		// 도쿄->인천
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120711 0600"), df.parse("20120711 0830"), "500", 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120711 1600"), df.parse("20120711 1830"), "500", 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120712 0600"), df.parse("20120712 0830"), "500", 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120712 1600"), df.parse("20120712 1830"), "500", 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120713 0600"), df.parse("20120713 0830"), "500", 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120713 1600"), df.parse("20120713 1830"), "500", 5000));
		// 파리->인천
		scList.add(new AirlineSchedule("LBG", "ICN", df.parse("20120711 0700"), df.parse("20120711 1710"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "ICN", df.parse("20120712 0700"), df.parse("20120712 1710"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "ICN", df.parse("20120713 0700"), df.parse("20120713 1710"), "500", 5000));
		// 인천->파리
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120710 2030"), df.parse("20120711 1040"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120711 2030"), df.parse("20120712 1040"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120712 2030"), df.parse("20120713 1040"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120713 2030"), df.parse("20120714 1040"), "500", 5000));
		// 런던->인천
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120710 1100"), df.parse("20120710 2300"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120712 1100"), df.parse("20120712 2300"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120711 1100"), df.parse("20120711 2300"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120713 1100"), df.parse("20120713 2300"), "500", 5000));
		// 파리->카이로
		scList.add(new AirlineSchedule("LBG", "CAI", df.parse("20120712 1420"), df.parse("20120712 1810"), "500", 5000));
		// 카이로->파리
		scList.add(new AirlineSchedule("CAI", "LBG", df.parse("20120711 0800"), df.parse("20120711 1150"), "500", 5000));
		// 파리->델리
		scList.add(new AirlineSchedule("LBG", "DEL", df.parse("20120710 1220"), df.parse("20120710 1830"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "DEL", df.parse("20120712 1220"), df.parse("20120712 1830"), "500", 5000));
		// 델리->파리
		scList.add(new AirlineSchedule("DEL", "LBG", df.parse("20120711 0850"), df.parse("20120712 1500"), "500", 5000));
		scList.add(new AirlineSchedule("DEL", "LBG", df.parse("20120713 0850"), df.parse("20120713 1500"), "500", 5000));
		// 런던->파리
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120711 0900"), df.parse("20120711 1030"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120711 1400"), df.parse("20120711 1530"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120711 1700"), df.parse("20120711 1830"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120712 0900"), df.parse("20120712 1030"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120712 1400"), df.parse("20120712 1530"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120712 1700"), df.parse("20120712 1830"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120713 0900"), df.parse("20120713 1030"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120713 1400"), df.parse("20120713 1530"), "500", 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120713 1700"), df.parse("20120713 1830"), "500", 5000));
		// 파리->런던
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120711 0820"), df.parse("20120711 0950"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120711 1320"), df.parse("20120711 1450"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120711 1620"), df.parse("20120711 1750"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120712 0820"), df.parse("20120712 0950"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120712 1320"), df.parse("20120712 1450"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120712 1620"), df.parse("20120712 1750"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120713 0820"), df.parse("20120713 0950"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120713 1320"), df.parse("20120713 1450"), "500", 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120713 1620"), df.parse("20120713 1750"), "500", 5000));
		// 인천->델리
		scList.add(new AirlineSchedule("ICN", "DEL", df.parse("20120711 1200"), df.parse("20120711 1800"), "500", 5000));
		scList.add(new AirlineSchedule("ICN", "DEL", df.parse("20120713 1200"), df.parse("20120713 1800"), "500", 5000));
		// 델리->인천
		scList.add(new AirlineSchedule("DEL", "ICN", df.parse("20120710 0800"), df.parse("20120710 1400"), "500", 5000));
		scList.add(new AirlineSchedule("DEL", "ICN", df.parse("20120712 0800"), df.parse("20120712 1400"), "500", 5000));
		//카이로->도쿄
		scList.add(new AirlineSchedule("CAI", "NRT", df.parse("20120710 2000"), df.parse("20120710 0630"), "500", 5000));
		//도쿄->카이로
		scList.add(new AirlineSchedule("NRT", "CAI", df.parse("20120712 2100"), df.parse("20120712 0730"), "500", 5000));
		
	}

	@Test
	public void getAirportDistance() {
		commonDao.deleteAll("airport");
		commonDao.deleteAll("airport_distance");

		for (int idx = 0; idx < airports.length; idx++) {
			airportDao.add(airports[idx]);
		}
	}
}
