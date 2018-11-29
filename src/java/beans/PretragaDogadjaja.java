/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.StavkeSifarnika;
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
    private List<StavkeSifarnika> kategorijeDogadjaja;
    private List<StavkeSifarnika> mesta;
    private List<StavkeSifarnika> uzrasti;
    private String kljucneReci = "";
    
    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();

    public PretragaDogadjaja() {
    }
    
    class SortByIdSifarnik implements Comparator<StavkeSifarnika> {
        
        @Override
        public int compare (StavkeSifarnika a, StavkeSifarnika b) {
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
        kategorijeDogadjaja = this.setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(2));
        return kategorijeDogadjaja;
    }
    
    public void setKategorijeDogadjaja(List<StavkeSifarnika> kategorijeDogadjaja) {
        this.kategorijeDogadjaja = kategorijeDogadjaja;
    }
    
    public List<StavkeSifarnika> getMesta() {
        mesta = this.setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(3));
        return mesta;
    }
    
    public void setMesta(List<StavkeSifarnika> mesta) {
        this.mesta = mesta;
    }
    
    public List<StavkeSifarnika> getUzrasti() {
        uzrasti = this.setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(4));
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
    
}
