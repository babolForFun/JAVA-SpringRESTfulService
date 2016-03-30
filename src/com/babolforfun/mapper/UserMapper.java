package com.babolforfun.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.babolforfun.models.User;

/**
 * Mapper from db to User object
 * @author babolForFun
 *
 */
public class UserMapper  implements RowMapper<User>{
	
	/** 
	 *	Map the user from DB to MODEL 
	 */
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		  
		// Create new object
	   User user = new User();	      

	   // Set the params
	   user.set_id		(rs.getInt("_id"));
	   user.setName		(rs.getString("name"));
	   user.setSurname	(rs.getString("surname"));
	   user.setAge		(rs.getString("age"));
	   user.setAddress	(rs.getString("address"));
	   user.setExtra	(rs.getString("extra"));
		
	   // return User object
	   return user;
	   }
}
