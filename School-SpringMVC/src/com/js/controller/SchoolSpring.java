package com.js.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SchoolSpring {
	 
	@RequestMapping("/welcome")
	public ModelAndView welcomeToSchool() {
 		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello There, Welcome to School Spring MVC</h3>This message is coming from SchoolController.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}