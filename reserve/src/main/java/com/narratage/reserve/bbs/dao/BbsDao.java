package com.narratage.reserve.bbs.dao;

import java.util.List;

import com.narratage.reserve.bbs.vo.BbsVo;

public interface BbsDao {
	public List<BbsVo> selectBbsList();
	public BbsVo selectBbsDetail(Integer bbsId);
	public int insertBbs(BbsVo BbsVo);
	public int updateBbs(Integer bbsId);
	public int deleteBbs(Integer bbsId);
}
