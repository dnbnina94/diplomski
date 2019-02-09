/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import db.helpers.KorisniciHelper;
import java.util.List;

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

    public Admin() {
        korisnici = korisniciHelper.getNeodobreniKorisnici();
    }

    public List<Korisnici> getKorisnici() {
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
        }
        if (page.equals("adminOdobreni.xhtml")) {
            korisnici = korisniciHelper.getSveOdobreneOrganizacije();
        }
        /*if (page.equals("adminAdmini.xhtml")) {
            korisnici = korisniciHelper.getSviAdmini();
        }*/
    }
    
    public void obrisiKorisnika() {
        return;
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

}
