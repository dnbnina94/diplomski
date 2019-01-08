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

    public void izmenaPodataka() {
        try {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            IzmenaPodataka izmenaPodataka = new IzmenaPodataka();
            izmenaPodataka.setKorisnik(korisnik);
            elContext.getELResolver().setValue(elContext, null, "izmenaPodataka", izmenaPodataka);
            FacesContext.getCurrentInstance().getExternalContext().redirect("izmena_podataka.xhtml");
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(KorisnikBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
