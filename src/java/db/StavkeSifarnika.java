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

    public StavkeSifarnika() {
    }

    public StavkeSifarnika(int idStavka, Sifarnici sifarnici, String naziv, String ikonica, Set vestis) {
       this.idStavka = idStavka;
       this.sifarnici = sifarnici;
       this.naziv = naziv;
       this.ikonica = ikonica;
       this.vestis = vestis;
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

}


