package db.helpers;

import db.HibernateUtil;
import db.Korisnici;
import db.Organizacije;
import db.StavkeSifarnika;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nina
 */
public class KorisniciHelper {

    private Session session;

    public KorisniciHelper() {
    }

    public Korisnici getKorisnikByKorisnickoIme(String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Korisnici AS korisnik WHERE korisnik.korisnickoIme = binary('" + korisnickoIme + "')");
            List<Korisnici> l = q.list();
            session.getTransaction().commit();

            if (l.isEmpty()) {
                return null;
            }

            return l.get(0);

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public Organizacije getOrganizacijaByEmail(String email) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM Organizacije AS organizacija WHERE organizacija.email = '" + email + "'");
            List<Organizacije> l = q.list();
            session.getTransaction().commit();

            if (l.isEmpty()) {
                return null;
            }

            return l.get(0);

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

    }

    public void insertKorisnik(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(korisnik);
            session.save(korisnik.getOrganizacije());

            /*for (Object telefon : korisnik.getOrganizacije().getTelefonis()) {
                session.save((Telefoni) telefon);
            }*/

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void insertOrganizacija(Organizacije organizacija) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(organizacija);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaNaziv(String naziv, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.naziv = :naziv where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setString( "naziv", naziv ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaOpis(String opis, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.tekst = :opis where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setString( "opis", opis ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaOblastDelovanja(StavkeSifarnika oblastDelovanja, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.oblastDelovanja = :oblastDelovanja where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setInteger("oblastDelovanja", oblastDelovanja.getIdStavka() ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaWebAdresa(String webAdresa, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.webAdresa = :webAdresa where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setString( "webAdresa", webAdresa ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaKontaktOsoba(String kontaktOsoba, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.kontaktOsoba = :kontaktOsoba where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setString( "kontaktOsoba", kontaktOsoba ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaEmail(String email, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.email = :email where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setString( "email", email ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaMesto(StavkeSifarnika mesto, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.mesto = :mesto where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setInteger("mesto", mesto.getIdStavka() ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaUlica(StavkeSifarnika ulica, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.ulica = :ulica where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setInteger("ulica", ulica.getIdStavka() ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaTelefoni(String telefoni, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Organizacije c set c.telefoni = :telefoni where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setString("telefoni", telefoni ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaLozinka(byte[] lozinka, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Korisnici c set c.lozinka = :lozinka where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setBinary("lozinka", lozinka ).setString("korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void updateOrganizacijaSalt(byte[] salt, String korisnickoIme) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();
            
            String hqlUpdate = "update Korisnici c set c.salt = :salt where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery( hqlUpdate ).setBinary("salt", salt ).setString( "korisnickoIme", korisnickoIme ).executeUpdate();
            
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public List<Organizacije> getSveOrganizacije() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM Organizacije AS organizacija");
            List<Organizacije> l = q.list();
            session.getTransaction().commit();

            return l;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

}
