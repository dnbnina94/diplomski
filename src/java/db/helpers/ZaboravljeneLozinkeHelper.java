/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.ZaboravljeneLozinke;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nina
 */
public class ZaboravljeneLozinkeHelper {
    
    private Session session;
    
    public ZaboravljeneLozinkeHelper() {
        
    }
    
    public ZaboravljeneLozinke getRequest(String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(ZaboravljeneLozinke.class);
            c.add(Restrictions.eq("korisnickoIme", korisnickoIme));
            
            List<ZaboravljeneLozinke> zaboravljeneLozinke = (List<ZaboravljeneLozinke>) c.list();

            session.getTransaction().commit();
            
            if (zaboravljeneLozinke.isEmpty())
                return null;
            return zaboravljeneLozinke.get(0);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void updateRequest(ZaboravljeneLozinke zaboravljeneLozinke) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            session.update(zaboravljeneLozinke);

            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void insertRequest(ZaboravljeneLozinke zaboravljeneLozinke) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            session.save(zaboravljeneLozinke);

            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void deleteRequest(ZaboravljeneLozinke zaboravljeneLozinke) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            session.delete(zaboravljeneLozinke);

            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
}
