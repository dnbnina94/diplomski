/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.Oglasi;
import db.Vesti;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nina
 */
public class OglasiHelper {
    private Session session;
    
    public OglasiHelper() {
    }
    
    public void insertOglas(Oglasi oglas) {
        session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.getTransaction().begin();
            
            session.save(oglas);
            
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public int getMaxId() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Oglasi AS oglas");
            List<Oglasi> oglasi = (List<Oglasi>) q.list();
            
            session.getTransaction().commit();
            
            if (oglasi.isEmpty())
                return 0;
            else
                return oglasi.get(oglasi.size()-1).getIdOglas();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
}
