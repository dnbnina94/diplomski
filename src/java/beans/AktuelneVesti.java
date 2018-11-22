/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Vesti;
import db.helpers.VestiHelper;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nina
 */
public class AktuelneVesti implements Serializable {
    
    private List<Vesti> vesti;
    private VestiHelper vestiHelper = new VestiHelper();
    private String greska = "greska";
    
    public String getGreska() {
        return greska;
    }
    
    public void setGreska(String greska) {
        this.greska = greska;
    }
    
    public List<Vesti> getVesti() {
        return vesti;
    }
    
    public void setVest(List<Vesti> vesti) {
        this.vesti = vesti;
    }
    
    public AktuelneVesti() {
        vesti = vestiHelper.aktuelneVesti();
    }
    
}
