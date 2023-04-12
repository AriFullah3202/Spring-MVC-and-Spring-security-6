package com.test001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test001.dao.CustomerDAO;
import com.test001.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customer.setRole("ADMIN");
		customer.setEnable(true);
		customerDAO.saveCustomer(customer);
		
	}

}
