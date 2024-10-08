package com.hex.hiberHQL.com.hex.hiberHQL;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;









/**
 * Hello world!
 *
 */
public class App 
{
	
	SessionFactory fac;
	Session ses;
	Transaction tx;

	App() {
		fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();

		ses = fac.openSession();

	}
	
	void insertProduct(int Pid,String name , Double price,int qty) {
		tx = ses.beginTransaction();
		Product p = new Product();
		p.setPid(Pid);
		p.setName(name);
		p.setPrice(price);
		p.setQty(qty);
		ses.save(p);
	    tx.commit();
	     
	          System.out.println("Item added");
	      
	}
	
	
	void removeHQL(int Pid) {
		tx = ses.beginTransaction();

		String hql = "delete from Product P where P.Pid=:bn ";

		Query q = ses.createQuery(hql);

		q.setParameter("bn", Pid);

		
		int result= q.executeUpdate();
		tx.commit();
		if (result > 0) {
	          System.out.println("Item removed");
	      } else {
	          System.out.println("Failed to remove item");
	      }
		

	}
	
	
	void updateproduct(int Pid , Double Price) {
		tx = ses.beginTransaction();
		String hql = "Update Product P set P.price=:nm where P.Pid=:bn";
		Query q = ses.createQuery(hql);
		q.setParameter("bn", Pid);
		q.setParameter("nm", Price);
		int result= q.executeUpdate();
		tx.commit();
		if (result > 0) {
	          System.out.println("Price Updated");
	      } else {
	          System.out.println("Failed to  update price");
	      }
		

	}
	
	void Calculatebill(int Pid ,int qty) {
		Double totalBill=0.0;
		tx = ses.beginTransaction();
		String hql="from Product p where p.Pid=:pn and p.qty>:pq";
		Query q=ses.createQuery(hql, Product.class);
		q.setParameter("pn", Pid);
		q.setParameter("pq", qty);
		List<Product> l=q.getResultList();

		if(l!=null&&!l.isEmpty() )
		{
			Product p = l.get(0);
			
			int totQuantity=p.getQty();
			if(totQuantity<qty)
			{
				System.out.println("The required quantity is not available");
			}
			else
			{
				totalBill=qty*p.getPrice();
				System.out.println("The Total bill is   :" + totalBill);
			}
			ses.close();
			
		}
		else
		{
			System.out.println("Requested Product is not available");
		}
	   

	}
	


	
	
	
	
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	App app = new App();
    	while(true) {
			System.out.println("1. To insert");
			System.out.println("2. To remove Item");
			System.out.println("3. To Update Price.");
			System.out.println("4. To calculate total bill");	
			System.out.println("0. To exit");
			int ch=sc.nextInt();
			if(ch==1) {
		    	System.out.println("Enter Id:");
		    	int id  =sc.nextInt();
		    	System.out.println("Enter name:");
		    	String name =sc.next();
		    	System.out.println("Enter price");
		    	Double price =sc.nextDouble();
		    	System.out.println("Enter qty:");
		    	int qty  =sc.nextInt();
		    	app.insertProduct(id,name, price,qty);
			}
			else if(ch==2){
				System.out.println("Enter Id to remove:");
		     	int id  =sc.nextInt();
		    	app.removeHQL(id);
			}
			else if(ch==3) {
				System.out.println("Enter Id:");
		    	int id  =sc.nextInt();

	    	System.out.println("Enter price");
	    	Double price =sc.nextDouble();
	    	app.updateproduct(id, price);
			}
			else if (ch==4) {
				System.out.println("Enter Id:");
		    	int id  =sc.nextInt();
		    	System.out.println("Enter qty:");
		    	int qty  =sc.nextInt();
		    	app.Calculatebill(id, qty);
			}
		
			
			else if(ch==0) {
				break;
			}
			else {
				continue;
			}
		}

    	
        System.out.println( "Hello World!" );
    }
}
