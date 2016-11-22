package com.niit.model;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

//replica of table
@Entity

//it is used to represent table name 
@Table(name="User")

//it has to pass atributes(variables)  to DAO
@Component

public class Furniture_User 
{
 //refers to primary key automatically
 
  
  //here Id we are not taking from user so it should be autogenerated.
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  
  private String role;
 // private static final AtomicInteger count=new AtomicInteger();
  
  
  
  
  public Furniture_User()
  {
	 // int i;
	  role="ROLE_USER";
	//  i=count.incrementAndGet();
	 // id="U_"+i;
	 // System.out.println("Created user :"+id);
  }
   
  public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = "ROLE_USER";
}

//public String getId() {
//	return id;
//}
//
//public void setId(String id) {
//	this.id = id;
//}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMailId() {
	return mailId;
}

public void setMailId(String mailId) {
	this.mailId = mailId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}



@NotEmpty(message="Please enter username")
  private String name;
  
  @NotEmpty(message="Please enter valid mail ID")
  private String mailId;
  
  @NotEmpty(message="Please enter valid password")   
  private String password;
  
  @NotEmpty(message="Please enter valid address")
  private String address;
  
  @NotEmpty(message="Please enter valid phone number")
  private String phoneNo;
   
}
