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
		
		ShiftGroupService service = configurableApplicationContext.getBean(ShiftGroupService.class);
		
		Shift mornShift = new Shift("M-01");
		Shift eveShift = new Shift("E-02");
		Shift nightShift = new Shift("N-03");
		List<Shift> shifts = Arrays.asList(mornShift,eveShift,nightShift);
		
		shiftRepository.saveAll(shifts);
		
		ShiftGroup grpA = new ShiftGroup("A");
		ShiftGroup grpB = new ShiftGroup("B");
		ShiftGroup grpC = new ShiftGroup("C");
		ShiftGroup grpD = new ShiftGroup("D");
		ShiftGroup grpE = new ShiftGroup("E");
		ShiftGroup grpF = new ShiftGroup("F");
		List<ShiftGroup> shiftGroups = Arrays.asList(grpA,grpB,grpC,grpD,grpE,grpF);
		
		grpA.addShift(mornShift);
		grpB.addShift(nightShift);
		grpC.addShift(eveShift);
		grpD.addShift(mornShift);
		grpE.addShift(nightShift);
		grpF.addShift(eveShift);
		grpB.addShift(eveShift);
		grpD.addShift(eveShift);
		
		shiftGroupRepository.saveAll(shiftGroups);
		
		shiftRepository.saveAll(shifts);
		
		System.out.println("----------->" + service.doesShiftBelongToGroup("Even02", "F"));
	}

}
