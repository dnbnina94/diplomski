/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Oglasi;
import db.Organizacije;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nina
 */
public class PretragaOglasa {

    private List<Oglasi> oglasi;
    
    // 1 - za pretragu oglasa, 2 - za oglase organizacije
    private int tipPretrage;
    
    private Organizacije organizacija;
    private Oglasi oglas;

    public PretragaOglasa() {
    }
    
    class SortOglasiByDatumDescending implements Comparator<Oglasi> {
        
        @Override
        public int compare (Oglasi a, Oglasi b) {
            return b.getDatumKreiranja().compareTo(a.getDatumKreiranja());
        }
        
    }
    
    private List<Oglasi> setToList(Set set) {
        oglasi = new ArrayList<Oglasi>(set);
        Collections.sort(oglasi, new PretragaOglasa.SortOglasiByDatumDescending());
        return oglasi;
    }

    public List<Oglasi> getOglasi() {
        if (tipPretrage == 2) {
            return setToList(organizacija.getKorisnici().getOglasis());
        }
        return oglasi;
    }

    public void setOglasi(List<Oglasi> oglasi) {
        this.oglasi = oglasi;
    }

    public int getTipPretrage() {
        return tipPretrage;
    }

    public void setTipPretrage(int tipPretrage) {
        this.tipPretrage = tipPretrage;
    }

    public Organizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(Organizacije organizacija) {
        this.organizacija = organizacija;
    }

    public Oglasi getOglas() {
        return oglas;
    }

    public void setOglas(Oglasi oglas) {
        this.oglas = oglas;
    }

}
