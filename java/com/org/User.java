package com.org;

public class User {

     private String name;   
     private String mail;
     private long phone;
     private String subject;
     private String password;
     
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String name, String mail, long phone, String subject, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.subject = subject;
		this.password = password;
	}
     
     
}
