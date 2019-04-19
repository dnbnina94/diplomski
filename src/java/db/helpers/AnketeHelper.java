/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.Ankete;
import db.HibernateUtil;
import db.Korisnici;
import db.Pitanja;
import db.PonudjeniOdgovori;
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
public class AnketeHelper {

    private Session session;

    public AnketeHelper() {
    }

    public int getMaxId() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM Ankete AS anketa");
            List<Ankete> ankete = (List<Ankete>) q.list();

            session.getTransaction().commit();

            if (ankete.isEmpty()) {
                return 0;
            } else {
                return ankete.get(ankete.size() - 1).getIdAnketa();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public int getMaxIdPitanja() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM Pitanja AS pitanje");
            List<Pitanja> pitanja = (List<Pitanja>) q.list();

            session.getTransaction().commit();

            if (pitanja.isEmpty()) {
                return 0;
            } else {
                return pitanja.get(pitanja.size() - 1).getIdPitanje();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public int getMaxIdPonudjeniOdgovori() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM PonudjeniOdgovori AS ponOdg");
            List<PonudjeniOdgovori> ponudjeniOdgovori = (List<PonudjeniOdgovori>) q.list();

            session.getTransaction().commit();

            if (ponudjeniOdgovori.isEmpty()) {
                return 0;
            } else {
                return ponudjeniOdgovori.get(ponudjeniOdgovori.size() - 1).getIdOdgovor();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void insertAnketa(Ankete anketa) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();

            session.save(anketa);

            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void insertPitanje(Pitanja pitanje) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();

            session.save(pitanje);

            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void insertPonudjeniOdgovor(PonudjeniOdgovori ponOdg) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();

            session.save(ponOdg);

            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public long pretragaAnketaTotalCount(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();

            Criteria c = session.createCriteria(Ankete.class);
            c.add(Restrictions.eq("korisnik.korisnickoIme", korisnik.getKorisnickoIme()));

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

    public long pretragaAnketaTotalCount(String kljucneReci, Korisnici kreator, int sortiranje) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();

            Criteria c = session.createCriteria(Ankete.class);

            if (kreator != null) {
                c.add(Restrictions.eq("korisnici.korisnickoIme", kreator.getKorisnickoIme()));
            }

            if (!kljucneReci.isEmpty()) {
                c.add(Restrictions.like("naziv", kljucneReci, MatchMode.ANYWHERE));
            }

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

    public List<Ankete> pretragaAnketa(String kljucneReci, Korisnici kreator, int sortiranje, int currentPage, int pageLength, int numOfShowedItems) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();

            Criteria c = session.createCriteria(Ankete.class);

            if (!kljucneReci.isEmpty()) {
                c.add(Restrictions.like("naziv", kljucneReci, MatchMode.ANYWHERE));
            }

            if (kreator != null) {
                c.add(Restrictions.eq("korisnici.korisnickoIme", kreator.getKorisnickoIme()));
            }

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

            c.setMaxResults(pageLength);
            c.setFirstResult(currentPage * pageLength + (numOfShowedItems - currentPage * pageLength));

            List<Ankete> ankete = c.list();

            session.getTransaction().commit();

            return ankete;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Ankete> pretragaAnketa(Korisnici kreator, int currentPage, int pageLength, int numOfShowedItems) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {

            session.getTransaction().begin();

            Criteria c = session.createCriteria(Ankete.class);
            c.add(Restrictions.eq("korisnici.korisnickoIme", kreator.getKorisnickoIme()));

            c.setMaxResults(pageLength);
            c.setFirstResult(currentPage * pageLength + (numOfShowedItems - currentPage * pageLength));

            List<Ankete> ankete = c.list();

            session.getTransaction().commit();

            return ankete;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
