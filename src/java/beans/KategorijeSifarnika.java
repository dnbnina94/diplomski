/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.*;
import db.helpers.StavkeSifarnikaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nina
 */
public class KategorijeSifarnika implements Serializable {

    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    private List<StavkeSifarnika> mesta;
    private List<StavkeSifarnika> ulice;
    private List<StavkeSifarnika> oblastiDelovanja;
    private List<StavkeSifarnika> vestiKategorije;
    private List<StavkeSifarnika> dogadjajiKategorije;
    private List<StavkeSifarnika> uzrast;
    private List<StavkeSifarnika> karakteristikeProstora;

    public KategorijeSifarnika() {
        mesta = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(3).getStavkeSifarnikas());
        ulice = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(5).getStavkeSifarnikas());
        oblastiDelovanja = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(6).getStavkeSifarnikas());
        vestiKategorije = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(1).getStavkeSifarnikas());
        dogadjajiKategorije = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(2).getStavkeSifarnikas());
        uzrast = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(4).getStavkeSifarnikas());
        karakteristikeProstora = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(7).getStavkeSifarnikas());
    }

    class SortByIdSifarnik implements Comparator<StavkeSifarnika> {

        @Override
        public int compare(StavkeSifarnika a, StavkeSifarnika b) {
            return a.getIdStavka() - b.getIdStavka();
        }

    }

    private List<StavkeSifarnika> setToList(Set set) {
        List<StavkeSifarnika> stavkeSifarnika = new ArrayList<StavkeSifarnika>(set);
        Collections.sort(stavkeSifarnika, new SortByIdSifarnik());
        return stavkeSifarnika;
    }

    public List<String> StringList(List<StavkeSifarnika> list) {
        List<String> stringList = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            stringList.add(list.get(i).getNaziv());
        }

        return stringList;
    }

    public List<StavkeSifarnika> getVestiKategorije() {
        vestiKategorije = setToList(stavkeSifarnikaHelper.getStavkeByIdSifarnik(1).getStavkeSifarnikas());
        return vestiKategorije;
    }

    public void setVestiKategorije(List<StavkeSifarnika> vestiKategorije) {
        this.vestiKategorije = vestiKategorije;
    }

    public List<StavkeSifarnika> getDogadjajiKategorije() {
        return dogadjajiKategorije;
    }

    public void setDogadjajiKategorije(List<StavkeSifarnika> dogadjajiKategorije) {
        this.dogadjajiKategorije = dogadjajiKategorije;
    }

    public List<StavkeSifarnika> getMesta() {
        mesta = setToList(getStavkeSifarnikaHelper().getStavkeByIdSifarnik(3).getStavkeSifarnikas());
        return mesta;
    }

    public void setMesta(List<StavkeSifarnika> mesta) {
        this.mesta = mesta;
    }

    public List<StavkeSifarnika> getUzrast() {
        return uzrast;
    }

    public void setUzrast(List<StavkeSifarnika> uzrast) {
        this.uzrast = uzrast;
    }

    public StavkeSifarnikaHelper getStavkeSifarnikaHelper() {
        return stavkeSifarnikaHelper;
    }

    public void setStavkeSifarnikaHelper(StavkeSifarnikaHelper stavkeSifarnikaHelper) {
        this.stavkeSifarnikaHelper = stavkeSifarnikaHelper;
    }

    public List<StavkeSifarnika> getUlice() {
        ulice = setToList(getStavkeSifarnikaHelper().getStavkeByIdSifarnik(5).getStavkeSifarnikas());
        return ulice;
    }

    public void setUlice(List<StavkeSifarnika> ulice) {
        this.ulice = ulice;
    }

    public List<StavkeSifarnika> getOblastiDelovanja() {
        oblastiDelovanja = setToList(getStavkeSifarnikaHelper().getStavkeByIdSifarnik(6).getStavkeSifarnikas());
        return oblastiDelovanja;
    }

    public void setOblastiDelovanja(List<StavkeSifarnika> oblastiDelovanja) {
        this.oblastiDelovanja = oblastiDelovanja;
    }

    public List<StavkeSifarnika> getKarakteristikeProstora() {
        return karakteristikeProstora;
    }

    public void setKarakteristikeProstora(List<StavkeSifarnika> karakteristikeProstora) {
        this.karakteristikeProstora = karakteristikeProstora;
    }

}
