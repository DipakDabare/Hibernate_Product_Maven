package com.jbk.Product.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.Product.entity.Product;

public class HibernateUtility {
	
	public static SessionFactory getSessionFactory() {
		
		Configuration configuration=new Configuration();
		
	     configuration.configure().addAnnotatedClass(Product.class);
	  
		
		SessionFactory sessionFactory=configuration.buildSessionFactory();
//		SessionFactory sessionFactory = configuration.configure().addAnnotatedClass(Product.class).buildSessionFactory();
		return sessionFactory;
		
		
		
	}

}
