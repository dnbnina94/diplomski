/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nina
 */
public class StavkeSifarnikaHelper {
    
    private Session session;
    
    public StavkeSifarnikaHelper() {
    }
    
    public Sifarnici getStavkeByIdSifarnik(int idSifarnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Sifarnici AS sifarnik WHERE sifarnik.idSifarnik = " + idSifarnik);
            List<Sifarnici> sifarnici = q.list();
            Sifarnici sifarnik = sifarnici.get(0);
            session.getTransaction().commit();
            
            return sifarnik;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public StavkeSifarnika getStavkaByNaziv(String naziv) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM StavkeSifarnika AS stavka WHERE stavka.naziv = '" + naziv + "'");
            List<StavkeSifarnika> stavkeSifarnika = q.list();
            session.getTransaction().commit();
            
            if (!stavkeSifarnika.isEmpty())
                return stavkeSifarnika.get(0);
            return null;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void insertStavka(StavkeSifarnika stavkaSifarnika) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            session.save(stavkaSifarnika);
            
            session.getTransaction().commit();
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
            
            Query q = session.createQuery("FROM StavkeSifarnika AS stavka");
            List<StavkeSifarnika> stavkeSifarnika = (List<StavkeSifarnika>) q.list();
            
            session.getTransaction().commit();
            
            if (stavkeSifarnika.isEmpty())
                return 0;
            else
                return stavkeSifarnika.get(stavkeSifarnika.size()-1).getIdStavka();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<Sifarnici> getSifarnici() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Sifarnici.class);
            List<Sifarnici> l = c.list();
            
            session.getTransaction().commit();
            
            return l;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
}
