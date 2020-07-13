package com.java.shiftgroup.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.shiftgroup.model.Shift;
import com.java.shiftgroup.model.ShiftGroup;
import com.java.shiftgroup.repository.ShiftGroupRepository;

@Service
public class ShiftGroupService implements ShiftGroupServiceInterface{
	
	private ShiftGroupRepository shiftGroupRepository;
	
	//Good Practise of using Autowiring is by setter method
	@Autowired
	public void setShiftGroupRepository(ShiftGroupRepository shiftGroupRepository) {
		this.shiftGroupRepository = shiftGroupRepository;
	}


	@Override
	public boolean doesShiftBelongToGroup(String shiftCode, String shiftGroupCode) {
		List<ShiftGroup> shiftGroups = shiftGroupRepository.findByCode(shiftGroupCode);
		 
		 if(!shiftGroups.isEmpty())  {  
			for(ShiftGroup sg : shiftGroups)
			{
				for(Shift shift: sg.getListShifts()) {
					String sgShiftCode = shift.getCode();
					if(sgShiftCode.equals(shiftCode))	return true;
				}
			}
		 }	
		 return false;
	}


	@Override
	public List<ShiftGroup> listAllShiftGroups() {
		return shiftGroupRepository.findAll();
	}


	@Override
	public void save(ShiftGroup shiftGroup) {
		shiftGroupRepository.save(shiftGroup);
		
	}


	@Override
	public ShiftGroup getShiftGroupById(String shiftGroupCode) {
		return shiftGroupRepository.findById(shiftGroupCode).get();
	}


	@Override
	public void delete(String shiftGroupCode) {
		shiftGroupRepository.deleteById(shiftGroupCode);
		
	}
}
