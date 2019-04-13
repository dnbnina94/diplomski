/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.Obavestenja;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nina
 */
public class ObavestenjaHelper {
    
    private Session session;
    
    public ObavestenjaHelper() {
    }
    
    public List<Obavestenja> getSvaObavestenja() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Obavestenja.class);
            List<Obavestenja> obavestenja = c.list();
            
            session.getTransaction().commit();
            
            return obavestenja;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public int getMaxId() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Obavestenja AS obavestenje");
            List<Obavestenja> obavestenja = (List<Obavestenja>) q.list();
            
            session.getTransaction().commit();
            
            if (obavestenja.isEmpty())
                return 0;
            else
                return obavestenja.get(obavestenja.size()-1).getIdObavestenje();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void insertObavestenje(Obavestenja obavestenje) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            session.save(obavestenje);
            
            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void updateObavestenje(Obavestenja obavestenje) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            session.update(obavestenje);
            
            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void obrisiObavestenje(Obavestenja obavestenje) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            session.delete(obavestenje);
            
            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void obrisiObavestenja(Set obavestenja) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            for (Obavestenja o : (Set<Obavestenja>) obavestenja) {
                session.delete(o);
            }
            
            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<Obavestenja> getObavestenja(int currentPage, int pageLength) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Obavestenja.class);
            c.addOrder(Order.desc("datum"));
            
            c.setFirstResult(currentPage*pageLength);
            c.setMaxResults(pageLength);
            
            List<Obavestenja> l = c.list();
            
            session.getTransaction().commit();
            
            return l;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public long getObavestenjaTotalCount() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Obavestenja.class);
            
            c.setProjection(Projections.rowCount());
            Long count = (Long) c.uniqueResult();
            
            session.getTransaction().commit();
            
            return count;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public long getBrNovihObavestenja() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Obavestenja.class);
            c.add(Restrictions.eq("procitano", false));
            
            c.setProjection(Projections.rowCount());
            long count = (Long) c.uniqueResult();
            
            session.getTransaction().commit();
            
            return count;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
}
