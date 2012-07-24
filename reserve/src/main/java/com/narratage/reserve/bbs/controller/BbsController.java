package com.narratage.reserve.bbs.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narratage.reserve.bbs.service.BbsServiceImpl;
import com.narratage.reserve.bbs.vo.BbsVo;

import com.narratage.reserve.util.StringUtil;
import com.narratage.reserve.bbs.controller.UtilLog;


@Controller
public class BbsController extends UtilLog {

	@Autowired
	private BbsServiceImpl bbsServiceImpl;
	
	
	@RequestMapping(value="/bbs/insertBbs")
	public String insertBbs(ModelMap model, BbsVo command, HttpServletRequest request) throws Exception {
		BbsVo bbsVo = new BbsVo();
		StringUtil StringUtil = new StringUtil();
		HttpSession ses = request.getSession();
		
		try {
			if (!StringUtil.isNullOrEmpty((String)ses.getAttribute("USER_ID")) ) {
				infoLog("세션만료!");
				return alert("로그인후 이용해주세요.", "../loginFrm.do", model);
			}
			infoLog("공지추가 프로세스...");
//			if (!command.validation()) {
//				infoLog("유효성 검사 실패!!!");
//				return alert("유효성 검사 실패!!!", "regNoticeFrm.do", model);
//			}
			BeanUtils.copyProperties(bbsVo, command);
			if (bbsServiceImpl.insertBbs(bbsVo) < 1) {
				infoLog("DB실패!");
				return alert("DB실패!", "regNoticeFrm.do", model);
			}
			infoLog("공지추가 완료...");
			return "redirect:bbsList.do";
		} catch (Exception e) {
			errorLog("INSERT BBS ERROR!", e);
			throw e;
		}
	}	
	
	
	
}





