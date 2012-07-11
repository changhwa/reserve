package com.test.reserve.inform.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.dao.CommonDao;
import com.narratage.reserve.inform.datatype.SearchAirportType;
import com.narratage.reserve.inform.datatype.SearchDateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;

/**
 * 차후 수정이 필요합니다^___^
 * @author StevePak
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/narratage/reserve/inform/test-applicationContext.xml")
public class AirlineScheduleDaoTest {
	private static final Date BASE_DATE1 = new Date(System.currentTimeMillis());
	private static final long SEVEN_DAYS_BY_LONG = 1000 * 60 * 60 * 24 * 7;
	private static final Date BASE_DATE2 = new Date(System.currentTimeMillis() + SEVEN_DAYS_BY_LONG);
	private static final Date BASE_DATE3 = new Date(System.currentTimeMillis() + SEVEN_DAYS_BY_LONG * 2);

	@Autowired
	AirlineScheduleDao airlineScheduleDao;
	@Autowired
	CommonDao commonDao;

	AirlineSchedule[] airlineSchedules;

	@Before
	public void setUp() {
		this.airlineSchedules = new AirlineSchedule[7];
		airlineSchedules[0] = new AirlineSchedule("AAA", "BBB", BASE_DATE1, BASE_DATE2, "747", 1000);
		airlineSchedules[1] = new AirlineSchedule("AAA", "CCC", BASE_DATE1, BASE_DATE3, "747", 2000);
		airlineSchedules[2] = new AirlineSchedule("BBB", "CCC", BASE_DATE1, BASE_DATE2, "747", 3000);
		airlineSchedules[3] = new AirlineSchedule("AAA", "BBB", BASE_DATE1, BASE_DATE3, "747", 4000);
		airlineSchedules[4] = new AirlineSchedule("CCC", "AAA", BASE_DATE2, BASE_DATE3, "747", 5000);
		airlineSchedules[5] = new AirlineSchedule("AAA", "BBB", BASE_DATE2, BASE_DATE3, "747", 6000);
		airlineSchedules[6] = new AirlineSchedule("BBB", "CCC", BASE_DATE2, BASE_DATE3, "747", 8000);
	}

	@Test
	public void getDualAirportAirlineScheduleList() {
		simpleDeleteAll();
		this.simpleCount(0);
		airlineScheduleDao.add(airlineSchedules[0]);
		airlineScheduleDao.add(airlineSchedules[1]);
		this.simpleCount(2);

		List<AirlineSchedule> airlineScheduleList = airlineScheduleDao.get(SearchDateType.LANDING,
				airlineSchedules[0].getTakeOffAirport(), airlineSchedules[0].getLandingAirport(), BASE_DATE1,
				BASE_DATE3);
		assertThat(airlineScheduleList.size(), is(1));
		isMatchAirlineSchedule(airlineSchedules[0], airlineScheduleList.get(0));
	}

	@Test
	public void getSingleAirportAirlineScheduleList() {
		simpleDeleteAll();
		for (int idx = 0; idx < airlineSchedules.length; idx++) {
			airlineScheduleDao.add(airlineSchedules[idx]);
		}
		List<AirlineSchedule> airlineScheduleList = airlineScheduleDao.get(SearchAirportType.TAKE_OFF,
				SearchDateType.LANDING, "AAA", new Date(), BASE_DATE2);
		for (int i = 0; i < airlineScheduleList.size(); i++) {
			System.out.println(airlineScheduleList.get(i));
		}
	}

	private void isMatchAirlineSchedule(AirlineSchedule airlineSchedule1, AirlineSchedule airlineSchedule2) {
		// system.currentTimeMills가 밀리세컨드를 포함하여 테스트중 문제를 일으킴
		// 포멧을 사용하여 문제점 해결
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		assertThat(airlineSchedule1.getAircraft(), is(airlineSchedule2.getAircraft()));
		assertThat(airlineSchedule1.getLandingAirport(), is(airlineSchedule2.getLandingAirport()));
		assertThat(airlineSchedule1.getPrice(), is(airlineSchedule2.getPrice()));
		assertThat(airlineSchedule1.getTakeOffAirport(), is(airlineSchedule2.getTakeOffAirport()));
		assertThat(df.format(airlineSchedule1.getTakeOffDate()), is(df.format(airlineSchedule2.getTakeOffDate())));
		assertThat(df.format(airlineSchedule1.getLandingDate()), is(df.format(airlineSchedule2.getLandingDate())));
	}

	private void simpleCount(int expected) {
		assertThat(commonDao.getCount("airline_schedule"), is(expected));
	}

	private void simpleDeleteAll() {
		commonDao.deleteAll("airline_schedule");
	}
}
