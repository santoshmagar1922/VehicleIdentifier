package com.workscape.vehicleidentifier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name="Frame")
public class Frame {
	
	
	@XmlElement(name="Material")
	private String material;

	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material= material;
	}
}
