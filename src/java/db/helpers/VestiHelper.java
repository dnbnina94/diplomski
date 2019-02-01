/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nina
 */
public class VestiHelper {
    
    private Session session;
    
    public VestiHelper() {
    }
    
    public List<Vesti> aktuelneVesti() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Vesti.class);
            c.addOrder(Order.desc("datum"));
            c.setMaxResults(5);
            List l = c.list();
            //Query q = session.createQuery("FROM Vesti order by date(datum) desc");
            //q.setMaxResults(5);
            //List l = q.list();
            session.getTransaction().commit();
            
            return l;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public Vesti getVestById(int idVest) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Vesti AS vest WHERE vest.idVest = " + idVest);
            List<Vesti> l =  (List<Vesti>) q.list();
            session.getTransaction().commit();
            
            if (l.isEmpty())
                return null;
            return l.get(0);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public int getMaxId() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Vesti AS vest");
            List<Vesti> vesti = (List<Vesti>) q.list();
            
            session.getTransaction().commit();
            
            if (vesti.isEmpty())
                return 0;
            else
                return vesti.get(vesti.size()-1).getIdVest();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void insertVest(Vesti vest) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();

            session.save(vest);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public List<Vesti> pretragaVesti() {
        return null;
    }
    
}
