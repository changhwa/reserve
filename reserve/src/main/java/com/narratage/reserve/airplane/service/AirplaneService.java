package com.narratage.reserve.airplane.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface AirplaneService {
	public boolean insertAirplane(HashMap map);
	public boolean modifyAirplane(String airplaneCode);
	public ArrayList findAllAirplane();
	public ArrayList findAirplane(String airplaneCode);
	public boolean deleteAirplane(String airplaneCode);
}
