/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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
        session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.getTransaction().begin();

            Vesti v = null;
            Query q = session.createQuery("FROM Vesti");
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
