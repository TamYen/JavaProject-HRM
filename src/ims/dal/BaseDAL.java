/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ANHB
 */
public class BaseDAL {
    public Session session;
    public SessionFactory sessionFactory;
    
    public BaseDAL(Class annotatedClass){
        try{
            connect(annotatedClass);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public BaseDAL(){
        try{
            connect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void connect() throws Exception
    {
        try{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                 
            sessionFactory  = configuration.buildSessionFactory(serviceRegistry);
//            sessionFactory = new Configuration().configure().addAnnotatedClass(annotatedClass).buildSessionFactory();
            session = sessionFactory.openSession();
        }catch(HibernateException ex){
            throw ex;
        }
    }

    public void connect(Class annotatedClass) throws Exception
    {
        try{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                 
            sessionFactory  = configuration.buildSessionFactory(serviceRegistry);
//            sessionFactory = new Configuration().configure().addAnnotatedClass(annotatedClass).buildSessionFactory();
            session = sessionFactory.openSession();
        }catch(HibernateException ex){
            throw ex;
        }
    }
    
    public void close() throws Exception{
        if(session != null){
            session.close();
            sessionFactory.close();
        }
    }
}
