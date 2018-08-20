package com.example.utility;

import org.springframework.stereotype.Component;

import com.example.entity.Customer;
import com.example.model.FCDVRequest;

@Component
public class CommonUtility {

	
	public Customer populatePojoToEntity(FCDVRequest fcdvRequest) {
		
		Customer customer = new Customer();
		
		if(fcdvRequest.getEmail() != null && !fcdvRequest.getEmail().trim().isEmpty()) {
			customer.setEmail(fcdvRequest.getEmail());
		}
		
		if(fcdvRequest.getId() != null && !fcdvRequest.getId().trim().isEmpty()) {
			customer.setId(new Long(fcdvRequest.getId()));
		}
		
		if(fcdvRequest.getName() != null && !fcdvRequest.getName().trim().isEmpty()) {
			customer.setName(fcdvRequest.getName());
		}
		
		if(fcdvRequest.getPassword() != null && !fcdvRequest.getPassword().trim().isEmpty()) {
			customer.setPassword(fcdvRequest.getPassword());
		}
		
		if(fcdvRequest.getPhoneNumber() != null && !fcdvRequest.getPhoneNumber().trim().isEmpty()) {
			customer.setPhoneNumber(fcdvRequest.getPhoneNumber());
		}
		
		return customer;
		
	}
}
