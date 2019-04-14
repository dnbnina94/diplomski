/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Dogadjaji;
import db.Korisnici;
import db.Obavestenja;
import db.Oglasi;
import db.Organizacije;
import db.Sifarnici;
import db.StavkeSifarnika;
import db.Vesti;
import db.helpers.DogadjajiHelper;
import db.helpers.KarakteristikeProstoraHelper;
import db.helpers.KorisniciHelper;
import db.helpers.ObavestenjaHelper;
import db.helpers.OglasiHelper;
import db.helpers.StavkeSifarnikaHelper;
import db.helpers.VestiHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

/**
 *
 * @author Nina
 */
public class Admin {

    private List<Korisnici> korisnici;
    private String page;
    private Korisnici selektovanKorisnikBrisanje;
    private Korisnici selektovanKorisnikPrihvatanje;
    private Dogadjaji selektovanDogadjajBrisanje;
    private Vesti selektovanaVestBrisanje;
    private Vesti selektovanaVestArhiviranje;
    private Oglasi selektovanOglasBrisanje;
    private List<Sifarnici> sifarnici;
    private int pageSifarnici;
    private List<StavkeSifarnika> stavkeSifarnika;
    private StavkeSifarnika selectedStavkaSifarnikaIzmena;
    private StavkeSifarnika selectedStavkaSifarnikaBrisanje;
    private String stavka;
    private String stavkaGreska = "";
    private String closeModalScript;
    private String novaStavka;
    private String novaStavkaGreska = "";
    private boolean postojeEntiteti;
    private String postojeEntitetiPoruka = "";
    private Part thumbnail;
    private String thumbnailGreska = "";
    private Part submittedThumbnail = null;
    private String thumbnailName;
    private boolean menjanThumbnail;
    private List<Obavestenja> obavestenja;

    // 1 za korisnike, 2 za sifarnike, 3 za obavestenja
    private int adminStrana = 1;
    private String kljucneReci = "";
    private int currentPage;
    private int pageLength = 10;
    private int numOfShowedItems;
    private long numOfTotalItems;
    private String insertSuccessfulScript = "";

    private long brNovihObavestenja = 0;

    private KorisniciHelper korisniciHelper = new KorisniciHelper();
    private DogadjajiHelper dogadjajiHelper = new DogadjajiHelper();
    private VestiHelper vestiHelper = new VestiHelper();
    private OglasiHelper oglasiHelper = new OglasiHelper();
    private StavkeSifarnikaHelper stavkeHelper = new StavkeSifarnikaHelper();
    private KarakteristikeProstoraHelper karakteristikeHelper = new KarakteristikeProstoraHelper();
    private ObavestenjaHelper obavestenjaHelper = new ObavestenjaHelper();

    class SortKorisniciByKorIme implements Comparator<Korisnici> {

        @Override
        public int compare(Korisnici a, Korisnici b) {
            return a.getKorisnickoIme().toLowerCase().compareTo(b.getKorisnickoIme().toLowerCase());
        }

    }

    class SortSifarniciById implements Comparator<Sifarnici> {

        @Override
        public int compare(Sifarnici a, Sifarnici b) {
            return a.getIdSifarnik() - b.getIdSifarnik();
        }

    }

    class SortStavkeSifarnikaById implements Comparator<StavkeSifarnika> {

        @Override
        public int compare(StavkeSifarnika a, StavkeSifarnika b) {
            return a.getIdStavka() - b.getIdStavka();
        }

    }

    class SortObavestenjaByDatum implements Comparator<Obavestenja> {

        @Override
        public int compare(Obavestenja a, Obavestenja b) {
            return a.getDatum().compareTo(b.getDatum());
        }
    }

    public Admin() {
        currentPage = 0;
        numOfShowedItems = 0;
        numOfTotalItems = 0;

        page = "adminNeodobreni.xhtml";

        sifarnici = stavkeHelper.getSifarnici();
        pageSifarnici = sifarnici.get(0).getIdSifarnik();

        /*stavkeSifarnika = new ArrayList<StavkeSifarnika>(sifarnici.get(0).getStavkeSifarnikas());
        Collections.sort(stavkeSifarnika, new Admin.SortStavkeSifarnikaById());*/
    }

    public List<Korisnici> getKorisnici() {
        if (numOfTotalItems == 0) {
            numOfTotalItems = korisniciHelper.getKorisniciTotalCount(page, kljucneReci);
            korisnici = new ArrayList<Korisnici>();
            korisnici.addAll(korisniciHelper.getKorisnici(page, kljucneReci, currentPage, pageLength, numOfShowedItems));
            numOfShowedItems = korisnici.size();
            currentPage++;
        }

        return korisnici;
    }

    public void setKorisnici(List<Korisnici> korisnici) {
        this.korisnici = korisnici;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;

        numOfTotalItems = 0;
        numOfShowedItems = 0;
        currentPage = 0;
        
        kljucneReci = "";
        /*
        if (page.equals("adminNeodobreni.xhtml")) {
            korisnici = korisniciHelper.getNeodobreniKorisnici();
            Collections.sort(korisnici, new Admin.SortKorisniciByKorIme());
        }
        if (page.equals("adminOdobreni.xhtml")) {
            korisnici = korisniciHelper.getOdobreniKorisnici();
            Collections.sort(korisnici, new Admin.SortKorisniciByKorIme());
        }
         */
 /*if (page.equals("adminAdmini.xhtml")) {
            korisnici = korisniciHelper.getSviAdmini();
        }*/
    }

    public void obrisiKorisnika() {
        if (selektovanKorisnikBrisanje != null) {
            korisniciHelper.obrisiKorisnika(selektovanKorisnikBrisanje);

            numOfShowedItems--;
            numOfTotalItems--;

            for (Korisnici korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equals(selektovanKorisnikBrisanje.getKorisnickoIme())) {
                    korisnici.remove(korisnik);
                    break;
                }
            }

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali korisnika.", null);
            FacesContext.getCurrentInstance().addMessage("izmena_podataka:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public void prihvatiKorisnika() {
        return;
    }

    public Korisnici getSelektovanKorisnikBrisanje() {
        return selektovanKorisnikBrisanje;
    }

    public void setSelektovanKorisnikBrisanje(Korisnici selektovanKorisnikBrisanje) {
        this.selektovanKorisnikBrisanje = selektovanKorisnikBrisanje;
    }

    public Korisnici getSelektovanKorisnikPrihvatanje() {
        return selektovanKorisnikPrihvatanje;
    }

    public void setSelektovanKorisnikPrihvatanje(Korisnici selektovanKorisnikPrihvatanje) {
        this.selektovanKorisnikPrihvatanje = selektovanKorisnikPrihvatanje;
    }

    public void odobriKorisnika() {
        if (selektovanKorisnikPrihvatanje != null) {
            selektovanKorisnikPrihvatanje.setOdobren(true);
            korisniciHelper.updateKorisnikOdobren(selektovanKorisnikPrihvatanje);

            numOfShowedItems--;
            numOfTotalItems--;

            for (Korisnici korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equals(selektovanKorisnikPrihvatanje.getKorisnickoIme())) {
                    korisnici.remove(korisnik);
                    break;
                }
            }

            //this.setPage(page);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste odobrili korisnikov zahtev za registraciju.", null);
            FacesContext.getCurrentInstance().addMessage("izmena_podataka:growl-success", message);
            //FacesContext.getCurrentInstance().addMessage("korisnici:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Dogadjaji getSelektovanDogadjajBrisanje() {
        return selektovanDogadjajBrisanje;
    }

    public void setSelektovanDogadjajBrisanje(Dogadjaji selektovanDogadjajBrisanje) {
        this.selektovanDogadjajBrisanje = selektovanDogadjajBrisanje;
    }

    public void obrisiDogadjaj() {
        if (selektovanDogadjajBrisanje != null) {
            dogadjajiHelper.obrisiDogadjaj(selektovanDogadjajBrisanje);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali događaj.", null);
            FacesContext.getCurrentInstance().addMessage("dogadjaj:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Vesti getSelektovanaVestBrisanje() {
        return selektovanaVestBrisanje;
    }

    public void setSelektovanaVestBrisanje(Vesti selektovanaVestBrisanje) {
        this.selektovanaVestBrisanje = selektovanaVestBrisanje;
    }

    public void obrisiVest() {
        if (selektovanaVestBrisanje != null) {
            vestiHelper.obrisiVest(selektovanaVestBrisanje);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali vest.", null);
            FacesContext.getCurrentInstance().addMessage("vest:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Vesti getSelektovanaVestArhiviranje() {
        return selektovanaVestArhiviranje;
    }

    public void setSelektovanaVestArhiviranje(Vesti selektovanaVestArhiviranje) {
        this.selektovanaVestArhiviranje = selektovanaVestArhiviranje;
    }

    public void arhivirajVest() {
        if (selektovanaVestArhiviranje != null) {
            selektovanaVestArhiviranje.setArhivirana(1);
            vestiHelper.arhiviranjeVesti(selektovanaVestArhiviranje);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste arhivirali vest.", null);
            FacesContext.getCurrentInstance().addMessage("vest:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Oglasi getSelektovanOglasBrisanje() {
        return selektovanOglasBrisanje;
    }

    public void setSelektovanOglasBrisanje(Oglasi selektovanOglasBrisanje) {
        this.selektovanOglasBrisanje = selektovanOglasBrisanje;
    }

    public void obrisiOglas() {
        if (selektovanOglasBrisanje != null) {
            oglasiHelper.obrisiOglas(selektovanOglasBrisanje);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali oglas.", null);
            FacesContext.getCurrentInstance().addMessage("oglas:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public void izmeniVest() {

    }

    public List<Sifarnici> getSifarnici() {
        return sifarnici;
    }

    public int getPageSifarnici() {
        return pageSifarnici;
    }

    public void setPageSifarnici(int pageSifarnici) {
        /*this.pageSifarnici = pageSifarnici;

        stavkeSifarnika = new ArrayList<StavkeSifarnika>(stavkeHelper.getStavkeByIdSifarnik(pageSifarnici).getStavkeSifarnikas());
        Collections.sort(stavkeSifarnika, new SortStavkeSifarnikaById());
         */

        this.pageSifarnici = pageSifarnici;

        numOfTotalItems = 0;
        numOfShowedItems = 0;
        currentPage = 0;
        
        kljucneReci = "";
    }

    public List<StavkeSifarnika> getStavkeSifarnika() {
        if (numOfTotalItems == 0) {
            numOfTotalItems = stavkeHelper.pretragaSifarnikaTotalCount(pageSifarnici, kljucneReci);
            stavkeSifarnika = new ArrayList<StavkeSifarnika>();
            stavkeSifarnika.addAll(stavkeHelper.pretragaSifarnika(pageSifarnici, kljucneReci, currentPage, pageLength, numOfShowedItems));
            numOfShowedItems = stavkeSifarnika.size();
            currentPage++;
        }

        return stavkeSifarnika;
    }

    public void setStavkeSifarnika(List<StavkeSifarnika> stavkeSifarnika) {
        this.stavkeSifarnika = stavkeSifarnika;
    }

    public boolean stavkaValidacija(String stavka) {
        switch (pageSifarnici) {
            case 1: {
                if (stavka.isEmpty()) {
                    stavkaGreska = "Polje ne sme ostati prazno.";
                    return false;
                }
                if (!stavka.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
                    stavkaGreska = "Polje ne sme sadržati numerike i specijalne karaktere.";
                    return false;
                }

                stavkaGreska = "";
                return true;
            }
            case 2: {
                if (stavka.isEmpty()) {
                    stavkaGreska = "Polje ne sme ostati prazno.";
                    return false;
                }
                if (!stavka.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
                    stavkaGreska = "Polje ne sme sadržati numerike i specijalne karaktere.";
                    return false;
                }

                stavkaGreska = "";
                return true;
            }
            case 3: {
                if (stavka.isEmpty()) {
                    stavkaGreska = "Polje ne sme ostati prazno.";
                    return false;
                }
                if (!stavka.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
                    stavkaGreska = "Polje ne sme sadržati numerike i specijalne karaktere.";
                    return false;
                }

                stavkaGreska = "";
                return true;
            }
            case 4: {
                if (stavka.isEmpty()) {
                    stavkaGreska = "Polje ne sme ostati prazno.";
                    return false;
                }

                stavkaGreska = "";
                return true;
            }
            case 5: {
                if (stavka.isEmpty()) {
                    stavkaGreska = "Polje ne sme ostati prazno.";
                    return false;
                }
                if (!stavka.matches("[a-zA-ZčćšđžČĆŠĐŽ0-9 ]+")) {
                    stavkaGreska = "Polje sme sadržati samo slova i numeričke karaktere.";
                    return false;
                }

                stavkaGreska = "";
                return true;
            }
            case 6: {
                if (stavka.isEmpty()) {
                    stavkaGreska = "Polje ne sme ostati prazno.";
                    return false;
                }
                if (!stavka.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
                    stavkaGreska = "Polje ne sme sadržati numerike i specijalne karaktere.";
                    return false;
                }

                stavkaGreska = "";
                return true;
            }
            case 7: {
                if (stavka.isEmpty()) {
                    stavkaGreska = "Polje ne sme ostati prazno.";
                    return false;
                }

                stavkaGreska = "";
                return true;
            }
        }

        return true;
    }

    public void izmeniStavku() {
        if (selectedStavkaSifarnikaIzmena != null) {
            if (stavkaValidacija(stavka)) {
                if (stavkeHelper.getStavkeSifarnikaBySifarnikAndNaziv(pageSifarnici, stavka, selectedStavkaSifarnikaIzmena.getIdStavka()) == null) {
                    selectedStavkaSifarnikaIzmena.setNaziv(stavka);

                    if (menjanThumbnail) {
                        if (selectedStavkaSifarnikaIzmena.getIkonica() != null) {
                            File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("thumbnailsIkonice"));
                            File file = new File(uploads, selectedStavkaSifarnikaIzmena.getIkonica());

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
                                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    selectedStavkaSifarnikaIzmena.setIkonica(newThumbnailName);
                                } else {
                                    selectedStavkaSifarnikaIzmena.setIkonica(null);
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            if (submittedThumbnail != null) {
                                UUID uid = UUID.randomUUID();
                                String newThumbnailName = uid + ".";
                                int i = submittedThumbnail.getSubmittedFileName().lastIndexOf('.');
                                if (i > 0) {
                                    newThumbnailName += submittedThumbnail.getSubmittedFileName().substring(i + 1);
                                }

                                File uploads = new File(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("thumbnailsIkonice"));
                                File file = new File(uploads, newThumbnailName);

                                try (InputStream input = submittedThumbnail.getInputStream()) {
                                    Files.copy(input, file.toPath());
                                } catch (IOException ex) {
                                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                selectedStavkaSifarnikaIzmena.setIkonica(newThumbnailName);
                            } else {
                                selectedStavkaSifarnikaIzmena.setIkonica(null);
                            }
                        }
                    }

                    for (int i = 0; i < stavkeSifarnika.size(); i++) {
                        if (stavkeSifarnika.get(i).getIdStavka() == selectedStavkaSifarnikaIzmena.getIdStavka()) {
                            stavkeSifarnika.remove(i);
                            stavkeSifarnika.add(i, selectedStavkaSifarnikaIzmena);
                            break;
                        }
                    }

                    stavkeHelper.updateStavka(selectedStavkaSifarnikaIzmena);

                    stavkaGreska = "";
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste izmenili stavku šifarnika.", null);
                    FacesContext.getCurrentInstance().addMessage("sifarnici:growl-success", message);
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                    closeModalScript = "$('#sifarnici\\\\:amodal_izmena').modal('hide'); $('html, body').animate({ scrollTop: 0 }, 'slow');";
                } else {
                    stavkaGreska = "Stavka šifarnika sa zadatim nazivom već postoji.";
                    closeModalScript = "";
                }
            } else {
                closeModalScript = "";
            }
        }
    }

    public StavkeSifarnika getSelectedStavkaSifarnikaIzmena() {
        return selectedStavkaSifarnikaIzmena;
    }

    public void setSelectedStavkaSifarnikaIzmena(StavkeSifarnika selectedStavkaSifarnikaIzmena) {
        this.selectedStavkaSifarnikaIzmena = selectedStavkaSifarnikaIzmena;
    }

    public StavkeSifarnika getSelectedStavkaSifarnikaBrisanje() {
        return selectedStavkaSifarnikaBrisanje;
    }

    public void setSelectedStavkaSifarnikaBrisanje(StavkeSifarnika selectedStavkaSifarnikaBrisanje) {
        this.selectedStavkaSifarnikaBrisanje = selectedStavkaSifarnikaBrisanje;
    }

    public void obrisiStavku() {
        if (getSelectedStavkaSifarnikaBrisanje() != null) {
            stavkeHelper.obrisiStavku(selectedStavkaSifarnikaBrisanje);

            numOfShowedItems--;
            numOfTotalItems--;

            for (StavkeSifarnika stavka : stavkeSifarnika) {
                if (stavka.getIdStavka() == selectedStavkaSifarnikaBrisanje.getIdStavka()) {
                    stavkeSifarnika.remove(stavka);
                    break;
                }
            }

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste obrisali stavku šifarnika.", null);
            FacesContext.getCurrentInstance().addMessage("sifarnici:growl-success", message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public String getStavka() {
        return stavka;
    }

    public void setStavka(String stavka) {
        this.stavka = stavka;
    }

    public String getStavkaGreska() {
        return stavkaGreska;
    }

    public void setStavkaGreska(String stavkaGreska) {
        this.stavkaGreska = stavkaGreska;
    }

    public String getCloseModalScript() {
        return closeModalScript;
    }

    public void setCloseModalScript(String closeModalScript) {
        this.closeModalScript = closeModalScript;
    }

    public String getNovaStavka() {
        return novaStavka;
    }

    public void setNovaStavka(String novaStavka) {
        this.novaStavka = novaStavka;
    }

    public String getNovaStavkaGreska() {
        return novaStavkaGreska;
    }

    public void setNovaStavkaGreska(String novaStavkaGreska) {
        this.novaStavkaGreska = novaStavkaGreska;
    }

    public void dodajStavku() {

        if (stavkaValidacija(this.novaStavka)) {
            if (stavkeHelper.getStavkeSifarnikaBySifarnikAndNaziv(pageSifarnici, this.novaStavka) == null) {
                StavkeSifarnika novaStavka = new StavkeSifarnika();
                novaStavka.setIdStavka(stavkeHelper.getMaxId() + 1);
                Sifarnici sifarnik = stavkeHelper.getSifarnikById(pageSifarnici);
                novaStavka.setSifarnici(sifarnik);
                novaStavka.setNaziv(this.novaStavka);

                stavkeHelper.insertStavka(novaStavka);
                numOfShowedItems++;
                numOfTotalItems++;

                this.novaStavka = "";
                novaStavkaGreska = "";
                setInsertSuccessfulScript("$('html, body').animate({ scrollTop: 0 }, 'slow');");

                if (stavkeSifarnika != null) {
                    stavkeSifarnika.add(0, novaStavka);
                } else {
                    stavkeSifarnika = new ArrayList<StavkeSifarnika>();
                    stavkeSifarnika.add(novaStavka);
                }

                /*if (sifarnik != null) {
                    stavkeSifarnika = new ArrayList<StavkeSifarnika>(sifarnik.getStavkeSifarnikas());
                    Collections.sort(stavkeSifarnika, new Admin.SortStavkeSifarnikaById());
                }*/
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste dodali stavku šifarnika.", null);
                FacesContext.getCurrentInstance().addMessage("sifarnici:growl-success", message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            } else {
                novaStavkaGreska = "Stavka šifarnika sa zadatim nazivom već postoji.";
                setInsertSuccessfulScript("");
            }
        } else {
            novaStavkaGreska = stavkaGreska;
            setInsertSuccessfulScript("");
        }
    }

    public void proveriBrisanje(StavkeSifarnika stavka) {
        selectedStavkaSifarnikaBrisanje = stavka;
        if (selectedStavkaSifarnikaBrisanje != null) {
            switch (selectedStavkaSifarnikaBrisanje.getSifarnici().getIdSifarnik()) {
                case 1: {
                    postojeEntiteti = !vestiHelper.getVestiByKategorija(selectedStavkaSifarnikaBrisanje).isEmpty();
                    postojeEntitetiPoruka = postojeEntiteti ? "Postoje vesti sa selektovanom kategorijom. Brisanjem ove stavke brišete i sve vesti koje pripadaju selektovanoj kategoriji." : "";
                    break;
                }
                case 2: {
                    postojeEntiteti = !dogadjajiHelper.getDogadjajiByKategorija2(selectedStavkaSifarnikaBrisanje).isEmpty();
                    postojeEntitetiPoruka = postojeEntiteti ? "Postoje događaji sa selektovanom kategorijom. Brisanjem ove stavke brišete i sve događaje koji pripadaju selektovanoj kategoriji." : "";
                    break;
                }
                case 3: {
                    postojeEntiteti = false;
                    if (!korisniciHelper.getOrganizacijeByMesto(selectedStavkaSifarnikaBrisanje).isEmpty()) {
                        postojeEntiteti = true;
                    }
                    if (!dogadjajiHelper.getDogadjajiByMesto(selectedStavkaSifarnikaBrisanje).isEmpty()) {
                        postojeEntiteti = true;
                    }
                    postojeEntitetiPoruka = postojeEntiteti ? "Postoje Događaji i/ili organizacije sa selektovanim mestom. Brisanjem ove stavke brišete i sva mesta i/ili događaje sa selektovanim mestom." : "";
                    break;
                }
                case 4: {
                    postojeEntiteti = !dogadjajiHelper.getDogadjajiByUzrast(selectedStavkaSifarnikaBrisanje).isEmpty();
                    postojeEntitetiPoruka = postojeEntiteti ? "Postoje događaji sa selektovanim uzrastom. Brisanjem ove stavke brišete i sve događaje sa selektovanim uzrastom." : "";
                    break;
                }
                case 5: {
                    postojeEntiteti = false;
                    if (!korisniciHelper.getOrganizacijeByUlica(selectedStavkaSifarnikaBrisanje).isEmpty()) {
                        postojeEntiteti = true;
                    }
                    if (!dogadjajiHelper.getDogadjajiByUlica(selectedStavkaSifarnikaBrisanje).isEmpty()) {
                        postojeEntiteti = true;
                    }
                    postojeEntitetiPoruka = postojeEntiteti ? "Postoje Događaji i/ili organizacije sa selektovanim mestom. Brisanjem ove stavke brišete i sva mesta i/ili događaje sa selektovanim mestom." : "";
                    break;
                }
                case 6: {
                    postojeEntiteti = !korisniciHelper.getOrganizacijeByOblastDelovanja(selectedStavkaSifarnikaBrisanje).isEmpty();
                    postojeEntitetiPoruka = postojeEntiteti ? "Postoje organizacije sa selektovanom oblasti delovanja. Brisanjem ove stavke brišete i sve organizacije sa selektovanom oblasti delovanja." : "";
                    break;
                }
                case 7: {
                    postojeEntiteti = !karakteristikeHelper.getKarakteristikeByStavka(selectedStavkaSifarnikaBrisanje).isEmpty();
                    postojeEntitetiPoruka = postojeEntiteti ? "Postoje događaji sa selektovanom karakteristikom prostora. Da li ste sigurni da želite da obrišete selektovanu karakteristiku prostora? (Brisanjem ove stavke ne brišete događaje sa selektovanom karakteristikom prostora)" : "";
                    break;
                }
            }
        }
    }

    public boolean isPostojeEntiteti() {
        return postojeEntiteti;
    }

    public void setPostojeEntiteti(boolean postojeEntiteti) {
        this.postojeEntiteti = postojeEntiteti;
    }

    public String getPostojeEntitetiPoruka() {
        return postojeEntitetiPoruka;
    }

    public void setPostojeEntitetiPoruka(String postojeEntitetiPoruka) {
        this.postojeEntitetiPoruka = postojeEntitetiPoruka;
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
                    thumbnailGreska = "Veličina file-a ne sme biti veća od 500KB.";
                    thumbnail = null;
                    submittedThumbnail = null;
                    setThumbnailName(null);
                } else {
                    thumbnailGreska = "";
                    this.submittedThumbnail = thumbnail;
                    setMenjanThumbnail(true);
                    setThumbnailName(thumbnail.getSubmittedFileName());
                }
            } catch (Exception e) {
                thumbnailGreska = "File koji ste odabrali ne odgovara formatu slike.";
                thumbnail = null;
                submittedThumbnail = null;
                setThumbnailName(null);
            }
        } catch (IOException e) {
            thumbnailGreska = "Došlo je do greške prilikom upload-ovanja file-a. Molimo, pokušajte ponovo.";
            thumbnail = null;
            submittedThumbnail = null;
            setThumbnailName(null);
        }
    }

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
    }

    public boolean isMenjanThumbnail() {
        return menjanThumbnail;
    }

    public void setMenjanThumbnail(boolean menjanThumbnail) {
        this.menjanThumbnail = menjanThumbnail;
    }

    public List<Obavestenja> getObavestenja() {
        return obavestenja;
    }

    public void setObavestenja(List<Obavestenja> obavestenja) {
        this.obavestenja = obavestenja;
    }

    /*
    public int brNovihObavestenja() {
        if (obavestenja != null) {
            int br = 0;
            for (Obavestenja o : obavestenja) {
                if (!o.isProcitano()) {
                    br++;
                }
            }
            return br;
        }
        return 0;
    }
     */
    public void procitajObavestenja() {
        /*if (obavestenja != null) {
            for (Obavestenja o : obavestenja) {
                o.setProcitano(true);
                obavestenjaHelper.updateObavestenje(o);
            }
        }*/
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }

    public int getNumOfShowedItems() {
        return numOfShowedItems;
    }

    public void setNumOfShowedItems(int numOfShowedItems) {
        this.numOfShowedItems = numOfShowedItems;
    }

    public long getNumOfTotalItems() {
        return numOfTotalItems;
    }

    public void setNumOfTotalItems(long numOfTotalItems) {
        this.numOfTotalItems = numOfTotalItems;
    }

    public void currentPageIncrement() {
        stavkeSifarnika.addAll(stavkeHelper.pretragaSifarnika(pageSifarnici, kljucneReci, currentPage, pageLength, numOfShowedItems));
        numOfShowedItems = stavkeSifarnika.size();
        currentPage++;
    }

    public void currentPageKorisniciIncrement() {
        korisnici.addAll(korisniciHelper.getKorisnici(page, kljucneReci, currentPage, pageLength, numOfShowedItems));
        numOfShowedItems = korisnici.size();
        currentPage++;
    }

    public void currentPageObavestenjaIncrement() {
        List<Obavestenja> novaObavestenja = obavestenjaHelper.getObavestenja(currentPage, pageLength);
        for (Obavestenja obavestenje : novaObavestenja) {
            if (!obavestenje.isProcitano()) {
                obavestenjaHelper.setObavestenjeProcitano(new Obavestenja(obavestenje));
            }
        }
        obavestenja.addAll(novaObavestenja);
        numOfShowedItems = obavestenja.size();
        currentPage++;
    }

    public String getInsertSuccessfulScript() {
        return insertSuccessfulScript;
    }

    public void setInsertSuccessfulScript(String insertSuccessfulScript) {
        this.insertSuccessfulScript = insertSuccessfulScript;
    }

    public void redirectToKorisnici() {
        adminStrana = 1;
        numOfTotalItems = 0;
        numOfShowedItems = 0;
        currentPage = 0;
        page = "adminNeodobreni.xhtml";
        kljucneReci = "";
    }

    public void redirectToSifarnici() {
        adminStrana = 2;
        numOfShowedItems = 0;
        numOfTotalItems = 0;
        currentPage = 0;
        pageSifarnici = sifarnici.get(0).getIdSifarnik();
        kljucneReci = "";
    }

    public void redirectToObavestenja() {
        adminStrana = 3;
        numOfShowedItems = 0;
        numOfTotalItems = 0;
        currentPage = 0;

        numOfTotalItems = obavestenjaHelper.getObavestenjaTotalCount();
        obavestenja = new ArrayList<Obavestenja>();
        List<Obavestenja> novaObavestenja = obavestenjaHelper.getObavestenja(currentPage, pageLength);
        for (Obavestenja obavestenje : novaObavestenja) {
            if (!obavestenje.isProcitano()) {
                obavestenjaHelper.setObavestenjeProcitano(new Obavestenja(obavestenje));
            }
        }
        obavestenja.addAll(novaObavestenja);
        numOfShowedItems = obavestenja.size();
        currentPage++;

    }

    public long getBrNovihObavestenja() {
        return obavestenjaHelper.getBrNovihObavestenja();
    }

    public void setBrNovihObavestenja(long brNovihObavestenja) {
        this.brNovihObavestenja = brNovihObavestenja;
    }

    public int getAdminStrana() {
        return adminStrana;
    }

    public void setAdminStrana(int adminStrana) {
        this.adminStrana = adminStrana;
    }

    public String getKljucneReci() {
        return kljucneReci;
    }

    public void setKljucneReci(String kljucneReci) {
        this.kljucneReci = kljucneReci;
    }

    public void pretraga() {
        numOfShowedItems = 0;
        numOfTotalItems = 0;
        currentPage = 0;
    }

}
