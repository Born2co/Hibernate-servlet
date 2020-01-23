package com.satya.hibernate.dao;

        public class EmployeeDAOFactory {
	    public static EmployeeDAO getInstance() {
		return new EmployeeDAOImpl();
	}
}
