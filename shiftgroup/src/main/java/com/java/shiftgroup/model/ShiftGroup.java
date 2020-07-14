package com.java.shiftgroup.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="shift_group")
public class ShiftGroup {	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false, unique = true)
	private int id;
	
	@Id
	@Column(name = "Code", nullable = false, unique = true)
	private String code;
	
	@ManyToMany(
			fetch= FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(
			name="shift_grouping", 
			joinColumns = @JoinColumn(name="shift_group_code"),
			inverseJoinColumns= @JoinColumn(name="shift_code"))
	private Set<Shift> listShifts = new HashSet<>();
	
	//Default constructor is mandatory for JPA mapping
	public ShiftGroup() {
		super();
	}
	
	public ShiftGroup(int id,String code) {
		this.id=id;
		this.code=code;
	}

	public void addShift(Shift shift) {
		this.listShifts.add(shift);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setListShifts(Set<Shift> listShifts) {
		this.listShifts = listShifts;
	}

	public long getId() {
		return id;
	}
	
	public String getCode() {
		return code;
	}

	public Set<Shift> getListShifts() {
		return listShifts;
	}
}
