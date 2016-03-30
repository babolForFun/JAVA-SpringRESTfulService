package com.babolforfun.JDBCTemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.babolforfun.mapper.UserMapper;
import com.babolforfun.dao.UserDAO;
import com.babolforfun.models.User;


/**
 * Class JDBC User Template
 * @author babolForFun
 *
 */
public class UserJDBCTemplate implements UserDAO{

	// Variables
	private DataSource dataSource;				// DB connection
	private JdbcTemplate userJDBCTemplateObject;	
	
	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.userJDBCTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void createUser(String name, String surname, String age, String address, String extra) {
		
		// SQL query
		String SQL = "INSERT INTO User (name, surname, age, address, extra) VALUES  (?, ?, ?, ?, ?)";
		userJDBCTemplateObject.update( SQL, name, surname, age, address, extra);
    	
	    return;				
	}

	@Override
	public User getUser(Integer id) {
		
		// SQL query
		String SQL = "SELECT _id,name,surname,age,address,extra"
					+ " FROM User"
					+ " WHERE _id = ?";

		// User instance
	   	User user = null;
		
	   	try{
			user = userJDBCTemplateObject.queryForObject(
						SQL, 
	                    new Object[]{ id },
	                    new UserMapper()
	               );
		}catch(Exception e){
			System.out.println(". " + e.getMessage());
		}
	   	
	   	// Return user
		return user;
	}

	@Override
	public List<User> listAllUsers() {
		
		// SQL query
		String SQL = "SELECT _id,name,surname,age,address,extra"
				+ 	 " FROM User";
		
		// Calling user mapper for mapping
	 	List <User> users = userJDBCTemplateObject.query(
	 							SQL, 
	                            new UserMapper()
	                        );
	 	
	   	// Return List<User>
	 	return users;
	}

	@Override
	public void delete(Integer id) {
		
		// SQL query
		String SQL = "DELETE FROM User"
				+ 	 " WHERE _id = ?";
		userJDBCTemplateObject.update(SQL, id);
	 	
	  	return;				
	}

	@Override
	public void update(Integer id, String age) {
		
		// SQL query
		String SQL = "UPDATE User "
				+ 	 "SET age = ? "
				+ 	 "WHERE _id = ?";
		
		userJDBCTemplateObject.update(SQL, age, id);
	    
	    return;		
	}

}
