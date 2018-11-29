/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.*;
import db.helpers.StavkeSifarnikaHelper;
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
public class KategorijeSifarnika implements Serializable {

    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    
    public KategorijeSifarnika() {
    }
    
    class SortByIdSifarnik implements Comparator<StavkeSifarnika> {
        
        @Override
        public int compare (StavkeSifarnika a, StavkeSifarnika b) {
            return a.getIdStavka() - b.getIdStavka();
        }
        
    }
    
    public List<StavkeSifarnika> setToList(Set set) {
        List<StavkeSifarnika> stavkeSifarnika = new ArrayList<StavkeSifarnika>(set);
        Collections.sort(stavkeSifarnika, new SortByIdSifarnik());
        return stavkeSifarnika;
    }
    
    public List<StavkeSifarnika> getVestiKategorije() {
        return setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(1));
    }
    
    public List<StavkeSifarnika> getDogadjajiKategorije() {
        return setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(2));
    }
    
    public List<StavkeSifarnika> getMesta() {
        return setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(3));
    }
    
    public List<StavkeSifarnika> getUzrast() {
        return setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(4));
    }
    
}
