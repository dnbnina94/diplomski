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
    
    class SortVestiByDatum implements Comparator<Vesti> {
        
        @Override
        public int compare (Vesti a, Vesti b) {
            return a.getDatum().compareTo(b.getDatum());
        }
        
    }
    
    public String getGreska() {
        return greska;
    }
    
    public void setGreska(String greska) {
        this.greska = greska;
    }
    
    public List<Vesti> getVesti() {
        return vesti;
    }
    
    public void setVest(List<Vesti> vesti) {
        this.vesti = vesti;
    }
    
    public AktuelneVesti() {
        vesti = vestiHelper.aktuelneVesti();
        Collections.sort(vesti, new AktuelneVesti.SortVestiByDatum());
        if (vesti.size() > 4)
            vesti = vesti.subList(0, 5);
    }
    
    public List<Vesti> setToListVesti(Set set) {
        List<Vesti> vestiKategorije = new ArrayList<Vesti>(set);
        Collections.sort(vestiKategorije, new AktuelneVesti.SortVestiByDatum());
        if (vestiKategorije.size() > 3)
            return vestiKategorije.subList(0, 4);
        return vestiKategorije;
    }
    
}
