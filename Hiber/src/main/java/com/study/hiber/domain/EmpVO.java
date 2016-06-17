package com.study.hiber.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 관계형 DB에서 table 하나
@Entity
@Table(name="emp")
public class EmpVO {
	
	@Id
	@Column(name="emp_no")
	int emp_no;
	
	@Column(name="emp_name")
	String emp_name;
	
	@Column(name="address")
	String address;

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	
}
