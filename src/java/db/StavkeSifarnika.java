package db;
// Generated Nov 24, 2018 6:36:55 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.List;
import java.util.Set;




/**
 * StavkeSifarnika generated by hbm2java
 */
public class StavkeSifarnika  implements java.io.Serializable {

    private int idStavka;
    private Sifarnici sifarnici;
    private String naziv;
    private String ikonica;
     
    private Set vestis = new HashSet(0);
    private Set dogadjajisKategorija = new HashSet(0);
    private Set dogadjajisMesto = new HashSet(0);
    private Set dogadjajisUzrast = new HashSet(0);
    
    private Set organizacijesMesto = new HashSet(0);
    private Set organizacijesUlica = new HashSet(0);
    private Set organizacijesOblastDelovanja = new HashSet(0);
    
    private Set dogadjajisKarakteristike = new HashSet(0);

    public StavkeSifarnika() {
    }

    public StavkeSifarnika(int idStavka, Sifarnici sifarnici, String naziv, String ikonica, Set vestis, Set dogadjajisKategorija, Set dogadjajisMesto, Set dogadjajisUzrast, Set organizacijesMesto, Set organizacijesUlica, Set organizacijesOblastDelovanja, Set dogadjajisKarakteristike) {
       this.idStavka = idStavka;
       this.sifarnici = sifarnici;
       this.naziv = naziv;
       this.ikonica = ikonica;
       this.vestis = vestis;
       this.dogadjajisKategorija = dogadjajisKategorija;
       this.dogadjajisMesto = dogadjajisMesto;
       this.dogadjajisUzrast = dogadjajisUzrast;
       this.organizacijesMesto = organizacijesMesto;
       this.organizacijesUlica = organizacijesUlica;
       this.organizacijesOblastDelovanja = organizacijesOblastDelovanja;
       this.dogadjajisKarakteristike = dogadjajisKarakteristike;
    }
    
    public StavkeSifarnika(int idStavka, Sifarnici sifarnici, String naziv, String ikonica) {
        this.idStavka = idStavka;
        this.sifarnici = sifarnici;
        this.naziv = naziv;
        this.ikonica = ikonica;
    }
   
    public int getIdStavka() {
        return this.idStavka;
    }
    
    public void setIdStavka(int idStavka) {
        this.idStavka = idStavka;
    }
    public Sifarnici getSifarnici() {
        return this.sifarnici;
    }
    
    public void setSifarnici(Sifarnici sifarnici) {
        this.sifarnici = sifarnici;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getIkonica() {
        return ikonica;
    }
    
    public void setIkonica(String ikonica) {
        this.ikonica = ikonica;
    }
    
    public Set getVestis() {
        return vestis;
    }
    
    public void setVestis(Set vestis) {
        this.vestis = vestis;
    }
    
    private List<Vesti> setToListVesti() {
        return null;
    }
    
    public Set getDogadjajisKategorija() {
        return dogadjajisKategorija;
    }
    
    public void setDogadjajisKategorija(Set dogadjajisKategorija) {
        this.dogadjajisKategorija = dogadjajisKategorija;
    }
    
    public Set getDogadjajisMesto() {
        return dogadjajisMesto;
    }
    
    public void setDogadjajisMesto(Set dogadjajisMesto) {
        this.dogadjajisMesto = dogadjajisMesto;
    }
    
    public Set getDogadjajisUzrast() {
        return dogadjajisUzrast;
    }
    
    public void setDogadjajisUzrast(Set dogadjajisUzrast) {
        this.dogadjajisUzrast = dogadjajisUzrast;
    }
    
    public Set getOrganizacijesMesto() {
        return organizacijesMesto;
    }  
    
    public void setOrganizacijesMesto(Set organizacijesMesto) {
        this.organizacijesMesto = organizacijesMesto;
    }
    
    public Set getOrganizacijesUlica() {
        return organizacijesUlica;
    }
    
    public void setOrganizacijesUlica(Set organizacijesUlica) {
        this.organizacijesUlica = organizacijesUlica;
    }
    
    public Set getOrganizacijesOblastDelovanja() {
        return organizacijesOblastDelovanja;
    }
    
    public void setOrganizacijesOblastDelovanja(Set organizacijesOblastDelovanja) {
        this.organizacijesOblastDelovanja = organizacijesOblastDelovanja;
    }

    public Set getDogadjajisKarakteristike() {
        return dogadjajisKarakteristike;
    }

    public void setDogadjajisKarakteristike(Set dogadjajisKarakteristike) {
        this.dogadjajisKarakteristike = dogadjajisKarakteristike;
    }
    
}


