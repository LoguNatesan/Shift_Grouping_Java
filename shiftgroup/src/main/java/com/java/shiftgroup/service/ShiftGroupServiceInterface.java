package com.java.shiftgroup.service;

import java.util.List;

import com.java.shiftgroup.model.ShiftGroup;

public interface ShiftGroupServiceInterface {
	boolean doesShiftBelongToGroup(String shiftCode, String shiftGroupCode);
	
	List<ShiftGroup> listAllShiftGroups();
	
	void save(ShiftGroup shiftGroup);
	
	ShiftGroup getShiftGroupById(String shiftGroupCode);
	
	void delete(String shiftGroupCode);
}
