package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.validation.constraints.*;


public class Employee {
    private String employeeSkillsValue;
    
    @NotNull
    @Size(min=8,max=10, message="Please enter a Name with at least between 8 and 10 characters.")
	private String name;
    private long id;
    
    @NotNull
    @Size(min=8,max=12, message="Please enter a value between 8 and 12.")
    private String contactNumber;
    private ArrayList<String> employeeSkills;
	private LinkedHashMap<Integer, String> employeeSkillsMap;
    private Date employeeDOB;


    public String getEmployeeSkillsValue() {
		return employeeSkillsValue;
	}
	public void setEmployeeSkillsValue(String employeeSkillsValue) {
		this.employeeSkillsValue = employeeSkillsValue;
	}
    
    public LinkedHashMap<Integer, String> getEmployeeSkillsMap() {
		return employeeSkillsMap;
	}
	public void setEmployeeSkillsMap(LinkedHashMap<Integer, String> employeeSkillsMap) {
		this.employeeSkillsMap = employeeSkillsMap;
	}
    
    public String getName() {
		return name;
	}
	public ArrayList<String> getEmployeeSkills() {
		return employeeSkills;
	}
	public void setEmployeeSkills(ArrayList<String> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}
	public Date getEmployeeDOB() {
		return employeeDOB;
	}
	public void setEmployeeDOB(Date employeeDOB) {
		this.employeeDOB = employeeDOB;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
 
    // standard getters and setters
	
	
	
}