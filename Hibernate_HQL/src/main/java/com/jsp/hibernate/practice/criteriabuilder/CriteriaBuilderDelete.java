package com.jsp.hibernate.practice.criteriabuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.practice.hql.Product;

public class CriteriaBuilderDelete {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure()
				.addAnnotatedClass(Product.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction trans = session.beginTransaction();
		
		//update product set productPrice = 234 where productId = 105

		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaDelete<Product> cd = cb.createCriteriaDelete(Product.class);
		
		Root<Product> root= cd.from(Product.class);
		
		cd.where(cb.equal(root.get("productId"),105 ));
		
		Query <Product> query = session.createQuery(cd);
		
		int delete = query.executeUpdate();
		
		System.out.println(delete+" rows affected                         ");

		trans.commit();
		session.close();
	}

}
