package com.jsp.hibernate.practice.onrtomany;

import java.util.ArrayList;
import java.util.List;

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
		c.setCompanyName("MicroSoft");

		Company c1 = new Company();
		c1.setCompanyId(2);
		c1.setCompanyName("Amazon");

		Employee e1 = new Employee();
		e1.setEmployeeId(101);
		e1.setEmployeeName("Avinash");
		e1.setEmployeeSalary(100000);

		Employee e2 = new Employee();
		e2.setEmployeeId(102);
		e2.setEmployeeName("Yeswanth");
		e2.setEmployeeSalary(150000);

		Employee e3 = new Employee();
		e3.setEmployeeId(103);
		e3.setEmployeeName("Gowtham");
		e3.setEmployeeSalary(120000);

		Employee e4 = new Employee();
		e4.setEmployeeId(104);
		e4.setEmployeeName("Akash");
		e4.setEmployeeSalary(130000);
		
		/* need to write this code only if you use bidirectional without mappedBy

		//Adding Employee objects inside a list
		List<Employee> elist = new ArrayList<Employee>();
		elist.add(e1);
		elist.add(e2);
		elist.add(e3);
		elist.add(e4);


		//By using setter method adding a list to get foreign key connection
		c.setEmployee(elist);


		*/
		
		
		//By using setter method adding a Emplopyee companyName to get foreign key connection
		e1.setCompany(c);
		e2.setCompany(c);
		e3.setCompany(c1);
		e4.setCompany(c1);

		Configuration cfg = new Configuration().configure()
				.addAnnotatedClass(Company.class)
				.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction trans = session.beginTransaction();

		session.save(c);
		session.save(c1);
		session.save(e4);
		session.save(e3);
		session.save(e1);
		session.save(e2);

		trans.commit();
		session.close();
		sf.close();
	}
}
