package com.gt.wide.entity;

import java.io.Serializable;

public class Information  implements Serializable{
	
	private static final long serialVersionUID = 6535891267365484847L;
	
	private int id;
	private int userId;
	private String nickName;
	private String gender;
	private String birthday;
	private String email;
	private String createTime;
	private String lastUpdate;
	private String lastUpdater;
	
	
	public Information() {
		super();
	}
	
	
	
	public Information(int id,int userId, String nickName, String gender, String birthday, String email, String createTime,
			String lastUpdate, String lastUpdater) {
		this.id=id;
		this.userId = userId;
		this.nickName = nickName;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.createTime = createTime;
		this.lastUpdate = lastUpdate;
		this.lastUpdater = lastUpdater;
	}


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		
		return birthday.split(" ")[0];
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getLastUpdater() {
		return lastUpdater;
	}
	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}



	@Override
	public String toString() {
		return "Information [id=" + id + ", userId=" + userId + ", nickName=" + nickName + ", gender=" + gender
				+ ", birthday=" + birthday + ", email=" + email + ", createTime=" + createTime + ", lastUpdate="
				+ lastUpdate + ", lastUpdater=" + lastUpdater + "]";
	}
	
	
	
}
