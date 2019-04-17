/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.SifarniciIzvestaj;
import db.StavkeIzvestaj;
import db.helpers.StavkeIzvestajHelper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nina
 */
public class KreiranjeIzvestaja {

    private String naziv = "";
    private String nazivGreska = "";

    private Date datumPocetka;
    private String datumPocetkaGreska = "";

    private Date datumKraja;
    private String datumKrajaGreska = "";

    private String datumiGreska = "";

    private String kreiranjeIzvestajaSuccessScript = "";

    private List<SifarniciIzvestaj> sifarniciIzvestaj;

    private Map<SifarniciIzvestaj, Boolean> sifarniciIzvestajCheckMap;
    private String sifarniciIzvestajGreska = "";

    private StavkeIzvestajHelper stavkeIzvestajHelper = new StavkeIzvestajHelper();

    private List<String> izvestaji;
    
    private String selectedIzvestajSlanje = "";
    
    private String email = "";
    private String emailGreska = "";
    
    private String mailToLink = "#";
    
    private String mailToScript = "";

    public KreiranjeIzvestaja() {
        sifarniciIzvestaj = stavkeIzvestajHelper.getSviSifarniciIzvestaj();
        sifarniciIzvestajCheckMap = new HashMap<SifarniciIzvestaj, Boolean>();

        for (SifarniciIzvestaj sifarnik : sifarniciIzvestaj) {
            sifarniciIzvestajCheckMap.put(sifarnik, Boolean.FALSE);
        }
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

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public String getDatumPocetkaGreska() {
        return datumPocetkaGreska;
    }

    public void setDatumPocetkaGreska(String datumPocetkaGreska) {
        this.datumPocetkaGreska = datumPocetkaGreska;
    }

    public Date getDatumKraja() {
        return datumKraja;
    }

    public void setDatumKraja(Date datumKraja) {
        this.datumKraja = datumKraja;
    }

    public String getDatumKrajaGreska() {
        return datumKrajaGreska;
    }

    public void setDatumKrajaGreska(String datumKrajaGreska) {
        this.datumKrajaGreska = datumKrajaGreska;
    }

    public List<SifarniciIzvestaj> getSifarniciIzvestaj() {
        return sifarniciIzvestaj;
    }

    public void setSifarniciIzvestaj(List<SifarniciIzvestaj> sifarniciIzvestaj) {
        this.sifarniciIzvestaj = sifarniciIzvestaj;
    }

    public Map<SifarniciIzvestaj, Boolean> getSifarniciIzvestajCheckMap() {
        return sifarniciIzvestajCheckMap;
    }

    public void setSifarniciIzvestajCheckMap(Map<SifarniciIzvestaj, Boolean> sifarniciIzvestajCheckMap) {
        this.sifarniciIzvestajCheckMap = sifarniciIzvestajCheckMap;
    }

    public String getSifarniciIzvestajGreska() {
        return sifarniciIzvestajGreska;
    }

    public void setSifarniciIzvestajGreska(String sifarniciIzvestajGreska) {
        this.sifarniciIzvestajGreska = sifarniciIzvestajGreska;
    }

    public boolean nazivValidacija() {
        if (naziv.isEmpty()) {
            nazivGreska = "Polje 'Naziv izveštaja' ne sme ostati prazno.";
            return false;
        }

        File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("izvestaji"));
        File file = new File(uploads, naziv + ".txt");

        if (file.exists()) {
            nazivGreska = "Izveštaj sa zadatim nazivom već postoji.";
            return false;
        }

        nazivGreska = "";
        return true;
    }

    public boolean sifarniciIzvestajValidacija() {
        for (Map.Entry<SifarniciIzvestaj, Boolean> entry : sifarniciIzvestajCheckMap.entrySet()) {
            if (entry.getValue()) {
                sifarniciIzvestajGreska = "";
                return true;
            }
        }

        sifarniciIzvestajGreska = "Morate štiklirati makar jednu stavku izveštaja.";
        return false;
    }

    public boolean datumPocetkaValidacija() {
        if (getDatumPocetka() == null) {
            datumPocetkaGreska = "Polje 'Početak perioda' ne sme ostati prazno.";
            return false;
        }

        datumPocetkaGreska = "";
        return true;
    }

    public boolean datumKrajaValidacija() {
        if (getDatumKraja() == null) {
            datumKrajaGreska = "Polje 'Kraj perioda' ne sme ostati prazno.";
            return false;
        }

        datumKrajaGreska = "";
        return true;
    }

    public boolean datumiValidacija() {
        if (datumKraja.before(datumPocetka)) {
            datumiGreska = "Datum kraja perioda ne sme biti pre datuma početka perioda.";
            return false;
        }

        datumiGreska = "";
        return true;
    }

    public void kreirajIzvestaj() throws IOException {
        boolean valid = true;

        if (!nazivValidacija()) {
            valid = false;
        }
        if (!sifarniciIzvestajValidacija()) {
            valid = false;
        }
        if (!datumPocetkaValidacija()) {
            valid = false;
        }
        if (!datumKrajaValidacija()) {
            valid = false;
        }

        if (datumPocetka != null && datumKraja != null) {
            Calendar calDatum1 = Calendar.getInstance();
            calDatum1.setTime(datumPocetka);

            calDatum1.set(Calendar.HOUR_OF_DAY, 0);
            calDatum1.set(Calendar.MINUTE, 0);
            calDatum1.set(Calendar.SECOND, 0);

            datumPocetka = calDatum1.getTime();

            Calendar calDatum2 = Calendar.getInstance();
            calDatum2.setTime(datumKraja);

            calDatum2.set(Calendar.HOUR_OF_DAY, 23);
            calDatum2.set(Calendar.MINUTE, 59);
            calDatum2.set(Calendar.SECOND, 59);

            datumKraja = calDatum2.getTime();

            if (!datumiValidacija()) {
                valid = false;
            }
        }

        if (valid) {

            String text = naziv + "\n\n";

            SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

            text += "(Izveštaj za period od " + dt.format(datumPocetka) + " do " + dt.format(datumKraja) + ")\n\n";

            for (Map.Entry<SifarniciIzvestaj, Boolean> entry : sifarniciIzvestajCheckMap.entrySet()) {
                if (entry.getValue()) {
                    List<StavkeIzvestaj> stavkeIzvestaj = stavkeIzvestajHelper.getStavkeIzvestaj(entry.getKey(), datumPocetka, datumKraja);
                    text += "-- " + entry.getKey().getNaziv() + ": " + stavkeIzvestaj.size() + "\n";

                    for (StavkeIzvestaj stavka : stavkeIzvestaj) {
                        text += "       - " + stavka.getNaziv() + "\n";
                    }

                    text += "\n";
                }
            }

            File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("izvestaji"));
            File file = new File(uploads, naziv + ".txt");

            Writer writer = new FileWriter(file);

            try {
                writer.write(text);
            } finally {
                writer.close();
            }

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste kreirali izveštaj", null);
            FacesContext.getCurrentInstance().addMessage("kreiranje_izvestaja:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            kreiranjeIzvestajaSuccessScript = "$('html, body').animate({ scrollTop: 0 }, 'slow');";

        } else {
            kreiranjeIzvestajaSuccessScript = "";
        }

    }

    public String getDatumiGreska() {
        return datumiGreska;
    }

    public void setDatumiGreska(String datumiGreska) {
        this.datumiGreska = datumiGreska;
    }

    public String getKreiranjeIzvestajaSuccessScript() {
        return kreiranjeIzvestajaSuccessScript;
    }

    public void setKreiranjeIzvestajaSuccessScript(String kreiranjeIzvestajaSuccessScript) {
        this.kreiranjeIzvestajaSuccessScript = kreiranjeIzvestajaSuccessScript;
    }

    public List<String> getIzvestaji() {
        File folder = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("izvestaji"));
        File[] listOfFiles = folder.listFiles();

        izvestaji = new ArrayList<String>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                izvestaji.add(listOfFiles[i].getName());
            }
        }

        return izvestaji;
    }

    public void setIzvestaji(List<String> izvestaji) {
        this.izvestaji = izvestaji;
    }

    public void obrisiIzvestaj(String izvestaj) {
        File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("izvestaji"));
        File file = new File(uploads, izvestaj);

        try {
            boolean result = Files.deleteIfExists(file.toPath());

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali izveštaj", null);
            FacesContext.getCurrentInstance().addMessage("kreiranje_izvestaja:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            kreiranjeIzvestajaSuccessScript = "$('html, body').animate({ scrollTop: 0 }, 'slow');";
            
        } catch (IOException ex) {
            Logger.getLogger(KreiranjeIzvestaja.class.getName()).log(Level.SEVERE, null, ex);
            kreiranjeIzvestajaSuccessScript = "";
        }
        
    }

    public String getSelectedIzvestajSlanje() {
        return selectedIzvestajSlanje;
    }

    public void setSelectedIzvestajSlanje(String selectedIzvestajSlanje) {
        this.selectedIzvestajSlanje = selectedIzvestajSlanje;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailGreska() {
        return emailGreska;
    }

    public void setEmailGreska(String emailGreska) {
        this.emailGreska = emailGreska;
    }
    
    public boolean emailValidacija() {
        if (email.isEmpty()) {
            emailGreska = "Polje 'Email adresa' ne sme ostati prazno.";
            return false;
        }

        if (!email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+")) {
            emailGreska = "Email adresa koju ste uneli ne odgovara email formatu.";
            return false;
        }

        emailGreska = "";
        return true;
    }
    
    public void posaljiIzvestaj() {
        boolean valid = true;
        
        if (!emailValidacija()) {
            valid = false;
        }
        
        if (valid) {
            mailToLink = "mailto:" + email + "?subject=Izvestaj&body=http://localhost:8080/izvestaji/" + selectedIzvestajSlanje;
            mailToScript = "window.location.href = '" + mailToLink + "';";
        } else {
            mailToLink = "#";
            mailToScript = "";
        }
        
    }

    public String getMailToLink() {
        return mailToLink;
    }

    public void setMailToLink(String mailToLink) {
        this.mailToLink = mailToLink;
    }

    public String getMailToScript() {
        return mailToScript;
    }

    public void setMailToScript(String mailToScript) {
        this.mailToScript = mailToScript;
    }

}
