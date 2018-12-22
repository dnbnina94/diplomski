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

    private String opisOrg;
    private String opisOrgGreska = "";
    
    private String oblastDelovanja;
    private String oblastDelovanjaGreska = "";

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
        telefon = "";
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
            script = "$('.wizardPseudoClass').carousel(" + nextIndex + ");$('.wizardPseudoClass').carousel('pause');";
        }
    }

    public boolean nazivOrgValidacija() {
        if (nazivOrg.isEmpty()) {
            nazivOrgGreska = "Polje 'Naziv organizacije' ne sme ostati prazno.";
            return false;
        }

        nazivOrgGreska = "";
        return true;
    }

    public boolean opisOrgValidacija() {
        if (opisOrg.isEmpty()) {
            opisOrgGreska = "Polje 'Opis organizacije' ne sme ostati prazno.";
            return false;
        }

        opisOrgGreska = "";
        return true;
    }
    
    public boolean oblastDelovanjaValidacija() {
        if (oblastDelovanja.isEmpty()) {
            oblastDelovanjaGreska = "Polje 'Oblast delovanja' ne sme ostati prazno.";
            return false;
        }
        
        oblastDelovanjaGreska = "";
        return true;
    }

    public void narednaStavka() {
        boolean valid = true;

        if (nextIndex < 2) {
            if (nextIndex == 0) {
                if (!nazivOrgValidacija()) valid = false;
                if (!opisOrgValidacija()) valid = false;
                if (!oblastDelovanjaValidacija()) valid = false;
            }
            if (nextIndex == 1) {

            }
            if (nextIndex == 2) {

            }

            if (valid) {
                nextIndex++;
                script = "$('.wizardPseudoClass').carousel(" + nextIndex + ");$('.wizardPseudoClass').carousel('pause');";
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

    public String getOpisOrg() {
        return opisOrg;
    }

    public void setOpisOrg(String opisOrg) {
        this.opisOrg = opisOrg;
    }

    public String getOpisOrgGreska() {
        return opisOrgGreska;
    }

    public void setOpisOrgGreska(String opisOrgGreska) {
        this.opisOrgGreska = opisOrgGreska;
    }

    public String getOblastDelovanja() {
        return oblastDelovanja;
    }

    public void setOblastDelovanja(String oblastDelovanja) {
        this.oblastDelovanja = oblastDelovanja;
    }

    public String getOblastDelovanjaGreska() {
        return oblastDelovanjaGreska;
    }

    public void setOblastDelovanjaGreska(String oblastDelovanjaGreska) {
        this.oblastDelovanjaGreska = oblastDelovanjaGreska;
    }

}
