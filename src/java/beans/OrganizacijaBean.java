/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import db.Organizacije;
import db.Telefoni;
import db.Vesti;
import db.helpers.KorisniciHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Nina
 */
public class OrganizacijaBean {
    
    private Organizacije organizacija;
    
    public OrganizacijaBean() {
    }
    
    class SortByIdTelefon implements Comparator<Telefoni> {
        
        @Override
        public int compare (Telefoni a, Telefoni b) {
            return a.getIdTelefon()- b.getIdTelefon();
        }
        
    }
    
    class SortVestiByDatumDescending implements Comparator<Vesti> {
        
        @Override
        public int compare (Vesti a, Vesti b) {
            return b.getDatum().compareTo(a.getDatum());
        }
        
    }
    
    private List<Telefoni> setTelefoniToList() {
        List<Telefoni> telefoni = new ArrayList<Telefoni>(organizacija.getTelefonis());
        Collections.sort(telefoni, new OrganizacijaBean.SortByIdTelefon());
        return telefoni;
    }
    
    public String telefoniToString() {
        String telefoniString = "";
        List<Telefoni> telefoni = this.setTelefoniToList();
        for (int i=0; i < telefoni.size(); i++) {
            telefoniString += telefoni.get(i).getTelefon();
            if (i < telefoni.size() - 1)
                telefoniString += ", ";
        }
        
        return telefoniString;
    }
    
    public Organizacije getOrganizacija() {
        return organizacija;
    }
    
    public void setOrganizacija(Organizacije organizacija) {
        this.organizacija = organizacija;
    }
    
    public List<Vesti> setVestiToList() {
        List<Vesti> vesti = new ArrayList<Vesti>(organizacija.getKorisnici().getVestis());
        Collections.sort(vesti, new OrganizacijaBean.SortVestiByDatumDescending());
        return vesti;
    }
    
    public List<Vesti> setVestiToListFeatured() {
        List<Vesti> vesti = this.setVestiToList();
        if (vesti.size() > 7)
            return vesti.subList(0, 8);
        return vesti;
    }
    
}