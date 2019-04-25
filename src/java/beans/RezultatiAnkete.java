/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Ankete;
import db.Odgovori;
import db.Pitanja;
import db.PonudjeniOdgovori;
import db.PopunjeneAnkete;
import db.helpers.PopunjeneAnketeHelper;
import helpers.CookieHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

/**
 *
 * @author Nina
 */
public class RezultatiAnkete {

    private Ankete anketa;

    private Map<Pitanja, Map<PonudjeniOdgovori, Integer>> brOdgovoraNaPitanje = new HashMap<Pitanja, Map<PonudjeniOdgovori, Integer>>();
    
    private PopunjeneAnketeHelper popAnketeHelper = new PopunjeneAnketeHelper();
    private CookieHelper cookieHelper = new CookieHelper();

    private PopunjeneAnkete popunjeneAnkete;

    public RezultatiAnkete() {
    }

    class SortByIdPitanje implements Comparator<Pitanja> {

        @Override
        public int compare(Pitanja a, Pitanja b) {
            return a.getIdPitanje() - b.getIdPitanje();
        }
    }

    class SortByIdPonudjeniOdgovor implements Comparator<PonudjeniOdgovori> {

        @Override
        public int compare(PonudjeniOdgovori a, PonudjeniOdgovori b) {
            return a.getIdOdgovor() - b.getIdOdgovor();
        }
    }

    public List<Pitanja> convertSetToListPitanja() {
        List<Pitanja> pitanja = new ArrayList<Pitanja>();
        if (anketa != null) {
            pitanja.addAll(anketa.getPitanjas());
            Collections.sort(pitanja, new RezultatiAnkete.SortByIdPitanje());
        }
        return pitanja;
    }

    public List<PonudjeniOdgovori> convertSetToListPonudjeniOdgovori(Pitanja pitanje) {
        List<PonudjeniOdgovori> ponudjeniOdgovori = new ArrayList<PonudjeniOdgovori>();
        if (pitanje != null) {
            ponudjeniOdgovori.addAll(pitanje.getPonudjeniOdgovoris());
            Collections.sort(ponudjeniOdgovori, new RezultatiAnkete.SortByIdPonudjeniOdgovor());
        }
        return ponudjeniOdgovori;
    }

    public Ankete getAnketa() {
        return anketa;
    }

    public void setAnketa(Ankete anketa) {
        this.anketa = anketa;

        setBrOdgovoraNaPitanje(new HashMap<Pitanja, Map<PonudjeniOdgovori, Integer>>());

        for (Pitanja pitanje : new ArrayList<Pitanja>(anketa.getPitanjas())) {

            Map<PonudjeniOdgovori, Integer> odgovori = new HashMap<PonudjeniOdgovori, Integer>();
            for (PonudjeniOdgovori ponOdg : new ArrayList<PonudjeniOdgovori>(pitanje.getPonudjeniOdgovoris())) {
                odgovori.put(ponOdg, ponOdg.getOdgovoris().size());
            }

            getBrOdgovoraNaPitanje().put(pitanje, odgovori);

        }

        popunjeneAnkete = null;

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
        
        if (korisnikBean.getKorisnik() != null) {
            popunjeneAnkete = popAnketeHelper.getPopunjenaAnketaByKorisnik(anketa, korisnikBean.getKorisnik(), null);
        } else {
            Cookie cookie = cookieHelper.getCookie("userId");
            if (cookie != null) {
                popunjeneAnkete = popAnketeHelper.getPopunjenaAnketaByKorisnik(anketa, null, cookie.getValue());
            }
        }

    }

    public Map<Pitanja, Map<PonudjeniOdgovori, Integer>> getBrOdgovoraNaPitanje() {
        return brOdgovoraNaPitanje;
    }

    public void setBrOdgovoraNaPitanje(Map<Pitanja, Map<PonudjeniOdgovori, Integer>> brOdgovoraNaPitanje) {
        this.brOdgovoraNaPitanje = brOdgovoraNaPitanje;
    }

    public int ukupanBrojOdgovora(Pitanja pitanje) {
        int ukupanBr = 0;

        for (Map.Entry<PonudjeniOdgovori, Integer> odg : brOdgovoraNaPitanje.get(pitanje).entrySet()) {
            ukupanBr += odg.getValue();
        }

        return ukupanBr;
    }

    public PopunjeneAnkete getPopunjeneAnkete() {
        return popunjeneAnkete;
    }

    public void setPopunjeneAnkete(PopunjeneAnkete popunjeneAnkete) {
        this.popunjeneAnkete = popunjeneAnkete;
    }
    
    public boolean korisnikovOdgovor(PonudjeniOdgovori ponOdg) {
        if (popunjeneAnkete == null)
            return false;
        
        for (Odgovori odg : new ArrayList<Odgovori>(popunjeneAnkete.getOdgovoris())) {
            if (odg.getPonudjeniOdgovori().getIdOdgovor() == ponOdg.getIdOdgovor())
                return true;
        }
        
        return false;
    }

}
