package com.java.shiftgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.shiftgroup.model.ShiftGroup;
import com.java.shiftgroup.service.ShiftGroupService;

@Controller
public class HomeController {
	
	@Autowired
	private ShiftGroupService shiftGroupService;
	
	@RequestMapping(value="home", method= RequestMethod.GET)
	public String homeView(Model model)
	{
		List<ShiftGroup> listShiftGroups = shiftGroupService.listAllShiftGroups();
		
		model.addAttribute("message", "code is correct");
		//System.out.println("%%%%%%%%%%%%%%%%%hiiiiii");
		return "homePage";
	}

}
