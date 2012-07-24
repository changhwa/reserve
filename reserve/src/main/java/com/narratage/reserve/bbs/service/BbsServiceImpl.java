package com.narratage.reserve.bbs.service;

import java.util.List;

import com.narratage.reserve.bbs.vo.BbsVo;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.narratage.reserve.bbs.dao.BbsDao;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;
	
	 public List<BbsVo> selectBbsList(BbsVo BbsVo) {
		return null;
	 }
	 
	 public BbsVo selectBbsDetail(Integer bbsId)  {
		 return bbsDao.selectBbsDetail(bbsId);
	 }

	 public int insertBbs(BbsVo BbsVo) {
		 return bbsDao.insertBbs(BbsVo);
	 }
	 public int updateBbs(Integer bbsId) {
		 return 1;
	 }
	 public int deleteBbs(Integer bbsId) {
		 return 1;
	 }
	
	
	
}


