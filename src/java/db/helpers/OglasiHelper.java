/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.Korisnici;
import db.Oglasi;
import db.Organizacije;
import db.Vesti;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nina
 */
public class OglasiHelper {

    private Session session;

    public OglasiHelper() {
    }

    public void insertOglas(Oglasi oglas) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            session.getTransaction().begin();

            session.save(oglas);

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

            Query q = session.createQuery("FROM Oglasi AS oglas");
            List<Oglasi> oglasi = (List<Oglasi>) q.list();

            session.getTransaction().commit();

            if (oglasi.isEmpty()) {
                return 0;
            } else {
                return oglasi.get(oglasi.size() - 1).getIdOglas();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Criteria pretragaOglasa(Session session, String kljucneReci, String kreatorOglasa, int sortiranje) {
        
        Criteria c = session.createCriteria(Oglasi.class);

        if (!kljucneReci.isEmpty()) {
            c.add(Restrictions.or(Restrictions.like("naslov", kljucneReci, MatchMode.ANYWHERE), Restrictions.like("tekst", kljucneReci, MatchMode.ANYWHERE)));
        }
        if (!kreatorOglasa.isEmpty()) {
            c.add(Restrictions.eq("korisnici.korisnickoIme", kreatorOglasa));
        }

        Date danas = new Date();
        c.add(Restrictions.gt("datumIsticanja", danas));

        if (sortiranje == 1) {
            c.addOrder(Order.desc("datumKreiranja"));
        }
        if (sortiranje == 2) {
            c.addOrder(Order.asc("datumKreiranja"));
        }
        if (sortiranje == 3) {
            c.addOrder(Order.asc("datumIsticanja"));
        }
        if (sortiranje == 4) {
            c.addOrder(Order.desc("datumIsticanja"));
        }
        
        return c;
    }

    public List<Oglasi> pretragaOglasa(String kljucneReci, String kreatorOglasa, int sortiranje, int currentPage, int pageLength) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = pretragaOglasa(session, kljucneReci, kreatorOglasa, sortiranje);
            
            c.setFirstResult(currentPage*pageLength);
            c.setMaxResults(pageLength);

            List l = c.list();

            session.getTransaction().commit();

            return l;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public long pretragaOglasaTotalCount(String kljucneReci, String kreatorOglasa, int sortiranje) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = pretragaOglasa(session, kljucneReci, kreatorOglasa, sortiranje);

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

    public void zahtevBrisanjeOglasa(Oglasi oglas) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Oglasi c set c.zahtevBrisanje = 1 where c.idOglas = :idOglas";
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("idOglas", oglas.getIdOglas()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Oglasi> getOglasiByKorisnik(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Oglasi.class);
            c.add(Restrictions.eq("korisnici", korisnik));
            List l = c.list();

            session.getTransaction().commit();

            return l;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<Oglasi> pretragaOglasa(Korisnici korisnik, int currentPage, int pageLength) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Oglasi.class);
            c.add(Restrictions.eq("korisnici", korisnik));
            
            c.addOrder(Order.desc("datumKreiranja"));
            
            c.setFirstResult(currentPage*pageLength);
            c.setMaxResults(pageLength);
            
            List l = c.list();

            session.getTransaction().commit();

            return l;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public long pretragaOglasaTotalCount(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Oglasi.class);
            c.add(Restrictions.eq("korisnici", korisnik));
            
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

    public void obrisiOglas(Oglasi oglas) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "Delete Oglasi c where c.idOglas = :idOglas";
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("idOglas", oglas.getIdOglas()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateOglas(Oglasi oglas) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();
            session.update(oglas);
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<Oglasi> getFeaturedOglasiByKorisnik(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Oglasi.class);
            c.add(Restrictions.eq("korisnici", korisnik));
            c.addOrder(Order.desc("datumKreiranja"));
            c.setMaxResults(8);
            
            List<Oglasi> l = c.list();
            
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
