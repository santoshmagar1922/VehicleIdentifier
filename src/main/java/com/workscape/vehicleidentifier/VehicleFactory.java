package com.workscape.vehicleidentifier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleFactory {
	
	private static Map<String, List<String>> frameVsVehicleTypeMap = new HashMap<String, List<String>>();
	private static Map<String, List<String>> PowerTrainVsVehicleTypeMap = new HashMap<String, List<String>>();
	private static Map<String, List<String>> wheelsVsVehicleTypeMap = new HashMap<String, List<String>>();
	
	
	static {

		frameVsVehicleTypeMap.put("Plastic", Arrays.asList(new String[] {"Big Wheel", "Hang Glider"}));
		frameVsVehicleTypeMap.put("Metal", Arrays.asList(new String[] {"Bicycle", "Motorcycle", "Car"}));
		
		
		PowerTrainVsVehicleTypeMap.put("Human", Arrays.asList(new String[] {"Big Wheel", "Bicycle"}));
		PowerTrainVsVehicleTypeMap.put("Internal Combustion", Arrays.asList(new String[] {"Motorcycle", "Car"}));
		PowerTrainVsVehicleTypeMap.put("Bernoulli", Arrays.asList(new String[] {"Hang Glider"}));
		
		wheelsVsVehicleTypeMap.put("3_Plastic", Arrays.asList(new String[] {"Big Wheel"}));
		wheelsVsVehicleTypeMap.put("2_Metal", Arrays.asList(new String[] {"Bicycle", "Motorcycle"}));
		wheelsVsVehicleTypeMap.put("none", Arrays.asList(new String[] {"Hang Glider"}));
		wheelsVsVehicleTypeMap.put("4", Arrays.asList(new String[] {"Car"}));
		
	}


	public static Map<String, List<String>> getFrameVsVehicleTypeMap() {
		return frameVsVehicleTypeMap;
	}


	public static void setFrameVsVehicleTypeMap(
			Map<String, List<String>> frameVsVehicleTypeMap) {
		VehicleFactory.frameVsVehicleTypeMap = frameVsVehicleTypeMap;
	}


	public static Map<String, List<String>> getPowerTrainVsVehicleTypeMap() {
		return PowerTrainVsVehicleTypeMap;
	}


	public static void setPowerTrainVsVehicleTypeMap(
			Map<String, List<String>> powerTrainVsVehicleTypeMap) {
		PowerTrainVsVehicleTypeMap = powerTrainVsVehicleTypeMap;
	}


	public static Map<String, List<String>> getWheelsVsVehicleTypeMap() {
		return wheelsVsVehicleTypeMap;
	}


	public static void setWheelsVsVehicleTypeMap(
			Map<String, List<String>> wheelsVsVehicleTypeMap) {
		VehicleFactory.wheelsVsVehicleTypeMap = wheelsVsVehicleTypeMap;
	}
	
}
