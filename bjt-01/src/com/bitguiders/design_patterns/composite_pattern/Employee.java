package com.bitguiders.design_patterns.composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private int salary;
	private String department;
	List<Employee> subOrdinates = new ArrayList<Employee>();
	
	public Employee(String name,String department,int salary){
		this.name=name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	public List<Employee> getSubOrdinates() {
		return subOrdinates;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSubOrdinates(List<Employee> subOrdinates) {
		this.subOrdinates = subOrdinates;
	}
	
	public void add(Employee e){
		this.subOrdinates.add(e);
	}
	public void remove(Employee e){
		this.subOrdinates.remove(e);
	}
	@Override
	public String toString() {
		return (subOrdinates.size()>0?"+":"-")+" name=" + name + ", salary=" + salary + ", department=" + department;
	}
	
}
