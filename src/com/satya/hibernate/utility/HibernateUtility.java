package com.satya.hibernate.utility;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {
	private static SessionFactory factory;
	private HibernateUtility(){}
	
	public static SessionFactory getSessionFactory(){
		    if(factory==null){
			Configuration config=new Configuration();
			config.configure("com/satya/hibernate/config/hibernate.cfg.xml");
			
			ServiceRegistry registry=new StandardServiceRegistryBuilder().
			applySettings(config.getProperties()).build();
			factory=config.buildSessionFactory(registry);
		}
		return factory;
		}

}
