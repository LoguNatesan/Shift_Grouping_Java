package com.java.shiftgroup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.shiftgroup.model.ShiftGroup;

@Repository
public interface ShiftGroupRepository extends JpaRepository<ShiftGroup, String>{
	List<ShiftGroup> findByCode(String shiftGroupCode);
}
