/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.AdminLog;
import db.StavkeSifarnika;
import db.Vesti;
import db.helpers.AdminLogHelper;
import db.helpers.StavkeSifarnikaHelper;
import db.helpers.VestiHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author Nina
 */
public class IzmenaVesti {

    private Vesti vest;
    private String naslov;
    private String tekst;
    private StavkeSifarnika kategorija;
    private String thumbnailName;

    private Part thumbnail;
    private Part submittedThumbnail = null;

    private List<StavkeSifarnika> kategorijeVesti;
    private boolean menjanThumbnail;

    private String naslovGreska = "";
    private String kategorijaGreska = "";
    private String tekstGreska = "";
    private String thumbnailGreska = "";

    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    private VestiHelper vestiHelper = new VestiHelper();
    private AdminLogHelper adminLogHelper = new AdminLogHelper();

    public IzmenaVesti() {
        kategorijeVesti = new ArrayList<StavkeSifarnika>(stavkeSifarnikaHelper.getStavkeByIdSifarnik(1).getStavkeSifarnikas());
        Collections.sort(kategorijeVesti, new IzmenaVesti.SortByIdSifarnik());
    }

    class SortByIdSifarnik implements Comparator<StavkeSifarnika> {

        @Override
        public int compare(StavkeSifarnika a, StavkeSifarnika b) {
            return a.getIdStavka() - b.getIdStavka();
        }

    }

    public String getNaslovGreska() {
        return naslovGreska;
    }

    public void setNaslovGreska(String naslovGreska) {
        this.naslovGreska = naslovGreska;
    }

    public String getKategorijaGreska() {
        return kategorijaGreska;
    }

    public void setKategorijaGreska(String kategorijaGreska) {
        this.kategorijaGreska = kategorijaGreska;
    }

    public String getTekstGreska() {
        return tekstGreska;
    }

    public void setTekstGreska(String tekstGreska) {
        this.tekstGreska = tekstGreska;
    }

    public String getThumbnailGreska() {
        return thumbnailGreska;
    }

    public void setThumbnailGreska(String thumbnailGreska) {
        this.thumbnailGreska = thumbnailGreska;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public StavkeSifarnika getKategorija() {
        return kategorija;
    }

    public void setKategorija(StavkeSifarnika kategorija) {
        this.kategorija = kategorija;
    }

    public Part getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Part thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<StavkeSifarnika> getKategorijeVesti() {
        return kategorijeVesti;
    }

    public void setKategorijeVesti(List<StavkeSifarnika> kategorijeVesti) {
        this.kategorijeVesti = kategorijeVesti;
    }

    public void setThumbnailVest(String thumbnail) {
        if (!thumbnail.isEmpty()) {

        }
    }

    public void uploadThumbnail() {
        try (InputStream input = thumbnail.getInputStream()) {
            try {
                ImageIO.read(input).toString();

                if (thumbnail.getSize() > 512000) {
                    thumbnailGreska = "Veličina file-a ne sme biti veća od 500KB.";
                    thumbnail = null;
                    submittedThumbnail = null;
                    thumbnailName = null;
                } else {
                    thumbnailGreska = "";
                    this.submittedThumbnail = thumbnail;
                    menjanThumbnail = true;
                    thumbnailName = thumbnail.getSubmittedFileName();
                }
            } catch (Exception e) {
                thumbnailGreska = "File koji ste odabrali ne odgovara formatu slike.";
                thumbnail = null;
                submittedThumbnail = null;
                thumbnailName = null;
            }
        } catch (IOException e) {
            thumbnailGreska = "Došlo je do greške prilikom upload-ovanja file-a. Molimo, pokušajte ponovo.";
            thumbnail = null;
            submittedThumbnail = null;
            thumbnailName = null;
        }
    }

    public void removeThumbnail() {
        thumbnailGreska = "";
        thumbnail = null;
        submittedThumbnail = null;
        menjanThumbnail = true;
        thumbnailName = null;
    }

    public boolean isMenjanThumbnail() {
        return menjanThumbnail;
    }

    public void setMenjanThumbnail(boolean menjanThumbnail) {
        this.menjanThumbnail = menjanThumbnail;
    }

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
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

    public void izmeniVest() {
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
            vestiHelper.updateVestNaslov(vest, naslov);
            vestiHelper.updateVestTekst(vest, Jsoup.clean(tekst, "", Whitelist.basic().addTags("h1", "h2", "h3"), new Document.OutputSettings().prettyPrint(false)));
            vestiHelper.updateVestKategorija(vest, kategorija);

            vest.setNaslov(naslov);
            vest.setTekst(Jsoup.clean(tekst, "", Whitelist.basic().addTags("h1", "h2", "h3"), new Document.OutputSettings().prettyPrint(false)));
            vest.setKategorija(kategorija);

            if (menjanThumbnail) {
                if (vest.getThumbnail() != null) {
                    File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("thumbnailsVesti"));
                    File file = new File(uploads, vest.getThumbnail());

                    try {
                        boolean result = Files.deleteIfExists(file.toPath());

                        if (submittedThumbnail != null) {
                            UUID uid = UUID.randomUUID();
                            String newThumbnailName = uid + ".";
                            int i = submittedThumbnail.getSubmittedFileName().lastIndexOf('.');
                            if (i > 0) {
                                newThumbnailName += submittedThumbnail.getSubmittedFileName().substring(i + 1);
                            }

                            file = new File(uploads, newThumbnailName);

                            try (InputStream input = submittedThumbnail.getInputStream()) {
                                Files.copy(input, file.toPath());
                            } catch (IOException ex) {
                                Logger.getLogger(IzmenaVesti.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            vestiHelper.updateVestThumbnail(vest, newThumbnailName);
                            vest.setThumbnail(newThumbnailName);
                        } else {
                            vestiHelper.updateVestThumbnail(vest, null);
                            vest.setThumbnail(null);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(IzmenaVesti.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (submittedThumbnail != null) {
                        UUID uid = UUID.randomUUID();
                        String newThumbnailName = uid + ".";
                        int i = submittedThumbnail.getSubmittedFileName().lastIndexOf('.');
                        if (i > 0) {
                            newThumbnailName += submittedThumbnail.getSubmittedFileName().substring(i + 1);
                        }

                        File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("thumbnailsVesti"));
                        File file = new File(uploads, newThumbnailName);

                        try (InputStream input = submittedThumbnail.getInputStream()) {
                            Files.copy(input, file.toPath());
                        } catch (IOException ex) {
                            Logger.getLogger(IzmenaVesti.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        vestiHelper.updateVestThumbnail(vest, newThumbnailName);
                        vest.setThumbnail(newThumbnailName);
                    } else {
                        vestiHelper.updateVestThumbnail(vest, null);
                        vest.setThumbnail(null);
                    }
                }
            }

            AdminLog adminLog = new AdminLog();
            adminLog.setIdLog(adminLogHelper.getMaxId() + 1);
            adminLog.setTekst("Izmenjena vest " + vest.getNaslov());
            adminLog.setDatum(new Date());

            adminLogHelper.insertLog(adminLog);

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            PretragaVesti pretragaVestiBean = (PretragaVesti) elContext.getELResolver().getValue(elContext, null, "pretragaVesti");
            pretragaVestiBean.setVest(vest);
            elContext.getELResolver().setValue(elContext, null, "pretragaVesti", pretragaVestiBean);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste izmenili vest.", null);
            FacesContext.getCurrentInstance().addMessage("vest:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("vest.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(IzmenaVesti.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Vesti getVest() {
        return vest;
    }

    public void setVest(Vesti vest) {
        this.vest = vest;
    }

}
