package com.jsp.hibernate.practice.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Company c = new Company();
    	c.setCompanyId(1);
    	c.setCompanyNmae("Amazon");
    	
    	Employee e1 = new Employee();
    	e1.setEmployeeId(101);
    	e1.setEmployeeName("Avinash");
    	e1.setEmployeeSalary(500000);
    	
    	Employee e2 = new Employee();
    	e2.setEmployeeId(102);
    	e2.setEmployeeName("Gowtham");
    	e2.setEmployeeSalary(600000);
    	
    	Employee e3 = new Employee();
    	e3.setEmployeeId(103);
    	e3.setEmployeeName("Yaswanth");
    	e3.setEmployeeSalary(700000);
    	
    	Employee e4 = new Employee();
    	e4.setEmployeeId(104);
    	e4.setEmployeeName("Akash");
    	e4.setEmployeeSalary(800000);
    	
    	
    	//many to one uniDirectional
    	e1.setCompany(c);
    	e2.setCompany(c);
    	e3.setCompany(c);
    	e4.setCompany(c);
    	
    	Configuration cfg = new Configuration().configure()
    			.addAnnotatedClass(Company.class)
    			.addAnnotatedClass(Employee.class);
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	Transaction trans = session.beginTransaction();
    	
    	session.save(c);
    	session.save(e1);
    	session.save(e2);
    	session.save(e3);
    	session.save(e4);
    	
    	
    	trans.commit();
    	session.close();
    	sf.close();
    }
}
