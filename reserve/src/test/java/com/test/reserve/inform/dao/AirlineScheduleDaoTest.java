package com.test.reserve.inform.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.datatype.AirportType;
import com.narratage.reserve.inform.datatype.DateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;

/**
 * 차후 수정이 필요합니다^___^
 * 
 * @author StevePak
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/mybatis/application-mybatis.xml"})
@Transactional
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
	public void temp(){
		
	}



}
