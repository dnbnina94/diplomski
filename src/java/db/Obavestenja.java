package db;
// Generated Feb 15, 2019 1:44:18 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Obavestenja generated by hbm2java
 */
public class Obavestenja  implements java.io.Serializable {


     private int idObavestenje;
     private Korisnici korisnici;
     private Date datum;
     private String tekst;

    public Obavestenja() {
    }

    public Obavestenja(int idObavestenje, Korisnici korisnici, Date datum, String tekst) {
       this.idObavestenje = idObavestenje;
       this.korisnici = korisnici;
       this.datum = datum;
       this.tekst = tekst;
    }
   
    public int getIdObavestenje() {
        return this.idObavestenje;
    }
    
    public void setIdObavestenje(int idObavestenje) {
        this.idObavestenje = idObavestenje;
    }
    public Korisnici getKorisnici() {
        return this.korisnici;
    }
    
    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
    }
    public Date getDatum() {
        return this.datum;
    }
    
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    public String getTekst() {
        return this.tekst;
    }
    
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }




}


