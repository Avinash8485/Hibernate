package com.jsp.hibernate.practice.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration().configure()
    		   .addAnnotatedClass(Product.class);
       
       SessionFactory sf = cfg.buildSessionFactory();
       
       Session session = sf.openSession();
       
       Transaction transaction = session.beginTransaction();
       
//      SELECT QUERY
//       Query<Product> query = session.createQuery("from Product p");
//       
//       List<Product> list = query.list();
//       
//       for(Product pro : list) {
//    	   System.out.println(pro);
//       }
       
       
       
//       UPDATE QUERY
//       Query<Product> query = session.createQuery("update Product p set p.productPrice = ?1 where p.productId between ?2 and ?3");
//       
//       query.setParameter(1, 1500);
//       query.setParameter(2, 101);
//       query.setParameter(3, 103);
       

//       DELETE QUERY
     Query<Product> query = session.createQuery("delete from Product p  where p.productId between ?2 and ?3");
     
    
     query.setParameter(2, 101);
     query.setParameter(3, 103);
       
       int rowsAffected = query.executeUpdate();
       
       if(rowsAffected> 0) {
    	   System.out.println(rowsAffected+" rows are updated");
       }else {
    	   System.out.println("no rows updated");
       }
       transaction.commit();
       session.close();
    }
}
