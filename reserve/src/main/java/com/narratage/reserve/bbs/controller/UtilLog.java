package com.narratage.reserve.bbs.controller;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;


@Controller
public abstract class UtilLog {
	
	private Logger logger = Logger.getLogger(getClass());

	protected void debugLog(String debugMsg){
		if(logger.isDebugEnabled()){
			logger.debug(debugMsg);
		}
	}

	protected void infoLog(String infoMsg){
		if(logger.isInfoEnabled()){
			logger.info(infoMsg);
		}
	}

	protected void warnLog(String warnMsg) {
		logger.warn(warnMsg);
	}

	protected void errorLog(String errMsg){
		logger.error(errMsg);
	}

	protected void errorLog(String errMsg, Throwable e){
		logger.error(errMsg, e);
	}

	protected void fatalLog(String fatalMsg) {
		logger.fatal(fatalMsg);
	}

	protected Map<String, String> getHeaders(HttpServletRequest request) throws Exception {
		Map<String, String> headers = new HashMap<String, String>();
		Enumeration<?> eheaders = request.getHeaderNames();
		while (eheaders.hasMoreElements()) {
			String key = (String) eheaders.nextElement();
			String value = request.getHeader(key);
			headers.put(key, value);
		}
		return headers;
	}

	protected String getHeader(HttpServletRequest request, String headerName) throws Exception {
		return request.getHeader(headerName);
	}
	
	/**
	 * <pre>
	 * alert and go returnUri
	 * </pre>
	 * @param alertMsg
	 * @param returnUri
	 * @return
	 * @throws Exception
	 */
	public String alert(String alertMsg, String returnUri, ModelMap model) throws Exception {
		model.addAttribute("alertMsg", alertMsg);
		model.addAttribute("returnUri", returnUri);
		return "/common/alert";
	}
}



