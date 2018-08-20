package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Customer;
import com.example.entity.EmployeeDAO;
import com.example.model.FCDVRequest;
import com.example.model.FCDVResponse;
import com.example.utility.CommonUtility;

@RestController
public class EmployeeController {
	
	private EmployeeDAO employeeDAO;
	
	private CommonUtility commonUtility;
	
	
	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO,CommonUtility commonUtility) {
		this.employeeDAO = employeeDAO;
		this.commonUtility = commonUtility;
	}

	@RequestMapping(value="/api/onlineCiti", method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FCDVResponse updateOnlineCitiBankService(@RequestBody FCDVRequest requestBody){
		FCDVResponse fcdvResponse = new FCDVResponse();
		Customer customer = this.commonUtility.populatePojoToEntity(requestBody);
		customer =  this.employeeDAO.save(customer);
		if(customer.getId() != null) {
			fcdvResponse.setMessageType("Your customer is recorded successfully with Id :" + customer.getId());
			fcdvResponse.setResponseMessage("Thanks for contacting our service");
		}
		return fcdvResponse;
	}
	

	@RequestMapping(value="/api/onlineCiti", method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FCDVResponse handleOnlineCitiBankService(@RequestBody FCDVRequest requestBody){
		FCDVResponse fcdvResponse = new FCDVResponse();
		Customer customer = this.commonUtility.populatePojoToEntity(requestBody);
		customer =  this.employeeDAO.save(customer);
		if(customer.getId() != null) {
			fcdvResponse.setMessageType("Your customer is recorded successfully with Id :" + customer.getId());
			fcdvResponse.setResponseMessage("Thanks for contacting our service");
		}
		return fcdvResponse;
	}
	
	@RequestMapping(value="/api/onlineCiti", method=RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<Customer> getOnlineCitiBankService(){
		Iterable<Customer> listCustomer =  this.employeeDAO.findAll();
		return listCustomer;
	}
	
}
