package com.babolforfun.models;

public class User {

	// User attribute
	private int _id;
	private String name;
	private String surname;
	private String age;
	private String address;
	private String extra;
	
	// Void Constructor	
	public User(){};
	
	// Constructor
	public User(int _id, String name, String surname, String age, String address, String extra) {
		super();
		this._id = _id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.address = address;
		this.extra = extra;
	}
	
	// Getters and setters
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	
	
}
