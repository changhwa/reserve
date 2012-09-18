package com.test.reserve.inform.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.domain.AirlineSchedule;

/**
 * 차후 수정이 필요합니다^___^
 * 
 * @author StevePak
 */
//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/mybatis/application-mybatis.xml")
public class AirlineScheduleDaoTest {
	private static final Date BASE_DATE1 = new Date(System.currentTimeMillis());
	private static final long SEVEN_DAYS_BY_LONG = 1000 * 60 * 60 * 24 * 7;
	private static final Date BASE_DATE2 = new Date(System.currentTimeMillis() + SEVEN_DAYS_BY_LONG);
	private static final Date BASE_DATE3 = new Date(System.currentTimeMillis() + SEVEN_DAYS_BY_LONG * 2);

	@Autowired
	AirlineScheduleDao airlineScheduleDao;

	AirlineSchedule[] airlineSchedules;

	@Before
	public void setUp() {
		this.airlineSchedules = new AirlineSchedule[7];
		airlineSchedules[0] = new AirlineSchedule("AAA", "BBB", BASE_DATE1, BASE_DATE2, 1, 1000);
		airlineSchedules[1] = new AirlineSchedule("AAA", "CCC", BASE_DATE1, BASE_DATE3, 1, 2000);
		airlineSchedules[2] = new AirlineSchedule("BBB", "CCC", BASE_DATE1, BASE_DATE2, 1, 3000);
		airlineSchedules[3] = new AirlineSchedule("AAA", "BBB", BASE_DATE1, BASE_DATE3, 1, 4000);
		airlineSchedules[4] = new AirlineSchedule("CCC", "AAA", BASE_DATE2, BASE_DATE3, 1, 5000);
		airlineSchedules[5] = new AirlineSchedule("AAA", "BBB", BASE_DATE2, BASE_DATE3, 1, 6000);
		airlineSchedules[6] = new AirlineSchedule("BBB", "CCC", BASE_DATE2, BASE_DATE3, 1, 8000);
	}

	@Test
	public void getPath(){
		airlineScheduleDao.add(airlineSchedules[0]);
		airlineScheduleDao.add(airlineSchedules[1]);
		airlineScheduleDao.add(airlineSchedules[2]);
		airlineScheduleDao.add(airlineSchedules[3]);
		airlineScheduleDao.add(airlineSchedules[4]);
		airlineScheduleDao.add(airlineSchedules[5]);
		airlineScheduleDao.add(airlineSchedules[6]);
		
		List<HashMap<String, Object>> airlineScheduleList = airlineScheduleDao.getPath("AAA", "BBB", BASE_DATE1, BASE_DATE3);
		System.out.println();
	}
	
	@Test
	public void get(){
		
	}
	
	private void isMatchAirlineSchedule(AirlineSchedule airlineSchedule1, AirlineSchedule airlineSchedule2) {
		// system.currentTimeMills가 밀리세컨드를 포함하여 테스트중 문제를 일으킴
		// 포멧을 사용하여 문제점 해결
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		assertThat(airlineSchedule1.getAirplaneCode(), is(airlineSchedule2.getAirplaneCode()));
		assertThat(airlineSchedule1.getLandingAirport(), is(airlineSchedule2.getLandingAirport()));
		assertThat(airlineSchedule1.getPrice(), is(airlineSchedule2.getPrice()));
		assertThat(airlineSchedule1.getTakeOffAirport(), is(airlineSchedule2.getTakeOffAirport()));

		assertThat(df.format(airlineSchedule1.getTakeOffDate()), is(df.format(airlineSchedule2.getTakeOffDate())));
		assertThat(df.format(airlineSchedule1.getLandingDate()), is(df.format(airlineSchedule2.getLandingDate())));
	}

}
