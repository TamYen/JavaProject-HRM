/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ANHB
 */
public class EmployeeDAL extends BaseDAL{


    public EmployeeDAL() {
        super();
    }

//    private static Session getSession(){
//        sessionFactory = HIbernateUtil.getSessionFactory();
//        session =sessionFactory.getCurrentSession();
//        return session;
//    }
//    
//    public void closeSession() throws HibernateException{
//        if(session != null || session.isOpen()){
//            session.close();
//            sessionFactory.close();
//        }
//    }
    
    public void save(Employee e) throws Exception{        
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
//        close();
    }
    public void delete(Employee e) throws Exception{
        session.beginTransaction();
        session.delete(e);
        session.getTransaction().commit();
//        close();
    }
    public void update(Employee e) throws Exception{
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
//        close();
//        if(ss.isOpen()){
//            ss.close();
//            ssf.close();
//        }
//        Session ss =ssf.openSession();
//        ss.getTransaction().begin();
    }
    public List<Employee> getAll() throws Exception{
        List<Employee> result = new ArrayList<>();
//        session.beginTransaction();
        result = session.createQuery("from Employee order by maNv").list();
//        close();
        return result;
    }
    
}
