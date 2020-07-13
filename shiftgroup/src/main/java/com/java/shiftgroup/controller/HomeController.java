package com.java.shiftgroup.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.shiftgroup.model.Shift;
import com.java.shiftgroup.model.ShiftGroup;
import com.java.shiftgroup.service.ShiftGroupService;
import com.java.shiftgroup.service.ShiftService;

@Controller
public class HomeController {
	
	@Autowired
	private ShiftGroupService shiftGroupService;
	
	@Autowired
	private ShiftService shiftService;
	
	@RequestMapping(value="home", method= RequestMethod.GET)
	public String gethomeView(Model model)
	{
		List<ShiftGroup> listShiftGroups = shiftGroupService.listAllShiftGroups();
		List<Shift> listShifts = shiftService.listAllShifts();
		model.addAttribute("listShiftGroups",listShiftGroups);
		model.addAttribute("listShifts",listShifts);
		model.addAttribute("shiftGroup", new ShiftGroup());
		
		return "homePage";
	}
	
	@RequestMapping(value="home", method= RequestMethod.POST)
	public String gethomeView(Model model,@RequestParam String shiftGroupCode, @RequestParam String shiftCode )
	{
	    System.out.println("Query param: ShiftGroupCode: " + shiftGroupCode);
	    System.out.println("Query param: ShiftCode: " + shiftCode);
		List<ShiftGroup> listShiftGroups = shiftGroupService.listAllShiftGroups();
		List<Shift> listShifts = shiftService.listAllShifts();
		model.addAttribute("listShiftGroups",listShiftGroups);
		model.addAttribute("listShifts",listShifts);
		
		boolean checkShift = shiftGroupService.doesShiftBelongToGroup(shiftCode, shiftGroupCode);
		
		if(checkShift) System.out.println("Selected shift code: '" + shiftGroupCode + "' belongs to shift group: " + shiftCode);
		else System.out.println("Selected shift code: '" + shiftGroupCode + "' does not belong to shift group: " + shiftCode);
		return "homePage";
	}

}
