package edu.training.model;
import java.util.*;


public class User {
String name;
Date dob;

String email;
String mob;
String passwd;

public User(String name,Date dob,String mob,String email,  String passwd) {
	super();
	this.name = name;
	this.dob=dob;
	this.email = email;
	this.mob = mob;
	this.passwd = passwd;
	
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMob() {
	return mob;
}
public void setMob(String mob) {
	this.mob = mob;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}


  public Date getDob() { return dob; }
  
 public void setDob(Date dob) { this.dob = dob; }
 

@Override
public String toString() {
	return "User [name=" + name + ", email=" + email + ", mob=" + mob + ", passwd=" + passwd
			+ ", dob=" + dob + "]";
}



}
