package com.test.reserve.seat.service;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narratage.reserve.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/mybatis/application-mybatis.xml")
public class SeatServiceImplTest {

	//given
	
	String seatValue;
	SeatServiceImplTest service;
	String[] temp;
	char[] joinSeatValue;
	ArrayList tempList = new ArrayList();
	int[] selectNum={6,10,25};
	String[] seatName={"A1","B10"};
	String successSeat;

	@Before
	public void setUp(){
		
		//when
		seatValue="01010101013#00000000003#11111111113#11111111113#00000000003#0101010101";
		
		temp = seatValue.split("#");
		service = new SeatServiceImplTest();
		joinSeatValue = StringUtil.arrayToString(temp).toCharArray();
		
		// Then post webpage
		successSeat="02010101013000000000031111111112311111111113000000000030101010101";


		// Then makeSeatNameFromSeatArray
		tempList.add("0");
		tempList.add("A1");
		tempList.add("0");
		tempList.add("A2");
		tempList.add("0");
		tempList.add("A3");
		tempList.add("0");
		tempList.add("A4");
		tempList.add("0");
		tempList.add("A5");
		tempList.add("3");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("0");
		tempList.add("3");
		tempList.add("B1");
		tempList.add("B2");
		tempList.add("B3");
		tempList.add("B4");
		tempList.add("B5");
		tempList.add("B6");
		tempList.add("B7");
		tempList.add("B8");
		tempList.add("B9");
		tempList.add("B10");
		tempList.add("3");
	}
	
	@Test
	public void splitSeatValue(){
		assertThat(temp[0],is("01010101013"));		
	}

	@Test
	public void makeSeatNameFromSeatArray() {
		
		ArrayList<String> list = new ArrayList<String>();
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
	
	

	@Test
	public void searchSeatName(){
		
		String tempIndex = seatName[1];
		tempList.indexOf(tempIndex);
		assertThat("31", is(tempList.indexOf(tempIndex)+""));
	}
	

	@Test
	public void joinSeatValue(){
		assertThat(joinSeatValue[0],is('0'));
	}

	
	@Test
	public void changedArrayIndex(){
		joinSeatValue[1] = '2';
		joinSeatValue[31] = '2';
		assertThat(StringUtil.arrayToString(joinSeatValue),is(successSeat));
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
