package com.gt.wide.entity;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 2570927196397057537L;
	
	private Integer addressId; //地址id
	private Integer userId; //用户id
	private String person; //收货人
	private String telephone; //收货电话号码
	private String address; // 收货地址
	private Date createTime; //创建时间
	private Date updateTime; //修改时间
	private String updatePerson; //修改人员
	
	public Address() {
		super();
	}
	public Address(Integer addressId, Integer userId, String person, String telephone, String address, Date createTime,
			Date updateTime, String updatePerson) {
		super();
		setAddressId(addressId);
		setUserId(userId);
		setPerson(person);
		setTelephone(telephone);
		setAddress(address);
		setCreateTime(createTime);
		setUpdateTime(updateTime);
		setUpdatePerson(updatePerson);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((updatePerson == null) ? 0 : updatePerson.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (updatePerson == null) {
			if (other.updatePerson != null)
				return false;
		} else if (!updatePerson.equals(other.updatePerson))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", userId=" + userId + ", person=" + person + ", telephone="
				+ telephone + ", address=" + address + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", updatePerson=" + updatePerson + "]";
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdatePerson() {
		return updatePerson;
	}
	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}
}
