package com.workscape.vehicleidentifier;


import java.io.File;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit test for VehicleIdentifier.
 */
public class VehicleIdentifierTest {

	private VehicleIdentifier classUnderTest = new VehicleIdentifier();
	
	
	@Test
	public void testFindBigWheel() { 
		Vehicles vehicles = getVehicles("test-vehicles-big-wheel.xml");
		Map<String, String> vehicleIdVsType = classUnderTest.findVehicle(vehicles);
		Assert.assertEquals("Big Wheel", vehicleIdVsType.values().iterator().next());
	}
	
	
	@Test
	public void testFindbiCycle() { 
		Vehicles vehicles = getVehicles("test-vehicles-bicycle.xml");
		Map<String, String> vehicleIdVsType = classUnderTest.findVehicle(vehicles);
		Assert.assertEquals("Bicycle", vehicleIdVsType.values().iterator().next());
		
	}
	
	@Test
	public void testFindMultipleVehicles() { 
		Vehicles vehicles = getVehicles("vehicles.xml");
		Map<String, String> vehicleIdVsType = classUnderTest.findVehicle(vehicles);
		Assert.assertEquals(3, vehicleIdVsType.keySet().size());
		Assert.assertEquals("Big Wheel", vehicleIdVsType.get("vehicle 1"));
		Assert.assertEquals("Bicycle", vehicleIdVsType.get("vehicle 2"));
		Assert.assertEquals("Bicycle", vehicleIdVsType.get("vehicle 3"));
		
	}
	
	private Vehicles getVehicles(String vName) {
		 Vehicles vehicles = null;
		try {  
			   
	        File file = new File("./test/"+ vName);  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Vehicles.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        vehicles = (Vehicles) jaxbUnmarshaller.unmarshal(file);  
	      } catch (JAXBException e) {  
	        e.printStackTrace();  
	      } 
		
		return vehicles;
	}
}
