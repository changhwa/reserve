package com.narratage.reserve.airplane.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface AirplaneService {
	public boolean insertAirplane(HashMap map);
	public boolean modifyAirplane(int airplaneCode);
	public ArrayList findAllAirplane();
	public ArrayList findAirplane(int airplaneCode);
	public boolean deleteAirplane(int airplaneCode);
}
