package com.gt.wide.entity;

public class User {
	private int id;
	private String userName;
	private String pwd;
	private boolean delFlag;
	private String  createTime;
	private String  lastUpdate;
	private String lastUpdater;
	private String  telephone;
	
	
	
	public User() {
		super();
	}
	
	
	
	public User(int id, String userName, String pwd, boolean delFlag, String createTime, String lastUpdate,
			String lastUpdater, String telephone) {
		
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.delFlag = delFlag;
		this.createTime = createTime;
		this.lastUpdate = lastUpdate;
		this.lastUpdater = lastUpdater;
		this.telephone = telephone;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public boolean isDelFlag() {
		return delFlag;
	}
	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String  getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String  lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getLastUpdater() {
		return lastUpdater;
	}
	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}
	public String  getTelephone() {
		return telephone;
	}
	public void setTelephone(String  telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd + ", delFlag=" + delFlag + ", createTime="
				+ createTime + ", lastUpdate=" + lastUpdate + ", lastUpdater=" + lastUpdater + ", telephone="
				+ telephone + "]";
	}
	
}
