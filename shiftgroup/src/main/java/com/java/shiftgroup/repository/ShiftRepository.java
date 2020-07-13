package com.java.shiftgroup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.shiftgroup.model.Shift;
import com.java.shiftgroup.model.ShiftGroup;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,String> {
	//List<Shift> findByCode(String shiftGroupCode);
}
