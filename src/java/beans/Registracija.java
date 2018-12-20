/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nina
 */
public class Registracija {

    private List<String> telefoni;
    private String telefon;
    private int nextIndex = 0;
    private String script = "";
    
    private String nazivOrg;
    private String nazivOrgGreska = "";
    
    public Registracija() {
        telefoni = new ArrayList<String>();
        nextIndex = 0;
    }
    
    public List<String> getTelefoni() {
        return telefoni;
    }
    
    public void setTelefoni(List<String> telefoni) {
        this.telefoni = telefoni;
    }
    
    public void addTelefon() {
        telefoni.add(telefon);
        telefon="";
    }
    
    public void removeTelefon(int status) {
        telefoni.remove(status);
    }
    
    public String getTelefon() {
        return telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public int getNextIndex() {
        return nextIndex;
    }
    
    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }
    
    public void prethodnaStavka() {
        if (nextIndex > 0) {
            nextIndex--;
            script = "$('.wizardPseudoClass').carousel("+nextIndex+");$('.wizardPseudoClass').carousel('pause');";
        }
    }
    
    private boolean nazivOrgValidacija() {
        if (nazivOrg.isEmpty()) {
            nazivOrgGreska = "Polje 'Naziv organizacije' ne sme ostati prazno.";
            return false;
        }
        
        nazivOrgGreska = "";
        return true;
    }
    
    public void narednaStavka() {
        boolean valid = true;
                
        if (nextIndex < 2) {
            if (nextIndex == 0) { 
                if (!nazivOrgValidacija()) valid = false;
            }
            if (nextIndex == 1) {
                
            }
            if (nextIndex == 2) {
                
            }
            
            if (valid) {
                nextIndex++;
                script = "$('.wizardPseudoClass').carousel("+nextIndex+");$('.wizardPseudoClass').carousel('pause');";
            }
        }
    }
    
    public String getScript() {
        return script;
    }
    
    public void setScript(String script) {
        this.script = script;
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
    
}
