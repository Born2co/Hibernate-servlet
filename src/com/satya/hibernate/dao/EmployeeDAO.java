package com.satya.hibernate.dao;
import com.satya.hibernate.model.Employee;


public interface EmployeeDAO {
	
boolean saveEmployeeDAO(Employee e);
Employee findEmployee(int empno);
int deleteEmployeeDAO(int  empno);

public int updateEmployee(int empno, int empsal);

}
