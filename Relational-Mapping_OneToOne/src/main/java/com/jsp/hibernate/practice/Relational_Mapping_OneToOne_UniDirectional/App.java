package com.jsp.hibernate.practice.Relational_Mapping_OneToOne_UniDirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Person person = new Person();
    	person.setPersonId(101);
    	person.setPersonName("Avinash");
    	
    	Aadhar aadhar = new Aadhar();
    	aadhar.setAadharId(1);
    	aadhar.setAadharNo(9876543210l);
    	
    	/*UNIDIRECTIONAL
    	
    	//Unidirectional - Adding aadhar object inside person
    	//person.setAadhar(aadhar);
    	
    	*/
    	
    	
    	
    	/*BIDIRECTIONAL
    	 
    	//Bidirectional - Adding aadhar object inside person
    	person.setAadhar(aadhar);
    	
    	//Biidirectional - Adding aadhar object inside person
    	aadhar.setPerson(person);
    	
    	*/
    	
    	
    	// BIDIRECTIONAL USING MAPPEDBY
    	 
    	//Bidirectional - Adding aadhar object inside person
    	person.setAadhar(aadhar);
    	 
    	 
       Configuration conn = new Configuration();
       conn.configure();
       conn.addAnnotatedClass(Person.class);
       conn.addAnnotatedClass(Aadhar.class);
       
       SessionFactory sos = conn.buildSessionFactory();
       
       Session ss = sos.openSession();
       
       Transaction tran = ss.beginTransaction();
       
       ss.save(aadhar);
       ss.save(person);
       
       tran.commit();
       ss.close();
       sos.close();
       }
}
