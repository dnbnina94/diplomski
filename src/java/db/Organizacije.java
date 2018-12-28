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
    private Set telefonis = new HashSet(0);
    
    public Organizacije() {
        
    }
    
    public Organizacije(Korisnici korisnici, StavkeSifarnika oblastDelovanja, String naziv, String kontaktOsoba, String email, String tekst) {
        this.korisnici = korisnici;
        this.oblastDelovanja = oblastDelovanja;
        this.naziv = naziv;
        this.kontaktOsoba = kontaktOsoba;
        this.email = email;
        this.tekst = tekst;
    }
    
    public Organizacije(Korisnici korisnici, StavkeSifarnika oblastDelovanja, String naziv, String kontaktOsoba, String email, String tekst, String webAdresa, Set telefonis) {
        this.korisnici = korisnici;
        this.oblastDelovanja = oblastDelovanja;
        this.naziv = naziv;
        this.kontaktOsoba = kontaktOsoba;
        this.email = email;
        this.tekst = tekst;
        this.webAdresa = webAdresa;
        this.telefonis = telefonis;
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
    
    public Set getTelefonis() {
        return telefonis;
    }
    
    public void setTelefonis(Set telefonis) {
        this.telefonis = telefonis;
    }
}
