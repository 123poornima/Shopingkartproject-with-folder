package com.niit.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

//replica of table
//it is used to represent table name 
//it has to pass atributes(variables)  to DAO
@Entity
@Table(name="Furniture_Category") 
@Component 
public class Furniture_Category
{ 
	  private String c_ID;  
	  private String c_Name;   
	  private String c_Description; 	 
	  private Set<Furniture> products;
	
	 //refers to primary key automatically
	 
	  @OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	  public Set<Furniture> getProducts() {
			return products;
		}

		public void setProducts(Set<Furniture> products) {
			this.products = products;
		}
	  
	  
	  @Id
	  public String getc_ID() 
	  {
		return c_ID;
	  }

	public String getc_Name()
	{
		return c_Name;
	}

	public String getC_Description()
	{
		return c_Description;
	}

	public void setc_ID(String c_ID)
	{
		this.c_ID = c_ID;
	}

	public void setc_Name(String c_Name) 
	{
		this.c_Name = c_Name;
	}

	public void setC_Description(String c_Description) 
	{
		this.c_Description = c_Description;
	}
	
	


	 
	 


}
