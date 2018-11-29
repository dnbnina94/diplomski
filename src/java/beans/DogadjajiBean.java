/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.helpers.DogadjajiHelper;
import java.util.List;

/**
 *
 * @author Nina
 */
public class DogadjajiBean {
    
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();
    private List<Dogadjaji> dogadjaji;

    public DogadjajiBean() {
    }
    
    public List<Dogadjaji> getDogadjaji() {
        dogadjaji = dogadjajiHelper.dogadjaji();
        return dogadjaji;
    }
    
}
