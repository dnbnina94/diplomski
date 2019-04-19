/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.AdminLog;
import db.Ankete;
import db.Pitanja;
import db.PonudjeniOdgovori;
import db.StavkeIzvestaj;
import db.helpers.AdminLogHelper;
import db.helpers.AnketeHelper;
import db.helpers.StavkeIzvestajHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class KreiranjeAnkete {

    private String naziv = "";
    private String nazivGreska = "";

    private int nivoVidljivosti;
    private String nivoVidljivostiGreska = "";

    private Date datumIsticanja;
    private String datumIsticanjaGreska = "";

    private String pitanje = "";
    private String pitanjeGreska = "";

    private int tipPitanja;
    private String tipPitanjaGreska = "";

    private List<Pitanja> pitanja = new ArrayList<Pitanja>();
    private String pitanjaGreska = "";

    private String anketaCreationSuccess = "";

    private List<String> ponudjeniOdgovori = new ArrayList<String>();
    private String ponudjenOdgovor = "";
    private String ponudjenOdgovorGreska = "";

    private AnketeHelper anketeHelper = new AnketeHelper();
    private StavkeIzvestajHelper stavkeIzvestajHelper = new StavkeIzvestajHelper();
    private AdminLogHelper adminLogHelper = new AdminLogHelper();

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
        
        anketaCreationSuccess = "";

    }

    public void removePonudjeniOdgovor(int status) {
        ponudjeniOdgovori.remove(status);
        
        anketaCreationSuccess = "";
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

            pitanjaGreska = "";
            pitanje = "";
            tipPitanja = 0;
            ponudjeniOdgovori = new ArrayList<String>();
        }
        
        anketaCreationSuccess = "";

    }

    public void izbrisiPitanje(int index) {
        pitanja.remove(index);
        
        anketaCreationSuccess = "";
    }

    public boolean nazivValidacija() {
        if (naziv.isEmpty()) {
            nazivGreska = "Polje 'Naziv ankete' ne sme ostati prazno.";
            return false;
        }

        nazivGreska = "";
        return true;
    }

    public boolean nivoVidljivostiValidacija() {
        if (nivoVidljivosti != 1 && nivoVidljivosti != 2) {
            nivoVidljivostiGreska = "Polje 'Nivo vidljivosti' ne sme ostati prazno.";
            return false;
        }

        nivoVidljivostiGreska = "";
        return true;
    }

    public boolean datumIsticanjaValidacija() {
        if (datumIsticanja == null) {
            datumIsticanjaGreska = "Polje 'Datum zatvaranja ankete' ne sme ostati prazno.";
            return false;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(datumIsticanja);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        datumIsticanja = cal.getTime();

        if (datumIsticanja.before(new Date())) {
            datumIsticanjaGreska = "Datum zatvaranja ankete ne sme biti pre današnjeg datuma.";
            return false;
        }

        datumIsticanjaGreska = "";
        return true;
    }

    public boolean pitanjaValidacija() {
        if (pitanja.isEmpty()) {
            setPitanjaGreska("Anketa mora sadržati makar jedno pitanje.");
            return false;
        }

        setPitanjaGreska("");
        return true;
    }

    public void kreirajAnketu() {
        boolean valid = true;

        if (!nazivValidacija()) {
            valid = false;
        }
        if (!nivoVidljivostiValidacija()) {
            valid = false;
        }
        if (!datumIsticanjaValidacija()) {
            valid = false;
        }
        if (!pitanjaValidacija()) {
            valid = false;
        }

        if (valid) {
            Ankete anketa = new Ankete();
            anketa.setIdAnketa(anketeHelper.getMaxId() + 1);
            anketa.setNaziv(naziv);
            anketa.setNivoVidljivosti(nivoVidljivosti);
            anketa.setDatumIsticanja(datumIsticanja);
            anketa.setDatumKreiranja(new Date());

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            anketa.setKorisnici(korisnikBean.getKorisnik());

            anketeHelper.insertAnketa(anketa);

            for (Pitanja pit : pitanja) {
                pit.setAnkete(anketa);
                pit.setIdPitanje(anketeHelper.getMaxIdPitanja() + 1);

                anketeHelper.insertPitanje(pit);

                for (PonudjeniOdgovori odg : pit.getPonudjeniOdgovori()) {
                    odg.setIdOdgovor(anketeHelper.getMaxIdPonudjeniOdgovori() + 1);
                    odg.setPitanja(pit);

                    anketeHelper.insertPonudjeniOdgovor(odg);
                }
            }

            StavkeIzvestaj stavkeIzvestaj = new StavkeIzvestaj();
            stavkeIzvestaj.setIdStavka(stavkeIzvestajHelper.getMaxId() + 1);
            stavkeIzvestaj.setNaziv(anketa.getNaziv());
            stavkeIzvestaj.setDatum(new Date());
            stavkeIzvestaj.setSifarniciIzvestaj(stavkeIzvestajHelper.getSifarnikIzvestajById(13));

            stavkeIzvestajHelper.insertStavkaIzvestaj(stavkeIzvestaj);

            if (korisnikBean.getKorisnik().getTip() == 1) {
                AdminLog adminLog = new AdminLog();
                adminLog.setIdLog(adminLogHelper.getMaxId() + 1);
                adminLog.setDatum(new Date());
                adminLog.setTekst("Kreirana anketa: " + anketa.getNaziv());

                adminLogHelper.insertLog(adminLog);
            }
            
            anketaCreationSuccess = "$('html, body').animate({ scrollTop: 0 }, 'slow');";

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste kreirali anketu.", null);
            FacesContext.getCurrentInstance().addMessage("nova_anketa:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            naziv = "";
            nazivGreska = "";
            datumIsticanja = null;
            datumIsticanjaGreska = "";
            nivoVidljivosti = 0;
            nivoVidljivostiGreska = "";
            pitanje = "";
            pitanjeGreska = "";
            tipPitanja = 0;
            tipPitanjaGreska = "";
            pitanja = new ArrayList<Pitanja>();
            pitanjaGreska = "";
            ponudjenOdgovor = "";
            ponudjenOdgovorGreska = "";
            ponudjeniOdgovori = new ArrayList<String>();

        } else {
            anketaCreationSuccess = "";
        }

    }

    public String getPitanjaGreska() {
        return pitanjaGreska;
    }

    public void setPitanjaGreska(String pitanjaGreska) {
        this.pitanjaGreska = pitanjaGreska;
    }

    public Date getDatumIsticanja() {
        return datumIsticanja;
    }

    public void setDatumIsticanja(Date datumIsticanja) {
        this.datumIsticanja = datumIsticanja;
    }

    public String getDatumIsticanjaGreska() {
        return datumIsticanjaGreska;
    }

    public void setDatumIsticanjaGreska(String datumIsticanjaGreska) {
        this.datumIsticanjaGreska = datumIsticanjaGreska;
    }

    public String getAnketaCreationSuccess() {
        return anketaCreationSuccess;
    }

    public void setAnketaCreationSuccess(String anketaCreationSuccess) {
        this.anketaCreationSuccess = anketaCreationSuccess;
    }

}
