package com.babolforfun.dao;

import java.util.List;

import javax.sql.DataSource;

import com.babolforfun.models.User;

/**
 * DAO User - interface of CRUD functions
 * @author babolforfun
 *
 */
public interface UserDAO {
	
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   
   /** 
    * This is the method to be used to create
    * a record in the User table.
    */
   public void createUser(String name,String surname,String age,String address,String extra);
   
   /** 
    * This is the method to be used to list down
    * a record from the User table corresponding
    * to a passed user id.
    */
   public User getUser(Integer id);
   
   /** 
    * This is the method to be used to list down
    * all the records from the User table.
    */
   public List<User> listAllUsers();
   
   /** 
    * This is the method to be used to delete
    * a record from the User table corresponding
    * to a passed student id.
    */
   public void delete(Integer id);
   
   /** 
    * This is the method to be used to update
    * a record into the User table.
    */
   public void update(Integer id, Integer age);
}