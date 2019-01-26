/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.StavkeSifarnika;
import db.Vesti;
import db.helpers.VestiHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nina
 */
public class AktuelneVesti implements Serializable {
    
    private List<Vesti> vesti;
    private VestiHelper vestiHelper = new VestiHelper();
    private String greska = "greska";
    
    class SortVestiByDatumDescending implements Comparator<Vesti> {
        
        @Override
        public int compare (Vesti a, Vesti b) {
            return b.getDatum().compareTo(a.getDatum());
        }
        
    }
    
    public String getGreska() {
        return greska;
    }
    
    public void setGreska(String greska) {
        this.greska = greska;
    }
    
    public List<Vesti> getVesti() {
        Collections.sort(vesti, new AktuelneVesti.SortVestiByDatumDescending());
        
        for (int i=0; i<vesti.size(); i++) {
            Vesti vest = vesti.get(i);
            if (i==0) {
                vest.setOuterDivClass("col-md-6 col-xs-12 featured-col-container");
                vest.setInnerDivClassRelative("featured-col featured-col-bigger");
                vest.setInnerDivClassAbsolute("featured-content featured-bigger");
            }
            if (i==1) {
                vest.setOuterDivClass("col-md-6 col-xs-6 featured-col-container");
                vest.setInnerDivClassRelative("featured-col featured-col-bigger featured-col-second");
                vest.setInnerDivClassAbsolute("featured-content featured-bigger");
            }
            if (i != 0 && i != 1) {
                vest.setOuterDivClass("col-md-4 col-xs-6 featured-col-container");
                vest.setInnerDivClassRelative("featured-col featured-col-smaller");
                vest.setInnerDivClassAbsolute("featured-content featured-smaller");
            }
            vesti.set(i, vest);
        }
        
        return vesti;
    }
    
    public void setVesti(List<Vesti> vesti) {
        this.vesti = vesti;
    }
    
    public AktuelneVesti() {
        vesti = vestiHelper.aktuelneVesti();
    }
    
    public List<Vesti> setToListVesti(Set set) {
        List<Vesti> vestiKategorije = new ArrayList<Vesti>(set);
        Collections.sort(vestiKategorije, new AktuelneVesti.SortVestiByDatumDescending());
        if (vestiKategorije.size() > 3)
            return vestiKategorije.subList(0, 4);
        return vestiKategorije;
    }
    
}
