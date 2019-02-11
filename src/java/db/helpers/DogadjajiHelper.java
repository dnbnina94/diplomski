/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.Dogadjaji;
import db.KarakteristikeProstora;
import db.Korisnici;
import db.Oglasi;
import db.StavkeSifarnika;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

/**
 *
 * @author Nina
 */
public class DogadjajiHelper {

    private Session session;

    public DogadjajiHelper() {
    }

    public List<Dogadjaji> dogadjaji() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM Dogadjaji");
            q.setMaxResults(5);
            List l = q.list();
            session.getTransaction().commit();

            return l;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
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

            Query q = session.createQuery("FROM Dogadjaji AS dogadjaj");
            List<Dogadjaji> dogadjaji = (List<Dogadjaji>) q.list();

            session.getTransaction().commit();

            if (dogadjaji.isEmpty()) {
                return 0;
            } else {
                return dogadjaji.get(dogadjaji.size() - 1).getIdDogadjaj();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void insertDogadjaj(Dogadjaji dogadjaj) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(dogadjaj);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void insertKarakteristike(int idDogadjaj, List<StavkeSifarnika> karakteristikeProsotora) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            for (int i = 0; i < karakteristikeProsotora.size(); i++) {
                Query query = session.createQuery("insert into karakteristike_prostora values(" + idDogadjaj + "," + karakteristikeProsotora.get(i).getIdStavka() + ")");
                query.executeUpdate();
            }

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public List<Dogadjaji> pretragaDogadjaja(Date datumDogadjaja,
            Map<StavkeSifarnika, Boolean> checkMap,
            StavkeSifarnika mesto,
            StavkeSifarnika uzrast,
            String kljucneReci,
            List<StavkeSifarnika> selectedKarakteristikeProstora,
            String kreatorDogadjaja,
            int sortiranje) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Dogadjaji.class);
            if (datumDogadjaja != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(datumDogadjaja);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                Date minDate = cal.getTime();

                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
                Date maxDate = cal.getTime();

                Conjunction and1 = Restrictions.conjunction();
                and1.add(Restrictions.ge("datumDogadjaja", minDate));
                and1.add(Restrictions.le("datumDogadjaja", maxDate));
                Conjunction and2 = Restrictions.conjunction();
                and2.add(Restrictions.ge("datumIsticanja", minDate));
                and2.add(Restrictions.le("datumIsticanja", maxDate));
                Disjunction or = Restrictions.disjunction();
                or.add(and1);
                or.add(and2);
                c.add(or);
            }

            Disjunction orKategorije = Restrictions.disjunction();
            for (Entry<StavkeSifarnika, Boolean> entry : checkMap.entrySet()) {
                if (entry.getValue()) {
                    orKategorije.add(Restrictions.eq("kategorija", entry.getKey()));
                }
            }
            c.add(orKategorije);

            if (mesto != null) {
                c.add(Restrictions.eq("mesto", mesto));
            }

            if (uzrast != null) {
                c.add(Restrictions.eq("uzrast", uzrast));
            }

            if (!kljucneReci.isEmpty()) {
                c.add(Restrictions.or(Restrictions.like("naslov", kljucneReci, MatchMode.ANYWHERE), Restrictions.like("tekst", kljucneReci, MatchMode.ANYWHERE)));
            }
            
            if (selectedKarakteristikeProstora != null) {
                for(StavkeSifarnika selectedKar : selectedKarakteristikeProstora) {
                    Iterator karIterator = selectedKar.getKarakteristikeProstoras().iterator();
                    Disjunction karDisj = Restrictions.disjunction();
                    while (karIterator.hasNext()) {
                        karDisj.add(Restrictions.eq("idDogadjaj", ((KarakteristikeProstora) karIterator.next()).getDogadjaji().getIdDogadjaj()));
                    }
                    c.add(karDisj);
                }
            }
            
            if (!kreatorDogadjaja.isEmpty()) {
                c.add(Restrictions.eq("korisnici.korisnickoIme", kreatorDogadjaja));
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
                c.addOrder(Order.asc("datumDogadjaja"));
            }
            if (sortiranje == 4) {
                c.addOrder(Order.desc("datumDogadjaja"));
            }

            List l = c.list();

            session.getTransaction().commit();

            return l;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void zahtevBrisanjeDogadjaja(Dogadjaji dogadjaj) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Dogadjaji c set c.zahtevBrisanje = 1 where c.idDogadjaj = :idDogadjaj";
            int updatedEntities = session.createQuery( hqlUpdate ).setInteger("idDogadjaj", dogadjaj.getIdDogadjaj()).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public List<Dogadjaji> getDogadjajiByKorisnik(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Dogadjaji.class);
            c.add(Restrictions.eq("korisnici", korisnik));
            List l = c.list();
            
            session.getTransaction().commit();
            //session.close();
            
            return l;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public List<Dogadjaji> getDogadjajiByKategorija(StavkeSifarnika kategorija) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Dogadjaji.class);
            c.add(Restrictions.eq("kategorija", kategorija));
            
            Date danas = new Date();
            c.add(Restrictions.gt("datumIsticanja", danas));
            
            List l = c.list();
            
            session.getTransaction().commit();
            //session.close();
            
            return l;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

}
