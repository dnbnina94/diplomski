/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class KorisnikBean {

    private Korisnici korisnik;

    public KorisnikBean() {
    }

    public Korisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnici korisnik) {
        this.korisnik = korisnik;
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("index.xhtml");
            context.responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(KorisnikBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void proveriAdminPrivilegije() {
        if (korisnik == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(KorisnikBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (korisnik.getTip() == 2) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(KorisnikBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void proveriOrganizacijaPrivilegiju() {
        if (korisnik == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(KorisnikBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (korisnik.getTip() == 1) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(KorisnikBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
