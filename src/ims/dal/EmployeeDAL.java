/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ANHB
 */
public class EmployeeDAL extends BaseDAL{

//    private Session session;
//    private SessionFactory sessionFactory;

    public EmployeeDAL(Class annotatedClass) {
        super(annotatedClass);
    }

//    public EmployeeDAL() {
//        try {
//            connect();
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void connect() throws Exception
//    {
//        try{
//            sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
//            session = sessionFactory.openSession();
//        }catch(HibernateException ex){
//            throw ex;
//        }
//    }
//    
//    public void close() throws Exception{
//        if(session != null){
//            session.close();
//            sessionFactory.close();
//        }
//    }
    
    public void save(Employee e) throws Exception{        
        SessionFactory ssf = HIbernateUtil.getSessionFactory();
        Session ss =ssf.openSession();
        ss.beginTransaction();
        ss.save(e);
        ss.getTransaction().commit();
        ssf.close();
    }
    public void delete(Employee e) throws Exception{
        SessionFactory ssf = HIbernateUtil.getSessionFactory();
        Session ss =ssf.getCurrentSession();
        ss.beginTransaction();
        ss.delete(e);
        ss.getTransaction().commit();
        ssf.close();
    }
    public void update(Employee e) throws Exception{
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        close();
    }
    public List<Employee> getAll() throws Exception{
        List<Employee> result = new ArrayList<>();
        result = session.createQuery("from Employee").list();
        System.out.println(result.size());
        close();
        return result;
    }
}
