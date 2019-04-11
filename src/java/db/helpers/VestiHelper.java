/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
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
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
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
        } finally {
            session.close();
        }
    }

    public Vesti getVestById(int idVest) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM Vesti AS vest WHERE vest.idVest = " + idVest);
            List<Vesti> l = (List<Vesti>) q.list();
            session.getTransaction().commit();

            if (l.isEmpty()) {
                return null;
            }
            return l.get(0);

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

            Query q = session.createQuery("FROM Vesti AS vest");
            List<Vesti> vesti = (List<Vesti>) q.list();

            session.getTransaction().commit();

            if (vesti.isEmpty()) {
                return 0;
            } else {
                return vesti.get(vesti.size() - 1).getIdVest();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void insertVest(Vesti vest) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(vest);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Criteria pretragaVesti(Session session, String kljucneReci, Map<StavkeSifarnika, Boolean> checkMap, String kreatorVesti, int sortiranje, Date datum) {
        Criteria c = session.createCriteria(Vesti.class);
        if (!kljucneReci.isEmpty()) {
            c.add(Restrictions.or(Restrictions.like("naslov", kljucneReci, MatchMode.ANYWHERE), Restrictions.like("tekst", kljucneReci, MatchMode.ANYWHERE)));
        }
        if (!kreatorVesti.isEmpty()) {
            c.add(Restrictions.eq("korisnici.korisnickoIme", kreatorVesti));
        }

        if (datum != null) {
            Calendar minDate = Calendar.getInstance();
            Calendar maxDate = Calendar.getInstance();

            minDate.setTime(datum);
            maxDate.setTime(datum);

            minDate.set(Calendar.HOUR_OF_DAY, 0);
            minDate.set(Calendar.MINUTE, 0);
            minDate.set(Calendar.SECOND, 0);

            maxDate.set(Calendar.HOUR_OF_DAY, 23);
            maxDate.set(Calendar.MINUTE, 59);
            maxDate.set(Calendar.SECOND, 59);

            c.add(Restrictions.and(Restrictions.ge("datum", minDate.getTime()), Restrictions.le("datum", maxDate.getTime())));
        }

        Disjunction orKategorije = Restrictions.disjunction();
        for (Map.Entry<StavkeSifarnika, Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {
                orKategorije.add(Restrictions.eq("kategorija", entry.getKey()));
            }
        }
        c.add(orKategorije);

        if (sortiranje == 1) {
            c.addOrder(Order.desc("datum"));
        }
        if (sortiranje == 2) {
            c.addOrder(Order.asc("datum"));
        }

        c.add(Restrictions.eq("arhivirana", 0));

        return c;
    }

    public List<Vesti> pretragaVesti(String kljucneReci, Map<StavkeSifarnika, Boolean> checkMap, String kreatorVesti, int sortiranje, Date datum, int currentPage, int pageLength) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = pretragaVesti(session, kljucneReci, checkMap, kreatorVesti, sortiranje, datum);

            c.setFirstResult(pageLength * currentPage);
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

    public long pretragaVestiTotalCount(String kljucneReci, Map<StavkeSifarnika, Boolean> checkMap, String kreatorVesti, int sortiranje, Date datum) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = pretragaVesti(session, kljucneReci, checkMap, kreatorVesti, sortiranje, datum);
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

    public long pretragaVestiTotalCount(StavkeSifarnika kategorijaVesti) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Vesti.class);
            c.add(Restrictions.eq("kategorija", kategorijaVesti));
            c.add(Restrictions.eq("arhivirana", 0));
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

    public long pretragaVestiTotalCount(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Vesti.class);
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

    public void arhiviranjeVesti(Vesti vest) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Vesti c set c.arhivirana = 1 where c.idVest = :idVest";
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("idVest", vest.getIdVest()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void zahtevBrisanjeVesti(Vesti vest) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Vesti c set c.zahtevBrisanje = 1 where c.idVest = :idVest";
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("idVest", vest.getIdVest()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Vesti> getVestiByKategorija(StavkeSifarnika kategorija) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Vesti.class);
            c.add(Restrictions.eq("kategorija", kategorija));
            c.add(Restrictions.eq("arhivirana", 0));
            c.addOrder(Order.desc("datum"));

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

    public List<Vesti> getVestiByKategorija(StavkeSifarnika kategorija, int currentPage, int pageLength) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Vesti.class);
            c.add(Restrictions.eq("kategorija", kategorija));
            c.add(Restrictions.eq("arhivirana", 0));
            c.addOrder(Order.desc("datum"));

            c.setFirstResult(currentPage * pageLength);
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

    public List<Vesti> getVestiByKorisnik(Korisnici korisnik, int currentPage, int pageLength) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Vesti.class);
            c.add(Restrictions.eq("korisnici", korisnik));
            c.addOrder(Order.desc("datum"));

            c.setFirstResult(currentPage * pageLength);
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

    public List<Vesti> getVestiByKorisnik(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Vesti.class);
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

    public void obrisiVest(Vesti vest) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "Delete Vesti c where c.idVest = :idVest";
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("idVest", vest.getIdVest()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void updateVestNaslov(Vesti vest, String naslov) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Vesti c set c.naslov = :naslov where c.idVest = :idVest";
            int updatedEntities = session.createQuery(hqlUpdate).setString("naslov", naslov).setInteger("idVest", vest.getIdVest()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateVestTekst(Vesti vest, String tekst) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Vesti c set c.tekst = :tekst where c.idVest = :idVest";
            int updatedEntities = session.createQuery(hqlUpdate).setString("tekst", tekst).setInteger("idVest", vest.getIdVest()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateVestKategorija(Vesti vest, StavkeSifarnika kategorija) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Vesti c set c.kategorija = :kategorija where c.idVest = :idVest";
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("kategorija", kategorija.getIdStavka()).setInteger("idVest", vest.getIdVest()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateVestThumbnail(Vesti vest, String thumbnail) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Vesti c set c.thumbnail = :thumbnail where c.idVest = :idVest";
            int updatedEntities = session.createQuery(hqlUpdate).setString("thumbnail", thumbnail).setInteger("idVest", vest.getIdVest()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Vesti> getFeaturedVestiByKorisnik(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Vesti.class);
            c.add(Restrictions.eq("korisnici", korisnik));
            c.addOrder(Order.desc("datum"));
            c.setMaxResults(8);

            List<Vesti> l = c.list();

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
