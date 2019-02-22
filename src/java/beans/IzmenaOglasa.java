/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Oglasi;
import db.helpers.OglasiHelper;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author Nina
 */
public class IzmenaOglasa {

    private Oglasi oglas;
    private String naslov;
    private String tekst;
    private Date datumIsticanja;

    private String naslovGreska = "";
    private String tekstGreska = "";
    private String datumIsticanjaGreska = "";

    private OglasiHelper oglasiHelper = new OglasiHelper();

    public IzmenaOglasa() {
    }

    public Oglasi getOglas() {
        return oglas;
    }

    public void setOglas(Oglasi oglas) {
        this.oglas = oglas;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getDatumIsticanja() {
        return datumIsticanja;
    }

    public void setDatumIsticanja(Date datumIsticanja) {
        this.datumIsticanja = datumIsticanja;
    }

    public String getNaslovGreska() {
        return naslovGreska;
    }

    public void setNaslovGreska(String naslovGreska) {
        this.naslovGreska = naslovGreska;
    }

    public String getTekstGreska() {
        return tekstGreska;
    }

    public void setTekstGreska(String tekstGreska) {
        this.tekstGreska = tekstGreska;
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

        datumIsticanjaGreska = "";
        return true;
    }

    public void izmeniOglas() {
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
            oglas.setNaslov(naslov);
            oglas.setTekst(Jsoup.clean(tekst, "", Whitelist.basic().addTags("h1", "h2", "h3"), new Document.OutputSettings().prettyPrint(false)));

            Calendar datumIsticanjaCal = Calendar.getInstance();
            datumIsticanjaCal.setTime(datumIsticanja);

            datumIsticanjaCal.set(Calendar.HOUR_OF_DAY, 23);
            datumIsticanjaCal.set(Calendar.MINUTE, 59);
            datumIsticanjaCal.set(Calendar.SECOND, 59);
            
            datumIsticanja = datumIsticanjaCal.getTime();
            
            oglas.setDatumIsticanja(datumIsticanja);
            
            oglasiHelper.updateOglas(oglas);
            
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            PretragaOglasa pretragaOglasaBean = (PretragaOglasa) elContext.getELResolver().getValue(elContext, null, "pretragaOglasa");
            pretragaOglasaBean.setOglas(oglas);
            elContext.getELResolver().setValue(elContext, null, "pretragaOglasa", pretragaOglasaBean);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste izmenili oglas.", null);
            FacesContext.getCurrentInstance().addMessage("oglas:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("oglas.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(IzmenaOglasa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
