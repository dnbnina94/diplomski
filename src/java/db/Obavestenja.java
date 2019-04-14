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
public class Obavestenja {
    private int idObavestenje;
    private Korisnici korisnici;
    private Date datum;
    private String tekst;
    private Vesti vesti;
    private Dogadjaji dogadjaji;
    private Oglasi oglasi;
    private boolean procitano;
    
    public Obavestenja() {
    }
    
    public Obavestenja(Obavestenja ob) {
        this.idObavestenje = ob.getIdObavestenje();
        this.korisnici = ob.korisnici;
        this.datum = ob.datum;
        this.tekst = ob.tekst;
        this.vesti = ob.vesti;
        this.dogadjaji = ob.dogadjaji;
        this.oglasi = ob.oglasi;
        this.procitano = ob.procitano;
    }
    
    public Obavestenja(int idObavestenje, Korisnici korisnici, Date datum, String tekst, boolean procitano) {
        this.idObavestenje = idObavestenje;
        this.korisnici = korisnici;
        this.datum = datum;
        this.tekst = tekst;
        this.procitano = procitano;
    }
    
    public Obavestenja(int idObavestenje, Korisnici korisnici, Date datum, String tekst, Vesti vesti, Dogadjaji dogadjaji, Oglasi oglasi, boolean procitano) {
        this.idObavestenje = idObavestenje;
        this.korisnici = korisnici;
        this.datum = datum;
        this.tekst = tekst;
        this.vesti = vesti;
        this.dogadjaji = dogadjaji;
        this.oglasi = oglasi;
        this.procitano = procitano;
    }

    public int getIdObavestenje() {
        return idObavestenje;
    }

    public void setIdObavestenje(int idObavestenje) {
        this.idObavestenje = idObavestenje;
    }

    public Korisnici getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Vesti getVesti() {
        return vesti;
    }

    public void setVesti(Vesti vesti) {
        this.vesti = vesti;
    }

    public Dogadjaji getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(Dogadjaji dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

    public Oglasi getOglasi() {
        return oglasi;
    }

    public void setOglasi(Oglasi oglasi) {
        this.oglasi = oglasi;
    }

    public boolean isProcitano() {
        return procitano;
    }

    public void setProcitano(boolean procitano) {
        this.procitano = procitano;
    }
    
}
