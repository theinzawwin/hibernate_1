package com.best.hibernate.hibernate_proj1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.best.hibernate.hibernate_proj1.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static Session sessionObj;
    static SessionFactory sessionFactoryObj;
	public static SessionFactory getSessionFactory() {
		try {
    		StandardServiceRegistry standardRegistry = 
    		new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    		Metadata metaData = 
    		new MetadataSources(standardRegistry).getMetadataBuilder().build();
    		sessionFactoryObj = metaData.getSessionFactoryBuilder().build();
    		} catch (Throwable th) {

    			System.err.println("Enitial SessionFactory creation failed" + th);
    			throw new ExceptionInInitializerError(th);

    		}
        return sessionFactoryObj;
	}
    public static void main( String[] args )
    {
       Session session=getSessionFactory().openSession();
       session.beginTransaction();
       Student std1=new Student("Kaung Myat Htut", "14/3434", "kaung@gmail.com");
       session.save(std1);
       session.getTransaction().commit();
       System.out.println("Successfully Saved");
    }
}
