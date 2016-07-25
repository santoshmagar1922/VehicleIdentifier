package com.workscape.vehicleidentifier;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
/**
 * Vehicle Identifier!
 * 
 */
public class VehicleIdentifier {
	
	public static void main(String[] args) {
		try {  
			   
	        File file = new File("./input/vehicles.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Vehicles.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        Vehicles vehicles = (Vehicles) jaxbUnmarshaller.unmarshal(file);  
	          
        	VehicleIdentifier vi = new VehicleIdentifier();
        	vi.findVehicle(vehicles);
	        
	      } catch (JAXBException e) {  
	        e.printStackTrace();  
	      }  
	}

	
	/**
	 * This is the method who will find the vehicle and its details like id and type from passed in vehicles list. 
	 * @param vehicles
	 * @return Map<String, String>
	 */
	public Map<String, String> findVehicle(Vehicles vehicles) {
		
		Map<String, List<String>> frameVsVehicleTypeMap = VehicleFactory.getFrameVsVehicleTypeMap();
    	Map<String, List<String>> PowerTrainVsVehicleTypeMap = VehicleFactory.getPowerTrainVsVehicleTypeMap();
    	Map<String, List<String>> wheelsVsVehicleTypeMap = VehicleFactory.getWheelsVsVehicleTypeMap();
		
		Map<String, String> vehicleIdVsType = new HashMap();
		Map<String, Integer> vehicleTypeVsCount = new HashMap();
		
        for (Vehicle vehicle : vehicles.getVehicle()) {
        	
        	List<String> vehiclesByFrame = new ArrayList(frameVsVehicleTypeMap.get(vehicle.getFrame().getMaterial()));
        	List<String> vehiclesByPT = findVehicleByPowerTrain(PowerTrainVsVehicleTypeMap, vehicle);
        	List<String> vehiclesByWheels = findVehicleByWheels(wheelsVsVehicleTypeMap, vehicle);

        	intersectAllResults(vehiclesByFrame, vehiclesByPT, vehiclesByWheels);
        	
        	populateVehicleIdVsCountMap(vehicleIdVsType, vehicleTypeVsCount, vehicle, vehiclesByFrame);
        }
        printResult(vehicleIdVsType);
        printReport(vehicleTypeVsCount);
        
        return vehicleIdVsType;
	}

	/**
	 * THis is the method which will populate Vehicle Id Vs CountMap
	 * @param vehicleTypeVsCount
	 * @param vehicle
	 * @return
	 */
	public void populateVehicleIdVsCountMap(Map<String, String> vehicleIdVsType, Map<String, Integer> vehicleTypeVsCount, Vehicle vehicle,
			List<String> vehiclesByFrame) {
		vehicleIdVsType.put(vehicle.getId(), vehiclesByFrame.get(0));
		if (vehicleTypeVsCount.get(vehiclesByFrame.get(0)) == null) {
			vehicleTypeVsCount.put(vehiclesByFrame.get(0), 1);
		} else {        		
			int count = vehicleTypeVsCount.get(vehiclesByFrame.get(0));
			vehicleTypeVsCount.put(vehiclesByFrame.get(0), count + 1);
		}
	}

	/**
	 * THis is the method which will find Vehicle By Power Train
	 * @param PowerTrainVsVehicleTypeMap
	 * @param vehicle
	 * @return
	 */
	public static List<String> findVehicleByPowerTrain(
			Map<String, List<String>> PowerTrainVsVehicleTypeMap,
			Vehicle vehicle) {
		List<String> vehiclesByPT = new ArrayList();
		if (vehicle.getPowerTrain() != null && vehicle.getPowerTrain().getType() != null && !"".equals(vehicle.getPowerTrain().getType())) {
			vehiclesByPT = new ArrayList(PowerTrainVsVehicleTypeMap.get(vehicle.getPowerTrain().getType()));
		}
		return vehiclesByPT;
	}

	/**
	 * THis is the method which will find Vehicle By Wheels 
	 * @param vehiclesByWheels
	 * @param vehicle
	 * @return
	 */
	public static List<String> findVehicleByWheels(
			Map<String, List<String>> wheelsVsVehicleTypeMap, Vehicle vehicle) {
		List<String> vehiclesByWheels = new ArrayList();
		if (vehicle.getWheels() != null && vehicle.getWheels().getWheel() != null && !vehicle.getWheels().getWheel().isEmpty() ) {
			String keyForWheels = vehicle.getWheels().getWheel().size()+"_" + vehicle.getWheels().getWheel().get(0).getMaterial();
			vehiclesByWheels = new ArrayList(wheelsVsVehicleTypeMap.get(keyForWheels));
		}else {
			vehiclesByWheels = new ArrayList(wheelsVsVehicleTypeMap.get("none"));
		}
		return vehiclesByWheels;
	}
	
	/**
	 * This method does all the filtering or intersection of all the list. The logic is to find the vehicles list by
	 * all the input parameters. This will get us list for each search criteria. Finally if we intersect all the list,
	 * we will get the actual vehicle matching all the input criteria. 
	 *  
	 * @param vehiclesByFrame
	 * @param vehiclesByPT
	 * @param vehiclesByWheels
	 */

	public static void intersectAllResults(List<String> vehiclesByFrame,
			List<String> vehiclesByPT, List<String> vehiclesByWheels) {
		if (!vehiclesByFrame.isEmpty() && !vehiclesByPT.isEmpty()) {
			vehiclesByFrame.retainAll(vehiclesByPT);
		}
		if (!vehiclesByFrame.isEmpty() && !vehiclesByWheels.isEmpty()) {
			vehiclesByFrame.retainAll(vehiclesByWheels);
		}
	}
	
	/**
	 * THis method prints the Vehicle Id Vs Vehicle Type
	 * @param result
	 */
	public void printResult(Map<String, String> result) {
		System.out.println("Printing :: Vehicle Id Vs Vehicle Type");
		System.out.println("--------------------------------------");
		for (String key : result.keySet()) {
		    System.out.println(key + " -->> " + result.get(key));
		}
		
	}
	
	/**
	 * THis method prints the  Vehicle Type VS Count
	 * @param result
	 */
	public void printReport(Map<String, Integer> result) {
		System.out.println("");
		System.out.println("Printing :: Vehicle Type VS Count");
		System.out.println("--------------------------------------");
		for (String key : result.keySet()) {
		    System.out.println(key + " -->> " + result.get(key));
		}
		
	}
}
