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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nina
 */
public class StavkeSifarnikaHelper {
    
    private Session session;
    
    public StavkeSifarnikaHelper() {
    }
    
    public Sifarnici getStavkeByIdSifarnik(int idSifarnik) {
        session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }
    
    public StavkeSifarnika getStavkaByNaziv(String naziv) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM StavkeSifarnika AS stavka WHERE stavka.naziv = '" + naziv + "'");
            List<StavkeSifarnika> stavkeSifarnika = q.list();
            session.getTransaction().commit();
            
            if (!stavkeSifarnika.isEmpty())
                return stavkeSifarnika.get(0);
            return null;
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public void insertStavka(StavkeSifarnika stavkaSifarnika) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            session.save(stavkaSifarnika);
            
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
            
            Query q = session.createQuery("FROM StavkeSifarnika AS stavka");
            List<StavkeSifarnika> stavkeSifarnika = (List<StavkeSifarnika>) q.list();
            
            session.getTransaction().commit();
            
            if (stavkeSifarnika.isEmpty())
                return 0;
            else
                return stavkeSifarnika.get(stavkeSifarnika.size()-1).getIdStavka();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
}
