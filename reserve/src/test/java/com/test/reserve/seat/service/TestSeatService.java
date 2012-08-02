package com.test.reserve.seat.service;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/mybatis/application-mybatis.xml")
public class TestSeatService {
	
	String seatValue;
	TestSeatService service;
	


	@Before
	public void setUp(){

		seatValue="01010101013#00000000003#11111111113#11111111113#00000000003#0101010101";
		//int[] selectSetNum={6,10,14};
		//String[] reservedSeat={"A1","A2","C3","C5"};
		service = new TestSeatService();
	}
	

	@Test
	public void makeSeatNameFromSeatArray() {
		String[] temp = seatValue.split("#");
		//assertThat(temp[0],is("01010101013"));
		ArrayList list = new ArrayList();
		int count=0;
		int seatNum=1;
		int yl=0;
		boolean gongback = false;
		for(int i=0;i<temp.length;i++){
			char[] ch = temp[i].toCharArray();
			for(int j=0;j<ch.length;j++){				
				if(ch[j]=='0'){
					list.add("0");
				}
				else if(ch[j]=='1'){
					list.add(service.firstChar(yl)+seatNum);
					seatNum++;
					gongback = true;
				}
				else{
					list.add("3");
				}
				if(j==ch.length-1 && gongback){
					++yl;
				}
			}
			gongback = false;
			seatNum=1;
		}
		assertThat((String)list.get(22), is("B1"));
		
	}

	public String firstChar(int i){
		int howNum = i+65;
		char c;
		for(c=65 ; c<91 ; c++){
			if(c==howNum){
				break;
			}
			else{
				continue;
			}
		}
		return c+"";
	}

}
