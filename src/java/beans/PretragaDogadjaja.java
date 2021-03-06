/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.Organizacije;
import db.StavkeSifarnika;
import db.helpers.DogadjajiHelper;
import db.helpers.KorisniciHelper;
import db.helpers.StavkeSifarnikaHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class PretragaDogadjaja {

    private StavkeSifarnika mesto;
    private StavkeSifarnika uzrast;
    private StavkeSifarnika karakteristikaProstora;
    private StavkeSifarnika kategorijaDogadjaja;
    private List<StavkeSifarnika> kategorijeDogadjaja;
    private List<StavkeSifarnika> mesta;
    private List<StavkeSifarnika> uzrasti;
    private List<StavkeSifarnika> karakteristikeProstora;
    private String kljucneReci = "";
    private Dogadjaji dogadjaj;
    private List<Dogadjaji> dogadjaji;
    private Organizacije organizacija;
    private int sortiranje = 1;
    private Date datumDogadjaja;
    private List<StavkeSifarnika> selectedKarakteristikeProstora;
    private String kreatorDogadjaja = "";
    private List<Organizacije> organizacije;
    private String dateScript = "";

    private Map<StavkeSifarnika, Boolean> checkMap = new HashMap<StavkeSifarnika, Boolean>();

    //1 - pretraga po kategoriji, 2 - dogadjaji korisnika, 3 - rezultat pretrage
    private int tipPretrage = 3;

    private int currentPage = 0;
    private int pageLength = 5;
    private int numOfShowedItems = 0;
    private long numOfTotalItems = 0;

    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();
    private KorisniciHelper korisniciHelper = new KorisniciHelper();

    class SortDogadjajiByDatumDescending implements Comparator<Dogadjaji> {

        @Override
        public int compare(Dogadjaji a, Dogadjaji b) {
            return b.getDatumKreiranja().compareTo(a.getDatumKreiranja());
        }

    }

    public PretragaDogadjaja() {
        kategorijeDogadjaja = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(2).getStavkeSifarnikas());
        Collections.sort(kategorijeDogadjaja, new PretragaDogadjaja.SortByIdSifarnik());

        for (StavkeSifarnika kategorija : kategorijeDogadjaja) {
            checkMap.put(kategorija, Boolean.FALSE);
        }

        mesta = this.setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(3).getStavkeSifarnikas());

        uzrasti = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(4).getStavkeSifarnikas());
        Collections.sort(uzrasti, new PretragaDogadjaja.SortByIdSifarnik());

        karakteristikeProstora = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(7).getStavkeSifarnikas());
        Collections.sort(karakteristikeProstora, new PretragaDogadjaja.SortByIdSifarnik());

        selectedKarakteristikeProstora = new ArrayList<StavkeSifarnika>();
    }

    class SortOrganizacijeByName implements Comparator<Organizacije> {

        @Override
        public int compare(Organizacije a, Organizacije b) {
            return a.getKorisnickoIme().toLowerCase().compareTo(b.getKorisnickoIme().toLowerCase());
        }

    }

    class SortByIdSifarnik implements Comparator<StavkeSifarnika> {

        @Override
        public int compare(StavkeSifarnika a, StavkeSifarnika b) {
            return a.getIdStavka() - b.getIdStavka();
        }

    }

    private List<StavkeSifarnika> setToList(Set set) {
        List<StavkeSifarnika> stavkeSifarnika = new ArrayList<StavkeSifarnika>(set);
        Collections.sort(stavkeSifarnika, new PretragaDogadjaja.SortByIdSifarnik());
        return stavkeSifarnika;
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

    public List<StavkeSifarnika> getKategorijeDogadjaja() {
        kategorijeDogadjaja = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(2).getStavkeSifarnikas());
        Collections.sort(kategorijeDogadjaja, new PretragaDogadjaja.SortByIdSifarnik());
        
        Map<StavkeSifarnika, Boolean> checkMapOld = checkMap;
        checkMap = new HashMap<StavkeSifarnika, Boolean>();
        for (StavkeSifarnika kategorija : kategorijeDogadjaja) {
            checkMap.put(kategorija, Boolean.FALSE);
        }

        for (Map.Entry<StavkeSifarnika, Boolean> entry : checkMap.entrySet()) {
            for (Map.Entry<StavkeSifarnika, Boolean> entry2 : checkMapOld.entrySet()) {
                if (entry2.getKey().getIdStavka() == entry.getKey().getIdStavka()) {
                    entry.setValue(entry2.getValue());
                    break;
                }
            }
        }
        
        return kategorijeDogadjaja;
    }

    public void setKategorijeDogadjaja(List<StavkeSifarnika> kategorijeDogadjaja) {
        this.kategorijeDogadjaja = kategorijeDogadjaja;
    }

    public List<StavkeSifarnika> getMesta() {
        return mesta;
    }

    public void setMesta(List<StavkeSifarnika> mesta) {
        this.mesta = mesta;
    }

    public List<StavkeSifarnika> getUzrasti() {
        return uzrasti;
    }

    public void setUzrasti(List<StavkeSifarnika> uzrasti) {
        this.uzrasti = uzrasti;
    }

    public String getKljucneReci() {
        return kljucneReci;
    }

    public void setKljucneReci(String kljucneReci) {
        this.kljucneReci = kljucneReci;
    }

    public Dogadjaji getDogadjaj() {
        return dogadjaj;
    }

    public void setDogadjaj(Dogadjaji dogadjaj) {
        this.dogadjaj = dogadjaj;
    }

    public StavkeSifarnika getKategorijaDogadjaja() {
        return kategorijaDogadjaja;
    }

    public void setKategorijaDogadjaja(StavkeSifarnika kategorijaDogadjaja) {
        this.kategorijaDogadjaja = kategorijaDogadjaja;
    }

    public int getTipPretrage() {
        return tipPretrage;
    }

    public void setTipPretrage(int tipPretrage) {
        this.tipPretrage = tipPretrage;
    }

    private List<Dogadjaji> setToListDogadjaji(Set set) {
        dogadjaji = new ArrayList<Dogadjaji>(set);
        Collections.sort(dogadjaji, new PretragaDogadjaja.SortDogadjajiByDatumDescending());
        return dogadjaji;
    }

    public List<Dogadjaji> getDogadjaji() {
        if (tipPretrage == 1) {
            /*dogadjaji = dogadjajiHelper.getDogadjajiByKategorija(kategorijaDogadjaja);
            Collections.sort(dogadjaji, new PretragaDogadjaja.SortDogadjajiByDatumDescending());
            return dogadjaji;
            //return setToListDogadjaji(kategorijaDogadjaja.getDogadjajisKategorija());
            */
            if (numOfTotalItems == 0) {
                numOfTotalItems = dogadjajiHelper.pretragaDogadjajaTotalCount(kategorijaDogadjaja);
                dogadjaji = new ArrayList<Dogadjaji>();
                dogadjaji.addAll(dogadjajiHelper.pretragaDogadjaja(kategorijaDogadjaja, currentPage, pageLength, numOfShowedItems));
                numOfShowedItems = dogadjaji.size();
                currentPage++;
            }
        }
        if (tipPretrage == 2) {
            /*dogadjaji = dogadjajiHelper.getDogadjajiByKorisnik(organizacija.getKorisnici());
            Collections.sort(dogadjaji, new PretragaDogadjaja.SortDogadjajiByDatumDescending());
            return dogadjaji;
            //return setToListDogadjaji(organizacija.getKorisnici().getDogadjajis());
             */
            if (numOfTotalItems == 0) {
                numOfTotalItems = dogadjajiHelper.pretragaDogadjajaTotalCount(organizacija.getKorisnici());
                dogadjaji = new ArrayList<Dogadjaji>();
                dogadjaji.addAll(dogadjajiHelper.pretragaDogadjaja(organizacija.getKorisnici(), currentPage, pageLength, numOfShowedItems));
                numOfShowedItems = dogadjaji.size();
                currentPage++;
            }
        }
        if (tipPretrage == 3) {
            //this.pretraziDogadjaje();
            if (numOfTotalItems == 0) {
                numOfTotalItems = dogadjajiHelper.PretragaDogadjajaTotalCount(datumDogadjaja, checkMap, mesto, uzrast, kljucneReci, selectedKarakteristikeProstora, kreatorDogadjaja, sortiranje);
                dogadjaji = new ArrayList<Dogadjaji>();
                dogadjaji.addAll(dogadjajiHelper.pretragaDogadjaja(datumDogadjaja, checkMap, mesto, uzrast, kljucneReci, selectedKarakteristikeProstora, kreatorDogadjaja, sortiranje, currentPage, pageLength, numOfShowedItems));
                numOfShowedItems = dogadjaji.size();
                currentPage++;
            }
        }
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaji> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

    public Organizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(Organizacije organizacija) {
        this.organizacija = organizacija;
    }

    public int getSortiranje() {
        return sortiranje;
    }

    public void setSortiranje(int sortiranje) {
        this.sortiranje = sortiranje;
    }

    public Date getDatumDogadjaja() {
        if (datumDogadjaja != null) {
            Calendar datumDogadjajaCal = Calendar.getInstance();
            datumDogadjajaCal.setTime(datumDogadjaja);
            int month = datumDogadjajaCal.get(Calendar.MONTH);
            int day = datumDogadjajaCal.get(Calendar.DAY_OF_MONTH);
            int year = datumDogadjajaCal.get(Calendar.YEAR);
            String datumDogadjajaString = "new Date(" + year + "," + month + "," + day + ")";
            dateScript = "$('#pretraga_dogadjaja\\\\:datum_dogadjaja').datepicker('setDate', " + datumDogadjajaString + ");";
        } else {
            dateScript = "$('#pretraga_dogadjaja\\\\:datum_dogadjaja').datepicker('setDate', null);";
            dateScript += "$('.ui-state-active').removeClass('ui-state-active');";
        }
        return datumDogadjaja;
    }

    public void setDatumDogadjaja(Date datumDogadjaja) {
        this.datumDogadjaja = datumDogadjaja;
    }

    /*public void pretraziDogadjaje() {
        dogadjaji = dogadjajiHelper.pretragaDogadjaja(datumDogadjaja, checkMap, mesto, uzrast, kljucneReci, selectedKarakteristikeProstora, kreatorDogadjaja, sortiranje);
        tipPretrage = 3;
    }*/

    public Map<StavkeSifarnika, Boolean> getCheckMap() {
        return checkMap;
    }

    public void setCheckMap(Map<StavkeSifarnika, Boolean> checkMap) {
        this.checkMap = checkMap;
    }

    public List<StavkeSifarnika> getKarakteristikeProstora() {
        return karakteristikeProstora;
    }

    public void setKarakteristikeProstora(List<StavkeSifarnika> karakteristikeProstora) {
        this.karakteristikeProstora = karakteristikeProstora;
    }

    public StavkeSifarnika getKarakteristikaProstora() {
        return karakteristikaProstora;
    }

    public void setKarakteristikaProstora(StavkeSifarnika karakteristikaProstora) {
        this.karakteristikaProstora = karakteristikaProstora;
    }

    public List<StavkeSifarnika> getSelectedKarakteristikeProstora() {
        return selectedKarakteristikeProstora;
    }

    public void setSelectedKarakteristikeProstora(List<StavkeSifarnika> selectedKarakteristikeProstora) {
        this.selectedKarakteristikeProstora = selectedKarakteristikeProstora;
    }

    public void removeKarakteristika(int status) {
        selectedKarakteristikeProstora.remove(status);
        if (selectedKarakteristikeProstora.isEmpty()) {
            karakteristikaProstora = null;
        }
    }

    public boolean karakteristikaValidacija() {
        if (karakteristikaProstora == null) {
            //karakteristikeProstoraGreska = "Polje 'Karakteristika prostora' ne sme ostati prazno.";
            return false;
        }

        //karakteristikeProstoraGreska = "";
        return true;
    }

    public void addKarakteristika() {
        boolean valid = karakteristikaValidacija();

        if (valid) {
            for (int i = 0; i < selectedKarakteristikeProstora.size(); i++) {
                if (selectedKarakteristikeProstora.get(i).getNaziv().equals(karakteristikaProstora.getNaziv())) {
                    //karakteristikeProstoraGreska = "Već ste dodali zadatu vrednost.";
                    valid = false;
                    break;
                }
            }
        } else {
            selectedKarakteristikeProstora = new ArrayList<StavkeSifarnika>();
        }

        if (valid) {
            selectedKarakteristikeProstora.add(karakteristikaProstora);
            //karakteristikaProstora = null;
        }
    }

    public List<Organizacije> getOrganizacije() {
        organizacije = new ArrayList<Organizacije>(korisniciHelper.getSveOdobreneOrganizacije());
        Collections.sort(organizacije, new PretragaDogadjaja.SortOrganizacijeByName());
        return organizacije;
    }

    public void setOrganizacije(List<Organizacije> organizacije) {
        this.organizacije = organizacije;
    }

    public String getKreatorDogadjaja() {
        return kreatorDogadjaja;
    }

    public void setKreatorDogadjaja(String kreatorDogadjaja) {
        this.kreatorDogadjaja = kreatorDogadjaja;
    }

    public String getDateScript() {
        return dateScript;
    }

    public void setDateScript(String dateScript) {
        this.dateScript = dateScript;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
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

    public void currentPageIncrement() {
        if (tipPretrage == 1) {
            dogadjaji.addAll(dogadjajiHelper.pretragaDogadjaja(kategorijaDogadjaja, currentPage, pageLength, numOfShowedItems));
            numOfShowedItems = dogadjaji.size();
        }
        if (tipPretrage == 2) {
            dogadjaji.addAll(dogadjajiHelper.pretragaDogadjaja(organizacija.getKorisnici(), currentPage, pageLength, numOfShowedItems));
            numOfShowedItems = dogadjaji.size();
        }
        if (tipPretrage == 3) {
            dogadjaji.addAll(dogadjajiHelper.pretragaDogadjaja(datumDogadjaja, checkMap, mesto, uzrast, kljucneReci, selectedKarakteristikeProstora, kreatorDogadjaja, sortiranje, currentPage, pageLength, numOfShowedItems));
            numOfShowedItems = dogadjaji.size();
        }
        currentPage++;
    }
    
    public void proveriPostojanostDogadjaja() {
        if (dogadjaj == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(OrganizacijaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void ukloniDogadjajIzListe(Dogadjaji dogadjaj) {
        numOfShowedItems--;
        numOfTotalItems--;
        
        for (Dogadjaji dog : dogadjaji) {
            if (dog.getIdDogadjaj() == dogadjaj.getIdDogadjaj()) {
                dogadjaji.remove(dog);
                return;
            }
        }
        
    }

}
