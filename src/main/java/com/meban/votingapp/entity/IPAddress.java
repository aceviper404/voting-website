package com.meban.votingapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ipaddress")
public class IPAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;
	private String address;
	
	
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	

	
}
