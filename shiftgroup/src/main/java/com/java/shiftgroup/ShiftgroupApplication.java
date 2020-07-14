package com.java.shiftgroup;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.java.shiftgroup.ShiftgroupApplication;
import com.java.shiftgroup.model.Shift;
import com.java.shiftgroup.model.ShiftGroup;
import com.java.shiftgroup.repository.ShiftGroupRepository;
import com.java.shiftgroup.repository.ShiftRepository;
import com.java.shiftgroup.service.ShiftGroupService;

@SpringBootApplication
public class ShiftgroupApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(ShiftgroupApplication.class, args);
		ShiftRepository shiftRepository = configurableApplicationContext.getBean(ShiftRepository.class);
		ShiftGroupRepository shiftGroupRepository = configurableApplicationContext.getBean(ShiftGroupRepository.class);
		
		//ShiftGroupService service = configurableApplicationContext.getBean(ShiftGroupService.class);
		
		Shift mornShift = new Shift(1,"M-01");
		Shift eveShift = new Shift(2,"E-02");
		Shift nightShift = new Shift(3,"N-03");
		List<Shift> shifts = Arrays.asList(mornShift,eveShift,nightShift);
		
		shiftRepository.saveAll(shifts);
		
		ShiftGroup grpA = new ShiftGroup(1,"A");
		ShiftGroup grpB = new ShiftGroup(2,"B");
		ShiftGroup grpC = new ShiftGroup(3,"C");
		ShiftGroup grpD = new ShiftGroup(4,"D");
		ShiftGroup grpE = new ShiftGroup(5,"E");
		ShiftGroup grpF = new ShiftGroup(6,"F");
		List<ShiftGroup> shiftGroups = Arrays.asList(grpA,grpB,grpC,grpD,grpE,grpF);
		
		grpA.addShift(mornShift);
		grpA.addShift(eveShift);
		grpA.addShift(nightShift);
		
		
		grpB.addShift(nightShift);
		grpB.addShift(mornShift);
		grpB.addShift(eveShift);
	
		
		grpC.addShift(eveShift);
		grpC.addShift(mornShift);
		grpC.addShift(nightShift);
		
		
		grpD.addShift(eveShift);
		grpD.addShift(mornShift);
		grpD.addShift(nightShift);
		
		grpE.addShift(nightShift);
		grpE.addShift(eveShift);
		grpE.addShift(mornShift);
		
		
		grpF.addShift(eveShift);
		grpF.addShift(mornShift);
		grpF.addShift(nightShift);
	
		
		shiftGroupRepository.saveAll(shiftGroups);
		shiftRepository.saveAll(shifts);
	}

}
