package com.satya.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.satya.hibernate.model.Employee;
import com.satya.hibernate.utility.HibernateUtility;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	
	
	
	

	public int updateEmployee(int empno, int empsal) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		
		Query query=session.createQuery
				("update Employee e set e.employeeSalary=? where e.employeeNumber=?");
		query.setParameter(0, empsal);
		query.setParameter(1,empno);
		
		
		org.hibernate.Transaction tx=session.beginTransaction();
		int k=query.executeUpdate();System.out.println(k);
		tx.commit();
		return k;
	}
	

	
	
	
	
	
	
	@Override
	public Employee findEmployee(int empno) {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Employee e=(Employee)session.get(Employee.class, empno);
		
		return e;
	}

	
	
	
	public int deleteEmployeeDAO(int empno) {
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Query query=session.createQuery("delete from Employee e where e.employeeNumber=?");
		query.setParameter(0,empno);
		org.hibernate.Transaction tx=session.beginTransaction();
		int k=query.executeUpdate();
		tx.commit();
		return k;
		
		
	}








	@Override
	public boolean saveEmployeeDAO(Employee e) {
	
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		
		try {
			session.save(e);tx.commit();session.close();
			return true;
			
		} catch (Exception e2) {
			tx.rollback();session.close();
			return false;
		}
	}
		
		
	

	
		

	}



	


