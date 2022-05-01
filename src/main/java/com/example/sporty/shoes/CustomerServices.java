package com.example.sporty.shoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerServices {

		@Autowired
		private CustomerRepository repo;
		
		public List<Customer> listAll() {
			return repo.findAll();
		}
		
	}

