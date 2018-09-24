package com.gt.wide.entity;

import java.util.Date;

public class Kind {
	private int kind_id;
	private int directory_id;
	private String kind_name;
	private String kind_describe;
	private Date create_time;
	private Date last_update_time;
	private int last_update_person;
	public Kind() {
		super();
	}
	public Kind(int kind_id, int directory_id, String kind_name, String kind_describe, Date create_time,
			Date last_update_time, int last_update_person) {
		super();
		this.kind_id = kind_id;
		this.directory_id = directory_id;
		this.kind_name = kind_name;
		this.kind_describe = kind_describe;
		this.create_time = create_time;
		this.last_update_time = last_update_time;
		this.last_update_person = last_update_person;
	}
	public int getKind_id() {
		return kind_id;
	}
	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}
	public int getDirectory_id() {
		return directory_id;
	}
	public void setDirectory_id(int directory_id) {
		this.directory_id = directory_id;
	}
	public String getKind_name() {
		return kind_name;
	}
	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
	public String getKind_describe() {
		return kind_describe;
	}
	public void setKind_describe(String kind_describe) {
		this.kind_describe = kind_describe;
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
		return "Kind [kind_id=" + kind_id + ", directory_id=" 
				+ directory_id + ", kind_name=" + kind_name
				+ ", kind_describe=" + kind_describe 
				+ ", create_time=" + create_time + ", last_update_time="
				+ last_update_time + ", last_update_person=" 
				+ last_update_person + "]";
	}
	
	

}
