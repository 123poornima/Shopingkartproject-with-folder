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
import com.niit.model.Furniture_Supplier;
@EnableTransactionManagement
//connects to DB by taking attributes from POJO class
@Repository("supplierDAO")
public class Furniture_SupplierDAOImpl implements Furniture_SupplierDAO
{  //IT WILL CREATE AN OBJECT WITHOUT HELP OF NEW OPERATOER
	@Autowired
	private SessionFactory sessionfactory;
	
	public Furniture_SupplierDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	//used to transaction from model to dao class
	@Transactional
	public void addFurnitureSupplier(Furniture_Supplier supplier)
	{
		sessionfactory.getCurrentSession().saveOrUpdate(supplier);
	}
	
	@Transactional
	public void deleteFurnitureSupplier(String id)
	{
		Furniture_Supplier supplier =new Furniture_Supplier();
		supplier.setS_ID(id);
		sessionfactory.getCurrentSession().delete(supplier);
		
	}
	@Transactional
	public Furniture_Supplier getFurnitureSupplier(String id)
	{
		String hql= "from Furniture_Supplier where s_ID = " +"'" + id +"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Furniture_Supplier> listSupplier= (List<Furniture_Supplier>)query.list();
		if (listSupplier != null && !listSupplier.isEmpty())
		{
			return listSupplier.get(0);
		}
		return  null;
	}
	
	@Transactional
	public Furniture_Supplier getFurnitureSupplireName(String name)
	{
		String hql= "from Furniture_Supplier where s_Name = " +"'" + name +"'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Furniture_Supplier> listSupplier= query.list();
		if (listSupplier != null || !listSupplier.isEmpty())
		{
			return listSupplier.get(0);
		}
		return  null;
	}
	@Transactional
	public List<Furniture_Supplier> furnitureSupplierList()
	{
		List<Furniture_Supplier> listSupplier = (List<Furniture_Supplier>)sessionfactory.getCurrentSession().createCriteria(Furniture_Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	     return listSupplier;
	}
}
