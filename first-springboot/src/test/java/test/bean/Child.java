package test.bean;

import java.io.Serializable;

public class Child extends Parent implements Serializable{
	
	private static final long serialVersionUID = -1189613059643005622L;
	private String school;
	private String email;
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
