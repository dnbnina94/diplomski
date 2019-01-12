/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import db.Organizacije;
import db.Telefoni;
import db.helpers.KorisniciHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Nina
 */
public class IzmenaPodataka {
    
    private KorisniciHelper korHelper = new KorisniciHelper();
    
    private String nazivOrg;
    private String nazivOrgGreska = "";
    
    private String opisOrg;
    private String opisOrgGreska = "";
    
    private String oblastDelovanja;
    private String oblastDelovanjaGreska = "";
    
    private String webAdresa;
    private String webAdresaGreska = "";
    
    private String mesto;
    private String mestoGreska = "";
    
    private String ulica;
    private String ulicaGreska = "";
    
    private String kontaktOsoba;
    private String kontaktOsobaGreska = "";
    
    private String email;
    private String emailGreska = "";
    
    public IzmenaPodataka() {
        
    }
    
    public String getNazivOrg() {
        return nazivOrg;
    }
    
    public void setNazivOrg(String nazivOrg) {
        this.nazivOrg = nazivOrg;
    }
    
    public String getNazivOrgGreska() {
        return nazivOrgGreska;
    }
    
    public void setNazivOrgGreska(String nazivOrgGreska) {
        this.nazivOrgGreska = nazivOrgGreska;
    }
    
    public String getOpisOrg() {
        return opisOrg;
    }
    
    public void setOpisOrg(String opisOrg) {
        this.opisOrg = opisOrg;
    }
    
    public String getOpisOrgGreska() {
        return opisOrgGreska;
    }
    
    public void setOpisOrgGreska(String opisOrgGreska) {
        this.opisOrgGreska = opisOrgGreska;
    }
    
    public String getOblastDelovanja() {
        return oblastDelovanja;
    }
    
    public void setOblastDelovanja(String oblastDelovanja) {
        this.oblastDelovanja = oblastDelovanja;
    }
    
    public String getOblastDelovanjaGreska() {
        return oblastDelovanjaGreska;
    }
    
    public void setOblastDelovanjaGreska(String oblastDelovanjaGreska) {
        this.oblastDelovanjaGreska = oblastDelovanjaGreska;
    }
    
    public String getWebAdresa() {
        return webAdresa;
    }
    
    public void setWebAdresa(String webAdresa) {
        this.webAdresa = webAdresa;
    }
    
    public String getWebAdresaGreska() {
        return webAdresaGreska;
    }
    
    public void setWebAdresaGreska(String webAdresaGreska) {
        this.webAdresaGreska = webAdresaGreska;
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
    
    public String getKontaktOsoba() {
        return kontaktOsoba;
    }
    
    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }
    
    public String getKontaktOsobaGreska() {
        return kontaktOsobaGreska;
    }
    
    public void setKontaktOsobaGreska(String kontaktOsobaGreska) {
        this.kontaktOsobaGreska = kontaktOsobaGreska;
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
    
    public void izmeniNazivOrg() {
        
    }
    
    public void izmeniOpisOrg() {
        
    }
    
}
