package db;
// Generated Nov 21, 2018 4:00:32 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Vesti generated by hbm2java
 */
public class Vesti implements java.io.Serializable {

    private int id;
    private String naslov;
    private String tekst;
    private Date datum;
    
    private String thumbnailUrl;

    public Vesti() {
    }

    public Vesti(int id, String naslov, String tekst, Date datum) {
        this.id = id;
        this.naslov = naslov;
        this.tekst = tekst;
        this.datum = datum;
        
        thumbnailUrl = "img:thumbnails/"+id+".jpg";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    public String getThumbnailUrl() {
        thumbnailUrl = "img:thumbnails/"+id+".jpg";
        return thumbnailUrl;
    }
    
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    
    public String getTekstShort() {
        String tekstShort = tekst.substring(0, Math.min(tekst.length(), 150));
        tekstShort += "...";
        return tekstShort;
    }

}
