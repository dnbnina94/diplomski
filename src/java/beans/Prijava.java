/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import db.helpers.KorisniciHelper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class Prijava {

    private String korIme;
    private String lozinka;
    private String korImeGreska = "";
    private String lozinkaGreska = "";
    private KorisniciHelper korisniciHelper = new KorisniciHelper();

    public Prijava() {
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getKorImeGreska() {
        return korImeGreska;
    }

    public void setKorImeGreska(String korImeGreska) {
        this.korImeGreska = korImeGreska;
    }

    public String getLozinkaGreska() {
        return lozinkaGreska;
    }

    public void setLozinkaGreska(String lozinkaGreska) {
        this.lozinkaGreska = lozinkaGreska;
    }

    public void login() {
        boolean valid = true;

        if (korIme == null || korIme.isEmpty()) {
            valid = false;
            korImeGreska = "Polje 'Korisničko ime' ne sme ostati prazno.";
        }

        if (lozinka == null || lozinka.isEmpty()) {
            valid = false;
            lozinkaGreska = "Polje 'Lozinka' ne sme ostati prazno.";
        }

        if (valid) {
            Korisnici korisnik = korisniciHelper.getKorisnikByKorisnickoIme(korIme);

            if (korisnik == null) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pogrešno ste uneli korisničko ime i/ili lozinku.", null);
                FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return;
            }

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(korisnik.getSalt().getBytes());
                byte[] hashedPassword = md.digest(lozinka.getBytes(StandardCharsets.UTF_8));

                if (!(new String(hashedPassword)).equals(korisnik.getLozinka())) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pogrešno ste uneli korisničko ime i/ili lozinku.", null);
                    FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                    return;
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Prijava.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!korisnik.isOdobren()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Administrator još uvek nije odobrio Vaš zahtev za registraciju. Molimo pokušajte kasnije.", null);
                FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return;
            }

            try {
                if (korisnik.getTip() == 2) {
                    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                    OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
                    organizacijaBean.setOrganizacija(korisnik.getOrganizacije());
                    elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("organizacija.xhtml");
                    FacesContext.getCurrentInstance().responseComplete();
                }
            } catch (IOException ex) {
                Logger.getLogger(Prijava.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
