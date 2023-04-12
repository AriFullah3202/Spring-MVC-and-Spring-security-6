package com.test001.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test001.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
		System.out.println("customer is saved" +customer);
		
		
		
	}

}
