/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Organizacije;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nina
 */
public class PretragaOrganizacija {

    private Organizacije organizacija;

    public PretragaOrganizacija() {
    }

    public Organizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(Organizacije organizacija) {
        this.organizacija = organizacija;
    }

    public void pretraziOrganizaciju() {
        if (organizacija != null) {
            try {
                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
                organizacijaBean.setOrganizacija(organizacija);
                elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);
                
                String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
                
                FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/faces/organizacija.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(PretragaOrganizacija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
