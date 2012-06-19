package com.narratage.reserve.airplane.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface AirplaneService {
	public boolean insertAirplane(HashMap map);
	public boolean modifyAirplane(int airplaneCode);
	public ArrayList findAllAirplane();
<<<<<<< HEAD
	public ArrayList findAirplane(int airplaneCode);
	public boolean deleteAirplane(int airplaneCode);
	public String findSeat(int airplaneCode);
	public boolean modifySeat(int airplaneCode);
=======
	public ArrayList findAirplane(String airplaneCode);
	public boolean deleteAirplane(String airplaneCode);
>>>>>>> master
}
