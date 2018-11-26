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
    
    public Set getStavkeByIdSifarnik(int idSifarnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Sifarnici AS sifarnik WHERE sifarnik.idSifarnik = " + idSifarnik);
            List<Sifarnici> sifarnici = q.list();
            Sifarnici sifarnik = sifarnici.get(0);
            session.getTransaction().commit();
            
            return sifarnik.getStavkeSifarnikas();
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
}
