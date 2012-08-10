package com.narratage.reserve.bbs.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.narratage.reserve.bbs.vo.BbsVo;
	
@Repository("bbsDao")
public class BbsDaoImpl extends SqlSessionDaoSupport implements BbsDao {
	
	@Autowired	
	private SqlSessionFactory sqlSessionFactory;
	
	public BbsVo selectBbsDetail(Integer bbsId) {
		return (BbsVo) getSqlSession().selectList("com.narratage.reserve.bbs.dao.BbsDao.selectBbsDetail", bbsId);	
	}
	
	public List<BbsVo> selectBbsList() {
		System.out.println(" --------------- DAO select method 전");
		return (List<BbsVo>) getSqlSession().selectList("com.narratage.reserve.bbs.dao.BbsDao.selectBbsList");
//		System.out.println(" --------------- DAO select method 후");
		
	}
	
	public int selectMaxBbsId() {
		System.out.println(" --------------- selectMaxBbsId");
		System.out.println(" --------------- selectMaxBbsId method 전");
		return (Integer)getSqlSession().selectOne("com.narratage.reserve.bbs.dao.BbsDao.selectMaxBbsId");
	}
	
	public int insertBbs(BbsVo BbsVo) {
		return (int) getSqlSession().insert("com.narratage.reserve.bbs.dao.BbsDao.insertBbs", BbsVo);	
	}
	public int updateBbs(Integer bbsId) {
		return 1;
	}
	public int deleteBbs(Integer bbsId) {
		return 1;
	}
	
	
}



