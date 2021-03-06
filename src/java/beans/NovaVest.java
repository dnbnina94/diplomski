/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.StavkeIzvestaj;
import db.StavkeSifarnika;
import db.Vesti;
import db.helpers.StavkeIzvestajHelper;
import db.helpers.VestiHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author Nina
 */
public class NovaVest {

    private String naslov;
    private String naslovGreska = "";

    private StavkeSifarnika kategorija;
    private String kategorijaGreska = "";

    private String tekst;
    private String tekstGreska = "";

    private Part thumbnail;
    private String thumbnailGreska = "";

    private Part submittedThumbnail = null;

    private VestiHelper vestiHelper = new VestiHelper();
    private StavkeIzvestajHelper stavkeIzvestajHelper = new StavkeIzvestajHelper();

    public NovaVest() {
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovGreska() {
        return naslovGreska;
    }

    public void setNaslovGreska(String naslovGreska) {
        this.naslovGreska = naslovGreska;
    }

    public StavkeSifarnika getKategorija() {
        return kategorija;
    }

    public void setKategorija(StavkeSifarnika kategorija) {
        this.kategorija = kategorija;
    }

    public String getKategorijaGreska() {
        return kategorijaGreska;
    }

    public void setKategorijaGreska(String kategorijaGreska) {
        this.kategorijaGreska = kategorijaGreska;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getTekstGreska() {
        return tekstGreska;
    }

    public void setTekstGreska(String tekstGreska) {
        this.tekstGreska = tekstGreska;
    }

    public Part getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Part thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailGreska() {
        return thumbnailGreska;
    }

    public void setThumbnailGreska(String thumbnailGreska) {
        this.thumbnailGreska = thumbnailGreska;
    }

    public void uploadThumbnail() {
        try (InputStream input = thumbnail.getInputStream()) {
            try {
                ImageIO.read(input).toString();

                if (thumbnail.getSize() > 512000) {
                    thumbnailGreska = "Veličina file-a ne sme biti veća od 500KB.";
                    thumbnail = null;
                    submittedThumbnail = null;
                } else {
                    thumbnailGreska = "";
                    this.submittedThumbnail = thumbnail;
                }
            } catch (Exception e) {
                thumbnailGreska = "File koji ste odabrali ne odgovara formatu slike.";
                thumbnail = null;
                submittedThumbnail = null;
            }
        } catch (IOException e) {
            thumbnailGreska = "Došlo je do greške prilikom upload-ovanja file-a. Molimo, pokušajte ponovo.";
            thumbnail = null;
            submittedThumbnail = null;
        }
    }

    public boolean naslovValidacija() {
        if (naslov.isEmpty()) {
            naslovGreska = "Polje 'Naslov vesti' ne sme ostati prazno.";
            return false;
        }

        naslovGreska = "";
        return true;
    }

    public boolean kategorijaValidacija() {
        if (kategorija == null) {
            kategorijaGreska = "Polje 'Kategorija vesti' ne sme ostati prazno.";
            return false;
        }

        kategorijaGreska = "";
        return true;
    }

    public boolean tekstValidacija() {
        if (tekst.isEmpty()) {
            tekstGreska = "Polje 'Tekst vesti' ne sme ostati prazno.";
            return false;
        }

        tekstGreska = "";
        return true;
    }

    public void kreirajVest() {
        boolean valid = true;

        if (!naslovValidacija()) {
            valid = false;
        }
        if (!kategorijaValidacija()) {
            valid = false;
        }
        if (!tekstValidacija()) {
            valid = false;
        }

        if (valid) {
            int vestId = vestiHelper.getMaxId() + 1;

            Vesti novaVest = new Vesti();

            String thumbnailName = null;
            if (submittedThumbnail != null) {
                UUID uid = UUID.randomUUID();
                thumbnailName = uid + ".";
                int i = submittedThumbnail.getSubmittedFileName().lastIndexOf('.');
                if (i > 0) {
                    thumbnailName += submittedThumbnail.getSubmittedFileName().substring(i + 1);
                }

                File uploads = new File(FacesContext.getCurrentInstance().
                                   getExternalContext().getInitParameter("thumbnailsVesti"));
                File file = new File(uploads, thumbnailName);

                try (InputStream input = submittedThumbnail.getInputStream()) {
                    Files.copy(input, file.toPath());
                } catch (IOException ex) {
                    Logger.getLogger(NovaVest.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }

                novaVest.setThumbnail(thumbnailName);
            } else {
                novaVest.setThumbnail(null);
            }

            novaVest.setIdVest(vestId);

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
            novaVest.setKorisnici(korisnikBean.getKorisnik());

            novaVest.setKategorija(kategorija);
            novaVest.setNaslov(naslov);
            novaVest.setTekst(Jsoup.clean(tekst, 
                                          "", 
                                          Whitelist.basic().addTags("h1", "h2", "h3"), 
                                          new OutputSettings().prettyPrint(false)));
            novaVest.setDatum(new Date());
            novaVest.setArhivirana(0);

            vestiHelper.insertVest(novaVest);

            StavkeIzvestaj stavkeIzvestaj = new StavkeIzvestaj();
            stavkeIzvestaj.setIdStavka(stavkeIzvestajHelper.getMaxId() + 1);
            stavkeIzvestaj.setNaziv(novaVest.getNaslov());
            stavkeIzvestaj.setDatum(new Date());
            stavkeIzvestaj.setSifarniciIzvestaj(stavkeIzvestajHelper.getSifarnikIzvestajById(4));

            stavkeIzvestajHelper.insertStavkaIzvestaj(stavkeIzvestaj);

            PretragaVesti pretragaVestiBean = (PretragaVesti) elContext.getELResolver().getValue(elContext, null, "pretragaVesti");
            pretragaVestiBean.setVest(novaVest);
            elContext.getELResolver().setValue(elContext, null, "pretragaVesti", pretragaVestiBean);

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("vest.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(NovaVest.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            thumbnail = submittedThumbnail;
        }

    }

    public void removeThumbnail() {
        thumbnailGreska = "";
        thumbnail = null;
        submittedThumbnail = null;
    }

    public void reset() {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        NovaVest novaVestBean = new NovaVest();
        elContext.getELResolver().setValue(elContext, null, "novaVest", novaVestBean);
    }
}
