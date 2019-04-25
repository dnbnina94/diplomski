/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Ankete;
import db.Korisnici;
import db.Oglasi;
import db.Organizacije;
import db.PopunjeneAnkete;
import db.helpers.AnketeHelper;
import db.helpers.KorisniciHelper;
import db.helpers.PopunjeneAnketeHelper;
import helpers.CookieHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

/**
 *
 * @author Nina
 */
public class PretragaAnketa {

    private Ankete anketa;

    // 1 - sve ankete, 2 - ankete korisnika, 3 - popunjene ankete korisnika
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
    private PopunjeneAnketeHelper popAnketeHelper = new PopunjeneAnketeHelper();
    private CookieHelper cookieHelper = new CookieHelper();

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

                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
                boolean sveAnkete = true;
                if (korisnikBean.getKorisnik() == null) {
                    sveAnkete = false;
                }

                numOfTotalItems = anketeHelper.pretragaAnketaTotalCount(kljucneReci, kreator, sortiranje, sveAnkete);
                ankete = new ArrayList<Ankete>();
                ankete.addAll(anketeHelper.pretragaAnketa(kljucneReci, kreator, sortiranje, sveAnkete, currentPage, pageLength, numOfShowedItems));
                numOfShowedItems = ankete.size();
                currentPage++;
            }

        }
        if (tipPretrage == 2) {

            if (numOfTotalItems == 0) {

                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
                boolean sveAnkete = true;
                if (korisnikBean.getKorisnik() == null) {
                    sveAnkete = false;
                }

                numOfTotalItems = anketeHelper.pretragaAnketaTotalCount(korisnik, sveAnkete);
                ankete = new ArrayList<Ankete>();
                ankete.addAll(anketeHelper.pretragaAnketa(korisnik, sveAnkete, currentPage, pageLength, numOfShowedItems));
                numOfShowedItems = ankete.size();
                currentPage++;
            }

        }
        if (tipPretrage == 3) {

            if (numOfTotalItems == 0) {

                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

                numOfTotalItems = popAnketeHelper.getPopunjeneAnketeKorisnikaTotalCount(korisnikBean.getKorisnik());
                ankete = new ArrayList<Ankete>();
                List<PopunjeneAnkete> popunjeneAnkete = popAnketeHelper.getPopunjeneAnketeKorisnika(korisnikBean.getKorisnik(), currentPage, pageLength, numOfShowedItems);
                for (PopunjeneAnkete popAnketa : popunjeneAnkete) {
                    ankete.add(popAnketa.getAnkete());
                }
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

    public void dozvoljenPristupAnketi() {
        if (anketa == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(OrganizacijaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (!mogucePopunjavanje(anketa)) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(OrganizacijaBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void dozvoljenPristupAnketiRezultati() {
        if (anketa == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(OrganizacijaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (!dostupniRezultati(anketa)) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(OrganizacijaBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean popunjenaAnketa(Ankete anketa) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

        boolean popunjeno = false;

        if (korisnikBean.getKorisnik() != null) {

            PopunjeneAnkete popAnketa = popAnketeHelper.getPopunjenaAnketaByKorisnik(korisnikBean.getKorisnik().getKorisnickoIme(), anketa);
            if (popAnketa != null) {
                popunjeno = true;
            }

        } else {

            Cookie cookie = cookieHelper.getCookie("userId");

            if (cookie != null) {

                PopunjeneAnkete popAnketa = popAnketeHelper.getPopunjenaAnketaByGost(cookie.getValue(), anketa);
                if (popAnketa != null) {
                    popunjeno = true;
                }

            }

        }

        return popunjeno;

    }

    public boolean mogucePopunjavanje(Ankete anketa) {

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
        
        if (korisnikBean.getKorisnik() != null) {
            
            if (anketa.getDatumIsticanja().before(new Date()))
                return false;
            
            if (korisnikBean.getKorisnik().getKorisnickoIme().equals(anketa.getKorisnici().getKorisnickoIme()))
                return false;
            
            PopunjeneAnkete popAnketa = popAnketeHelper.getPopunjenaAnketaByKorisnik(korisnikBean.getKorisnik().getKorisnickoIme(), anketa);
            if (popAnketa != null)
                return false;
            
        } else {
            
            if (anketa.getDatumIsticanja().before(new Date()))
                return false;
            
            if (anketa.getNivoVidljivosti() == 2)
                return false;
            
            Cookie cookie = cookieHelper.getCookie("userId");
            
            if (cookie != null) {
                PopunjeneAnkete popAnketa = popAnketeHelper.getPopunjenaAnketaByGost(cookie.getValue(), anketa);
                if (popAnketa != null)
                    return false;
            }
            
        }
        
        return true;

    }

    public boolean dostupniRezultati(Ankete anketa) {

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
        
        if (korisnikBean.getKorisnik() != null) {
            
            if (korisnikBean.getKorisnik().getTip() == 1) {
                return true;
            } else {
                
                if (anketa.getKorisnici().getKorisnickoIme().equals(korisnikBean.getKorisnik().getKorisnickoIme())) {
                    return true;
                }
                
                PopunjeneAnkete popAnketa = popAnketeHelper.getPopunjenaAnketaByKorisnik(korisnikBean.getKorisnik().getKorisnickoIme(), anketa);
                if (popAnketa != null)
                    return true;
                
                if (anketa.getDatumIsticanja().before(new Date()))
                    return true;
                
            }
            
        } else {
            
            if (anketa.getDatumIsticanja().before(new Date())) {
                return true;
            }
            
            Cookie cookie = cookieHelper.getCookie("userId");
            
            if (cookie != null) {
                PopunjeneAnkete popAnketa = popAnketeHelper.getPopunjenaAnketaByGost(cookie.getValue(), anketa);
                if (popAnketa != null) {
                    return true;
                }
            }
            
        }
        
        return false;

    }

    public void currentPageIncrement() {
        if (tipPretrage == 1) {

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            boolean sveAnkete = true;
            if (korisnikBean.getKorisnik() == null) {
                sveAnkete = false;
            }

            ankete.addAll(anketeHelper.pretragaAnketa(kljucneReci, kreator, sortiranje, sveAnkete, currentPage, pageLength, numOfShowedItems));
            numOfShowedItems = ankete.size();

        }
        if (tipPretrage == 2) {

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            boolean sveAnkete = true;
            if (korisnikBean.getKorisnik() == null) {
                sveAnkete = false;
            }

            ankete.addAll(anketeHelper.pretragaAnketa(korisnik, sveAnkete, currentPage, pageLength, numOfShowedItems));
            numOfShowedItems = ankete.size();

        }
        if (tipPretrage == 3) {

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            List<PopunjeneAnkete> popunjeneAnkete = popAnketeHelper.getPopunjeneAnketeKorisnika(korisnikBean.getKorisnik(), currentPage, pageLength, numOfShowedItems);
            for (PopunjeneAnkete popAnketa : popunjeneAnkete) {
                ankete.add(popAnketa.getAnkete());
            }
            numOfShowedItems = ankete.size();

        }

        currentPage++;
    }

    public void ukloniAnketuIzListe(Ankete anketa) {

        numOfShowedItems--;
        numOfTotalItems--;

        for (Ankete ank : ankete) {
            if (ank.getIdAnketa() == anketa.getIdAnketa()) {
                ankete.remove(ank);
                return;
            }
        }

    }

    public String popunjavanjeIliRezultati(Ankete anketa) {
        boolean mogucePopunjavanje = mogucePopunjavanje(anketa);
        boolean dostupniRezultati = dostupniRezultati(anketa);

        if (mogucePopunjavanje) {
            try {
                this.anketa = anketa;
                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                PopunjavanjeAnkete popunjavanjeAnkete = (PopunjavanjeAnkete) elContext.getELResolver().getValue(elContext, null, "popunjavanjeAnkete");
                popunjavanjeAnkete.setAnketa(anketa);
                elContext.getELResolver().setValue(elContext, null, "popunjavanjeAnkete", popunjavanjeAnkete);

                FacesContext.getCurrentInstance().getExternalContext().redirect("anketa.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(PretragaAnketa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (dostupniRezultati) {
            try {
                this.anketa = anketa;
                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                RezultatiAnkete rezultatiAnkete = (RezultatiAnkete) elContext.getELResolver().getValue(elContext, null, "rezultatiAnkete");
                rezultatiAnkete.setAnketa(anketa);
                elContext.getELResolver().setValue(elContext, null, "rezultatiAnkete", rezultatiAnkete);
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("anketa_rezultati.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(PretragaAnketa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "";
    }

}
