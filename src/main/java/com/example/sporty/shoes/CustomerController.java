package com.example.sporty.shoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	
		@Autowired
		CustomerServices service;
		@GetMapping("/customers")
		public String listUsers(Model model) {
			List<Customer> listUsers =  service.listAll();
			model.addAttribute("listUsers", listUsers);
			
			return "customerList";
		}
	}