package com.babolforfun.controller;


import org.springframework.web.bind.annotation.RestController;

import com.babolforfun.JDBCTemplate.UserJDBCTemplate;
import com.babolforfun.models.User;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
	
	// Get user from Id
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public void getUser(@RequestParam("_id") String id){

	  	// Get Beans.xml from context and from it the bean UserJDBCTemplate
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	  	
	    // Create user from request POST
	    User user = userJDBCTemplate.getUser(Integer.parseInt(id));
	    
	    // User to Json
		Gson gson = new Gson();
		String response = gson.toJson(user);
		
		if (user!=null){
			System.out.println(response);
		}else{
			System.out.println("{\"result\": \"Error: check Server log console\"}");
		}
	}

	// Delete user binding the result
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteUser(@RequestParam("_id") String _id){

	  	// Get Beans.xml from context and from it the bean UserJDBCTemplate
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	  	
	    // Parse id
	    int id = Integer.parseInt(_id);
	    
	    // Check if user exist
	    User user = userJDBCTemplate.getUser(id);
	    
	    // Response
	    if (user != null){
	    	userJDBCTemplate.delete(id);
	    	System.out.println("{\"result\": \"Succesful\"}");
	    }else{
	    	System.out.println("{\"result\": \"User with this ID does not exist\"}");
		}
	}

	// Update [age] of a user
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateUser(@RequestParam("_id") String _id,
							@RequestParam("age") String age){

	  	// Get Beans.xml from context and from it the bean UserJDBCTemplate
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	  	
	    // Update user
	    userJDBCTemplate.update(Integer.parseInt(_id),age);

	    // Response
    	System.out.println("{\"result\": \"Succesful\"}");
  
	}

	// List all user
	@RequestMapping(value = "/userlist")
	public void getUserList(){

	  	// Get Beans.xml from context and from it the bean UserJDBCTemplate
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	  	
	    // Get the list
	    List<User> users = userJDBCTemplate.listAllUsers();
	    
	    // Serialize list
	    Gson gson = new Gson();
	    String response = gson.toJson(users);
	    
	    if (users!=null){
	    	System.out.println(response);
	    }else{
			System.out.println("{\"result\": \"Error: check Server log console\"}");
		}
//  curl http://localhost:8080/RESTService/rest/methods/userlist
	    

	}

}