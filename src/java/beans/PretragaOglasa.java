/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Oglasi;
import db.Organizacije;
import db.StavkeSifarnika;
import db.helpers.KorisniciHelper;
import db.helpers.OglasiHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

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

    private String kljucneReci;

    private String kreatorOglasa;
    private List<Organizacije> organizacije;
    private KorisniciHelper korisniciHelper = new KorisniciHelper();

    private OglasiHelper oglasiHelper = new OglasiHelper();

    // 1 - datum kreiranja, 2 - rok isteka
    private int sortiranje;

    public PretragaOglasa() {
        organizacije = new ArrayList<Organizacije>(korisniciHelper.getSveOdobreneOrganizacije());
        Collections.sort(organizacije, new PretragaOglasa.SortOrganizacijeByName());
    }

    class SortOrganizacijeByName implements Comparator<Organizacije> {

        @Override
        public int compare(Organizacije a, Organizacije b) {
            return a.getKorisnickoIme().toLowerCase().compareTo(b.getKorisnickoIme().toLowerCase());
        }

    }

    class SortOglasiByDatumDescending implements Comparator<Oglasi> {

        @Override
        public int compare(Oglasi a, Oglasi b) {
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
            oglasi = oglasiHelper.getOglasiByKorisnik(organizacija.getKorisnici());
            Collections.sort(oglasi, new PretragaOglasa.SortOglasiByDatumDescending());
            return oglasi;
            //return setToList(organizacija.getKorisnici().getOglasis());
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

    public String getKljucneReci() {
        return kljucneReci;
    }

    public void setKljucneReci(String kljucneReci) {
        this.kljucneReci = kljucneReci;
    }

    public String getKreatorOglasa() {
        return kreatorOglasa;
    }

    public void setKreatorOglasa(String kreatorOglasa) {
        this.kreatorOglasa = kreatorOglasa;
    }

    public List<Organizacije> getOrganizacije() {
        return organizacije;
    }

    public void setOrganizacije(List<Organizacije> organizacije) {
        this.organizacije = organizacije;
    }

    public int getSortiranje() {
        return sortiranje;
    }

    public void setSortiranje(int sortiranje) {
        this.sortiranje = sortiranje;
    }

    public void pretraziOglase() {
        //oglasi = new ArrayList<Oglasi>();
        oglasi = oglasiHelper.pretragaOglasa(kljucneReci, kreatorOglasa, sortiranje);
        tipPretrage = 1;
    }

}
