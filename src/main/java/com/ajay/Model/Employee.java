package com.ajay.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int eid;	
private String fname;
private String lname;
private int age;
private String City;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public Employee(int eid, String fname, String lname, int age, String city) {
	this.eid = eid;
	this.fname = fname;
	this.lname = lname;
	this.age = age;
	City = city;
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", City=" + City + "]";
}
public Employee() {
	
}
}
