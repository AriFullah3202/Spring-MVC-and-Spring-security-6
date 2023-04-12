package com.test002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test001.entity.Customer;
import com.test001.service.CustomerService;

import jakarta.validation.Valid;

@Controller
public class TestController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/allvisitor")
	public String user() {
		return "test";
	}
	
	@RequestMapping("/customer")
	public String test() {
		return "customer";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	@RequestMapping("/allusers")
	public String user1() {
		return "user";
	}
	@RequestMapping("/test")
	public String test2() {
		return "test";
	}
	
	@RequestMapping("/insert")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		return "customer1";
	}
	@PostMapping("/process-insert")
	public String processCustomer(@Valid @ModelAttribute("customer") Customer customer , BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			
			for(ObjectError temp : allErrors) {
			}
			
			return "customer1";
		}
		
		customerService.saveCustomer(customer);
		return "redirect:/test";
	}

}
