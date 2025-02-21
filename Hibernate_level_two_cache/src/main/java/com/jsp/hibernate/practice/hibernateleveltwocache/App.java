package com.jsp.hibernate.practice.hibernateleveltwocache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{

	public static void main(String[] args) {
		Configuration conn = new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Product.class);

		SessionFactory sf = conn.buildSessionFactory();

  		// session1
		Session session1 = sf.openSession();
		Transaction tran = session1.beginTransaction();

		Product product = session1.get(Product.class, 101);
		System.out.println(product);

		Product product2 = session1.get(Product.class, 101);
		System.out.println(product2);

		tran.commit();
		session1.close();

		System.out.println();

		// session2
		Session session2 = sf.openSession();
		Transaction tran2 = session2.beginTransaction();

		Product product3 = session2.get(Product.class, 101);
		System.out.println(product3);

		Product product4 = session2.get(Product.class, 101);
		System.out.println(product4);

		tran2.commit();
		session2.close();

	}

}
