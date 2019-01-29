/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.Organizacije;
import db.StavkeSifarnika;
import db.helpers.DogadjajiHelper;
import db.helpers.StavkeSifarnikaHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nina
 */
public class PretragaDogadjaja {

    private StavkeSifarnika mesto;
    private StavkeSifarnika uzrast;
    private StavkeSifarnika karakteristikaProstora;
    private StavkeSifarnika kategorijaDogadjaja;
    private List<StavkeSifarnika> kategorijeDogadjaja;
    private List<StavkeSifarnika> mesta;
    private List<StavkeSifarnika> uzrasti;
    private List<StavkeSifarnika> karakteristikeProstora;
    private String kljucneReci = "";
    private Dogadjaji dogadjaj;
    private List<Dogadjaji> dogadjaji;
    private Organizacije organizacija;
    private int sortiranje;
    private Date datumDogadjaja;

    private Map<StavkeSifarnika, Boolean> checkMap = new HashMap<StavkeSifarnika, Boolean>();

    //1 - klasicna pretraga, 2 - dogadjaji korisnika
    private int tipPretrage;

    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();

    class SortDogadjajiByDatumDescending implements Comparator<Dogadjaji> {

        @Override
        public int compare(Dogadjaji a, Dogadjaji b) {
            return b.getDatumKreiranja().compareTo(a.getDatumKreiranja());
        }

    }

    public PretragaDogadjaja() {
        kategorijeDogadjaja = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(2).getStavkeSifarnikas());
        Collections.sort(kategorijeDogadjaja, new PretragaDogadjaja.SortByIdSifarnik());

        for (StavkeSifarnika kategorija : kategorijeDogadjaja) {
            checkMap.put(kategorija, Boolean.FALSE);
        }

        uzrasti = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(4).getStavkeSifarnikas());
        Collections.sort(uzrasti, new PretragaDogadjaja.SortByIdSifarnik());
        
        karakteristikeProstora = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(7).getStavkeSifarnikas());
        Collections.sort(karakteristikeProstora, new PretragaDogadjaja.SortByIdSifarnik());
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

    public StavkeSifarnika getMesto() {
        return mesto;
    }

    public void setMesto(StavkeSifarnika mesto) {
        this.mesto = mesto;
    }

    public StavkeSifarnika getUzrast() {
        return uzrast;
    }

    public void setUzrast(StavkeSifarnika uzrast) {
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
        if (tipPretrage == 1) {
            return setToListDogadjaji(kategorijaDogadjaja.getDogadjajisKategorija());
        } else {
            return setToListDogadjaji(organizacija.getKorisnici().getDogadjajis());
        }
    }

    public void setDogadjaji(List<Dogadjaji> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

    public Organizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(Organizacije organizacija) {
        this.organizacija = organizacija;
    }

    public int getSortiranje() {
        return sortiranje;
    }

    public void setSortiranje(int sortiranje) {
        this.sortiranje = sortiranje;
    }

    public Date getDatumDogadjaja() {
        return datumDogadjaja;
    }

    public void setDatumDogadjaja(Date datumDogadjaja) {
        this.datumDogadjaja = datumDogadjaja;
    }

    public void pretraziDogadjaje() {
        dogadjaji = dogadjajiHelper.pretragaDogadjaja(datumDogadjaja, checkMap, mesto, uzrast, kljucneReci, sortiranje);
        return;
    }

    public Map<StavkeSifarnika, Boolean> getCheckMap() {
        return checkMap;
    }

    public void setCheckMap(Map<StavkeSifarnika, Boolean> checkMap) {
        this.checkMap = checkMap;
    }

    public List<StavkeSifarnika> getKarakteristikeProstora() {
        return karakteristikeProstora;
    }

    public void setKarakteristikeProstora(List<StavkeSifarnika> karakteristikeProstora) {
        this.karakteristikeProstora = karakteristikeProstora;
    }

    public StavkeSifarnika getKarakteristikaProstora() {
        return karakteristikaProstora;
    }

    public void setKarakteristikaProstora(StavkeSifarnika karakteristikaProstora) {
        this.karakteristikaProstora = karakteristikaProstora;
    }

}
