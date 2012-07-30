package com.narratage.reserve.bbs.service;

import java.util.List;

import com.narratage.reserve.bbs.vo.BbsVo;

public interface BbsService {
	 public List<BbsVo> selectBbsList();
	 public BbsVo selectBbsDetail(Integer bbsId) ;
	 public int insertBbs(BbsVo BbsVo);
	 public int updateBbs(Integer bbsId);
	 public int deleteBbs(Integer bbsId);
}




