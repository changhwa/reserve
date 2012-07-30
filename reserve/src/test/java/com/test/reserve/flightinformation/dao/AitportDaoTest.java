package com.test.reserve.flightinformation.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.flightinformation.dao.AirportDao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/mybatis/application-mybatis.xml")
public class AitportDaoTest {
	@Autowired
	AirportDao airportDao;
	
	@Test
	public void test() {
		System.out.println("===TEST====");
		//airportDao.getAirportInfo("ICN");
	}

}
