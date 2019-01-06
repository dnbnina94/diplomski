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
    
}
