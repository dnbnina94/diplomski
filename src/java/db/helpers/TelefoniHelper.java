/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helpers;

import db.HibernateUtil;
import db.StavkeSifarnika;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nina
 */
public class TelefoniHelper {
    private Session session;
    
    public TelefoniHelper() {
        
    }
    
    public int getMaxId() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            
            Query q = session.createQuery("FROM Telefoni AS telefon");
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
