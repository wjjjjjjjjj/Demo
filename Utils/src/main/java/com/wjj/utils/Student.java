package com.wjj.utils;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sname;
	
	transient private int age;

	public Student(String sname, int age) {
		super();
		this.sname = sname;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [sname=" + sname + ", age=" + age + "]";
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
