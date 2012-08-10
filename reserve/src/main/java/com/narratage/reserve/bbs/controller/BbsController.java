package com.narratage.reserve.bbs.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narratage.reserve.bbs.service.BbsService;
import com.narratage.reserve.bbs.service.BbsServiceImpl;
import com.narratage.reserve.bbs.vo.BbsVo;

import com.narratage.reserve.util.StringUtil;
import com.narratage.reserve.bbs.controller.UtilLog;


@Controller
public class BbsController extends UtilLog {

	@Autowired
	private BbsService bbsService;

	@RequestMapping(value="/bbs/selectBbsList")
	public String selectBbsList(ModelMap model, BbsVo command, HttpServletRequest request) throws Exception{
		HttpSession ses = request.getSession();
		
		ses.setAttribute("bbs_id", "1");
		System.out.println(" ----> " + (String)ses.getAttribute("bbs_id"));
		
		infoLog("게시판 리스트");
		if (StringUtil.isNullOrEmpty((String)ses.getAttribute("bbs_id")) == true ) {
			infoLog("세션만료!");
			System.out.println("로그인 후 이용해 주세요.");
			return ""; // TODO : 추후 로그인 메서드에 맞게 수정
//				return alert("로그인후 이용해주세요.", "../loginFrm.do", model); // TODO : 추후 로그인 메서드에 맞게 수정
		}

		List<BbsVo> bbsList = bbsService.selectBbsList();
		model.addAttribute("selectBbsList", bbsList);
		return "/bbs/bbsList";
	}
	
	
	@RequestMapping(value="/bbs/insertBbs")
	public String insertBbs(ModelMap model, BbsVo command, HttpServletRequest request) throws Exception {
		BbsVo bbsVo = new BbsVo();
		StringUtil StringUtil = new StringUtil();
		
		HttpSession ses = request.getSession();
		ses.setAttribute("insert_admin_id", "agm");
		System.out.println("----------> " + (String)ses.getAttribute("insert_admin_id"));
		
		if (StringUtil.isNullOrEmpty((String)ses.getAttribute("insert_admin_id")) == true ) {
			infoLog("세션만료!");
//				return alert("로그인후 이용해주세요.", "../loginFrm.do", model);
			System.out.println("로그인 후 이용해 주세요.");
			return "로그인 후 이용해 주세요.";
		}

		infoLog("게시판 입력 프로세스...");
//			if (!command.validation()) {
//				infoLog("유효성 검사 실패!!!");
//				return alert("유효성 검사 실패!!!", "regNoticeFrm.do", model);
//			}

		if (bbsService.insertBbs(bbsVo) < 1) {
			infoLog("게시판 등록 실패!");
//				return alert("게시판 등록 실패!", "regNoticeFrm.do", model);
			return "/bbs/bbsList";
		}
		infoLog("게시판 등록 완료...");
		return "/bbs/bbsList";
	}	
	
	
	
}





