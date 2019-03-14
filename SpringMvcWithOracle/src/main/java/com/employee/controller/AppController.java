package com.employee.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
//@RequestMapping("/")
public class AppController {
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		return "deptManagement";
	}
	@RequestMapping(value = {"/home/","/home"},method = RequestMethod.GET)
	public String emps() {
		return "empManagement";
	}
}