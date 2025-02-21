package com.jsp.hibernate.practice.criteriabuilder;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.practice.hql.Product;

public class CriteriaBuilderUpdate {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure()
				.addAnnotatedClass(Product.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction trans = session.beginTransaction();
		
		//update product set productPrice = 234 where productId = 105

		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaUpdate<Product> cu = cb.createCriteriaUpdate(Product.class);
		
		Root<Product> root= cu.from(Product.class);
		
		cu.set(root.get("productPrice"),234 );
		
		cu.where(cb.equal(root.get("productId"),105 ));
		
		Query <Product> query = session.createQuery(cu);
		
		int update = query.executeUpdate();
		
		System.out.println(update+" rows affected                         ");

		trans.commit();
		session.close();

	}

}
