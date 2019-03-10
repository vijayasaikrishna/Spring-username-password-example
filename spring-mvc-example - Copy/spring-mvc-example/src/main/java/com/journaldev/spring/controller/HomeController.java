package com.journaldev.spring.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.User;
import com.journaldev.spring.model.User1;
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home1(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime1", formattedDate);

		return "home1";
	}

	@RequestMapping(value = "/User1", method = RequestMethod.POST)
	public String user1(@Validated User1 user, Model model) {
		System.out.println("User Page1 Requested");
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("password1",user.getPassword1());
		model.addAttribute("password",user.getPassword());
		
		return "user1";
	}
	
	@RequestMapping(value = "/User", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("password",user.getPassword());
		
		return "user";
	}
	
}

 