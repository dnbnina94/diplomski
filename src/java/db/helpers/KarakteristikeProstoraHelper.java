/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.Dogadjaji;
import db.HibernateUtil;
import db.KarakteristikeProstora;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nina
 */
public class KarakteristikeProstoraHelper {
    private Session session;
    
    public int getMaxId() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            Query q = session.createQuery("FROM KarakteristikeProstora AS karakteristikaProstora");
            List<KarakteristikeProstora> karakteristike = (List<KarakteristikeProstora>) q.list();

            session.getTransaction().commit();

            if (karakteristike.isEmpty()) {
                return 0;
            } else {
                return karakteristike.get(karakteristike.size() - 1).getIdKarakteristika();
            }

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void insertKarakteristikaProstora(KarakteristikeProstora karakteristikaProstora) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            session.getTransaction().begin();

            session.save(karakteristikaProstora);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
}
