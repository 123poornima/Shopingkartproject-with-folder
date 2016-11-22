package com.niit.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

//replica of table
@Entity
//it is used to represent table name 
@Table(name="Furniture_Supplier")
//it has to pass atributes(variables)  to DAO
@Component
public class Furniture_Supplier
{
	 @Id
	  private String s_ID;
	  
	  
	  private String s_Name;
	  
	 
	  
	  
	  private String s_Address;
	  
	  
	  private String s_Phoneno;

	
	public void setS_ID(String s_ID) {
		this.s_ID = s_ID;
	}

	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}

	public void setS_Address(String s_Address) {
		this.s_Address = s_Address;
	}

	public void setS_Phoneno(String s_Phoneno) {
		this.s_Phoneno = s_Phoneno;
	}
    
	 
	public String getS_ID() {
		return s_ID;
	}

	public String getS_Name() {
		return s_Name;
	}

	public String getS_Address() {
		return s_Address;
	}

	public String getS_Phoneno() {
		return s_Phoneno;
	}
	
	
	  
	  
}
