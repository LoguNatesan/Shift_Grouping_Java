package com.java.shiftgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.shiftgroup.model.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,String> {
}
