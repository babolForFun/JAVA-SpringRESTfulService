package com.babolforfun.controller;


import org.springframework.web.bind.annotation.RestController;

import com.babolforfun.JDBCTemplate.UserJDBCTemplate;
import com.babolforfun.models.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
 

/**
 * REST controller
 * @author kaliba
 *
 */
@RestController
@RequestMapping("/methods")
public class RESTcontroller {
 
	// Create user binding the result
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUserFromRest(@ModelAttribute("user")User user, BindingResult result){

	  	// Get Beans.xml from context and from it the bean UserJDBCTemplate
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	  	
	    // Create user from request POST
	    userJDBCTemplate.createUser(
	    		user.getName(),
	    		user.getSurname(),
	    		user.getAge(),
	    		user.getAddress(),
	    		user.getExtra());
	    
	   System.out.println("{\"result\": \"succesfull\"}");

	}
}