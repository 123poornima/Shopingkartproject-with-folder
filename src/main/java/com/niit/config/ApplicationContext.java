package com.niit.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Cart_Details;
import com.niit.model.Furniture_Category;
import com.niit.model.Furniture;
import com.niit.model.Furniture_Supplier;
import com.niit.model.Furniture_User;


//CONFIGURATION ANNOTATION-it is the replacement for the xml file....
//it indicates that the class can be used by the spring ioc container as a source of bean definition.

//COMPONENTSCAN-This annotation comes from spring framework 
//it scans package named com.niit and get all classes which are annotated with component and registered with spring container
@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContext 
{
	//BEAN-using bean in a method we can create an object which will be registered as bean in spring container
	//the name of the method will be considered as the name of the bean in spring container
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/poornima");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	private Properties getHibernateProperties()//properties is used to change database through dialect name
	{
		Properties properties =new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClass(Furniture_User.class);
		sessionBuilder.addAnnotatedClass(Furniture_Category.class);
		sessionBuilder.addAnnotatedClass(Furniture.class);
		sessionBuilder.addAnnotatedClass(Furniture_Supplier.class);
		sessionBuilder.addAnnotatedClass(Cart_Details.class);


		//sessionBuilder.addAnnotatedClass(UserDetails.class);
		System.out.println("connected");
		return sessionBuilder.buildSessionFactory();
	}
	
	
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction...");
		return transactionManager;
		
	}
}
