/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.Dogadjaji;
import db.Oglasi;
import db.StavkeSifarnika;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nina
 */
public class DogadjajiHelper {

    private Session session;

    public DogadjajiHelper() {
    }

    public List<Dogadjaji> dogadjaji() {
        session = HibernateUtil.getSessionFactory().openSession();
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
        session = HibernateUtil.getSessionFactory().openSession();
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
        session = HibernateUtil.getSessionFactory().openSession();
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
        session = HibernateUtil.getSessionFactory().openSession();
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

}
