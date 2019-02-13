/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.Korisnici;
import db.Oglasi;
import db.Organizacije;
import db.Vesti;
import db.helpers.DogadjajiHelper;
import db.helpers.KorisniciHelper;
import db.helpers.OglasiHelper;
import db.helpers.VestiHelper;
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
    private Dogadjaji selektovanDogadjajBrisanje;
    private Vesti selektovanaVestBrisanje;
    private Vesti selektovanaVestArhiviranje;
    private Oglasi selektovanOglasBrisanje;

    private KorisniciHelper korisniciHelper = new KorisniciHelper();
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();
    private VestiHelper vestiHelper = new VestiHelper();
    private OglasiHelper oglasiHelper = new OglasiHelper();

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

    public Dogadjaji getSelektovanDogadjajBrisanje() {
        return selektovanDogadjajBrisanje;
    }

    public void setSelektovanDogadjajBrisanje(Dogadjaji selektovanDogadjajBrisanje) {
        this.selektovanDogadjajBrisanje = selektovanDogadjajBrisanje;
    }
    
    public void obrisiDogadjaj() {
        if (selektovanDogadjajBrisanje != null) {
            dogadjajiHelper.obrisiDogadjaj(selektovanDogadjajBrisanje);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali događaj.", null);
            FacesContext.getCurrentInstance().addMessage("dogadjaj:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Vesti getSelektovanaVestBrisanje() {
        return selektovanaVestBrisanje;
    }

    public void setSelektovanaVestBrisanje(Vesti selektovanaVestBrisanje) {
        this.selektovanaVestBrisanje = selektovanaVestBrisanje;
    }
    
    public void obrisiVest() {
        if (selektovanaVestBrisanje != null) {
            vestiHelper.obrisiVest(selektovanaVestBrisanje);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali vest.", null);
            FacesContext.getCurrentInstance().addMessage("vest:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Vesti getSelektovanaVestArhiviranje() {
        return selektovanaVestArhiviranje;
    }

    public void setSelektovanaVestArhiviranje(Vesti selektovanaVestArhiviranje) {
        this.selektovanaVestArhiviranje = selektovanaVestArhiviranje;
    }
    
    public void arhivirajVest() {
        if (selektovanaVestArhiviranje != null) {
            selektovanaVestArhiviranje.setArhivirana(1);
            vestiHelper.arhiviranjeVesti(selektovanaVestArhiviranje);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste arhivirali vest.", null);
            FacesContext.getCurrentInstance().addMessage("vest:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Oglasi getSelektovanOglasBrisanje() {
        return selektovanOglasBrisanje;
    }

    public void setSelektovanOglasBrisanje(Oglasi selektovanOglasBrisanje) {
        this.selektovanOglasBrisanje = selektovanOglasBrisanje;
    }
    
    public void obrisiOglas() {
        if (selektovanOglasBrisanje != null) {
            oglasiHelper.obrisiOglas(selektovanOglasBrisanje);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali oglas.", null);
            FacesContext.getCurrentInstance().addMessage("oglas:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

}
