package com.gt.wide.entity;

import java.util.Date;

public class Brand {
	
	private int brand_id;
	private int directory_id;
	private String brand_name;
	private String brand_describe;
	private Date create_time;
	private Date last_update_time;
	private int last_update_person;
	public Brand() {
		
	}
	public Brand(int brand_id, int directory_id, String brand_name, String brand_describe, Date create_time,
			Date last_update_time, int last_update_person) {
		this.brand_id = brand_id;
		this.directory_id = directory_id;
		this.brand_name = brand_name;
		this.brand_describe = brand_describe;
		this.create_time = create_time;
		this.last_update_time = last_update_time;
		this.last_update_person = last_update_person;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getDirectory_id() {
		return directory_id;
	}
	public void setDirectory_id(int directory_id) {
		this.directory_id = directory_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_describe() {
		return brand_describe;
	}
	public void setBrand_describe(String brand_describe) {
		this.brand_describe = brand_describe;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}
	public int getLast_update_person() {
		return last_update_person;
	}
	public void setLast_update_person(int last_update_person) {
		this.last_update_person = last_update_person;
	}
	@Override
	public String toString() {
		return "brand [brand_id=" + brand_id + ", directory_id=" 
				+ directory_id + ", brand_name=" + brand_name
				+ ", brand_describe=" + brand_describe + ", create_time=" 
				+ create_time + ", last_update_time="
				+ last_update_time + ", last_update_person=" 
				+ last_update_person + "]";
	}
	

}
