package com.workscape.vehicleidentifier;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	    "id",
	    "frame",
	    "wheels",
	    "powerTrain"
	})

@XmlRootElement(name="Vehicle")
public class Vehicle {

	@XmlElement(name="Id")
	private String id;
	@XmlElement(name="Frame")
	private Frame frame;
	@XmlElement(name="Wheels")
	private Wheels wheels;
	@XmlElement(name="PowerTrain")
	private PowerTrain powerTrain;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public Wheels getWheels() {
		return wheels;
	}
	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}
	public PowerTrain getPowerTrain() {
		return powerTrain;
	}
	public void setPowerTrain(PowerTrain powerTrain) {
		this.powerTrain = powerTrain;
	}
}
