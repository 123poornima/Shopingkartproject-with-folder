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

@EnableTransactionManagement
@SuppressWarnings("deprecation")
@Repository("categoryDAO")
public class Furniture_CategoryDAOImpl implements Furniture_CategoryDAO 
{
	@Autowired
	private SessionFactory sessionFactory; 
	
	public Furniture_CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public void addFurnitureCategory(Furniture_Category category)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	
	@Transactional
	public void deleteFurnitureCategory(String id)
	{
		Furniture_Category category=new Furniture_Category();
		category.setc_ID(id);
		sessionFactory.getCurrentSession().delete(category);
	}
	
	@Transactional
	public Furniture_Category getFurnitureCategory(String id)
	{
		String hql="from Furniture_Category where c_ID="+"'"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Furniture_Category> list=(List<Furniture_Category>) query.list();
		if(list!=null&& !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public Furniture_Category getFurnitureCategoryName(String name)
	{
		String hql="from Furniture_Category where c_Name="+"'"+ name +"'";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Furniture_Category> list= query.list();
		if(list!=null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public List<Furniture_Category> furnitureCategoryList()
	{
		List<Furniture_Category> list= (List<Furniture_Category>) sessionFactory.getCurrentSession().createCriteria(Furniture_Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
				
	}
}