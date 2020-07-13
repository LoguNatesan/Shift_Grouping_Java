package com.java.shiftgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	private int id;
	@Id
	private String code;
	
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.PERSIST)
	@JoinTable(
			name="shift_grouping", 
			joinColumns = @JoinColumn(name="shift_group_code"),
			inverseJoinColumns= @JoinColumn(name="shift_code"))
	
	private List<Shift> listShifts = new ArrayList<>();
	
	//Default constructor is mandatory for JPA mapping
	public ShiftGroup() {
		super();
	}
	
	public ShiftGroup(String code) {
		this.code=code;
	}

	public void addShift(Shift shift) {
		listShifts.add(shift);
	}

	public int getId() {
		return id;
	}

	public List<Shift> getListShifts() {
		return listShifts;
	}
}
