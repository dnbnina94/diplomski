/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.jsoup.Jsoup;

/**
 *
 * @author Nina
 */
public class Dogadjaji implements java.io.Serializable {

    private int idDogadjaj;
    private String naslov;
    private String tekst;
    private StavkeSifarnika kategorija;
    private StavkeSifarnika mesto;
    private StavkeSifarnika ulica;
    private StavkeSifarnika uzrast;
    private Date datumDogadjaja;
    private Date datumKreiranja;
    private Korisnici korisnici;
    private Date datumIsticanja;
    private String thumbnail;
    private boolean zahtevBrisanje;
    private Set karakteristikeProstoras = new HashSet(0);
    
    private boolean arhiviran;

    public Dogadjaji() {
    }
    
    private class SortByIdKarakteristika implements Comparator<KarakteristikeProstora> {
        
        @Override
        public int compare(KarakteristikeProstora a, KarakteristikeProstora b) {
            return a.getIdKarakteristika()-b.getIdKarakteristika();
        }
        
    }

    public Dogadjaji(int idDogadjaj, String naslov, String tekst, StavkeSifarnika kategorija, StavkeSifarnika mesto, StavkeSifarnika ulica, StavkeSifarnika uzrast, Date datumDogadjaja, Date datumKreiranja, Korisnici korisnici, Date datumIsticanja, String thumbnail, boolean zahtevBrisanje, Set karakteristikeProstoras) {
        this.idDogadjaj = idDogadjaj;
        this.naslov = naslov;
        this.tekst = tekst;
        this.kategorija = kategorija;
        this.mesto = mesto;
        this.ulica = ulica;
        this.uzrast = uzrast;
        this.datumDogadjaja = datumDogadjaja;
        this.datumKreiranja = datumKreiranja;
        this.korisnici = korisnici;
        this.datumIsticanja = datumIsticanja;
        this.thumbnail = thumbnail;
        this.zahtevBrisanje = zahtevBrisanje;
        this.karakteristikeProstoras = karakteristikeProstoras;
    }
    
    public int getIdDogadjaj() {
        return idDogadjaj;
    }
    
    public void setIdDogadjaj(int idDogadjaj) {
        this.idDogadjaj = idDogadjaj;
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
    
    public StavkeSifarnika getKategorija() {
        return kategorija;
    }
    
    public void setKategorija(StavkeSifarnika kategorija) {
        this.kategorija = kategorija;
    }
    
    public StavkeSifarnika getMesto() {
        return mesto;
    }
    
    public void setMesto(StavkeSifarnika mesto) {
        this.mesto = mesto;
    }
    
    public StavkeSifarnika getUzrast() {
        return uzrast;
    }
    
    public void setUzrast(StavkeSifarnika uzrast) {
        this.uzrast = uzrast;
    }
    
    public Date getDatumDogadjaja() {
        return datumDogadjaja;
    }
    
    public void setDatumDogadjaja(Date datumDogadjaja) {
        this.datumDogadjaja = datumDogadjaja;
    }
    
    public Date getDatumKreiranja() {
        return datumKreiranja;
    }
    
    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }
    
    public Korisnici getKorisnici() {
        return korisnici;
    }
    
    public void setKorisnici(Korisnici korisnici) {
        this.korisnici = korisnici;
    }
    
    public Date getDatumIsticanja() {
        return datumIsticanja;
    }
    
    public void setDatumIsticanja(Date datumIsticanja) {
        this.datumIsticanja = datumIsticanja;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public StavkeSifarnika getUlica() {
        return ulica;
    }

    public void setUlica(StavkeSifarnika ulica) {
        this.ulica = ulica;
    }

    public Set getKarakteristikeProstoras() {
        return karakteristikeProstoras;
    }

    public void setKarakteristikeProstoras(Set karakteristikeProstoras) {
        this.karakteristikeProstoras = karakteristikeProstoras;
    }
    
    public String getTekstShort() {
        String tekstShort = Jsoup.parse(tekst).text();
        return tekstShort.substring(0, Math.min(tekstShort.length(), 100))+"...";
    }
    
    public String getTekstShortRezultatPretrage() {
        String tekstShort = Jsoup.parse(tekst).text();
        return tekstShort.substring(0, Math.min(tekstShort.length(), 256))+"...";
    }
    
    public String getNaslovShort() {
        if (naslov.length() <= 40)
            return naslov;
        else 
            return naslov.substring(0, Math.min(naslov.length(), 40))+"...";
    }
    
    public String getThumbnailUrl() {
        String thumbnailUrl;
        
        if (thumbnail == null) {
            HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            thumbnailUrl = "url('"+ origRequest.getContextPath() + "/faces/javax.faces.resource/thumbnail.png?ln=img')";
        } else {
            thumbnailUrl = "url(/dogadjaji/" + thumbnail + ")";
        }
        
        return thumbnailUrl;
    }

    public boolean isArhiviran() {
        Date danas = new Date();
        if (danas.after(datumIsticanja)) {
            return true;
        }
        return false;
    }

    public void setArhiviran(boolean arhiviran) {
        this.arhiviran = arhiviran;
    }

    public boolean isZahtevBrisanje() {
        return zahtevBrisanje;
    }

    public void setZahtevBrisanje(boolean zahtevBrisanje) {
        this.zahtevBrisanje = zahtevBrisanje;
    }
    
    public List<KarakteristikeProstora> karakteristikeToList() {
        List<KarakteristikeProstora> karakteristikeProstoraList = new ArrayList<KarakteristikeProstora>(karakteristikeProstoras);
        Collections.sort(karakteristikeProstoraList, new Dogadjaji.SortByIdKarakteristika());
        return karakteristikeProstoraList;
    }
    
}
