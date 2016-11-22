package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Furniture_Category;
import com.niit.model.Furniture;

//import antlr.collections.List;

//connects the database by taking from pojo class 
@EnableTransactionManagement
@Repository("productDAO")
public class FurnitureDAOImpl implements FurnitureDAO
{	
	@Autowired
	private SessionFactory sessionFactory; 
	
	public FurnitureDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public void addFurniture(Furniture product)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	
	@Transactional
	public void deleteFurniture(String Id)
	{
		Furniture product=new Furniture();
		product.setp_id(Id);
		sessionFactory.getCurrentSession().delete(product);
	}
	
	@Transactional
	public Furniture getFurniture(String Id)
	{
		String hql="from Furniture where p_id=" +"'"+Id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Furniture> listProduct=(List<Furniture>)query.list();
		if(listProduct!=null && !listProduct.isEmpty())
		{
			return listProduct.get(0);
		}
		
		return null;
	}
	
	
	
	@Transactional
	public Furniture getFurnitureName(String name)
	{
		String hql="from Furniture where p_name=" +"'"+name+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Furniture> listProduct=(List<Furniture>)query.list();
		if(listProduct!=null && !listProduct.isEmpty())
		{
			return listProduct.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public List<Furniture> furnitureList()
	{
		List<Furniture> listProduct=(List<Furniture>)sessionFactory.getCurrentSession().createCriteria(Furniture.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listProduct;
	}
	
}
