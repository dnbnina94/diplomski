/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.SifarniciIzvestaj;
import db.StavkeIzvestaj;
import db.StavkeSifarnika;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nina
 */
public class StavkeIzvestajHelper {

    private Session session;

    public StavkeIzvestajHelper() {
    }

    public int getMaxId() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM StavkeIzvestaj AS stavka");
            List<StavkeIzvestaj> stavkeIzvestaj = (List<StavkeIzvestaj>) q.list();

            session.getTransaction().commit();

            if (stavkeIzvestaj.isEmpty()) {
                return 0;
            } else {
                return stavkeIzvestaj.get(stavkeIzvestaj.size() - 1).getIdStavka();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public SifarniciIzvestaj getSifarnikIzvestajById(int id) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(SifarniciIzvestaj.class);
            c.add(Restrictions.eq("idSifarnik", id));

            List<SifarniciIzvestaj> sifarniciIzvestaj = (List<SifarniciIzvestaj>) c.list();

            session.getTransaction().commit();

            if (!sifarniciIzvestaj.isEmpty()) {
                return sifarniciIzvestaj.get(0);
            }
            return null;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void insertStavkaIzvestaj(StavkeIzvestaj stavkaIzvestaj) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(stavkaIzvestaj);

            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<SifarniciIzvestaj> getSviSifarniciIzvestaj() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(SifarniciIzvestaj.class);
            c.addOrder(Order.asc("idSifarnik"));
            List<SifarniciIzvestaj> sifarniciIzvestaj = (List<SifarniciIzvestaj>) c.list();

            session.getTransaction().commit();
            
            return sifarniciIzvestaj;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<StavkeIzvestaj> getStavkeIzvestaj(SifarniciIzvestaj sifarnikIzvestaj, Date datumPocetka, Date datumKraja) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(StavkeIzvestaj.class);
            c.add(Restrictions.eq("sifarniciIzvestaj.idSifarnik", sifarnikIzvestaj.getIdSifarnik()));
            c.add(Restrictions.ge("datum", datumPocetka));
            c.add(Restrictions.le("datum", datumKraja));
            
            List<StavkeIzvestaj> stavkeIzvestaj = (List<StavkeIzvestaj>) c.list();

            session.getTransaction().commit();
            
            return stavkeIzvestaj;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
