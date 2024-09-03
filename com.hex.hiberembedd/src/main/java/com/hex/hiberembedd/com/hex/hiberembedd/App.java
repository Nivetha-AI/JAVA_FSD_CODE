package com.hex.hiberembedd.com.hex.hiberembedd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App 
{

		
    public static void main( String[] args )
    {
    	 SessionFactory fac=new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	    	
		 Session ses=fac.openSession();
			
		 Transaction tx=ses.beginTransaction();
    	Student s1=new Student();
    	Result r=new Result();
    	r.setMarks(99);
    	r.setSub("Maths");
    	s1.setRoll(3);
    	s1.setName("ASha");
    	 s1.setFee(1000.0);
    	s1.setRes(r);
    	ses.save(s1);
    	tx.commit();
        System.out.println( "Hello World!" );
    }
}
