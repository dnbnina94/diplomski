package db;
// Generated Apr 17, 2019 7:40:18 PM by Hibernate Tools 4.3.1



/**
 * PonudjeniOdgovori generated by hbm2java
 */
public class PonudjeniOdgovori  implements java.io.Serializable {


     private int idOdgovor;
     private Pitanja pitanja;
     private String odgovor;

    public PonudjeniOdgovori() {
    }

    public PonudjeniOdgovori(int idOdgovor, Pitanja pitanja, String odgovor) {
       this.idOdgovor = idOdgovor;
       this.pitanja = pitanja;
       this.odgovor = odgovor;
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




}

