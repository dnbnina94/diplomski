/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.StavkeSifarnika;
import db.Vesti;
import db.helpers.StavkeSifarnikaHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nina
 */
public class PretragaDogadjaja {

    private String mesto;
    private String uzrast;
    private StavkeSifarnika kategorijaDogadjaja;
    private List<StavkeSifarnika> kategorijeDogadjaja;
    private List<StavkeSifarnika> mesta;
    private List<StavkeSifarnika> uzrasti;
    private String kljucneReci = "";
    private Dogadjaji dogadjaj;
    private List<Dogadjaji> dogadjaji;

    //1 - klasicna pretraga, 2 - dogadjaji korisnika
    private int tipPretrage;

    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    
    class SortDogadjajiByDatumDescending implements Comparator<Dogadjaji> {
        
        @Override
        public int compare (Dogadjaji a, Dogadjaji b) {
            return b.getDatumKreiranja().compareTo(a.getDatumKreiranja());
        }
        
    }

    public PretragaDogadjaja() {
        kategorijeDogadjaja = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(2).getStavkeSifarnikas());
        Collections.sort(kategorijeDogadjaja, new PretragaDogadjaja.SortByIdSifarnik());

        uzrasti = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(4).getStavkeSifarnikas());
        Collections.sort(uzrasti, new PretragaDogadjaja.SortByIdSifarnik());
    }

    class SortByIdSifarnik implements Comparator<StavkeSifarnika> {

        @Override
        public int compare(StavkeSifarnika a, StavkeSifarnika b) {
            return a.getIdStavka() - b.getIdStavka();
        }

    }

    private List<StavkeSifarnika> setToList(Set set) {
        List<StavkeSifarnika> stavkeSifarnika = new ArrayList<StavkeSifarnika>(set);
        Collections.sort(stavkeSifarnika, new PretragaDogadjaja.SortByIdSifarnik());
        return stavkeSifarnika;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUzrast() {
        return uzrast;
    }

    public void setUzrast(String uzrast) {
        this.uzrast = uzrast;
    }

    public List<StavkeSifarnika> getKategorijeDogadjaja() {
        return kategorijeDogadjaja;
    }

    public void setKategorijeDogadjaja(List<StavkeSifarnika> kategorijeDogadjaja) {
        this.kategorijeDogadjaja = kategorijeDogadjaja;
    }

    public List<StavkeSifarnika> getMesta() {
        mesta = this.setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(3).getStavkeSifarnikas());
        return mesta;
    }

    public void setMesta(List<StavkeSifarnika> mesta) {
        this.mesta = mesta;
    }

    public List<StavkeSifarnika> getUzrasti() {
        return uzrasti;
    }

    public void setUzrasti(List<StavkeSifarnika> uzrasti) {
        this.uzrasti = uzrasti;
    }

    public String getKljucneReci() {
        return kljucneReci;
    }

    public void setKljucneReci(String kljucneReci) {
        this.kljucneReci = kljucneReci;
    }

    public Dogadjaji getDogadjaj() {
        return dogadjaj;
    }

    public void setDogadjaj(Dogadjaji dogadjaj) {
        this.dogadjaj = dogadjaj;
    }

    public StavkeSifarnika getKategorijaDogadjaja() {
        return kategorijaDogadjaja;
    }

    public void setKategorijaDogadjaja(StavkeSifarnika kategorijaDogadjaja) {
        this.kategorijaDogadjaja = kategorijaDogadjaja;
    }

    public int getTipPretrage() {
        return tipPretrage;
    }

    public void setTipPretrage(int tipPretrage) {
        this.tipPretrage = tipPretrage;
    }
    
    private List<Dogadjaji> setToListDogadjaji(Set set) {
        dogadjaji = new ArrayList<Dogadjaji>(set);
        Collections.sort(dogadjaji, new PretragaDogadjaja.SortDogadjajiByDatumDescending());
        return dogadjaji;
    }

    public List<Dogadjaji> getDogadjaji() {
        return setToListDogadjaji(kategorijaDogadjaja.getDogadjajisKategorija());
    }

    public void setDogadjaji(List<Dogadjaji> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

}
