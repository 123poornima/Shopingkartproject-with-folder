package com.niit.model; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//replica of table
//it has to pass atributes(variables)  to DAO
//it is used to represent table name

@Entity
@Table(name="Furniture")
@Component 
public class Furniture 
{
 //refers to primary key automatically

  
  //here Id we are not taking from user so it should be autogenerated.
	@Id
    private String p_id; 
	private String p_name;
	private int p_price;
	private String p_description;
	private String category_id;
	private String supplier_id;
	
	  @ManyToOne
	  @JoinColumn(name="category_id",nullable=false,updatable=false,insertable=false)
	  private Furniture_Category  category;
	  
	  @ManyToOne
	  @JoinColumn(name="supplier_id",nullable=false,updatable=false,insertable=false)
	  private Furniture_Supplier supplier;
	
	  
  public String getp_id() {
	return p_id;
}

public void setp_id(String p_id) {
	this.p_id =  p_id;
}

public String getp_name() {
	return p_name;
}

public void setp_name(String p_name) {
	this.p_name = p_name;
}

public int getp_price() {
	return p_price;
}

public void setp_price(int p_price) {
	this.p_price = p_price;
}

public String getp_description() {
	return p_description;
}

public void setp_description(String p_description) {
	this.p_description = p_description;
}


 
  
public Furniture_Category getCategory() {
	return category;
}

public void setCategory(Furniture_Category category) {
	this.category = category;
}

public Furniture_Supplier getSupplier() {
	return supplier;
}

public void setSupplier(Furniture_Supplier supplier) {
	this.supplier = supplier;
}

public String getCategory_ID() {
	return category_id;
}

public void setCategory_ID(String category_id) {
	this.category_id = category_id;
}

public String getSupplier_ID() {
	return supplier_id;
}

public void setSupplier_ID(String supplier_id) {
	this.supplier_id= supplier_id;
}
  
  @Transient
  private MultipartFile image;
  
  
  public MultipartFile getImage()
  {
	  return image;
  }
  
  public void setImage(MultipartFile image)
  {
	  this.image=image;
  }
  
    
}

