/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Organizacije;
import db.StavkeSifarnika;
import db.Vesti;
import db.helpers.KorisniciHelper;
import db.helpers.StavkeSifarnikaHelper;
import db.helpers.VestiHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Nina
 */
public class PretragaVesti {

    private StavkeSifarnika kategorijaVesti;
    private List<Vesti> vesti;
    private List<StavkeSifarnika> kategorijeVesti;
    private Organizacije organizacija;
    private Vesti vest;
    private VestiHelper vestiHelper = new VestiHelper();
    private KorisniciHelper korisniciHelper = new KorisniciHelper();
    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    
    private List<Organizacije> organizacije;
    private String kreatorVesti;
    private int sortiranje;
    private String kljucneReci;
    private Date datum;
    
    // 1 - vesti kategorije, 2 - vesti korisnika, 3 - rezultat pretrage
    private int tipPretrage;
    private Map<StavkeSifarnika, Boolean> checkMap = new HashMap<StavkeSifarnika, Boolean>();
    
    public PretragaVesti() {
        kategorijeVesti = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(1).getStavkeSifarnikas());
        Collections.sort(kategorijeVesti, new PretragaVesti.SortByIdSifarnik());
        
        for (StavkeSifarnika kategorija : kategorijeVesti) {
            checkMap.put(kategorija, Boolean.FALSE);
        }
        
        organizacije = korisniciHelper.getSveOdobreneOrganizacije();
        Collections.sort(organizacije, new PretragaVesti.SortOrganizacijeByKorIme());
    }
    
    class SortOrganizacijeByKorIme implements Comparator<Organizacije> {

        @Override
        public int compare(Organizacije a, Organizacije b) {
            return a.getKorisnickoIme().toLowerCase().compareTo(b.getKorisnickoIme().toLowerCase());
        }
    }
    
    class SortVestiByDatumDescending implements Comparator<Vesti> {
        
        @Override
        public int compare (Vesti a, Vesti b) {
            return b.getDatum().compareTo(a.getDatum());
        }
        
    }
    
    class SortByIdSifarnik implements Comparator<StavkeSifarnika> {
        
        @Override
        public int compare (StavkeSifarnika a, StavkeSifarnika b) {
            return a.getIdStavka() - b.getIdStavka();
        }
        
    }
    
    public StavkeSifarnika getKategorijaVesti() {
        return kategorijaVesti;
    }
    
    public void setKategorijaVesti(StavkeSifarnika kategorijaVesti) {
        this.kategorijaVesti = kategorijaVesti;
    }
    
    private List<Vesti> setToList(Set set) {
        vesti = new ArrayList<Vesti>(set);
        Collections.sort(vesti, new PretragaVesti.SortVestiByDatumDescending());
        return vesti;
    }
    
    public List<Vesti> getVesti() {
        if (tipPretrage == 1) {
            vesti = vestiHelper.getVestiByKategorija(kategorijaVesti);
            Collections.sort(vesti, new PretragaVesti.SortVestiByDatumDescending());
            return vesti;
            //return setToList(kategorijaVesti.getVestis()); 
        }
        if (tipPretrage == 2) {
            vesti = vestiHelper.getVestiByKorisnik(organizacija.getKorisnici());
            Collections.sort(vesti, new PretragaVesti.SortVestiByDatumDescending());
            return vesti;
            //return setToList(organizacija.getKorisnici().getVestis()); 
        }
        this.pretraziVesti();
        return vesti;
    }
    
    public void setVesti(List<Vesti> vesti) {
        this.vesti = vesti;
    }
    
    public String prikazVestiKategorije(StavkeSifarnika kategorijaVesti) {
        this.kategorijaVesti = kategorijaVesti;
        return "vesti";
    }
    
    public Vesti getVest() {
        return vest;
    }
    
    public void setVest(Vesti vest) {
        this.vest = vest;
    }
    
    public List<StavkeSifarnika> getKategorijeVesti() {
        kategorijeVesti = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(1).getStavkeSifarnikas());
        Collections.sort(kategorijeVesti, new PretragaVesti.SortByIdSifarnik());
        
        for (StavkeSifarnika kategorija : kategorijeVesti) {
            checkMap.put(kategorija, Boolean.FALSE);
        }
        
        return kategorijeVesti;
    }
    
    public void setKategorijeVesti(List<StavkeSifarnika> kategorijeVesti) {
        this.kategorijeVesti = kategorijeVesti;
    }
    
    public Organizacije getOrganizacija() {
        return organizacija;
    }
    
    public void setOrganizacija(Organizacije organizacija) {
        this.organizacija = organizacija;
    }

    public int getTipPretrage() {
        return tipPretrage;
    }

    public void setTipPretrage(int tipPretrage) {
        this.tipPretrage = tipPretrage;
    }

    public List<Organizacije> getOrganizacije() {
        return organizacije;
    }

    public void setOrganizacije(List<Organizacije> organizacije) {
        this.organizacije = organizacije;
    }

    public String getKreatorVesti() {
        return kreatorVesti;
    }

    public void setKreatorVesti(String kreatorVesti) {
        this.kreatorVesti = kreatorVesti;
    }

    public int getSortiranje() {
        return sortiranje;
    }

    public void setSortiranje(int sortiranje) {
        this.sortiranje = sortiranje;
    }
    
    public void pretraziVesti() {
        vesti = vestiHelper.pretragaVesti(kljucneReci, checkMap, kreatorVesti, sortiranje, datum);
        tipPretrage = 3;
        return;
    }

    public String getKljucneReci() {
        return kljucneReci;
    }

    public void setKljucneReci(String kljucneReci) {
        this.kljucneReci = kljucneReci;
    }

    public Map<StavkeSifarnika, Boolean> getCheckMap() {
        return checkMap;
    }

    public void setCheckMap(Map<StavkeSifarnika, Boolean> checkMap) {
        this.checkMap = checkMap;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
}
