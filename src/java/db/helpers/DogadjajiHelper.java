/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.Dogadjaji;
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
}
