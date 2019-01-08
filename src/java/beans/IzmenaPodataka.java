/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;

/**
 *
 * @author Nina
 */
public class IzmenaPodataka {
    
    private Korisnici korisnik;
    
    private String nazivOrgGreska = "";
    private String opisOrgGreska = "";
    private String oblastDelovanjaGreska = "";
    private String webStranicaGreska = "";
    private String mestoGreska = "";
    private String ulicaGreska = "";
    
    public IzmenaPodataka() {
    }
    
    public Korisnici getKorisnik() {
        return korisnik;
    }
    
    public void setKorisnik(Korisnici korisnik) {
        this.korisnik = korisnik;
    }

    public String getNazivOrgGreska() {
        return nazivOrgGreska;
    }

    public void setNazivOrgGreska(String nazivOrgGreska) {
        this.nazivOrgGreska = nazivOrgGreska;
    }

    public String getOpisOrgGreska() {
        return opisOrgGreska;
    }

    public void setOpisOrgGreska(String opisOrgGreska) {
        this.opisOrgGreska = opisOrgGreska;
    }

    public String getOblastDelovanjaGreska() {
        return oblastDelovanjaGreska;
    }

    public void setOblastDelovanjaGreska(String oblastDelovanjaGreska) {
        this.oblastDelovanjaGreska = oblastDelovanjaGreska;
    }

    public String getWebStranicaGreska() {
        return webStranicaGreska;
    }

    public void setWebStranicaGreska(String webStranicaGreska) {
        this.webStranicaGreska = webStranicaGreska;
    }

    public String getMestoGreska() {
        return mestoGreska;
    }

    public void setMestoGreska(String mestoGreska) {
        this.mestoGreska = mestoGreska;
    }

    public String getUlicaGreska() {
        return ulicaGreska;
    }

    public void setUlicaGreska(String ulicaGreska) {
        this.ulicaGreska = ulicaGreska;
    }
    
    
    
}
