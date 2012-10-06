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
	
	public final static boolean isNullOrEmpty(String strObj) {
		if (strObj == null) {
			return true;
		}

		int iLength = strObj.length();
		int iStart = 0;

		while ((iStart < iLength) && (strObj.charAt(iStart) <= ' ')) {
			iStart++;
		}

		return (iStart == iLength);
	}
	
	
	public boolean validation(String pstrTitle) {
		if (StringUtil.isNullOrEmpty(pstrTitle)) {
			infoLog("strTitle is null or Empty!");
			return false;
		}
		return true;
	}
	
	
	private void infoLog(String string) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * validation for DB select
	 * @return
	 */
	public boolean validationForModify(String pstrTitle) {
		if (StringUtil.isNullOrEmpty(pstrTitle)) {
			infoLog("strTitle is null or Empty!");
			return false;
		}
		return true;
	}  
	
	public static String[] split(String oriStr, String stand){
		return oriStr.split(stand);
	}
	
	
	
}