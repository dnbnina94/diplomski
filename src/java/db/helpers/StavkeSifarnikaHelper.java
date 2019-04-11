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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

            if (!stavkeSifarnika.isEmpty()) {
                return stavkeSifarnika.get(0);
            }
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

            if (stavkeSifarnika.isEmpty()) {
                return 0;
            } else {
                return stavkeSifarnika.get(stavkeSifarnika.size() - 1).getIdStavka();
            }

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

    public StavkeSifarnika getStavkeSifarnikaBySifarnikAndNaziv(int sifarnik, String stavka, int idStavka) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(StavkeSifarnika.class);
            c.add(Restrictions.eq("naziv", stavka));
            c.add(Restrictions.eq("sifarnici.idSifarnik", sifarnik));
            c.add(Restrictions.ne("idStavka", idStavka));

            List<StavkeSifarnika> l = c.list();

            session.getTransaction().commit();

            if (l.isEmpty()) {
                return null;
            } else {
                return l.get(0);
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public StavkeSifarnika getStavkeSifarnikaBySifarnikAndNaziv(int sifarnik, String stavka) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(StavkeSifarnika.class);
            c.add(Restrictions.eq("naziv", stavka));
            c.add(Restrictions.eq("sifarnici.idSifarnik", sifarnik));

            List<StavkeSifarnika> l = c.list();

            session.getTransaction().commit();

            if (l.isEmpty()) {
                return null;
            } else {
                return l.get(0);
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateStavka(StavkeSifarnika stavka) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.update(stavka);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void dodajStavku(StavkeSifarnika stavka) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(stavka);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Sifarnici getSifarnikById(int idSifarnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Sifarnici.class);
            c.add(Restrictions.eq("idSifarnik", idSifarnik));
            
            List<Sifarnici> l = c.list();
            
            session.getTransaction().commit();
            
            if (l.isEmpty())
                return null;
            return l.get(0);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void obrisiStavku(StavkeSifarnika stavka) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            for (Dogadjaji dogadjaj : (Set<Dogadjaji>) stavka.getDogadjajisKategorija()) {
                session.delete(dogadjaj);
            }
            
            for (Dogadjaji dogadjaj : (Set<Dogadjaji>) stavka.getDogadjajisMesto()) {
                session.delete(dogadjaj);
            }
            
            for (Dogadjaji dogadjaj : (Set<Dogadjaji>) stavka.getDogadjajisUlica()) {
                session.delete(dogadjaj);
            }
            
            for (Dogadjaji dogadjaj : (Set<Dogadjaji>) stavka.getDogadjajisUzrast()) {
                session.delete(dogadjaj);
            }
            
            for (Vesti vest : (Set<Vesti>) stavka.getVestis()) {
                session.delete(vest);
            }
            
            for (Organizacije org : (Set<Organizacije>) stavka.getOrganizacijesMesto()) {
                session.delete(org);
            }
            
            for (Organizacije org : (Set<Organizacije>) stavka.getOrganizacijesUlica()) {
                session.delete(org);
            }
            
            for (Organizacije org : (Set<Organizacije>) stavka.getOrganizacijesOblastDelovanja()) {
                session.delete(org);
            }
            
            for (KarakteristikeProstora karakteristika : (Set<KarakteristikeProstora>) stavka.getKarakteristikeProstoras()) {
                session.delete(karakteristika);
            }
            
            session.delete(stavka);
            
            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<StavkeSifarnika> pretragaSifarnika(int idSifarnika, int currentPage, int pageLength, int numOfShowedItems) {
        Sifarnici sifarnik = this.getStavkeByIdSifarnik(idSifarnika);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(StavkeSifarnika.class);
            c.add(Restrictions.eq("sifarnici", sifarnik));
            c.addOrder(Order.desc("idStavka"));
            
            c.setFirstResult(currentPage*pageLength + (numOfShowedItems-currentPage*pageLength));
            c.setMaxResults(pageLength);
            
            List<StavkeSifarnika> l = c.list();
            
            session.getTransaction().commit();
            
            return l;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public long pretragaSifarnikaTotalCount(int idSifarnika) {
        Sifarnici sifarnik = this.getStavkeByIdSifarnik(idSifarnika);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(StavkeSifarnika.class);
            c.add(Restrictions.eq("sifarnici", sifarnik));
            
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

}
