package com.narratage.reserve.reservation.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narratage.reserve.reservation.dao.ReservationDao;

@Service("reservationService")
public class ReseravationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationDao dao;
	

	public boolean insertReserve(HashMap map) {
		// TODO Auto-generated method stub 
		return false;
	}

	public boolean deleteReserve(int reservCode) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList findDateReserve(String userId, String startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList findAllReserve(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList findAirinformCodeReserve(String airinformCode) {
		return dao.findAirinformCodeReserve(airinformCode);
	}

}
