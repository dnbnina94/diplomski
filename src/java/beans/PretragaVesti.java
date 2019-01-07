/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Organizacije;
import db.StavkeSifarnika;
import db.Vesti;
import db.helpers.StavkeSifarnikaHelper;
import db.helpers.VestiHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    
    // 1 - vesti kategorije, 2 - vesti korisnika
    private int tipPretrage;
    
    public PretragaVesti() {
        kategorijeVesti = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(1).getStavkeSifarnikas());
        Collections.sort(kategorijeVesti, new PretragaVesti.SortByIdSifarnik());
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
            return setToList(kategorijaVesti.getVestis()); 
        } else {
            return setToList(organizacija.getKorisnici().getVestis()); 
        }
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
    
}
