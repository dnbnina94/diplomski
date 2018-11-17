/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Nina
 */
public class Korisnik implements java.io.Serializable {
    
    private int id_korisnik;
    private String korisnicko_ime;
    private String lozinka;
    
    public Korisnik() {}
    
    public Korisnik(int id_korisnik, String korisnicko_ime, String lozinka) {
        this.id_korisnik = id_korisnik;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
    }
    
    public int getId_korisnik() {
        return id_korisnik;
    }
    
    public void setId_korisnik(int id_korisnik) {
        this.id_korisnik = id_korisnik;
    }
    
    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }
    
    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }
    
    public String getLozinka() {
        return lozinka;
    }
    
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
}
