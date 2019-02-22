/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.KarakteristikeProstora;
import db.StavkeSifarnika;
import db.helpers.DogadjajiHelper;
import db.helpers.KarakteristikeProstoraHelper;
import db.helpers.StavkeSifarnikaHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public class IzmenaDogadjaja {

    private Dogadjaji dogadjaj;
    private String naslov;
    private String tekst;
    private StavkeSifarnika kategorija;
    private String mesto;
    private String ulica;
    private Date datumPocetka;
    private Date datumKraja;
    private Date vremePocetka;
    private Date vremeKraja;
    private StavkeSifarnika uzrast;
    private List<StavkeSifarnika> karakteristikeProstora;
    private StavkeSifarnika karakteristikaProstora;
    private List<KarakteristikeProstora> karakteristikeProstoraList;
    private String thumbnailName;
    private Part thumbnail;
    private Part submittedThumbnail = null;
    private boolean menjanThumbnail;
    private Date datumIVremeKraja;
    private Date datumIVremePocetka;
    
    private String naslovGreska = "";
    private String tekstGreska = "";
    private String kategorijaGreska = "";
    private String mestoGreska = "";
    private String ulicaGreska = "";
    private String datumPocetkaGreska = "";
    private String datumKrajaGreska = "";
    private String datumIVremePocetkaGreska = "";
    private String datumIVremeKrajaGreska = "";
    private String vremePocetkaGreska = "";
    private String vremeKrajaGreska = "";
    private String uzrastGreska = "";
    private String karakteristikeProstoraGreska = "";
    private String thumbnailGreska = "";
    
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();
    private StavkeSifarnikaHelper stavkeSifarnikaHelper = new StavkeSifarnikaHelper();
    private KarakteristikeProstoraHelper karakteristikeHelper = new KarakteristikeProstoraHelper();
    
    public IzmenaDogadjaja() {
    }

    public Dogadjaji getDogadjaj() {
        return dogadjaj;
    }

    public void setDogadjaj(Dogadjaji dogadjaj) {
        this.dogadjaj = dogadjaj;
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

    public String getNaslovGreska() {
        return naslovGreska;
    }

    public void setNaslovGreska(String naslovGreska) {
        this.naslovGreska = naslovGreska;
    }

    public String getTekstGreska() {
        return tekstGreska;
    }

    public void setTekstGreska(String tekstGreska) {
        this.tekstGreska = tekstGreska;
    }

    public String getKategorijaGreska() {
        return kategorijaGreska;
    }

    public void setKategorijaGreska(String kategorijaGreska) {
        this.kategorijaGreska = kategorijaGreska;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getMestoGreska() {
        return mestoGreska;
    }

    public void setMestoGreska(String mestoGreska) {
        this.mestoGreska = mestoGreska;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getUlicaGreska() {
        return ulicaGreska;
    }

    public void setUlicaGreska(String ulicaGreska) {
        this.ulicaGreska = ulicaGreska;
    }

    public String getDatumPocetkaGreska() {
        return datumPocetkaGreska;
    }

    public void setDatumPocetkaGreska(String datumPocetkaGreska) {
        this.datumPocetkaGreska = datumPocetkaGreska;
    }

    public String getDatumKrajaGreska() {
        return datumKrajaGreska;
    }

    public void setDatumKrajaGreska(String datumKrajaGreska) {
        this.datumKrajaGreska = datumKrajaGreska;
    }

    public String getDatumIVremePocetkaGreska() {
        return datumIVremePocetkaGreska;
    }

    public void setDatumIVremePocetkaGreska(String datumIVremePocetkaGreska) {
        this.datumIVremePocetkaGreska = datumIVremePocetkaGreska;
    }

    public String getDatumIVremeKrajaGreska() {
        return datumIVremeKrajaGreska;
    }

    public void setDatumIVremeKrajaGreska(String datumIVremeKrajaGreska) {
        this.datumIVremeKrajaGreska = datumIVremeKrajaGreska;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumKraja() {
        return datumKraja;
    }

    public void setDatumKraja(Date datumKraja) {
        this.datumKraja = datumKraja;
    }

    public String getVremePocetkaGreska() {
        return vremePocetkaGreska;
    }

    public void setVremePocetkaGreska(String vremePocetkaGreska) {
        this.vremePocetkaGreska = vremePocetkaGreska;
    }

    public String getVremeKrajaGreska() {
        return vremeKrajaGreska;
    }

    public void setVremeKrajaGreska(String vremeKrajaGreska) {
        this.vremeKrajaGreska = vremeKrajaGreska;
    }

    public Date getVremePocetka() {
        return vremePocetka;
    }

    public void setVremePocetka(Date vremePocetka) {
        this.vremePocetka = vremePocetka;
    }

    public Date getVremeKraja() {
        return vremeKraja;
    }

    public void setVremeKraja(Date vremeKraja) {
        this.vremeKraja = vremeKraja;
    }

    public StavkeSifarnika getUzrast() {
        return uzrast;
    }

    public void setUzrast(StavkeSifarnika uzrast) {
        this.uzrast = uzrast;
    }

    public String getUzrastGreska() {
        return uzrastGreska;
    }

    public void setUzrastGreska(String uzrastGreska) {
        this.uzrastGreska = uzrastGreska;
    }

    public String getKarakteristikeProstoraGreska() {
        return karakteristikeProstoraGreska;
    }

    public void setKarakteristikeProstoraGreska(String karakteristikeProstoraGreska) {
        this.karakteristikeProstoraGreska = karakteristikeProstoraGreska;
    }

    public StavkeSifarnika getKarakteristikaProstora() {
        return karakteristikaProstora;
    }

    public void setKarakteristikaProstora(StavkeSifarnika karakteristikaProstora) {
        this.karakteristikaProstora = karakteristikaProstora;
    }

    public List<StavkeSifarnika> getKarakteristikeProstora() {
        return karakteristikeProstora;
    }

    public void setKarakteristikeProstora(List<StavkeSifarnika> karakteristikeProstora) {
        this.karakteristikeProstora = karakteristikeProstora;
    }

    public List<KarakteristikeProstora> getKarakteristikeProstoraList() {
        return karakteristikeProstoraList;
    }

    public void setKarakteristikeProstoraList(List<KarakteristikeProstora> karakteristikeProstoraList) {
        this.karakteristikeProstoraList = karakteristikeProstoraList;
        
        karakteristikeProstora = new ArrayList<StavkeSifarnika>();
        for (KarakteristikeProstora karakteristika : karakteristikeProstoraList) {
            karakteristikeProstora.add(karakteristika.getStavkeSifarnika());
        }
    }

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
    }

    public Part getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Part thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    public void removeThumbnail() {
        thumbnailGreska = "";
        thumbnail = null;
        submittedThumbnail = null;
        menjanThumbnail = true;
        thumbnailName = null;
    }
    
    public void uploadThumbnail() {
        try (InputStream input = thumbnail.getInputStream()) {
            try {
                ImageIO.read(input).toString();

                if (thumbnail.getSize() > 512000) {
                    setThumbnailGreska("Veličina file-a ne sme biti veća od 500KB.");
                    thumbnail = null;
                    submittedThumbnail = null;
                    thumbnailName = null;
                } else {
                    setThumbnailGreska("");
                    this.submittedThumbnail = thumbnail;
                    setMenjanThumbnail(true);
                    thumbnailName = thumbnail.getSubmittedFileName();
                }
            } catch (Exception e) {
                setThumbnailGreska("File koji ste odabrali ne odgovara formatu slike.");
                thumbnail = null;
                submittedThumbnail = null;
                thumbnailName = null;
            }
        } catch (IOException e) {
            setThumbnailGreska("Došlo je do greške prilikom upload-ovanja file-a. Molimo, pokušajte ponovo.");
            thumbnail = null;
            submittedThumbnail = null;
            thumbnailName = null;
        }
    }

    public String getThumbnailGreska() {
        return thumbnailGreska;
    }

    public void setThumbnailGreska(String thumbnailGreska) {
        this.thumbnailGreska = thumbnailGreska;
    }

    public boolean isMenjanThumbnail() {
        return menjanThumbnail;
    }

    public void setMenjanThumbnail(boolean menjanThumbnail) {
        this.menjanThumbnail = menjanThumbnail;
    }
    
    public boolean karakteristikaValidacija() {
        if (karakteristikaProstora == null) {
            karakteristikeProstoraGreska = "Polje 'Karakteristika prostora' ne sme ostati prazno.";
            return false;
        }

        karakteristikeProstoraGreska = "";
        return true;
    }
    
    public void addKarakteristika() {
        boolean valid = karakteristikaValidacija();

        if (valid) {
            for (int i = 0; i < karakteristikeProstora.size(); i++) {
                if (karakteristikeProstora.get(i).getNaziv().equals(karakteristikaProstora.getNaziv())) {
                    karakteristikeProstoraGreska = "Već ste dodali zadatu vrednost.";
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            karakteristikeProstora.add(karakteristikaProstora);
            karakteristikaProstora = null;
        }
    }
    
    public void removeKarakteristika(int status) {
        karakteristikeProstora.remove(status);

        karakteristikeProstoraGreska = "";
    }
    
    public boolean naslovValidacija() {
        if (naslov.isEmpty()) {
            naslovGreska = "Polje 'Naslov događaja' ne sme ostati prazno.";
            return false;
        }

        naslovGreska = "";
        return true;
    }
    
    public boolean kategorijaValidacija() {
        if (kategorija == null) {
            kategorijaGreska = "Polje 'Kategorija događaja' ne sme ostati prazno.";
            return false;
        }

        kategorijaGreska = "";
        return true;
    }
    
    public boolean tekstValidacija() {
        if (tekst.isEmpty()) {
            tekstGreska = "Polje 'Tekst događaja' ne sme ostati prazno.";
            return false;
        }

        tekstGreska = "";
        return true;
    }
    
    public boolean mestoValidacija() {
        if (mesto.isEmpty()) {
            mestoGreska = "Polje 'Mesto' ne sme ostati prazno.";
            return false;
        }

        if (!mesto.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
            mestoGreska = "Polje 'Mesto' ne sme sadržati numerike i specijalne karaktere.";
            return false;
        }

        mestoGreska = "";
        return true;
    }
    
    public boolean ulicaValidacija() {
        if (ulica.isEmpty()) {
            ulicaGreska = "Polje 'Ulica' ne sme ostati prazno.";
            return false;
        }

        if (!ulica.matches("[a-zA-ZčćšđžČĆŠĐŽ0-9 ]+")) {
            ulicaGreska = "Polje 'Ulica' sme sadržati samo slova i numeričke karaktere.";
            return false;
        }

        ulicaGreska = "";
        return true;
    }
    
    public boolean datumPocetkaValidacija() {
        if (getDatumPocetka() == null) {
            datumPocetkaGreska = "Polje 'Datum početka' ne sme ostati prazno.";
            return false;
        }

        datumPocetkaGreska = "";
        return true;
    }
    
    public boolean datumKrajaValidacija() {
        if (getDatumKraja() == null) {
            datumKrajaGreska = "Polje 'Datum kraja' ne sme ostati prazno.";
            return false;
        }

        datumKrajaGreska = "";
        return true;
    }
    
    public boolean vremePocetkaValidacija() {
        if (vremePocetka == null) {
            vremePocetkaGreska = "Polje 'Vreme početka' ne sme ostati prazno.";
            return false;
        }
        vremePocetkaGreska = "";
        return true;
    }

    public boolean vremeKrajaValidacija() {
        if (vremeKraja == null) {
            vremeKrajaGreska = "Polje 'Vreme kraja' ne sme ostati prazno.";
            return false;
        }
        vremeKrajaGreska = "";
        return true;
    }
    
    public boolean uzrastValidacija() {
        if (uzrast == null) {
            uzrastGreska = "Polje 'Uzrast' ne sme ostati prazno.";
            return false;
        }

        uzrastGreska = "";
        return true;
    }
    
    public boolean datumiValidacija() {
        if (getDatumIVremeKraja().before(getDatumIVremePocetka())) {
            datumIVremeKrajaGreska = "Datum i vreme kraja događaja ne sme biti pre datuma i vremena početka događaja.";
            return false;
        }

        datumIVremeKrajaGreska = "";
        return true;
    }
    
    private Date getDatumIVreme(Date datum, Date vreme) {
        Calendar calDatum = Calendar.getInstance();
        calDatum.setTime(datum);

        Calendar calVreme = Calendar.getInstance();
        calVreme.setTime(vreme);

        Calendar calDatumIVreme = Calendar.getInstance();

        calDatumIVreme.set(Calendar.YEAR, calDatum.get(Calendar.YEAR));
        calDatumIVreme.set(Calendar.MONTH, calDatum.get(Calendar.MONTH));
        calDatumIVreme.set(Calendar.DATE, calDatum.get(Calendar.DATE));
        calDatumIVreme.set(Calendar.HOUR_OF_DAY, calVreme.get(Calendar.HOUR_OF_DAY));
        calDatumIVreme.set(Calendar.MINUTE, calVreme.get(Calendar.MINUTE));
        calDatumIVreme.set(Calendar.SECOND, calVreme.get(Calendar.SECOND));

        return calDatumIVreme.getTime();
    }
    
    public void izmeniDogadjaj() {
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
        if (!mestoValidacija()) {
            valid = false;
        }
        if (!ulicaValidacija()) {
            valid = false;
        }
        
        boolean formiranDatumPocetak = true;
        if (!datumPocetkaValidacija()) {
            valid = false;
            formiranDatumPocetak = false;
        }
        if (!vremePocetkaValidacija()) {
            valid = false;
            formiranDatumPocetak = false;
        }
        
        datumIVremePocetka = null;
        if (formiranDatumPocetak) {
            datumIVremePocetka = getDatumIVreme(datumPocetka, vremePocetka);
            /*if (!datumIVremePocetakValidacija()) {
                valid = false;
            }*/
        } else {
            datumIVremePocetkaGreska = "";
            datumIVremePocetka = null;
        }
        
        boolean formiranDatumKraj = true;
        if (!datumKrajaValidacija()) {
            valid = false;
            formiranDatumKraj = false;
        }
        if (!vremeKrajaValidacija()) {
            valid = false;
            formiranDatumKraj = false;
        }

        datumIVremeKraja = null;
        if (formiranDatumKraj) {
            datumIVremeKraja = getDatumIVreme(datumKraja, vremeKraja);
            /*if (!datumIVremeKrajValidacija()) {
                valid = false;
            }*/
        } else {
            datumIVremeKrajaGreska = "";
            datumIVremeKraja = null;
        }

        if (datumIVremePocetka != null && datumIVremeKraja != null) {
            if (!datumiValidacija()) {
                valid = false;
            } else {
                datumIVremeKrajaGreska = "";
            }
        }

        if (!uzrastValidacija()) {
            valid = false;
        }
        
        if (valid) {
            dogadjaj.setNaslov(naslov);
            dogadjaj.setKategorija(kategorija);
            dogadjaj.setTekst(Jsoup.clean(tekst, "", Whitelist.basic().addTags("h1", "h2", "h3"), new Document.OutputSettings().prettyPrint(false)));
            
            if (menjanThumbnail) {
                if (dogadjaj.getThumbnail() != null) {
                    File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("thumbnailsDogadjaji"));
                    File file = new File(uploads, dogadjaj.getThumbnail());

                    try {
                        boolean result = Files.deleteIfExists(file.toPath());

                        if (submittedThumbnail != null) {
                            String newThumbnailName = dogadjaj.getIdDogadjaj()+ ".";
                            int i = submittedThumbnail.getSubmittedFileName().lastIndexOf('.');
                            if (i > 0) {
                                newThumbnailName += submittedThumbnail.getSubmittedFileName().substring(i + 1);
                            }

                            file = new File(uploads, newThumbnailName);

                            try (InputStream input = submittedThumbnail.getInputStream()) {
                                Files.copy(input, file.toPath());
                            } catch (IOException ex) {
                                Logger.getLogger(IzmenaDogadjaja.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            dogadjaj.setThumbnail(newThumbnailName);
                        } else {
                            dogadjaj.setThumbnail(null);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(IzmenaDogadjaja.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (submittedThumbnail != null) {
                        String newThumbnailName = dogadjaj.getIdDogadjaj()+ ".";
                        int i = submittedThumbnail.getSubmittedFileName().lastIndexOf('.');
                        if (i > 0) {
                            newThumbnailName += submittedThumbnail.getSubmittedFileName().substring(i + 1);
                        }
                        
                        File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("thumbnailsDogadjaji"));
                        File file = new File(uploads, newThumbnailName);

                        try (InputStream input = submittedThumbnail.getInputStream()) {
                            Files.copy(input, file.toPath());
                        } catch (IOException ex) {
                            Logger.getLogger(IzmenaDogadjaja.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        dogadjaj.setThumbnail(newThumbnailName);
                    } else {
                        dogadjaj.setThumbnail(null);
                    }
                }
            }
            
            StavkeSifarnika mestoDog = stavkeSifarnikaHelper.getStavkaByNaziv(mesto);
            if (mestoDog == null) {
                mestoDog = new StavkeSifarnika(stavkeSifarnikaHelper.getMaxId() + 1, stavkeSifarnikaHelper.getStavkeByIdSifarnik(3), mesto, null);
                stavkeSifarnikaHelper.insertStavka(mestoDog);
            }
            dogadjaj.setMesto(mestoDog);
            
            StavkeSifarnika ulicaDog = stavkeSifarnikaHelper.getStavkaByNaziv(ulica);
            if (ulicaDog == null) {
                ulicaDog = new StavkeSifarnika(stavkeSifarnikaHelper.getMaxId() + 1, stavkeSifarnikaHelper.getStavkeByIdSifarnik(5), ulica, null);
                stavkeSifarnikaHelper.insertStavka(ulicaDog);
            }
            dogadjaj.setUlica(ulicaDog);
            
            dogadjaj.setDatumDogadjaja(datumIVremePocetka);
            dogadjaj.setDatumIsticanja(datumIVremeKraja);
            
            dogadjaj.setUzrast(uzrast);
            
            List<KarakteristikeProstora> stareKarakteristikeList = dogadjaj.karakteristikeToList();
            List<StavkeSifarnika> stareKarakteristike = new ArrayList<StavkeSifarnika>();
            
            for (KarakteristikeProstora karakteristika : stareKarakteristikeList) {
                stareKarakteristike.add(karakteristika.getStavkeSifarnika());
            }
            
            for (KarakteristikeProstora karakteristika : stareKarakteristikeList) {
                if (!karakteristikeProstora.contains(karakteristika.getStavkeSifarnika())) {
                    karakteristikeHelper.deleteKarakteristika(karakteristika);
                }
            }
            
            int karakteristikeId = karakteristikeHelper.getMaxId()+1;
            for (StavkeSifarnika karakteristika : karakteristikeProstora) {
                if (!stareKarakteristike.contains(karakteristika)) {
                    KarakteristikeProstora novaKarakteristika = new KarakteristikeProstora(karakteristikeId, dogadjaj, karakteristika);
                    karakteristikeHelper.insertKarakteristikaProstora(novaKarakteristika);
                    karakteristikeId++;
                }
            }
            
            dogadjaj.setKarakteristikeProstoras(karakteristikeHelper.getKarakteristikeByDogadjaj(dogadjaj));
            
            dogadjajiHelper.updateDogadjaj(dogadjaj);
            
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            PretragaDogadjaja pretragaDogadjajaBean = (PretragaDogadjaja) elContext.getELResolver().getValue(elContext, null, "pretragaDogadjaja");
            pretragaDogadjajaBean.setDogadjaj(dogadjaj);
            elContext.getELResolver().setValue(elContext, null, "pretragaDogadjaja", pretragaDogadjajaBean);
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste izmenili događaj.", null);
            FacesContext.getCurrentInstance().addMessage("dogadjaj:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dogadjaj.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(IzmenaDogadjaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            thumbnail = submittedThumbnail;
        }
        
    }

    public Date getDatumIVremeKraja() {
        return datumIVremeKraja;
    }

    public void setDatumIVremeKraja(Date datumIVremeKraja) {
        this.datumIVremeKraja = datumIVremeKraja;
    }

    public Date getDatumIVremePocetka() {
        return datumIVremePocetka;
    }

    public void setDatumIVremePocetka(Date datumIVremePocetka) {
        this.datumIVremePocetka = datumIVremePocetka;
    }
    
}
