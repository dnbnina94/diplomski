package db;
// Generated Nov 24, 2018 6:36:55 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * Vesti generated by hbm2java
 */
public class Vesti implements java.io.Serializable {

    private int idVest;
    private Korisnici korisnici;
    private String naslov;
    private String tekst;
    private StavkeSifarnika kategorija;
    private Date datum;
    private String thumbnail;
    private int arhivirana;
    private boolean zahtevBrisanje;
    
    private String outerDivClass="col-md-6 col-xs-12 featured-col-container";
    private String innerDivClassRelative="featured-col featured-col-bigger";
    private String innerDivClassAbsolute="featured-content featured-bigger";

    public Vesti() {
    }

    public Vesti(int idVest, Korisnici korisnici, String naslov, String tekst, StavkeSifarnika kategorija, Date datum, String thumbnail, int arhivirana, boolean zahtevBrisanje) {
        this.idVest = idVest;
        this.korisnici = korisnici;
        this.naslov = naslov;
        this.tekst = tekst;
        this.kategorija = kategorija;
        this.datum = datum;
        
        this.thumbnail = thumbnail;
        this.arhivirana = arhivirana;
        this.zahtevBrisanje = zahtevBrisanje;
    }

    public int getIdVest() {
        return this.idVest;
    }

    public void setIdVest(int idVest) {
        this.idVest = idVest;
    }

    public Korisnici getKorisnici() {
        return this.korisnici;
    }

    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
    }

    public String getNaslov() {
        return this.naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return this.tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public StavkeSifarnika getKategorija() {
        return this.kategorija;
    }

    public void setKategorija(StavkeSifarnika kategorija) {
        this.kategorija = kategorija;
    }

    public Date getDatum() {
        return this.datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getTekstShort() {
        String tekstShort = Jsoup.parse(tekst).text();
        return tekstShort.substring(0, Math.min(tekstShort.length(), 100))+"...";
    }
    
    public String getTekstShortRezultatPretrage() {
        String tekstShort = Jsoup.parse(tekst).text();
        return tekstShort.substring(0, Math.min(tekstShort.length(), 256))+"...";
    }
    
    public String getTekstPure() {
        String tekstPure = Jsoup.parse(tekst).text();
        return tekstPure;
    }
    
    public String getNaslovShort() {
        if (naslov.length() <= 40)
            return naslov;
        else 
            return naslov.substring(0, Math.min(naslov.length(), 40))+"...";
    }
    
    public String getThumbnail() {
        return thumbnail;
    }
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    public String getThumbnailUrl() {
        String thumbnailUrl;
        
        if (thumbnail == null) {
            HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            thumbnailUrl = "url('" + origRequest.getContextPath() + "/faces/javax.faces.resource/thumbnail.png?ln=img')";
        } else {
            thumbnailUrl = "url(/vesti/" + thumbnail + ")";
        }
        
        return thumbnailUrl;
    }
    
    public String getThumbnailUrlBootsfaces() {
        return "resources/img/thumbnails/" + thumbnail;
    }
    
    public int getArhivirana() {
        return arhivirana;
    }
    
    public void setArhivirana(int arhivirana) {
        this.arhivirana = arhivirana;
    }

    public String getOuterDivClass() {
        return outerDivClass;
    }

    public void setOuterDivClass(String outerDivClass) {
        this.outerDivClass = outerDivClass;
    }

    public String getInnerDivClassRelative() {
        return innerDivClassRelative;
    }

    public void setInnerDivClassRelative(String innerDivClassRelative) {
        this.innerDivClassRelative = innerDivClassRelative;
    }

    public String getInnerDivClassAbsolute() {
        return innerDivClassAbsolute;
    }

    public void setInnerDivClassAbsolute(String innerDivClassAbsolute) {
        this.innerDivClassAbsolute = innerDivClassAbsolute;
    }

    public boolean isZahtevBrisanje() {
        return zahtevBrisanje;
    }

    public void setZahtevBrisanje(boolean zahtevBrisanje) {
        this.zahtevBrisanje = zahtevBrisanje;
    }

}
