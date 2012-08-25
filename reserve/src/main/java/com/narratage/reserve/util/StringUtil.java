package com.narratage.reserve.util;

public class StringUtil {
	
	/**
	 * 
	 * 배열형태에서 - > String 으로 변환함.. 
	 * 
	 * @param ch
	 * @return
	 */
	public static String arrayToString(Object[] ch){		
		StringBuilder sb = new StringBuilder();		
		for(int i =0; i<ch.length;i++){
			sb.append(ch[i]);						
		}		
		return sb.toString();		
	}
	
	public static String arrayToString(char[] ch){		
		StringBuilder sb = new StringBuilder();		
		for(int i =0; i<ch.length;i++){
			sb.append(ch[i]);						
		}		
		return sb.toString();		
	}

	public static String[] split(String oriStr, String stand){
		return oriStr.split(stand);
	}

}