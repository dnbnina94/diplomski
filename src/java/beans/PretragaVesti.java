/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.StavkeSifarnika;
import db.Vesti;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nina
 */
public class PretragaVesti {

    private StavkeSifarnika kategorijaVesti;
    private List<Vesti> vestiKategorije;
    
    public PretragaVesti() {
    }
    
    class SortVestiByDatumDescending implements Comparator<Vesti> {
        
        @Override
        public int compare (Vesti a, Vesti b) {
            return b.getDatum().compareTo(a.getDatum());
        }
        
    }
    
    public StavkeSifarnika getKategorijaVesti() {
        return kategorijaVesti;
    }
    
    public void setKategorijaVesti(StavkeSifarnika kategorijaVesti) {
        this.kategorijaVesti = kategorijaVesti;
    }
    
    private List<Vesti> setToList(Set set) {
        vestiKategorije = new ArrayList<Vesti>(set);
        Collections.sort(vestiKategorije, new PretragaVesti.SortVestiByDatumDescending());
        return vestiKategorije;
    }
    
    public List<Vesti> getVestiKatgorije() {
        return setToList(kategorijaVesti.getVestis()); 
    }
    
    public void setVestiKategorije(List<Vesti> vestiKategorije) {
        this.vestiKategorije = vestiKategorije;
    }
    
}
