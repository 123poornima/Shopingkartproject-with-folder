package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart_Details;


//to connect to database by taking all attributes from pojo class
//REPOSITORY ANNOTATION-data access layer for application which used to get data from database
@EnableTransactionManagement
@Repository("cartDAO")
public class Cart_DetailsDAOImpl implements Cart_DetailsDAO
{
	//tell where injection need to occur 
	  @Autowired   
	   private SessionFactory sessionfactory;

	  
	   public Cart_DetailsDAOImpl(SessionFactory sessionfactory)
	   {
		   this.sessionfactory=sessionfactory;
	   }
	   
	   //used for transaction from model to DAO class
	   @Transactional
	   public void addToFurnitureCart(Cart_Details cart)
	   {
		  sessionfactory.getCurrentSession().saveOrUpdate(cart);
	   }
	   
	   @Transactional
	   public void deleteFurnitureCart(int id)
	   {
		   Cart_Details cart=new Cart_Details();
		   cart.setId(id);
			sessionfactory.getCurrentSession().delete(cart);
	   }
	   
	   @Transactional
	   public Cart_Details getFurnitureCart(String p_id)
	   {
		   String hql="from Cart where u_id="+"'"+p_id+"'";
			Query query=sessionfactory.getCurrentSession().createQuery(hql);
			List<Cart_Details> list=(List<Cart_Details>) query.list();
			if(list!=null&& !list.isEmpty())
			{
				return list.get(0);
			}
			return null;
	   }
	   @Transactional
	   public List<Cart_Details> furnitureCartList()
	   {
		   List<Cart_Details> list= (List<Cart_Details>) sessionfactory.getCurrentSession().createCriteria(Cart_Details.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
	   }
	   @Transactional
	   public List<Cart_Details> userFurnitureCartList(String uname)
	   {
		  
		   //HQL(hibernate query language) is an object-oriented query language, similar to SQL, but instead of operating on tables and columns,HQL works with persistent objects and their properties.
		 //data is fetched from cart using user id
		   String hql="from Cart_Details where u_id="+"'"+uname+"'";
			@SuppressWarnings("rawtypes")
			Query query=sessionfactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Cart_Details> list=query.list();
			if(list!=null&& !list.isEmpty())
			{
				return list;
			}
			return null;
	   }
}
