/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Ankete;
import db.Pitanja;
import db.PonudjeniOdgovori;
import db.helpers.AnketeHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nina
 */
public class PopunjavanjeAnkete {
    
    private Ankete anketa;
    
    private AnketeHelper anketeHelper = new AnketeHelper();
    
    private Map<Pitanja, Integer> radiobuttonOdgovori = new HashMap<Pitanja, Integer>();
    private Map<Pitanja, Map<PonudjeniOdgovori, Boolean>> checkboxOdgovori = new HashMap<Pitanja, Map<PonudjeniOdgovori, Boolean>>();
    private Map<Pitanja, String> odgovoriGreske = new HashMap<Pitanja, String>();
    
    private String radioOdg = "";
    
    public PopunjavanjeAnkete() {
    }
    
    class SortByIdPitanje implements Comparator<Pitanja> {
        @Override
        public int compare(Pitanja a, Pitanja b) {
            return a.getIdPitanje()- b.getIdPitanje();
        }
    }
    
    class SortByIdPonudjeniOdgovor implements Comparator<PonudjeniOdgovori> {
        @Override
        public int compare(PonudjeniOdgovori a, PonudjeniOdgovori b) {
            return a.getIdOdgovor()- b.getIdOdgovor();
        }
    }
    
    public List<Pitanja> convertSetToListPitanja() {
        List<Pitanja> pitanja = new ArrayList<Pitanja>();
        if (anketa != null) {
            pitanja.addAll(anketa.getPitanjas());
            Collections.sort(pitanja, new SortByIdPitanje());
        }
        return pitanja;
    }
    
    public List<PonudjeniOdgovori> convertSetToListPonudjeniOdgovori(Pitanja pitanje) {
        List<PonudjeniOdgovori> ponudjeniOdgovori = new ArrayList<PonudjeniOdgovori>();
        if (pitanje != null) {
            ponudjeniOdgovori.addAll(pitanje.getPonudjeniOdgovoris());
            Collections.sort(ponudjeniOdgovori, new SortByIdPonudjeniOdgovor());
        }
        return ponudjeniOdgovori;
    }

    public Ankete getAnketa() {
        return anketa;
    }

    public void setAnketa(Ankete anketa) {
        this.anketa = anketa;
        
        setRadiobuttonOdgovori(new HashMap<Pitanja, Integer>());
        setCheckboxOdgovori(new HashMap<Pitanja, Map<PonudjeniOdgovori, Boolean>>());
        setOdgovoriGreske(new HashMap<Pitanja, String>());
        
        for (Pitanja pitanje : convertSetToListPitanja()) {
            getOdgovoriGreske().put(pitanje, "");
            if (pitanje.getTip() == 1) {
                getRadiobuttonOdgovori().put(pitanje, 0);
            }
            if (pitanje.getTip() == 2) {
                Map<PonudjeniOdgovori, Boolean> ponudjeniOdgPitanja = new HashMap<PonudjeniOdgovori, Boolean>();
                for (PonudjeniOdgovori odg : convertSetToListPonudjeniOdgovori(pitanje)) {
                    ponudjeniOdgPitanja.put(odg, Boolean.FALSE);
                }
                getCheckboxOdgovori().put(pitanje, ponudjeniOdgPitanja);
            }
        }
        
    }
    
    public void popuniAnketu() {
        return;
    }

    public Map<Pitanja, Integer> getRadiobuttonOdgovori() {
        return radiobuttonOdgovori;
    }

    public void setRadiobuttonOdgovori(Map<Pitanja, Integer> radiobuttonOdgovori) {
        this.radiobuttonOdgovori = radiobuttonOdgovori;
    }

    public Map<Pitanja, Map<PonudjeniOdgovori, Boolean>> getCheckboxOdgovori() {
        return checkboxOdgovori;
    }

    public void setCheckboxOdgovori(Map<Pitanja, Map<PonudjeniOdgovori, Boolean>> checkboxOdgovori) {
        this.checkboxOdgovori = checkboxOdgovori;
    }

    public Map<Pitanja, String> getOdgovoriGreske() {
        return odgovoriGreske;
    }

    public void setOdgovoriGreske(Map<Pitanja, String> odgovoriGreske) {
        this.odgovoriGreske = odgovoriGreske;
    }

    public String getRadioOdg() {
        return radioOdg;
    }
    
    public void setRadioOdg(String radioOdg) {
        this.radioOdg = radioOdg;
    }
    
    
}
