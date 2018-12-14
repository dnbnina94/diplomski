/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Nina
 */
public class Registracija {

    private List<String> telefoni;
    
    public Registracija() {
        telefoni = new ArrayList<String>();
    }
    
    public List<String> getTelefoni() {
        return telefoni;
    }
    
    public void setTelefoni(List<String> telefoni) {
        this.telefoni = telefoni;
    }
    
    public void addTelefon() {
        telefoni.add("");
    }
    
    public void removeTelefon(int status) {
        telefoni.remove(status);
    }
    
}
