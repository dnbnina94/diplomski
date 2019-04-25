/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.AdminLog;
import db.Ankete;
import db.Odgovori;
import db.Pitanja;
import db.PonudjeniOdgovori;
import db.PopunjeneAnkete;
import db.StavkeIzvestaj;
import db.helpers.AdminLogHelper;
import db.helpers.AnketeHelper;
import db.helpers.PopunjeneAnketeHelper;
import db.helpers.StavkeIzvestajHelper;
import helpers.CookieHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

/**
 *
 * @author Nina
 */
public class PopunjavanjeAnkete {

    private Ankete anketa;

    private AnketeHelper anketeHelper = new AnketeHelper();
    private PopunjeneAnketeHelper popAnketeHelper = new PopunjeneAnketeHelper();
    private StavkeIzvestajHelper stavkeIzvestajHelper = new StavkeIzvestajHelper();
    private AdminLogHelper adminLogHelper = new AdminLogHelper();
    private CookieHelper cookieHelper = new CookieHelper();

    private Map<Pitanja, String> radiobuttonOdgovori = new HashMap<Pitanja, String>();
    private Map<Pitanja, Map<PonudjeniOdgovori, Boolean>> checkboxOdgovori = new HashMap<Pitanja, Map<PonudjeniOdgovori, Boolean>>();
    private Map<Pitanja, String> odgovoriGreske = new HashMap<Pitanja, String>();

    public PopunjavanjeAnkete() {
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

        setRadiobuttonOdgovori(new HashMap<Pitanja, String>());
        setCheckboxOdgovori(new HashMap<Pitanja, Map<PonudjeniOdgovori, Boolean>>());
        setOdgovoriGreske(new HashMap<Pitanja, String>());

        for (Pitanja pitanje : convertSetToListPitanja()) {
            getOdgovoriGreske().put(pitanje, "");
            if (pitanje.getTip() == 1) {
                getRadiobuttonOdgovori().put(pitanje, null);
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

    public boolean radiobuttonOdgovoriValidacija() {
        boolean valid = true;

        for (Map.Entry<Pitanja, String> entry : radiobuttonOdgovori.entrySet()) {
            String greska = "";
            if (entry.getValue() == null) {
                greska = "Morate izabrati jedan od ponuđenih odgovora.";
                valid = false;
            }
            odgovoriGreske.put(entry.getKey(), greska);
        }

        return valid;
    }

    public boolean checkboxOdgovoriValidacija() {
        boolean valid = true;

        for (Map.Entry<Pitanja, Map<PonudjeniOdgovori, Boolean>> entry : checkboxOdgovori.entrySet()) {
            String greska = "";

            int uncheckedAnswers = 0;
            for (Map.Entry<PonudjeniOdgovori, Boolean> entry2 : entry.getValue().entrySet()) {
                if (!entry2.getValue()) {
                    uncheckedAnswers++;
                }
            }

            if (uncheckedAnswers == entry.getValue().size()) {
                greska = "Morate izabrati makar jedan od ponuđenih odgovora.";
                valid = false;
            }

            odgovoriGreske.put(entry.getKey(), greska);
        }

        return valid;
    }

    public void popuniAnketu() {
        boolean valid = true;

        if (!radiobuttonOdgovoriValidacija()) {
            valid = false;
        }
        if (!checkboxOdgovoriValidacija()) {
            valid = false;
        }

        if (valid) {
            PopunjeneAnkete popunjenaAnketa = new PopunjeneAnkete();
            popunjenaAnketa.setIdPopunjenaAnketa(popAnketeHelper.getMaxId() + 1);
            popunjenaAnketa.setAnkete(anketa);
            popunjenaAnketa.setDatum(new Date());

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            if (korisnikBean.getKorisnik() != null) {
                popunjenaAnketa.setKorisnici(korisnikBean.getKorisnik());
            } else {
                Cookie cookie = cookieHelper.getCookie("userId");
                if (cookie == null) {
                    UUID uid = UUID.randomUUID();
                    cookieHelper.setCookie("userId", uid.toString(), -1);
                    popunjenaAnketa.setCookie(uid.toString());
                } else {
                    popunjenaAnketa.setCookie(cookie.getValue());
                }
            }

            popAnketeHelper.insertPopunjenaAnketa(popunjenaAnketa);
            
            for (Pitanja pitanje : new ArrayList<Pitanja>(anketa.getPitanjas())) {
                if (pitanje.getTip() == 1) {
                    
                    int idPonOdg = Integer.parseInt(radiobuttonOdgovori.get(pitanje)); 
                    PonudjeniOdgovori ponOdg = null;
                    
                    for (PonudjeniOdgovori ponudjeniOdgvor : new ArrayList<PonudjeniOdgovori>(pitanje.getPonudjeniOdgovoris())) {
                        if (ponudjeniOdgvor.getIdOdgovor() == idPonOdg) {
                            ponOdg = ponudjeniOdgvor;
                            break;
                        }
                    }
                    
                    Odgovori odgovor = new Odgovori();
                    odgovor.setIdOdgovor(popAnketeHelper.getMaxIdOdgovor()+1);
                    odgovor.setPopunjeneAnkete(popunjenaAnketa);
                    odgovor.setPonudjeniOdgovori(ponOdg);
                    
                    popAnketeHelper.insertOdgovor(odgovor);
                    
                }
                if (pitanje.getTip() == 2) {
                    
                    for (Map.Entry<PonudjeniOdgovori, Boolean> ponudjeniOdgovor : checkboxOdgovori.get(pitanje).entrySet()) {
                        
                        if (ponudjeniOdgovor.getValue()) {
                            Odgovori odgovor = new Odgovori();
                            odgovor.setIdOdgovor(popAnketeHelper.getMaxIdOdgovor()+1);
                            odgovor.setPopunjeneAnkete(popunjenaAnketa);
                            odgovor.setPonudjeniOdgovori(ponudjeniOdgovor.getKey());
                            
                            popAnketeHelper.insertOdgovor(odgovor);
                        }
                        
                    }
                    
                }
            }

            StavkeIzvestaj novaStavka = new StavkeIzvestaj();
            novaStavka.setIdStavka(stavkeIzvestajHelper.getMaxId() + 1);
            novaStavka.setDatum(new Date());
            novaStavka.setNaziv(anketa.getNaziv());
            novaStavka.setSifarniciIzvestaj(stavkeIzvestajHelper.getSifarnikIzvestajById(14));

            stavkeIzvestajHelper.insertStavkaIzvestaj(novaStavka);

            if (korisnikBean.getKorisnik() != null) {
                if (korisnikBean.getKorisnik().getTip() == 1) {
                    AdminLog adminLog = new AdminLog();
                    adminLog.setIdLog(adminLogHelper.getMaxId() + 1);
                    adminLog.setDatum(new Date());
                    adminLog.setTekst("Popunjena anketa " + anketa.getNaziv());

                    adminLogHelper.insertLog(adminLog);
                }
            }
            
            PretragaAnketa pretragaAnketa = (PretragaAnketa) elContext.getELResolver().getValue(elContext, null, "pretragaAnketa");
            pretragaAnketa.setAnketa(anketa);
            elContext.getELResolver().setValue(elContext, null, "pretragaAnketa", pretragaAnketa);
            
            RezultatiAnkete rezultatiAnkete = (RezultatiAnkete) elContext.getELResolver().getValue(elContext, null, "rezultatiAnkete");
            rezultatiAnkete.setAnketa(anketa);
            elContext.getELResolver().setValue(elContext, null, "rezultatiAnkete", rezultatiAnkete);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste popunili anketu.", null);
            FacesContext.getCurrentInstance().addMessage("anketa:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("anketa_rezultati.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(KreiranjeAnkete.class.getName()).log(Level.SEVERE, null, ex);
            }
            FacesContext.getCurrentInstance().responseComplete();
            
        }

        return;
    }

    public Map<Pitanja, String> getRadiobuttonOdgovori() {
        return radiobuttonOdgovori;
    }

    public void setRadiobuttonOdgovori(Map<Pitanja, String> radiobuttonOdgovori) {
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

}
