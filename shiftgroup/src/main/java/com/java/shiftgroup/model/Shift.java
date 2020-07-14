package com.java.shiftgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shift")
public class Shift {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false, unique = true)
	private int id;
	
	@Id
	@Column(name = "Code", nullable = false, unique = true)
	private String code;

	//Default constructor is mandatory for JPA mapping
	public Shift() {
		super();
	}
	
	public Shift(int id,String code) {
		this.id=id;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
