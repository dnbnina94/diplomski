
package db.helpers;

import db.HibernateUtil;
import db.Korisnici;
import db.Organizacije;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nina
 */
public class KorisniciHelper {
    
    private Session session;
    
    public KorisniciHelper() {
    }
    
    public Korisnici getKorisnikByKorisnickoIme(String korisnickoIme) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Korisnici AS korisnik WHERE korisnik.korisnickoIme = '" + korisnickoIme + "'");
            List<Korisnici> l = q.list();
            session.getTransaction().commit();
            
            if (l.isEmpty())
                return null;
            
            return l.get(0);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    } 
    
    public Organizacije getOrganizacijaByEmail(String email) {
        session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Organizacije AS organizacija WHERE organizacija.email = '" + email + "'");
            List<Organizacije> l = q.list();
            session.getTransaction().commit();
            
            if (l.isEmpty())
                return null;
            
            return l.get(0);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        
    }
}
