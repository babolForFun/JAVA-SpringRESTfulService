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
 * @author babolForFun
 *
 */
@RestController
@RequestMapping("/methods")
public class RESTcontroller {
  

	/**
	 * Create user binding the result
	 * @param user User
	 * @param result binding result
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUserFromRest(@ModelAttribute("user")User user, BindingResult result){

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
	    
	   return "{\"result\": \"User added\"}\n";
	}
	

	/**
	 * Get user from Id 
	 * @param id user id
	 * @return User string
	 */
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public String getUser(@RequestParam("_id") String id){

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
			return response.concat("\n");
		}else{
			return "{\"result\": \"Error: check Server log console\"}\n";
		}
	}

	/**
	 * Delete user binding the result
	 * @param _id user id
	 * @return response
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("_id") String _id){

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
	    	return "{\"result\": \"User deleted\"}\n";
	    }else{
	    	return "{\"result\": \"User with this ID does not exist\"}\n";
		}
	}

	/**
	 * Update [age] of a user
	 * @param _id user id
	 * @param age field to update
	 * @return response
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@RequestParam("_id") String _id,
							@RequestParam("age") String age){

	  	// Get Beans.xml from context and from it the bean UserJDBCTemplate
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	  	
	    // Update user
	    userJDBCTemplate.update(Integer.parseInt(_id),age);

	    // Response
    	return "{\"result\": \"User updated\"}".concat("\n");
  
	}

	/**
	 * List all user
	 * @return user list
	 */ 
	@RequestMapping(value = "/userlist")
	public String getUserList(){

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
	    	return response.concat("\n");
	    }else{
			return "{\"result\": \"Error: check Server log console\"}\n";
		}
	    
	}

}