package db;
// Generated Apr 17, 2019 7:40:18 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

public class PonudjeniOdgovori  implements java.io.Serializable {

     private int idOdgovor;
     private Pitanja pitanja;
     private String odgovor;
     private Set odgovoris = new HashSet(0);

    public PonudjeniOdgovori() {
    }

    public PonudjeniOdgovori(int idOdgovor, Pitanja pitanja, String odgovor) {
       this.idOdgovor = idOdgovor;
       this.pitanja = pitanja;
       this.odgovor = odgovor;
    }
    
    public PonudjeniOdgovori(int idOdgovor, Pitanja pitanja, String odgovor, Set odgovoris) {
        this.idOdgovor = idOdgovor;
        this.pitanja = pitanja;
        this.odgovor = odgovor;
        this.odgovoris = odgovoris;
    }
   
    public int getIdOdgovor() {
        return this.idOdgovor;
    }
    
    public void setIdOdgovor(int idOdgovor) {
        this.idOdgovor = idOdgovor;
    }
    public Pitanja getPitanja() {
        return this.pitanja;
    }
    
    public void setPitanja(Pitanja pitanja) {
        this.pitanja = pitanja;
    }
    public String getOdgovor() {
        return this.odgovor;
    }
    
    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public Set getOdgovoris() {
        return odgovoris;
    }

    public void setOdgovoris(Set odgovoris) {
        this.odgovoris = odgovoris;
    }

}


