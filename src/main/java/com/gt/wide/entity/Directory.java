package com.gt.wide.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Directory {
	private int directory_id;
	private int pid;
	private String dname;
	private String ddescription;
	private Date create_time;
	private Date last_update_time;
	private int last_update_person;
	
	public Directory() {
		super();
	}
	public Directory(int directory_id, int pid, String dname, String ddescription, Date create_time, Date last_update_time,
			int last_update_person) {
		super();
		this.directory_id = directory_id;
		this.pid = pid;
		this.dname = dname;
		this.ddescription = ddescription;
		this.create_time = create_time;
		this.last_update_time = last_update_time;
		this.last_update_person = last_update_person;
	}
	public int getDirectory_id() {
		return directory_id;
	}
	public void setDirectory_id(int directory_id) {
		this.directory_id = directory_id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdescription() {
		return ddescription;
	}
	public void setDdescription(String ddescription) {
		this.ddescription = ddescription;
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
		return "Directory [directory_id=" + directory_id 
				+ ", pid=" + pid + ", dname=" + dname + ", ddescription="
				+ ddescription + ", create_time=" + create_time 
				+ ", last_update_time=" + last_update_time
				+ ", last_update_person=" + last_update_person + "]";
	}
	
}
