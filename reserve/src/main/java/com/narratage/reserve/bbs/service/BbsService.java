package com.narratage.reserve.bbs.service;

import java.util.List;

import com.narratage.reserve.bbs.vo.BbsVo;

public interface BbsService {

	 public List<BbsVo> selectBbsList() ;
	 public int selectBbsDetail(Integer BbsId) ;
	 public BbsVo insertBbs(BbsVo BbsVo);
	 public int updateBbs(Integer BbsId);
	 public int deleteBbs(Integer BbsId);
 
}




