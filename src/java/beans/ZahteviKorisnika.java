/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.Obavestenja;
import db.Oglasi;
import db.Vesti;
import db.helpers.DogadjajiHelper;
import db.helpers.ObavestenjaHelper;
import db.helpers.OglasiHelper;
import db.helpers.VestiHelper;
import java.util.Date;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class ZahteviKorisnika {

    private Vesti selektovanaVestBrisanje;
    private Vesti selektovanaVestArhiviranje;
    private Dogadjaji selektovanDogadjajBrisanje;
    private Oglasi selektovanOglasBrisanje;

    private VestiHelper vestiHelper = new VestiHelper();
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();
    private OglasiHelper oglasiHelper = new OglasiHelper();
    private ObavestenjaHelper obavestenjaHelper = new ObavestenjaHelper();

    public ZahteviKorisnika() {
    }

    public Vesti getSelektovanaVestBrisanje() {
        return selektovanaVestBrisanje;
    }

    public void setSelektovanaVestBrisanje(Vesti selektovanaVestBrisanje) {
        this.selektovanaVestBrisanje = selektovanaVestBrisanje;
    }

    public Dogadjaji getSelektovanDogadjajBrisanje() {
        return selektovanDogadjajBrisanje;
    }

    public void setSelektovanDogadjajBrisanje(Dogadjaji selektovanDogadjajBrisanje) {
        this.selektovanDogadjajBrisanje = selektovanDogadjajBrisanje;
    }

    public Oglasi getSelektovanOglasBrisanje() {
        return selektovanOglasBrisanje;
    }

    public void setSelektovanOglasBrisanje(Oglasi selektovanOglasBrisanje) {
        this.selektovanOglasBrisanje = selektovanOglasBrisanje;
    }

    public Vesti getSelektovanaVestArhiviranje() {
        return selektovanaVestArhiviranje;
    }

    public void setSelektovanaVestArhiviranje(Vesti selektovanaVestArhiviranje) {
        this.selektovanaVestArhiviranje = selektovanaVestArhiviranje;
    }

    public void obrisiVest() {
        if (selektovanaVestBrisanje != null) {
            selektovanaVestBrisanje.setZahtevBrisanje(true);
            vestiHelper.zahtevBrisanjeVesti(selektovanaVestBrisanje);
            
            Obavestenja obavestenje = new Obavestenja();
            obavestenje.setIdObavestenje(obavestenjaHelper.getMaxId()+1);
            
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            obavestenje.setKorisnici(korisnikBean.getKorisnik());
            
            obavestenje.setDatum(new Date());
            obavestenje.setVesti(selektovanaVestBrisanje);
            obavestenje.setTekst("Korisnik je poslao zahtev za brisanje vesti:");
            obavestenje.setProcitano(false);
            
            obavestenjaHelper.insertObavestenje(obavestenje);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste podneli zahtev za brisanje vesti.", null);
            FacesContext.getCurrentInstance().addMessage("vest:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public void arhivirajVest() {
        if (selektovanaVestArhiviranje != null) {
            selektovanaVestArhiviranje.setArhivirana(1);
            vestiHelper.arhiviranjeVesti(selektovanaVestArhiviranje);
            
            Obavestenja obavestenje = new Obavestenja();
            obavestenje.setIdObavestenje(obavestenjaHelper.getMaxId()+1);
            
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            obavestenje.setKorisnici(korisnikBean.getKorisnik());
            
            obavestenje.setDatum(new Date());
            obavestenje.setVesti(selektovanaVestArhiviranje);
            obavestenje.setTekst("Korisnik je arhivirao vest:");
            obavestenje.setProcitano(false);
            
            obavestenjaHelper.insertObavestenje(obavestenje);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste arhivirali vest.", null);
            FacesContext.getCurrentInstance().addMessage("vest:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    public void obrisiDogadjaj() {
        if (selektovanDogadjajBrisanje != null) {
            selektovanDogadjajBrisanje.setZahtevBrisanje(true);
            dogadjajiHelper.zahtevBrisanjeDogadjaja(selektovanDogadjajBrisanje);
            
            Obavestenja obavestenje = new Obavestenja();
            obavestenje.setIdObavestenje(obavestenjaHelper.getMaxId()+1);
            
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            obavestenje.setKorisnici(korisnikBean.getKorisnik());
            
            obavestenje.setDatum(new Date());
            obavestenje.setDogadjaji(selektovanDogadjajBrisanje);
            obavestenje.setTekst("Korisnik je poslao zahtev za brisanje događaja:");
            obavestenje.setProcitano(false);
            
            obavestenjaHelper.insertObavestenje(obavestenje);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste podneli zahtev za brisanje događaja.", null);
            FacesContext.getCurrentInstance().addMessage("dogadjaj:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    public void obrisiOglas() {
        if (selektovanOglasBrisanje != null) {
            selektovanOglasBrisanje.setZahtevBrisanje(true);
            oglasiHelper.zahtevBrisanjeOglasa(selektovanOglasBrisanje);
            
            Obavestenja obavestenje = new Obavestenja();
            obavestenje.setIdObavestenje(obavestenjaHelper.getMaxId()+1);
            
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            obavestenje.setKorisnici(korisnikBean.getKorisnik());
            
            obavestenje.setDatum(new Date());
            obavestenje.setOglasi(selektovanOglasBrisanje);
            obavestenje.setTekst("Korisnik je poslao zahtev za brisanje oglasa:");
            obavestenje.setProcitano(false);
            
            obavestenjaHelper.insertObavestenje(obavestenje);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste podneli zahtev za brisanje oglasa.", null);
            FacesContext.getCurrentInstance().addMessage("dogadjaj:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

}
