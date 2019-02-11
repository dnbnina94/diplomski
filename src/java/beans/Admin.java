/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import db.Organizacije;
import db.helpers.KorisniciHelper;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class Admin {

    private List<Korisnici> korisnici;
    private String page = "adminNeodobreni.xhtml";
    private Korisnici selektovanKorisnikBrisanje;
    private Korisnici selektovanKorisnikPrihvatanje;

    private KorisniciHelper korisniciHelper = new KorisniciHelper();

    class SortKorisniciByKorIme implements Comparator<Korisnici> {

        @Override
        public int compare(Korisnici a, Korisnici b) {
            return a.getKorisnickoIme().toLowerCase().compareTo(b.getKorisnickoIme().toLowerCase());
        }

    }

    public Admin() {
        korisnici = korisniciHelper.getNeodobreniKorisnici();
        Collections.sort(korisnici, new Admin.SortKorisniciByKorIme());
    }

    public List<Korisnici> getKorisnici() {
        /*if (page.equals("adminOdobreni.xhtml")) {
            korisnici = korisniciHelper.getOdobreniKorisnici();
            Collections.sort(korisnici, new Admin.SortKorisniciByKorIme());
        }
        if (page.equals("adminNeodobreni.xhtml")) {
            korisnici = korisniciHelper.getNeodobreniKorisnici();
            Collections.sort(korisnici, new Admin.SortKorisniciByKorIme());
        }*/
        return korisnici;
    }

    public void setKorisnici(List<Korisnici> korisnici) {
        this.korisnici = korisnici;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;

        if (page.equals("adminNeodobreni.xhtml")) {
            korisnici = korisniciHelper.getNeodobreniKorisnici();
            Collections.sort(korisnici, new Admin.SortKorisniciByKorIme());
        }
        if (page.equals("adminOdobreni.xhtml")) {
            korisnici = korisniciHelper.getOdobreniKorisnici();
            Collections.sort(korisnici, new Admin.SortKorisniciByKorIme());
        }
        /*if (page.equals("adminAdmini.xhtml")) {
            korisnici = korisniciHelper.getSviAdmini();
        }*/
    }

    public void obrisiKorisnika() {
        if (selektovanKorisnikBrisanje != null) {
            korisniciHelper.obrisiKorisnika(selektovanKorisnikBrisanje);

            this.setPage(page);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali korisnika.", null);
            FacesContext.getCurrentInstance().addMessage("izmena_podataka:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public void prihvatiKorisnika() {
        return;
    }

    public Korisnici getSelektovanKorisnikBrisanje() {
        return selektovanKorisnikBrisanje;
    }

    public void setSelektovanKorisnikBrisanje(Korisnici selektovanKorisnikBrisanje) {
        this.selektovanKorisnikBrisanje = selektovanKorisnikBrisanje;
    }

    public Korisnici getSelektovanKorisnikPrihvatanje() {
        return selektovanKorisnikPrihvatanje;
    }

    public void setSelektovanKorisnikPrihvatanje(Korisnici selektovanKorisnikPrihvatanje) {
        this.selektovanKorisnikPrihvatanje = selektovanKorisnikPrihvatanje;
    }

    public void odobriKorisnika() {
        if (selektovanKorisnikPrihvatanje != null) {
            selektovanKorisnikPrihvatanje.setOdobren(true);
            korisniciHelper.updateKorisnikOdobren(selektovanKorisnikPrihvatanje);
            
            this.setPage(page);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste odobrili korisnikov zahtev za registraciju.", null);
            FacesContext.getCurrentInstance().addMessage("izmena_podataka:growl-success", message);
            //FacesContext.getCurrentInstance().addMessage("korisnici:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

}
