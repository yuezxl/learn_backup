package com.zxl.bean;

import java.io.Serializable;

public class EmployeeExt implements Serializable{
private static final long serialVersionUID = 6922268437342295432L;
	
	public static Long testId = 12L;
	
	public Long getTheId() {
		return id;
	}
	
	private Long id;
	private String name1;
	private String email;
	private String address;
	transient private Integer age;
	
	private String ext;
	
	public String toString() {
		return "Person{id=" + id + ",age=" + age +  "}";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
}
