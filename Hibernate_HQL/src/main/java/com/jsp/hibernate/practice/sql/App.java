package com.jsp.hibernate.practice.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.jsp.hibernate.practice.hql.Product;

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
//       NativeQuery<Product> query = session.createNativeQuery("select * from Product",Product.class);
//       
//       List<Product> list = query.list();
//       
//       for(Product pro : list) {
//    	   System.out.println(pro);
//       }
       
       
       
//       UPDATE QUERY
//       NativeQuery<Product> query = session.createNativeQuery("update product  set productPrice = ?1 where productId between ?2 and ?3",Product.class);
//       
//       query.setParameter(1, 1500);
//       query.setParameter(2, 101);
//       query.setParameter(3, 103);
       

//       DELETE QUERY
     NativeQuery<Product> query = session.createNativeQuery("delete from product   where productId between ?2 and ?3",Product.class);
     
    
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
