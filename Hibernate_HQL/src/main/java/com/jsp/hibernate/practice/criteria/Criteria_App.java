package com.jsp.hibernate.practice.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jsp.hibernate.practice.hql.Product;

public class Criteria_App {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure()
				.addAnnotatedClass(Product.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction trans = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("productId", 105));
		
		criteria.setProjection(Projections.property("productName"));
		
		List<String> plist = criteria.list();
		
		for(String product :plist) {
			System.out.println(product);
		}
		
		trans.commit();
		session.close();
	}

}
