package db.helpers;

import db.Dogadjaji;
import db.HibernateUtil;
import db.KarakteristikeProstora;
import db.Korisnici;
import db.Oglasi;
import db.Organizacije;
import db.StavkeSifarnika;
import db.Vesti;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        } finally {
            session.close();
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
        } finally {
            session.close();
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
        } finally {
            session.close();
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
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setString("naziv", naziv).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setString("opis", opis).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("oblastDelovanja", oblastDelovanja.getIdStavka()).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setString("webAdresa", webAdresa).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setString("kontaktOsoba", kontaktOsoba).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setString("email", email).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("mesto", mesto.getIdStavka()).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setInteger("ulica", ulica.getIdStavka()).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setString("telefoni", telefoni).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setBinary("lozinka", lozinka).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
            int updatedEntities = session.createQuery(hqlUpdate).setBinary("salt", salt).setString("korisnickoIme", korisnickoIme).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
        } finally {
            session.close();
        }
    }
    
    public List<Organizacije> getSveOdobreneOrganizacije() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            session.getTransaction().begin();
            
            Criteria c = session.createCriteria(Korisnici.class);
            c.add(Restrictions.eq("odobren", true));
            c.add(Restrictions.eq("tip", 2));
            
            List<Korisnici> l = c.list();
            session.getTransaction().commit();
            
            List<Organizacije> retList = new ArrayList<Organizacije>();
            if (l != null) {
                for (Korisnici kor : l) {
                    retList.add(kor.getOrganizacije());
                }
            }
            return retList;

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Korisnici> getNeodobreniKorisnici() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Korisnici.class);
            c.add(Restrictions.eq("odobren", false));
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

    public List<Korisnici> getOdobreniKorisnici() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Korisnici.class);
            c.add(Restrictions.eq("odobren", true));
            c.add(Restrictions.eq("tip", 2));
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
    
    public List<Korisnici> getKorisnici(String tipKorisnika, String kljucneReci, int currentPage, int pageLength, int numOfShowedItems) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Korisnici.class);
            c.add(Restrictions.eq("tip", 2));
            
            if (tipKorisnika.equals("adminNeodobreni.xhtml")) {
                c.add(Restrictions.eq("odobren", false));
            }
            if (tipKorisnika.equals("adminOdobreni.xhtml")) {
                c.add(Restrictions.eq("odobren", true));
            }
            
            if (!kljucneReci.isEmpty()) {
                c.add(Restrictions.like("korisnickoIme", kljucneReci, MatchMode.ANYWHERE));
            }
            
            c.setFirstResult(currentPage*pageLength + (numOfShowedItems - currentPage*pageLength));
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
    
    public long getKorisniciTotalCount(String tipKorisnika, String kljucneReci) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Korisnici.class);
            c.add(Restrictions.eq("tip", 2));
            
            if (tipKorisnika.equals("adminNeodobreni.xhtml")) {
                c.add(Restrictions.eq("odobren", false));
            }
            if (tipKorisnika.equals("adminOdobreni.xhtml")) {
                c.add(Restrictions.eq("odobren", true));
            }
            
            if (!kljucneReci.isEmpty()) {
                c.add(Restrictions.like("korisnickoIme", kljucneReci, MatchMode.ANYWHERE));
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

    public List<Korisnici> getSviAdmini() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }

        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Korisnici.class);
            c.add(Restrictions.eq("tip", 1));
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

    public void updateKorisnikOdobren(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            String hqlUpdate = "update Korisnici c set c.odobren = :odobren where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery(hqlUpdate).setBoolean("odobren", korisnik.isOdobren()).setString("korisnickoIme", korisnik.getKorisnickoIme()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void obrisiKorisnika(Korisnici korisnik) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            for (Oglasi oglas : (Set<Oglasi>) korisnik.getOglasis()) {
                String hqlUpdate = "Delete Oglasi c where c.idOglas = :idOglas";
                int updatedEntities = session.createQuery(hqlUpdate).setInteger("idOglas", oglas.getIdOglas()).executeUpdate();
            }

            for (Vesti vest : (Set<Vesti>) korisnik.getVestis()) {
                String hqlUpdate = "Delete Vesti c where c.idVest = :idVest";
                int updatedEntities = session.createQuery(hqlUpdate).setInteger("idVest", vest.getIdVest()).executeUpdate();
            }

            for (Dogadjaji dogadjaj : (Set<Dogadjaji>) korisnik.getDogadjajis()) {
                for (KarakteristikeProstora karakteristika : (Set<KarakteristikeProstora>) dogadjaj.getKarakteristikeProstoras()) {
                    String hqlUpdate = "Delete KarakteristikeProstora c where c.idKarakteristika = :idKarakteristika";
                    int updatedEntities = session.createQuery(hqlUpdate).setInteger("idKarakteristika", karakteristika.getIdKarakteristika()).executeUpdate();
                }
                String hqlUpdate = "Delete Dogadjaji c where c.idDogadjaj = :idDogadjaj";
                int updatedEntities = session.createQuery(hqlUpdate).setInteger("idDogadjaj", dogadjaj.getIdDogadjaj()).executeUpdate();
            }

            String hqlUpdate = "Delete Organizacije c where c.korisnickoIme = :korisnickoIme";
            int updatedEntities = session.createQuery(hqlUpdate).setString("korisnickoIme", korisnik.getKorisnickoIme()).executeUpdate();
            
            hqlUpdate = "Delete Korisnici c where c.korisnickoIme = :korisnickoIme";
            updatedEntities = session.createQuery(hqlUpdate).setString("korisnickoIme", korisnik.getKorisnickoIme()).executeUpdate();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<Organizacije> getOrganizacijeByMesto(StavkeSifarnika mesto) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Organizacije.class);
            c.add(Restrictions.eq("mesto", mesto));
            
            List<Organizacije> l = c.list();
            
            session.getTransaction().commit();
            
            return l;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<Organizacije> getOrganizacijeByUlica(StavkeSifarnika ulica) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Organizacije.class);
            c.add(Restrictions.eq("ulica", ulica));
            
            List<Organizacije> l = c.list();
            
            session.getTransaction().commit();
            
            return l;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    public List<Organizacije> getOrganizacijeByOblastDelovanja(StavkeSifarnika oblastDelovanja) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Criteria c = session.createCriteria(Organizacije.class);
            c.add(Restrictions.eq("oblastDelovanja", oblastDelovanja));
            
            List<Organizacije> l = c.list();
            
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
