package db;
// Generated Nov 24, 2018 6:36:55 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Korisnici generated by hbm2java
 */
public class Korisnici  implements java.io.Serializable {


     private String korisnickoIme;
     private byte[] lozinka;
     private byte[] salt;
     private int tip;
     private Set vestis = new HashSet(0);
     private Set dogadjajis = new HashSet(0);
     private Set oglasis = new HashSet(0);
     private Organizacije organizacije;
     private boolean odobren;
     private Set popunjeneAnketes = new HashSet(0);
     private Set obavestenjas = new HashSet(0);
     private Set anketes = new HashSet(0);
     private ZaboravljeneLozinke zaboravljeneLozinke;

    public Korisnici() {
    }

	
    public Korisnici(String korisnickoIme, byte[] lozinka, byte[] salt, int tip, boolean odobren) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.salt = salt;
        this.tip = tip;
        this.odobren = odobren;
    }
    
    public Korisnici(String korisnickoIme, byte[] lozinka, int tip, Set vestis, Set dogadjajis, Set oglasis, Set popunjeneAnketes, Set obavestenjas, Set anketes, ZaboravljeneLozinke zaboravljeneLozinke) {
       this.korisnickoIme = korisnickoIme;
       this.lozinka = lozinka;
       this.tip = tip;
       this.vestis = vestis;
       this.dogadjajis = dogadjajis;
       this.oglasis = oglasis;
       this.popunjeneAnketes = popunjeneAnketes;
       this.anketes = anketes;
       this.obavestenjas = obavestenjas;
       this.zaboravljeneLozinke = zaboravljeneLozinke;
    }
   
    public String getKorisnickoIme() {
        return this.korisnickoIme;
    }
    
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    public byte[] getLozinka() {
        return this.lozinka;
    }
    
    public void setLozinka(byte[] lozinka) {
        this.lozinka = lozinka;
    }
    public int getTip() {
        return this.tip;
    }
    
    public void setTip(int tip) {
        this.tip = tip;
    }
    public Set getVestis() {
        return this.vestis;
    }
    
    public void setVestis(Set vestis) {
        this.vestis = vestis;
    }

    public Set getDogadjajis() {
        return dogadjajis;
    }
    
    public void setDogadjajis(Set dogadjajis) {
        this.dogadjajis = dogadjajis;
    }
    
    public Organizacije getOrganizacije() {
        return organizacije;
    }
    
    public void setOrganizacije(Organizacije organizacije) {
        this.organizacije = organizacije;
    }
    
    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }

    public boolean isOdobren() {
        return odobren;
    }
    
    public byte[] getSalt() {
        return salt;
    }
    
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public Set getOglasis() {
        return oglasis;
    }

    public void setOglasis(Set oglasis) {
        this.oglasis = oglasis;
    }

    public Set getPopunjeneAnketes() {
        return popunjeneAnketes;
    }

    public void setPopunjeneAnketes(Set popunjeneAnketes) {
        this.popunjeneAnketes = popunjeneAnketes;
    }

    public Set getObavestenjas() {
        return obavestenjas;
    }

    public void setObavestenjas(Set obavestenjas) {
        this.obavestenjas = obavestenjas;
    }

    public Set getAnketes() {
        return anketes;
    }

    public void setAnketes(Set anketes) {
        this.anketes = anketes;
    }

    public ZaboravljeneLozinke getZaboravljeneLozinke() {
        return zaboravljeneLozinke;
    }

    public void setZaboravljeneLozinke(ZaboravljeneLozinke zaboravljeneLozinke) {
        this.zaboravljeneLozinke = zaboravljeneLozinke;
    }
    
}


