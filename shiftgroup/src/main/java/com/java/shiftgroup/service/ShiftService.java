package com.java.shiftgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.shiftgroup.model.Shift;
import com.java.shiftgroup.repository.ShiftRepository;

@Service
public class ShiftService implements ShiftServiceInterface{
	
	private ShiftRepository shiftRepository;
	
	//Good Practise of using Autowiring is by setter method
	@Autowired
	public void setShiftRepository(ShiftRepository shiftRepository) {
		this.shiftRepository = shiftRepository;
	}

	@Override
	public List<Shift> listAllShifts() {
			return shiftRepository.findAll();
	}

	@Override
	public void save(Shift shift) {
		shiftRepository.save(shift);
		
	}

	@Override
	public Shift getShiftById(String shiftCode) {
			return shiftRepository.findById(shiftCode).get();
	}

	@Override
	public void delete(String shiftCode) {
		shiftRepository.deleteById(shiftCode);
		
	}

}
