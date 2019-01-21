/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.StavkeSifarnika;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

/**
 *
 * @author Nina
 */
public class NovDogadjaj {

    private String naslov;
    private String naslovGreska = "";
    
    private StavkeSifarnika kategorija;
    private String kategorijaGreska = "";
    
    private String tekst;
    private String tekstGreska = "";
    
    private Part thumbnail;
    private String thumbnailGreska = "";

    private Part submittedThumbnail = null;
    
    private String mesto;
    private String mestoGreska = "";
    
    private String ulica;
    private String ulicaGreska = "";
    
    private Date datumPocetka;
    private String datumPocetkaGreska = "";
    
    private Date datumKraja;
    private String datumKrajaGreska = "";
    
    private String vremePocetkaGreska = "";
    private String vremeKrajaGreska = "";
    
    public NovDogadjaj() {
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
    
    public boolean naslovValidacija() {
        if (naslov.isEmpty()) {
            naslovGreska = "Polje 'Naslov događaja' ne sme ostati prazno.";
            return false;
        }
        
        naslovGreska = "";
        return true;
    }
    
    public boolean kategorijaValidacija() {
        if (kategorija == null) {
            kategorijaGreska = "Polje 'Kategorija događaja' ne sme ostati prazno.";
            return false;
        }
        
        kategorijaGreska = "";
        return true;
    }
    
    public boolean tekstValidacija() {
        if (tekst.isEmpty()) {
            tekstGreska = "Polje 'Tekst događaja' ne sme ostati prazno.";
            return false;
        }
        
        tekstGreska = "";
        return true;
    }
    
    public boolean mestoValidacija() {
        if (mesto.isEmpty()) {
            mestoGreska = "Polje 'Mesto' ne sme ostati prazno.";
            return false;
        }
        
        if (!mesto.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
            mestoGreska = "Polje 'Mesto' ne sme sadržati numerike i specijalne karaktere.";
            return false;
        }

        mestoGreska = "";
        return true;
    }

    public boolean ulicaValidacija() {
        if (ulica.isEmpty()) {
            ulicaGreska = "Polje 'Ulica' ne sme ostati prazno.";
            return false;
        }
        
        if (!ulica.matches("[a-zA-ZčćšđžČĆŠĐŽ0-9 ]+")) {
            ulicaGreska = "Polje 'Ulica' sme sadržati samo slova i numeričke karaktere.";
            return false;
        }

        ulicaGreska = "";
        return true;
    }
    
    public boolean datumPocetkaValidacija() {
        if (datumPocetka == null) {
            datumPocetkaGreska = "Polje 'Datum pocetka' ne sme ostati prazno.";
            return false;
        }
        
        datumPocetkaGreska = "";
        return true;
    }
    
    public boolean datumKrajaValidacija() {
        if (datumKraja == null) {
            datumKrajaGreska = "Polje 'Datum kraja' ne sme ostati prazno.";
            return false;
        }
        
        datumKrajaGreska = "";
        return true;
    }
    
    public void kreirajDogadjaj() {
        boolean valid = true;
        
        if (!naslovValidacija()) {
            valid = false;
        }
        if (!kategorijaValidacija()) {
            valid = false;
        }
        if (!tekstValidacija()) {
            valid = false;
        }
        if (!mestoValidacija()) {
            valid = false;
        }
        if (!ulicaValidacija()) {
            valid = false;
        }
        if (!datumPocetkaValidacija()) {
            valid = false;
        }
        if (!datumKrajaValidacija()) {
            valid = false;
        }
        
        if (valid) {
            
        } else {
            thumbnail = submittedThumbnail;
        }
        
    }

    public StavkeSifarnika getKategorija() {
        return kategorija;
    }

    public void setKategorija(StavkeSifarnika kategorija) {
        this.kategorija = kategorija;
    }

    public String getKategorijaGreska() {
        return kategorijaGreska;
    }

    public void setKategorijaGreska(String kategorijaGreska) {
        this.kategorijaGreska = kategorijaGreska;
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

    public Part getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Part thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailGreska() {
        return thumbnailGreska;
    }

    public void setThumbnailGreska(String thumbnailGreska) {
        this.thumbnailGreska = thumbnailGreska;
    }
    
    public void uploadThumbnail() {
        try (InputStream input = thumbnail.getInputStream()) {
            try {
                ImageIO.read(input).toString();

                if (thumbnail.getSize() > 512000) {
                    thumbnailGreska = "Veličina file-a ne sme biti veća od 500KB.";
                    thumbnail = null;
                    submittedThumbnail = null;
                } else {
                    thumbnailGreska = "";
                    this.submittedThumbnail = thumbnail;
                }
            } catch (Exception e) {
                thumbnailGreska = "File koji ste odabrali ne odgovara formatu slike.";
                thumbnail = null;
                submittedThumbnail = null;
            }
        } catch (IOException e) {
            thumbnailGreska = "Došlo je do greške prilikom upload-ovanja file-a. Molimo, pokušajte ponovo.";
            thumbnail = null;
            submittedThumbnail = null;
        }
    }
    
    public void removeThumbnail() {
        thumbnailGreska = "";
        thumbnail = null;
        submittedThumbnail = null;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getMestoGreska() {
        return mestoGreska;
    }

    public void setMestoGreska(String mestoGreska) {
        this.mestoGreska = mestoGreska;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getUlicaGreska() {
        return ulicaGreska;
    }

    public void setUlicaGreska(String ulicaGreska) {
        this.ulicaGreska = ulicaGreska;
    }

    public String getDatumPocetkaGreska() {
        return datumPocetkaGreska;
    }

    public void setDatumPocetkaGreska(String datumPocetkaGreska) {
        this.datumPocetkaGreska = datumPocetkaGreska;
    }

    public String getDatumKrajaGreska() {
        return datumKrajaGreska;
    }

    public void setDatumKrajaGreska(String datumKrajaGreska) {
        this.datumKrajaGreska = datumKrajaGreska;
    }

    public String getVremePocetkaGreska() {
        return vremePocetkaGreska;
    }

    public void setVremePocetkaGreska(String vremePocetkaGreska) {
        this.vremePocetkaGreska = vremePocetkaGreska;
    }

    public String getVremeKrajaGreska() {
        return vremeKrajaGreska;
    }

    public void setVremeKrajaGreska(String vremeKrajaGreska) {
        this.vremeKrajaGreska = vremeKrajaGreska;
    }
    
}
