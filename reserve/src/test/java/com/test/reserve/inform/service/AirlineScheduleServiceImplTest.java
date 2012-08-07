package com.test.reserve.inform.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.dao.AirportDao;
import com.narratage.reserve.inform.dao.AirportDistanceDao;
import com.narratage.reserve.inform.dao.CommonDao;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.domain.Airport;
import com.narratage.reserve.inform.service.AirlineScheduleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/narratage/reserve/inform/test-applicationContext.xml")
public class AirlineScheduleServiceImplTest {
	@Autowired
	AirportDao airportDao;
	@Autowired
	AirportDistanceDao airportDistanceDao;
	@Autowired
	CommonDao commonDao;
	@Autowired
	AirlineScheduleDao scheduleDao;
	@Autowired
	AirlineScheduleService airlineScheduleService;

	Airport[] airports;
	AirlineSchedule[] schedules;

	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd hhmm z");
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
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120911 0600 PST"), df.parse("20120911 0830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120911 1600 PST"), df.parse("20120911 1830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120912 0600 PST"), df.parse("20120912 0830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120912 1600 PST"), df.parse("20120912 1830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120913 0600 PST"), df.parse("20120913 0830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "NRT", df.parse("20120913 1600 PST"), df.parse("20120913 1830 PST"), 1, 5000));
		// 도쿄->인천
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120911 0600 PST"), df.parse("20120911 0830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120911 1600 PST"), df.parse("20120911 1830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120912 0600 PST"), df.parse("20120912 0830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120912 1600 PST"), df.parse("20120912 1830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120913 0600 PST"), df.parse("20120913 0830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("NRT", "ICN", df.parse("20120913 1600 PST"), df.parse("20120913 1830 PST"), 1, 5000));
		// 파리->인천
		scList.add(new AirlineSchedule("LBG", "ICN", df.parse("20120911 0700 PST"), df.parse("20120911 1710 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "ICN", df.parse("20120912 0700 PST"), df.parse("20120912 1710 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "ICN", df.parse("20120913 0700 PST"), df.parse("20120913 1710 PST"), 1, 5000));
		// 인천->파리
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120910 2030 PST"), df.parse("20120911 1040 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120911 2030 PST"), df.parse("20120912 1040 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120912 2030 PST"), df.parse("20120913 1040 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "LBG", df.parse("20120913 2030 PST"), df.parse("20120914 1040 PST"), 1, 5000));
		// 런던->인천
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120910 1100 PST"), df.parse("20120910 2300 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120912 1100 PST"), df.parse("20120912 2300 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120911 1100 PST"), df.parse("20120911 2300 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "ICN", df.parse("20120913 1100 PST"), df.parse("20120913 2300 PST"), 1, 5000));
		// 파리->카이로                                                           PST                            PST
		scList.add(new AirlineSchedule("LBG", "CAI", df.parse("20120912 1420 PST"), df.parse("20120912 1810 PST"), 1, 5000));
		// 카이로->파리                                                           PST                            PST
		scList.add(new AirlineSchedule("CAI", "LBG", df.parse("20120911 0800 PST"), df.parse("20120911 1150 PST"), 1, 5000));
		// 파리->델리
		scList.add(new AirlineSchedule("LBG", "DEL", df.parse("20120910 1220 PST"), df.parse("20120910 1830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "DEL", df.parse("20120912 1220 PST"), df.parse("20120912 1830 PST"), 1, 5000));
		// 델리->파리
		scList.add(new AirlineSchedule("DEL", "LBG", df.parse("20120911 0850 PST"), df.parse("20120912 1500 PST"), 1, 5000));
		scList.add(new AirlineSchedule("DEL", "LBG", df.parse("20120913 0850 PST"), df.parse("20120913 1500 PST"), 1, 5000));
		// 런던->파리
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120911 0900 PST"), df.parse("20120911 1030 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120911 1400 PST"), df.parse("20120911 1530 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120911 1700 PST"), df.parse("20120911 1830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120912 0900 PST"), df.parse("20120912 1030 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120912 1400 PST"), df.parse("20120912 1530 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120912 1700 PST"), df.parse("20120912 1830 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120913 0900 PST"), df.parse("20120913 1030 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120913 1400 PST"), df.parse("20120913 1530 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LTN", "LBG", df.parse("20120913 1700 PST"), df.parse("20120913 1830 PST"), 1, 5000));
		// 파리->런던
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120911 0820 PST"), df.parse("20120911 0950 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120911 1320 PST"), df.parse("20120911 1450 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120911 1620 PST"), df.parse("20120911 1750 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120912 0820 PST"), df.parse("20120912 0950 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120912 1320 PST"), df.parse("20120912 1450 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120912 1620 PST"), df.parse("20120912 1750 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120913 0820 PST"), df.parse("20120913 0950 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120913 1320 PST"), df.parse("20120913 1450 PST"), 1, 5000));
		scList.add(new AirlineSchedule("LBG", "LTN", df.parse("20120913 1620 PST"), df.parse("20120913 1750 PST"), 1, 5000));
		// 인천->델리
		scList.add(new AirlineSchedule("ICN", "DEL", df.parse("20120911 1200 PST"), df.parse("20120911 1800 PST"), 1, 5000));
		scList.add(new AirlineSchedule("ICN", "DEL", df.parse("20120913 1200 PST"), df.parse("20120913 1800 PST"), 1, 5000));
		// 델리->인천
		scList.add(new AirlineSchedule("DEL", "ICN", df.parse("20120910 0800 PST"), df.parse("20120910 1400 PST"), 1, 5000));
		scList.add(new AirlineSchedule("DEL", "ICN", df.parse("20120912 0800 PST"), df.parse("20120912 1400 PST"), 1, 5000));
		//카이로->도쿄
		scList.add(new AirlineSchedule("CAI", "NRT", df.parse("20120910 2000 PST"), df.parse("20120910 0630 PST"), 1, 5000));
		//도쿄->카이로
		scList.add(new AirlineSchedule("NRT", "CAI", df.parse("20120912 2100 PST"), df.parse("20120912 0730 PST"), 1, 5000));
	}

	@Test
	public void getAirportDistance() throws ParseException {
		airlineScheduleService.getSortedAirlineScheduleList("LBG", "ICN", new Date(df.parse("20120912 0000 PST").getTime()), new Date(df.parse("20120913 2359 PST").getTime()));
	}
}
