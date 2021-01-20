package edu.moduloalumno.entity;

import java.io.Serializable;

public class Area implements Serializable{
	private static final long serialVersionUID = 1L;
	Integer area_id;
	String area_desc;
	String area_desc_min;
	
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public String getArea_desc() {
		return area_desc;
	}
	public void setArea_desc(String area_desc) {
		this.area_desc = area_desc;
	}
	public String getArea_desc_min() {
		return area_desc_min;
	}
	public void setArea_desc_min(String area_desc_min) {
		this.area_desc_min = area_desc_min;
	}
}
