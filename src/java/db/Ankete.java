package db;
// Generated Apr 18, 2019 12:51:16 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ankete generated by hbm2java
 */
public class Ankete  implements java.io.Serializable {


     private int idAnketa;
     private Korisnici korisnici;
     private String naziv;
     private String opis;
     private int nivoVidljivosti;
     private Date datumIsticanja;
     private Date datumKreiranja;
     private Set popunjeneAnketes = new HashSet(0);
     private Set pitanjas = new HashSet(0);

    public Ankete() {
    }

	
    public Ankete(int idAnketa, Korisnici korisnici, String naziv, String opis, int nivoVidljivosti, Date datumIsticanja, Date datumKreiranja) {
        this.idAnketa = idAnketa;
        this.korisnici = korisnici;
        this.naziv = naziv;
        this.opis = opis;
        this.nivoVidljivosti = nivoVidljivosti;
        this.datumIsticanja = datumIsticanja;
        this.datumKreiranja = datumKreiranja;
    }
    public Ankete(int idAnketa, Korisnici korisnici, String naziv, String opis, int nivoVidljivosti, Date datumIsticanja, Date datumKreiranja, Set pitanjas, Set popunjeneAnketes) {
       this.idAnketa = idAnketa;
       this.korisnici = korisnici;
       this.naziv = naziv;
       this.opis = opis;
       this.nivoVidljivosti = nivoVidljivosti;
       this.datumIsticanja = datumIsticanja;
       this.datumKreiranja = datumKreiranja;
       this.pitanjas = pitanjas;
       this.popunjeneAnketes = popunjeneAnketes;
    }
   
    public int getIdAnketa() {
        return this.idAnketa;
    }
    
    public void setIdAnketa(int idAnketa) {
        this.idAnketa = idAnketa;
    }
    public Korisnici getKorisnici() {
        return this.korisnici;
    }
    
    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public int getNivoVidljivosti() {
        return this.nivoVidljivosti;
    }
    
    public void setNivoVidljivosti(int nivoVidljivosti) {
        this.nivoVidljivosti = nivoVidljivosti;
    }
    public Date getDatumIsticanja() {
        return this.datumIsticanja;
    }
    
    public void setDatumIsticanja(Date datumIsticanja) {
        this.datumIsticanja = datumIsticanja;
    }
    public Set getPitanjas() {
        return this.pitanjas;
    }
    
    public void setPitanjas(Set pitanjas) {
        this.pitanjas = pitanjas;
    }
    
    public boolean zatvorena() {
        if (datumIsticanja.before(new Date()))
            return true;
        return false;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Set getPopunjeneAnketes() {
        return popunjeneAnketes;
    }

    public void setPopunjeneAnketes(Set popunjeneAnketes) {
        this.popunjeneAnketes = popunjeneAnketes;
    }
    
    public String getNazivShort() {
        if (naziv.length() <= 40)
            return naziv;
        else 
            return naziv.substring(0, Math.min(naziv.length(), 40))+"...";
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    public String getOpisShort() {
        return opis.substring(0, Math.min(opis.length(), 150))+"...";
    }

}


