package com.amazonaws.lambda.schedulelambda;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee {
	
	private int empId;
	
	private String name;
	private String department;
	private Address address;
	public int getEmpId() {
		return empId;
	}
	@XmlAttribute(name="id")
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	@XmlElement
	public void setDepartment(String department) {
		this.department = department;
	}
	public Address getAddress() {
		return address;
	}
	@XmlElement
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", department=" + department + ", address=" + address
				+ "]";
	}
	
	
	
}
