/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nina
 */
public class Organizacije implements java.io.Serializable {
    
    private String korisnickoIme;
    private Korisnici korisnici;
    private String naziv;
    private String kontaktOsoba;
    private String email;
    private String tekst;
    private String webAdresa;
    private StavkeSifarnika oblastDelovanja;
    private StavkeSifarnika mesto;
    private StavkeSifarnika ulica;
    private String telefoni;
    
    public Organizacije() {
        
    }
    
    public Organizacije(Korisnici korisnici, StavkeSifarnika oblastDelovanja, String naziv, String kontaktOsoba, String email, String tekst, StavkeSifarnika mesto, StavkeSifarnika ulica, String telefoni) {
        this.korisnici = korisnici;
        this.oblastDelovanja = oblastDelovanja;
        this.naziv = naziv;
        this.kontaktOsoba = kontaktOsoba;
        this.email = email;
        this.tekst = tekst;
        this.mesto = mesto;
        this.ulica = ulica;
        this.telefoni = telefoni;
    }
    
    public Organizacije(Organizacije organizacija) {
        this.korisnici = organizacija.getKorisnici();
        this.oblastDelovanja = organizacija.getOblastDelovanja();
        this.naziv = organizacija.getNaziv();
        this.kontaktOsoba = organizacija.getKontaktOsoba();
        this.email = organizacija.getEmail();
        this.tekst = organizacija.getTekst();
        this.webAdresa = organizacija.getWebAdresa();
        this.mesto = organizacija.getMesto();
        this.ulica = organizacija.getUlica();
        this.telefoni = organizacija.getTelefoni();
    }
    
    public Organizacije(Korisnici korisnici, StavkeSifarnika oblastDelovanja, String naziv, String kontaktOsoba, String email, String tekst, String webAdresa, StavkeSifarnika mesto, StavkeSifarnika ulica, String telefoni) {
        this.korisnici = korisnici;
        this.oblastDelovanja = oblastDelovanja;
        this.naziv = naziv;
        this.kontaktOsoba = kontaktOsoba;
        this.email = email;
        this.tekst = tekst;
        this.webAdresa = webAdresa;
        this.mesto = mesto;
        this.ulica = ulica;
        this.telefoni = telefoni;
    }
    
    public String getKorisnickoIme() {
        return korisnickoIme;
    }
    
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    
    public Korisnici getKorisnici() {
        return korisnici;
    }
    
    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
    }
    
    public String getNaziv() {
        return naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    public String getKontaktOsoba() {
        return kontaktOsoba;
    }
    
    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTekst() {
        return tekst;
    }
    
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    
    public String getWebAdresa() {
        return webAdresa;
    }
    
    public void setWebAdresa(String webAdresa) {
        this.webAdresa = webAdresa;
    }
    
    public StavkeSifarnika getOblastDelovanja() {
        return oblastDelovanja;
    }
    
    public void setOblastDelovanja(StavkeSifarnika oblastDelovanja) {
        this.oblastDelovanja = oblastDelovanja;
    }
    
    public StavkeSifarnika getMesto() {
        return mesto;
    }
    
    public void setMesto(StavkeSifarnika mesto) {
        this.mesto = mesto;
    }
    
    public StavkeSifarnika getUlica() {
        return ulica;
    }
    
    public void setUlica(StavkeSifarnika ulica) {
        this.ulica = ulica;
    }

    public String getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(String telefoni) {
        this.telefoni = telefoni;
    }
    
}
