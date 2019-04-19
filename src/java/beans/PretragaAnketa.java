/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Ankete;
import db.Korisnici;
import db.Oglasi;
import db.helpers.AnketeHelper;
import db.helpers.KorisniciHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class PretragaAnketa {
    
    private Ankete anketa;
    
    // 1 - sve ankete, 2 - ankete korisnika
    private int tipPretrage = 1;
    
    private String kljucneReci = "";
    
    private Korisnici korisnik;
    
    private Korisnici kreator;
    private List<Korisnici> korisnici = new ArrayList<Korisnici>();
    
    // 1 - datum kreiranja, 2 - ankete koje uskoro isticu
    private int sortiranje = 1;
    
    private List<Ankete> ankete = new ArrayList<Ankete>();
    
    private int currentPage = 0;
    private int pageLength = 5;
    private int numOfShowedItems = 0;
    private long numOfTotalItems = 0;
    
    private KorisniciHelper korHelper = new KorisniciHelper();
    private AnketeHelper anketeHelper = new AnketeHelper();
    
    public PretragaAnketa() {
    }

    public Ankete getAnketa() {
        return anketa;
    }

    public void setAnketa(Ankete anketa) {
        this.anketa = anketa;
    }

    public String getKljucneReci() {
        return kljucneReci;
    }

    public void setKljucneReci(String kljucneReci) {
        this.kljucneReci = kljucneReci;
    }

    public Korisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnici korisnik) {
        this.korisnik = korisnik;
    }

    public List<Korisnici> getKorisnici() {
        korisnici = korHelper.getSviOdobreniKorisniciIAdmin();
        return korisnici;
    }

    public void setKorisnici(List<Korisnici> korisnici) {
        this.korisnici = korisnici;
    }

    public int getTipPretrage() {
        return tipPretrage;
    }

    public void setTipPretrage(int tipPretrage) {
        this.tipPretrage = tipPretrage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumOfShowedItems() {
        return numOfShowedItems;
    }

    public void setNumOfShowedItems(int numOfShowedItems) {
        this.numOfShowedItems = numOfShowedItems;
    }

    public long getNumOfTotalItems() {
        return numOfTotalItems;
    }

    public void setNumOfTotalItems(long numOfTotalItems) {
        this.numOfTotalItems = numOfTotalItems;
    }

    public List<Ankete> getAnkete() {
        if (tipPretrage == 1) {
            if (numOfTotalItems == 0) {
                numOfTotalItems = anketeHelper.pretragaAnketaTotalCount(kljucneReci, kreator, sortiranje);
                ankete = new ArrayList<Ankete>();
                ankete.addAll(anketeHelper.pretragaAnketa(kljucneReci, kreator, sortiranje, currentPage, pageLength, numOfShowedItems));
                numOfShowedItems = ankete.size();
                currentPage++;
            }
        }
        if (tipPretrage == 2) {
            if (numOfTotalItems == 0) {
                numOfTotalItems = anketeHelper.pretragaAnketaTotalCount(korisnik);
                ankete = new ArrayList<Ankete>();
                ankete.addAll(anketeHelper.pretragaAnketa(korisnik, currentPage, pageLength, numOfShowedItems));
                numOfShowedItems = ankete.size();
                currentPage++;
            }
        }
        return ankete;
    }

    public void setAnkete(List<Ankete> ankete) {
        this.ankete = ankete;
    }

    public int getSortiranje() {
        return sortiranje;
    }

    public void setSortiranje(int sortiranje) {
        this.sortiranje = sortiranje;
    }

    public int getPageLength() {
        return pageLength;
    }
    
    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }

    public Korisnici getKreator() {
        return kreator;
    }

    public void setKreator(Korisnici kreator) {
        this.kreator = kreator;
    }
    
    public void proveriPostojanostAnkete() {
        if (anketa == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(OrganizacijaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
