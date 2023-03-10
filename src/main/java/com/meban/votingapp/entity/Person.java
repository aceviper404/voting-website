package com.meban.votingapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;
	private String name;
	
	private short numberOfVotes=1;
	
	
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getNumberOfVotes() {
		return numberOfVotes;
	}
	public void setNumberOfVotes(short numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	
	

}
