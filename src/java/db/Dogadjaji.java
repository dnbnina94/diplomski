/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.Date;

/**
 *
 * @author Nina
 */
public class Dogadjaji implements java.io.Serializable {

    private int idDogadjaj;
    private String naslov;
    private String tekst;
    private StavkeSifarnika kategorija;
    private StavkeSifarnika mesto;
    private StavkeSifarnika uzrast;
    private Date datumDogadjaja;
    private Date datumKreiranja;
    private Korisnici korisnici;
    private Date datumIsticanja;

    public Dogadjaji() {
    }

    public Dogadjaji(int idDogadjaj, String naslov, String tekst, StavkeSifarnika kategorija, StavkeSifarnika mesto, StavkeSifarnika uzrast, Date datumDogadjaja, Date datumKreiranja, Korisnici korisnici, Date datumIsticanja) {
        this.idDogadjaj = idDogadjaj;
        this.naslov = naslov;
        this.tekst = tekst;
        this.kategorija = kategorija;
        this.mesto = mesto;
        this.uzrast = uzrast;
        this.datumDogadjaja = datumDogadjaja;
        this.datumKreiranja = datumKreiranja;
        this.korisnici = korisnici;
        this.datumIsticanja = datumIsticanja;
    }
    
    public int getIdDogadjaj() {
        return idDogadjaj;
    }
    
    public void setIdDogadjaj(int idDogadjaj) {
        this.idDogadjaj = idDogadjaj;
    }
    
    public String getNaslov() {
        return naslov;
    }
    
    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }
    
    public String getTekst() {
        return tekst;
    }
    
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    
    public StavkeSifarnika getKategorija() {
        return kategorija;
    }
    
    public void setKategorija(StavkeSifarnika kategorija) {
        this.kategorija = kategorija;
    }
    
    public StavkeSifarnika getMesto() {
        return mesto;
    }
    
    public void setMesto(StavkeSifarnika mesto) {
        this.mesto = mesto;
    }
    
    public StavkeSifarnika getUzrast() {
        return uzrast;
    }
    
    public void setUzrast(StavkeSifarnika uzrast) {
        this.uzrast = uzrast;
    }
    
    public Date getDatumDogadjaja() {
        return datumDogadjaja;
    }
    
    public void setDatumDogadjaja(Date datumDogadjaja) {
        this.datumDogadjaja = datumDogadjaja;
    }
    
    public Date getDatumKreiranja() {
        return datumKreiranja;
    }
    
    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }
    
    public Korisnici getKorisnici() {
        return korisnici;
    }
    
    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
    }
    
    public Date getDatumIsticanja() {
        return datumIsticanja;
    }
    
    public void setDatumIsticanja(Date datumIsticanja) {
        this.datumIsticanja = datumIsticanja;
    }

}
