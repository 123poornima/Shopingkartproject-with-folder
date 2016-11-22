package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Furniture;
import com.niit.model.Furniture_User;

//
@EnableTransactionManagement

//to connect to database by taking all attributes from pojo class
@Repository("userDAO")
public class Furniture_UserDAOImpl implements Furniture_UserDAO
{
	
	//it will create an object without the help of new operator 	
   @Autowired    
   private SessionFactory sessionfactory;
   
   public Furniture_UserDAOImpl(SessionFactory sessionfactory)
   {
	   this.sessionfactory=sessionfactory;
   }
   
   //used for transaction from model to DAO class
   @Transactional
   public void addFurnitureUser(Furniture_User user)
   {
	  sessionfactory.getCurrentSession().saveOrUpdate(user);
   }
  
   @Transactional
	public Furniture_User getFurnitureUser(int Id)
	{
		String hql="from user where id="+Id;
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		List<Furniture_User> listUser=(List<Furniture_User>)query.list();
		if(listUser!=null && !listUser.isEmpty())
		{
			return listUser.get(0);
		}
		
		return null;
	}
}
