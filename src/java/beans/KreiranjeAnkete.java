/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Pitanja;
import db.PonudjeniOdgovori;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina
 */
public class KreiranjeAnkete {
    
    private String naziv = "";
    private String nazivGreska = "";
    
    private int nivoVidljivosti;
    private String nivoVidljivostiGreska = "";
    
    private String pitanje = "";
    private String pitanjeGreska = "";
    
    private int tipPitanja;
    private String tipPitanjaGreska = "";
    
    private List<Pitanja> pitanja = new ArrayList<Pitanja>();
    
    private List<String> ponudjeniOdgovori = new ArrayList<String>();
    private String ponudjenOdgovor = "";
    private String ponudjenOdgovorGreska = "";
    
    public KreiranjeAnkete() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNazivGreska() {
        return nazivGreska;
    }

    public void setNazivGreska(String nazivGreska) {
        this.nazivGreska = nazivGreska;
    }

    public int getNivoVidljivosti() {
        return nivoVidljivosti;
    }

    public void setNivoVidljivosti(int nivoVidljivosti) {
        this.nivoVidljivosti = nivoVidljivosti;
    }

    public String getNivoVidljivostiGreska() {
        return nivoVidljivostiGreska;
    }

    public void setNivoVidljivostiGreska(String nivoVidljivostiGreska) {
        this.nivoVidljivostiGreska = nivoVidljivostiGreska;
    }

    public List<Pitanja> getPitanja() {
        return pitanja;
    }

    public void setPitanja(List<Pitanja> pitanja) {
        this.pitanja = pitanja;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getPitanjeGreska() {
        return pitanjeGreska;
    }

    public void setPitanjeGreska(String pitanjeGreska) {
        this.pitanjeGreska = pitanjeGreska;
    }

    public int getTipPitanja() {
        return tipPitanja;
    }

    public void setTipPitanja(int tipPitanja) {
        this.tipPitanja = tipPitanja;
    }

    public String getTipPitanjaGreska() {
        return tipPitanjaGreska;
    }

    public void setTipPitanjaGreska(String tipPitanjaGreska) {
        this.tipPitanjaGreska = tipPitanjaGreska;
    }

    public List<String> getPonudjeniOdgovori() {
        return ponudjeniOdgovori;
    }

    public void setPonudjeniOdgovori(List<String> ponudjeniOdgovori) {
        this.ponudjeniOdgovori = ponudjeniOdgovori;
    }

    public String getPonudjenOdgovor() {
        return ponudjenOdgovor;
    }

    public void setPonudjenOdgovor(String ponudjenOdgovor) {
        this.ponudjenOdgovor = ponudjenOdgovor;
    }

    public String getPonudjenOdgovorGreska() {
        return ponudjenOdgovorGreska;
    }

    public void setPonudjenOdgovorGreska(String ponudjenOdgovorGreska) {
        this.ponudjenOdgovorGreska = ponudjenOdgovorGreska;
    }
    
    public boolean ponudjeniOdgovorValidacija(String ponOdg) {
        if (ponOdg.isEmpty()) {
            ponudjenOdgovorGreska = "Polje 'Ponuđeni odgovor' ne sme ostati prazno.";
            return false;
        }

        ponudjenOdgovorGreska = "";
        return true;
    }
    
    public void addPonudjeniOdgovor() {
        boolean valid = ponudjeniOdgovorValidacija(ponudjenOdgovor);

        for (int i = 0; i < ponudjeniOdgovori.size(); i++) {
            if (ponudjeniOdgovori.get(i).equals(ponudjenOdgovor)) {
                ponudjenOdgovorGreska = "Već ste uneli zadati ponuđeni odgovor.";
                valid = false;
                break;
            }
        }

        if (ponudjeniOdgovori.size() == 10) {
            ponudjenOdgovorGreska = "Možete uneti maksimalno 10 ponuđenih odgovora.";
            valid = false;
        }

        if (valid) {
            ponudjeniOdgovori.add(ponudjenOdgovor);
            ponudjenOdgovor = "";
        }

    }

    public void removePonudjeniOdgovor(int status) {
        ponudjeniOdgovori.remove(status);
    }
    
    boolean tipPitanjaValidacija() {
        if (tipPitanja != 1 && tipPitanja != 2) {
            tipPitanjaGreska = "Polje 'Tip pitanja' ne sme ostati prazno.";
            return false;
        }
        
        tipPitanjaGreska = "";
        return true;
    }
    
    boolean pitanjeValidacija() {
        if (pitanje.isEmpty()) {
            pitanjeGreska = "Polje 'Pitanje' ne sme ostati prazno.";
            return false;
        }
        
        pitanjeGreska = "";
        return true;
    }
    
    boolean ponudjeniOdgovoriValidacija() {
        if (ponudjeniOdgovori.size() < 2) {
            ponudjenOdgovorGreska = "Morate uneti makar 2 ponuđena odgovora.";
            return false;
        }
        
        ponudjenOdgovorGreska = "";
        return true;
    }
    
    public void kreirajPitanje() {
        boolean valid = true;
        
        if (!tipPitanjaValidacija()) {
            valid = false;
        }
        if (!pitanjeValidacija()) {
            valid = false;
        }
        if (!ponudjeniOdgovoriValidacija()) {
            valid = false;
        }
        
        if (valid) {
            // UBACI PITANJE MEDJU PITANJIMA
            Pitanja novoPitanje = new Pitanja();
            novoPitanje.setPitanje(pitanje);
            novoPitanje.setTip(tipPitanja);
            
            List<PonudjeniOdgovori> ponOdgovori = new ArrayList<PonudjeniOdgovori>();
            
            for (String odg : ponudjeniOdgovori) {
                PonudjeniOdgovori ponOdgovor = new PonudjeniOdgovori();
                ponOdgovor.setOdgovor(odg);
                ponOdgovori.add(ponOdgovor);
            }
            
            novoPitanje.setPonudjeniOdgovori(ponOdgovori);
            
            pitanja.add(novoPitanje);
            
            pitanje = "";
            tipPitanja = 0;
            ponudjeniOdgovori = new ArrayList<String>();
        }
        
    }
    
}
