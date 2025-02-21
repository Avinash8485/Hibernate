package com.jsp.hibernate.practice.criteriabuilder;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.practice.hql.Product;

public class CriteriaBuilder_App {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure()
				.addAnnotatedClass(Product.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction trans = session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<Product> cq = cb.createQuery(Product.class);

		Root<Product> root = cq.from(Product.class);
		cq.select(root);
		cq.where(cb.equal(root.get("productId"), 105));

		Query<Product> query = session.createQuery(cq);

		List<Product> plist = query.list();	

		for(Product product :plist) {
			System.out.println(product);
		}

		trans.commit();
		session.close();

	}

}
