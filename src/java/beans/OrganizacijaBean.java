/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Ankete;
import db.Dogadjaji;
import db.Korisnici;
import db.Oglasi;
import db.Organizacije;
import db.Vesti;
import db.helpers.AnketeHelper;
import db.helpers.DogadjajiHelper;
import db.helpers.KorisniciHelper;
import db.helpers.OglasiHelper;
import db.helpers.VestiHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class OrganizacijaBean {

    private Organizacije organizacija;

    private VestiHelper vestiHelper = new VestiHelper();
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();
    private OglasiHelper oglasiHelper = new OglasiHelper();
    private AnketeHelper anketeHelper = new AnketeHelper();

    private List<Dogadjaji> dogadjaji;
    private List<Vesti> vesti;
    private List<Oglasi> oglasi;
    private List<Ankete> ankete;

    public OrganizacijaBean() {
    }

    class SortOrganizacijeByName implements Comparator<Organizacije> {

        @Override
        public int compare(Organizacije a, Organizacije b) {
            return a.getKorisnickoIme().toLowerCase().compareTo(b.getKorisnickoIme().toLowerCase());
        }

    }

    /*class SortByIdTelefon implements Comparator<Telefoni> {
        
        @Override
        public int compare (Telefoni a, Telefoni b) {
            return a.getIdTelefon()- b.getIdTelefon();
        }
        
    }*/
    class SortVestiByDatumDescending implements Comparator<Vesti> {

        @Override
        public int compare(Vesti a, Vesti b) {
            return b.getDatum().compareTo(a.getDatum());
        }

    }

    class SortDogadjajiByDatumDescending implements Comparator<Dogadjaji> {

        @Override
        public int compare(Dogadjaji a, Dogadjaji b) {
            return b.getDatumKreiranja().compareTo(a.getDatumKreiranja());
        }
    }

    class SortOglasiByDatumDescending implements Comparator<Oglasi> {

        @Override
        public int compare(Oglasi a, Oglasi b) {
            return b.getDatumKreiranja().compareTo(a.getDatumKreiranja());
        }
    }

    /*public List<Telefoni> setTelefoniToList() {
        List<Telefoni> telefoni = new ArrayList<Telefoni>(organizacija.getTelefonis());
        Collections.sort(telefoni, new OrganizacijaBean.SortByIdTelefon());
        return telefoni;
    }*/
 /*public String telefoniToString() {
        String telefoniString = "";
        List<Telefoni> telefoni = this.setTelefoniToList();
        for (int i=0; i < telefoni.size(); i++) {
            telefoniString += telefoni.get(i).getTelefon();
            if (i < telefoni.size() - 1)
                telefoniString += ", ";
        }
        
        return telefoniString;
    }*/
    public Organizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(Organizacije organizacija) {
        this.organizacija = organizacija;
    }

    public List<Vesti> setVestiToList() {
        if (organizacija != null) {
            //List<Vesti> vesti = new ArrayList<Vesti>(organizacija.getKorisnici().getVestis());
            vesti = vestiHelper.getVestiByKorisnik(organizacija.getKorisnici());
            Collections.sort(vesti, new OrganizacijaBean.SortVestiByDatumDescending());
            return vesti;
        }
        return new ArrayList<Vesti>();
    }

    public List<Dogadjaji> setDogadjajiToList() {
        if (organizacija != null) {
            //List<Dogadjaji> dogadjaji = new ArrayList<Dogadjaji>(organizacija.getKorisnici().getDogadjajis());
            dogadjaji = dogadjajiHelper.getDogadjajiByKorisnik(organizacija.getKorisnici());
            Collections.sort(dogadjaji, new OrganizacijaBean.SortDogadjajiByDatumDescending());
            return dogadjaji;
        }
        return new ArrayList<Dogadjaji>();
    }

    public List<Oglasi> setOglasiToList() {
        if (organizacija != null) {
            //List<Oglasi> oglasi = new ArrayList<Oglasi>(organizacija.getKorisnici().getOglasis());
            oglasi = oglasiHelper.getOglasiByKorisnik(organizacija.getKorisnici());
            Collections.sort(oglasi, new OrganizacijaBean.SortOglasiByDatumDescending());
            return oglasi;
        }
        return new ArrayList<Oglasi>();
    }

    public List<Vesti> setVestiToListFeatured() {
        //vesti = this.setVestiToList();
        if (vesti.size() > 7) {
            return vesti.subList(0, 8);
        }
        return vesti;
    }

    public List<Dogadjaji> setDogadjajiToListFeatured() {
        //dogadjaji = this.setDogadjajiToList();
        if (dogadjaji.size() > 7) {
            return dogadjaji.subList(0, 8);
        }
        return dogadjaji;
    }

    public List<Oglasi> setOglasiToListFeatured() {
        //oglasi = this.setOglasiToList();
        if (oglasi.size() > 7) {
            return oglasi.subList(0, 8);
        }
        return oglasi;
    }

    public List<Dogadjaji> getDogadjaji() {
        /*//dogadjaji = dogadjajiHelper.getDogadjajiByKorisnik(organizacija.getKorisnici());
        dogadjaji = new ArrayList<Dogadjaji>(organizacija.getKorisnici().getDogadjajis());
        Collections.sort(dogadjaji, new OrganizacijaBean.SortDogadjajiByDatumDescending());
        return dogadjaji;
         */
        dogadjaji = dogadjajiHelper.getFeaturedDogadjajiByKorisnik(organizacija.getKorisnici());
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaji> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

    public List<Vesti> getVesti() {
        //vesti = vestiHelper.getVestiByKorisnik(organizacija.getKorisnici());
        /*vesti = new ArrayList<Vesti>(organizacija.getKorisnici().getVestis());
        Collections.sort(vesti, new OrganizacijaBean.SortVestiByDatumDescending());
        return vesti;
         */
        vesti = vestiHelper.getFeaturedVestiByKorisnik(organizacija.getKorisnici());
        return vesti;
    }

    public void setVesti(List<Vesti> vesti) {
        this.vesti = vesti;
    }

    public List<Oglasi> getOglasi() {
        /*//oglasi = oglasiHelper.getOglasiByKorisnik(organizacija.getKorisnici());
        oglasi = new ArrayList<Oglasi>(organizacija.getKorisnici().getOglasis());
        Collections.sort(oglasi, new OrganizacijaBean.SortOglasiByDatumDescending());
        return oglasi;
         */
        oglasi = oglasiHelper.getFeaturedOglasiByKorisnik(organizacija.getKorisnici());
        return oglasi;
    }

    public void setOglasi(List<Oglasi> oglasi) {
        this.oglasi = oglasi;
    }

    public void proveriPostojanostOrg() {
        if (organizacija == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(OrganizacijaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Ankete> getAnkete() {
        boolean sveAnkete = true;
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
        if (korisnikBean.getKorisnik() == null) {
            sveAnkete = false;
        }
        
        ankete = anketeHelper.getFeaturedAnketeByKorisnik(organizacija.getKorisnici(), sveAnkete);
        return ankete;
    }

    public void setAnkete(List<Ankete> ankete) {
        this.ankete = ankete;
    }

}
