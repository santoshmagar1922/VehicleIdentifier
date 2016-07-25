package com.workscape.vehicleidentifier;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	    "wheel"
	})
@XmlRootElement(name="Wheels")
public class Wheels {
	@XmlElement(name="Wheel")
	private List<Wheel> wheel;

	public List<Wheel> getWheel() {
		return wheel;
	}

	public void setWheel(List<Wheel> wheel) {
		this.wheel = wheel;
	}
	
}
