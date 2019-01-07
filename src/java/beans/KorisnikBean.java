/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;

/**
 *
 * @author Nina
 */
public class KorisnikBean {
    
    private Korisnici korisnik;
    
    public KorisnikBean() {
    }
    
    public Korisnici getKorisnik() {
        return korisnik;
    }
    
    public void setKorisnik(Korisnici korisnik) {
        this.korisnik = korisnik;
    }
    
}
