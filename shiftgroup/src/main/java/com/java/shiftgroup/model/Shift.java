package com.java.shiftgroup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shift")
public class Shift {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Id
	private String code;

	//Default constructor is mandatory for JPA mapping
	public Shift() {
		super();
	}
	
	public Shift(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
