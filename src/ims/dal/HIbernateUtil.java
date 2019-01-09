/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ANHB
 */
public class HIbernateUtil {
    private static SessionFactory sessionFactory;
    
    private static SessionFactory buildFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null )
            sessionFactory = buildFactory();
        return sessionFactory;
    }
}
