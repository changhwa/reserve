package com.narratage.reserve.bbs.service;

import java.util.List;

import com.narratage.reserve.bbs.vo.BbsVo;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.narratage.reserve.bbs.dao.BbsDao;
import com.narratage.reserve.bbs.dao.BbsDaoImpl;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;
	private BbsDaoImpl bbsDaoImpl;
	
	 public List<BbsVo> selectBbsList() {
		 System.out.println(" --------------- SERVICE select method 전");
		 return bbsDao.selectBbsList();
	 }
	 
	 public BbsVo selectBbsDetail(Integer bbsId)  {
		 return bbsDaoImpl.selectBbsDetail(bbsId);
	 }

	 
	 
	 public int insertBbs(BbsVo BbsVo) {
		 // TODO : 
		 // bbs_id 시퀀스 생성
		 // insert_dt, update_dt 현재 시간 가져와서 셋팅
		 // insert_admin_id, update_admin_id 현재 로그인한 이용자 정보 가져와서 셋팅
		 //
		 int intBbsId = 0;
		 intBbsId = bbsDao.selectMaxBbsId();
		 intBbsId = intBbsId + 1;
		 BbsVo.setIntBbsId(intBbsId);
		 
		 
		 System.out.println(" --------------- SERVICE insert method 전");
		 return bbsDao.insertBbs(BbsVo);
	 }
	 public int updateBbs(Integer bbsId) {
		 return 1;
	 }
	 public int deleteBbs(Integer bbsId) {
		 return 1;
	 }
	
	
	
}


