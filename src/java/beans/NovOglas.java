/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Oglasi;
import db.helpers.OglasiHelper;
import java.util.Calendar;
import java.util.Date;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author Nina
 */
public class NovOglas {

    private String naslov;
    private String naslovGreska = "";

    private String tekst;
    private String tekstGreska = "";

    private Date datumIsticanja;
    private String datumIsticanjaGreska = "";

    private OglasiHelper oglasiHelper = new OglasiHelper();

    public NovOglas() {
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovGreska() {
        return naslovGreska;
    }

    public void setNaslovGreska(String naslovGreska) {
        this.naslovGreska = naslovGreska;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getTekstGreska() {
        return tekstGreska;
    }

    public void setTekstGreska(String tekstGreska) {
        this.tekstGreska = tekstGreska;
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

    public boolean naslovValidacija() {
        if (naslov.isEmpty()) {
            naslovGreska = "Polje 'Naslov oglasa' ne sme ostati prazno.";
            return false;
        }

        naslovGreska = "";
        return true;
    }

    public boolean tekstValidacija() {
        if (tekst.isEmpty()) {
            tekstGreska = "Polje 'Tekst oglasa' ne sme ostati prazno.";
            return false;
        }

        tekstGreska = "";
        return true;
    }

    public boolean datumIsticanjaValidacija() {
        if (datumIsticanja == null) {
            datumIsticanjaGreska = "Polje 'Datum isticanja' ne sme ostati prazno.";
            return false;
        }

        Calendar datumIsticanjaCal = Calendar.getInstance();
        datumIsticanjaCal.setTime(datumIsticanja);

        datumIsticanjaCal.set(Calendar.HOUR_OF_DAY, 23);
        datumIsticanjaCal.set(Calendar.MINUTE, 59);
        datumIsticanjaCal.set(Calendar.SECOND, 59);

        datumIsticanja = datumIsticanjaCal.getTime();

        if (datumIsticanja.before(new Date())) {
            datumIsticanjaGreska = "Datum isticanja oglasa ne sme biti pre današnjeg datuma.";
            return false;
        }

        datumIsticanjaGreska = "";
        return true;
    }

    public void kreirajOglas() {
        boolean valid = true;

        if (!naslovValidacija()) {
            valid = false;
        }
        if (!tekstValidacija()) {
            valid = false;
        }
        if (!datumIsticanjaValidacija()) {
            valid = false;
        }

        if (valid) {
            Oglasi oglas = new Oglasi();

            oglas.setIdOglas(oglasiHelper.getMaxId() + 1);
            oglas.setNaslov(naslov);
            oglas.setTekst(Jsoup.clean(tekst, Whitelist.basic().addTags("h1", "h2", "h3")));
            oglas.setDatumKreiranja(new Date());
            oglas.setDatumIsticanja(datumIsticanja);

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            oglas.setKorisnici(korisnikBean.getKorisnik());

            oglasiHelper.insertOglas(oglas);
        }
    }

    public void reset() {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        NovOglas novOglasBean = new NovOglas();
        elContext.getELResolver().setValue(elContext, null, "novOglas", novOglasBean);
    }

}
