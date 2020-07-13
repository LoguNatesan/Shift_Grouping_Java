package com.java.shiftgroup.service;

import java.util.List;

import com.java.shiftgroup.model.Shift;


public interface ShiftServiceInterface {

	List<Shift> listAllShifts();
	
	void save(Shift shift);
	
	Shift getShiftById(String shiftCode);
	
	void delete(String shiftCode);
}
