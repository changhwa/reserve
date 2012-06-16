package com.narratage.reserve.bbs.dao;

import java.util.List;

import com.narratage.reserve.bbs.vo.BbsVo;

public interface BbsDao {
	
	public List<BbsVo> selectBbsList();
	public int selectBbsDetail();
	public BbsVo insertBbs();
	public int updateBbs();
	public int deleteBbs();

}
