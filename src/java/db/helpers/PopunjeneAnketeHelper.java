/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.Ankete;
import db.HibernateUtil;
import db.Korisnici;
import db.Odgovori;
import db.PopunjeneAnkete;
import java.util.List;
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
public class PopunjeneAnketeHelper {

    private Session session;

    public PopunjeneAnketeHelper() {

    }

    public int getMaxId() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM PopunjeneAnkete AS anketa");
            List<PopunjeneAnkete> popunjeneAnkete = (List<PopunjeneAnkete>) q.list();

            session.getTransaction().commit();

            if (popunjeneAnkete.isEmpty()) {
                return 0;
            } else {
                return popunjeneAnkete.get(popunjeneAnkete.size() - 1).getIdPopunjenaAnketa();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public int getMaxIdOdgovor() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM Odgovori AS odgovor");
            List<Odgovori> odgovori = (List<Odgovori>) q.list();

            session.getTransaction().commit();

            if (odgovori.isEmpty()) {
                return 0;
            } else {
                return odgovori.get(odgovori.size() - 1).getIdOdgovor();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void insertPopunjenaAnketa(PopunjeneAnkete popunjenaAnketa) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(popunjenaAnketa);

            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void insertOdgovor(Odgovori odgovor) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(odgovor);

            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public PopunjeneAnkete getPopunjenaAnketaByKorisnik(String korisnickoIme, Ankete anketa) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(PopunjeneAnkete.class);
            c.add(Restrictions.eq("korisnici.korisnickoIme", korisnickoIme));
            c.add(Restrictions.eq("ankete.idAnketa", anketa.getIdAnketa()));
            
            List<PopunjeneAnkete> popunjeneAnkete = c.list();

            session.getTransaction().commit();
            
            if (popunjeneAnkete.isEmpty())
                return null;
            return popunjeneAnkete.get(0);

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public PopunjeneAnkete getPopunjenaAnketaByGost(String cookie, Ankete anketa) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(PopunjeneAnkete.class);
            c.add(Restrictions.eq("cookie", cookie));
            c.add(Restrictions.eq("ankete.idAnketa", anketa.getIdAnketa()));
            
            List<PopunjeneAnkete> popunjeneAnkete = c.list();

            session.getTransaction().commit();
            
            if (popunjeneAnkete.isEmpty())
                return null;
            return popunjeneAnkete.get(0);

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public PopunjeneAnkete getPopunjenaAnketaByKorisnik(Ankete anketa, Korisnici korisnik, String cookie) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(PopunjeneAnkete.class);
            c.add(Restrictions.eq("ankete.idAnketa", anketa.getIdAnketa()));
            
            if (korisnik != null) {
                c.add(Restrictions.eq("korisnici.korisnickoIme", korisnik.getKorisnickoIme()));
            }
            if (cookie != null) {
                 c.add(Restrictions.eq("cookie", cookie));
            }
            
            List<PopunjeneAnkete> popunjeneAnkete = c.list();

            session.getTransaction().commit();
            
            if (popunjeneAnkete.isEmpty())
                return null;
            return popunjeneAnkete.get(0);

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public long getPopunjeneAnketeKorisnikaTotalCount(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(PopunjeneAnkete.class);
            c.add(Restrictions.eq("korisnici.korisnickoIme", korisnik.getKorisnickoIme()));
            
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
    
    public List<PopunjeneAnkete> getPopunjeneAnketeKorisnika(Korisnici korisnik, int currentPage, int pageLength, int numOfShowedItems) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(PopunjeneAnkete.class);
            c.add(Restrictions.eq("korisnici.korisnickoIme", korisnik.getKorisnickoIme()));
            
            c.addOrder(Order.desc("datum"));
            
            c.setMaxResults(pageLength);
            c.setFirstResult(currentPage * pageLength + (numOfShowedItems - currentPage * pageLength));
            
            List<PopunjeneAnkete> popunjeneAnkete = c.list();

            session.getTransaction().commit();
            
            return popunjeneAnkete;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
