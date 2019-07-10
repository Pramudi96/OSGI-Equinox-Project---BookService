package com.sa.bookstore;

public class Employee {

	private String EmpNo;
	private String EmpName;
	private int otHrs;
	private double basicSalary;
	
	public Employee(String EmpNo,String EmpName,int otHrs,double basicSalary){
		this.EmpNo = EmpNo;
		this.EmpName = EmpName;
		this.otHrs = otHrs;
		this.basicSalary = basicSalary;
	}

	public String getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(String empNo) {
		EmpNo = empNo;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public int getOtHrs() {
		return otHrs;
	}

	public void setOtHrs(int otHrs) {
		this.otHrs = otHrs;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	

}
