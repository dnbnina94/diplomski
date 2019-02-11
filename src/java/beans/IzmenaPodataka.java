/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import db.Organizacije;
import db.StavkeSifarnika;
import db.helpers.KorisniciHelper;
import db.helpers.StavkeSifarnikaHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Nina
 */
public class IzmenaPodataka {

    private KorisniciHelper korHelper = new KorisniciHelper();
    private StavkeSifarnikaHelper stavkeHelper = new StavkeSifarnikaHelper();

    private String nazivOrg;
    private String nazivOrgGreska = "";

    private String opisOrg;
    private String opisOrgGreska = "";

    private String oblastDelovanja;
    private String oblastDelovanjaGreska = "";

    private String webAdresa;
    private String webAdresaGreska = "";

    private String mesto;
    private String mestoGreska = "";

    private String ulica;
    private String ulicaGreska = "";

    private String kontaktOsoba;
    private String kontaktOsobaGreska = "";

    private String email;
    private String emailGreska = "";

    private List<String> telefoni = new ArrayList<String>();
    private String telefon;
    private String telefonGreska = "";

    private String saveFieldJs = "";

    private String staraLozinka;
    private String staraLozinkaGreska = "";

    private String novaLozinka;
    private String novaLozinkaGreska = "";

    private String ponovljenaNovaLozinka;
    private String ponovljenaNovaLozinkaGreska = "";

    public IzmenaPodataka() {

    }

    public String getNazivOrg() {
        return nazivOrg;
    }

    public void setNazivOrg(String nazivOrg) {
        this.nazivOrg = nazivOrg.trim().replaceAll(" +", " ");
    }

    public String getNazivOrgGreska() {
        return nazivOrgGreska;
    }

    public void setNazivOrgGreska(String nazivOrgGreska) {
        this.nazivOrgGreska = nazivOrgGreska;
    }

    public String getOpisOrg() {
        return opisOrg;
    }

    public void setOpisOrg(String opisOrg) {
        this.opisOrg = opisOrg.trim().replaceAll(" +", " ");
    }

    public String getOpisOrgGreska() {
        return opisOrgGreska;
    }

    public void setOpisOrgGreska(String opisOrgGreska) {
        this.opisOrgGreska = opisOrgGreska;
    }

    public String getOblastDelovanja() {
        return oblastDelovanja;
    }

    public void setOblastDelovanja(String oblastDelovanja) {
        this.oblastDelovanja = oblastDelovanja.trim().replaceAll(" +", " ");
    }

    public String getOblastDelovanjaGreska() {
        return oblastDelovanjaGreska;
    }

    public void setOblastDelovanjaGreska(String oblastDelovanjaGreska) {
        this.oblastDelovanjaGreska = oblastDelovanjaGreska;
    }

    public String getWebAdresa() {
        return webAdresa;
    }

    public void setWebAdresa(String webAdresa) {
        this.webAdresa = webAdresa.trim().replaceAll(" +", "");
        if (!this.webAdresa.isEmpty()) {
            if (!this.webAdresa.toLowerCase().startsWith("http://") && !this.webAdresa.toLowerCase().startsWith("https://") && !this.webAdresa.toLowerCase().startsWith("ftp://")) {
                this.webAdresa = "http://" + this.webAdresa;
            }
        }
    }

    public String getWebAdresaGreska() {
        return webAdresaGreska;
    }

    public void setWebAdresaGreska(String webAdresaGreska) {
        this.webAdresaGreska = webAdresaGreska;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto.trim().replaceAll(" +", " ");
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
        this.ulica = ulica.trim().replaceAll(" +", " ");
    }

    public String getUlicaGreska() {
        return ulicaGreska;
    }

    public void setUlicaGreska(String ulicaGreska) {
        this.ulicaGreska = ulicaGreska;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba.trim().replaceAll(" +", " ");
    }

    public String getKontaktOsobaGreska() {
        return kontaktOsobaGreska;
    }

    public void setKontaktOsobaGreska(String kontaktOsobaGreska) {
        this.kontaktOsobaGreska = kontaktOsobaGreska;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailGreska() {
        return emailGreska;
    }

    public void setEmailGreska(String emailGreska) {
        this.emailGreska = emailGreska;
    }

    public List<String> getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(List<String> telefoni) {
        this.telefoni = telefoni;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefonGreska() {
        return telefonGreska;
    }

    public void setTelefonGreska(String telefonGreska) {
        this.telefonGreska = telefonGreska;
    }

    public boolean telefonValidacija(String tel) {
        if (tel.length() < 7 || tel.length() > 15 || !tel.matches("[0-9]+")) {
            telefonGreska = "Telefon mora sadržati između 7 i 15 numeričkih karaktera.";
            return false;
        }

        telefonGreska = "";
        return true;
    }

    public void addTelefon() {
        boolean valid = telefonValidacija(telefon);

        for (int i = 0; i < telefoni.size(); i++) {
            if (telefoni.get(i).equals(telefon)) {
                telefonGreska = "Već ste uneli zadati telefon.";
                valid = false;
                break;
            }
        }

        if (telefoni.size() == 5) {
            telefonGreska = "Možete uneti maksimalno 5 brojeva telefona.";
            valid = false;
        }

        if (valid) {
            telefoni.add(telefon);
            telefon = "";
        }

    }

    public void removeTelefon(int status) {
        telefoni.remove(status);

        if (!telefon.matches("[0-9]+") && !telefon.isEmpty()) {
            telefonGreska = "Telefon mora sadržati između 7 i 15 numeričkih karaktera.";
        }
    }

    public void editNaziv(String naziv) {
        this.setNazivOrg(naziv);
        nazivOrgGreska = "";
    }

    public void editOpis(String opis) {
        this.setOpisOrg(opis);
        opisOrgGreska = "";
    }

    public void editOblastDelovanja(String oblastDelovanja) {
        this.setOblastDelovanja(oblastDelovanja);
        oblastDelovanjaGreska = "";
    }

    public void editWebAdresa(String webAdresa) {
        this.setWebAdresa(webAdresa);
        webAdresaGreska = "";
    }

    public void editMestoUlica(String mesto, String ulica) {
        this.setMesto(mesto);
        this.setUlica(ulica);
        mestoGreska = "";
        ulicaGreska = "";
    }

    public void editKontaktOsoba(String kontaktOsoba) {
        this.setKontaktOsoba(kontaktOsoba);
        kontaktOsobaGreska = "";
    }

    public void editEmail(String email) {
        this.setEmail(email);
        emailGreska = "";
    }

    public void editTelefoni(String telefoni) {
        this.telefoni = new ArrayList<String>();

        String[] telefoniArray = telefoni.replaceAll("\\s+", "").split("\\,");

        for (String t : telefoniArray) {
            this.telefoni.add(t);
        }

        telefon = "";
        telefonGreska = "";
    }

    public void editLozinka() {
        this.setStaraLozinka("");
        this.setNovaLozinka("");
        this.setPonovljenaNovaLozinka("");

        staraLozinkaGreska = "";
        novaLozinkaGreska = "";
        ponovljenaNovaLozinkaGreska = "";
    }

    public boolean nazivOrgValidacija() {
        if (nazivOrg.isEmpty()) {
            nazivOrgGreska = "Polje 'Naziv organizacije' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        nazivOrgGreska = "";
        saveFieldJs = "closeField('NazivOrg')";
        return true;
    }

    public void sacuvajNaziv() {
        if (nazivOrgValidacija()) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();

            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setNaziv(nazivOrg);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
            }

            OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
            organizacijaBean.getOrganizacija().setNaziv(nazivOrg);
            elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

            korHelper.updateOrganizacijaNaziv(nazivOrg, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }
    }

    public boolean opisOrgValidacija() {
        if (opisOrg.isEmpty()) {
            opisOrgGreska = "Polje 'Opis organizacije' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        opisOrgGreska = "";
        saveFieldJs = "closeField('OpisOrg')";
        return true;
    }

    public void sacuvajOpis() {
        if (opisOrgValidacija()) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();

            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setTekst(opisOrg);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
            }

            OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
            organizacijaBean.getOrganizacija().setTekst(opisOrg);
            elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

            korHelper.updateOrganizacijaOpis(opisOrg, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }
    }

    public boolean oblastDelovanjaValidacija() {
        if (oblastDelovanja.isEmpty()) {
            oblastDelovanjaGreska = "Polje 'Oblast delovanja' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        if (!oblastDelovanja.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
            oblastDelovanjaGreska = "Polje 'Oblast delovanja' ne sme sadržati numerike i specijalne karaktere.";
            saveFieldJs = "";
            return false;
        }

        oblastDelovanjaGreska = "";
        saveFieldJs = "closeField('OblastDelovanja')";
        return true;
    }

    public void sacuvajOblastDelovanja() {
        if (oblastDelovanjaValidacija()) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();

            StavkeSifarnika oblDelovanja = stavkeHelper.getStavkaByNaziv(oblastDelovanja);
            if (oblDelovanja == null) {
                oblDelovanja = new StavkeSifarnika(stavkeHelper.getMaxId() + 1, stavkeHelper.getStavkeByIdSifarnik(6), oblastDelovanja, null);
                stavkeHelper.insertStavka(oblDelovanja);
            }

            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setOblastDelovanja(oblDelovanja);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
            }

            OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
            organizacijaBean.getOrganizacija().setOblastDelovanja(oblDelovanja);
            elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

            korHelper.updateOrganizacijaOblastDelovanja(oblDelovanja, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }
    }

    public boolean webAdresaValidacija() {
        try {
            URL url = new URL(webAdresa);
        } catch (MalformedURLException e) {
            webAdresaGreska = "Web stranica koju ste uneli ne odgovara URL formatu.";
            saveFieldJs = "";
            return false;
        }

        webAdresaGreska = "";
        return true;
    }

    public void sacuvajWebAdresa() {
        if ((!webAdresa.isEmpty() && webAdresaValidacija()) || webAdresa.isEmpty()) {
            saveFieldJs = "closeField('WebAdresa')";

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();

            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setWebAdresa(webAdresa);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
            }

            OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
            organizacijaBean.getOrganizacija().setWebAdresa(webAdresa);
            elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

            korHelper.updateOrganizacijaWebAdresa(webAdresa, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }
    }

    public boolean kontaktOsobaValidacija() {
        if (kontaktOsoba.isEmpty()) {
            kontaktOsobaGreska = "Polje 'Kontakt osoba' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        if (!kontaktOsoba.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
            kontaktOsobaGreska = "Polje 'Kontakt osoba' ne sme sadržati numerike i specijalne karaktere.";
            saveFieldJs = "";
            return false;
        }

        kontaktOsobaGreska = "";
        saveFieldJs = "closeField('KontaktOsoba')";
        return true;
    }

    public void sacuvajKontaktOsoba() {
        if (kontaktOsobaValidacija()) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();

            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setKontaktOsoba(kontaktOsoba);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
            }

            OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
            organizacijaBean.getOrganizacija().setKontaktOsoba(kontaktOsoba);
            elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

            korHelper.updateOrganizacijaKontaktOsoba(kontaktOsoba, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }
    }

    public boolean emailValidacija() {
        if (email.isEmpty()) {
            emailGreska = "Polje 'Email adresa' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        if (!email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+")) {
            emailGreska = "Email adresa koju ste uneli ne odgovara email formatu.";
            saveFieldJs = "";
            return false;
        }

        if (korHelper.getOrganizacijaByEmail(email) != null) {
            emailGreska = "Email adresa koju ste uneli je već navedena od strane druge organizacije.";
            saveFieldJs = "";
            return false;
        }

        emailGreska = "";
        saveFieldJs = "closeField('Email')";
        return true;
    }

    public void sacuvajEmail() {
        if (emailValidacija()) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();

            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setEmail(email);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
            }

            OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
            organizacijaBean.getOrganizacija().setEmail(email);
            elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

            korHelper.updateOrganizacijaEmail(email, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }
    }

    public boolean mestoValidacija() {
        if (mesto.isEmpty()) {
            mestoGreska = "Polje 'Mesto' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        if (!mesto.matches("[a-zA-ZčćšđžČĆŠĐŽ ]+")) {
            mestoGreska = "Polje 'Mesto' ne sme sadržati numerike i specijalne karaktere.";
            saveFieldJs = "";
            return false;
        }

        mestoGreska = "";
        return true;
    }

    public boolean ulicaValidacija() {
        if (ulica.isEmpty()) {
            ulicaGreska = "Polje 'Ulica' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        if (!ulica.matches("[a-zA-ZčćšđžČĆŠĐŽ0-9 ]+")) {
            ulicaGreska = "Polje 'Ulica' sme sadržati samo slova i numeričke karaktere.";
            saveFieldJs = "";
            return false;
        }

        ulicaGreska = "";
        return true;
    }

    public void sacuvajMestoUlica() {
        boolean mestoValid = mestoValidacija();
        boolean ulicaValid = ulicaValidacija();

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
        OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");

        if (mestoValid) {
            StavkeSifarnika mesto = stavkeHelper.getStavkaByNaziv(this.mesto);
            if (mesto == null) {
                mesto = new StavkeSifarnika(stavkeHelper.getMaxId() + 1, stavkeHelper.getStavkeByIdSifarnik(3), this.mesto, null);
                stavkeHelper.insertStavka(mesto);
            }

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setMesto(mesto);
            }

            organizacijaBean.getOrganizacija().setMesto(mesto);
            korHelper.updateOrganizacijaMesto(mesto, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }

        if (ulicaValid) {
            StavkeSifarnika ulica = stavkeHelper.getStavkaByNaziv(this.ulica);
            if (ulica == null) {
                ulica = new StavkeSifarnika(stavkeHelper.getMaxId() + 1, stavkeHelper.getStavkeByIdSifarnik(5), this.ulica, null);
                stavkeHelper.insertStavka(ulica);
            }

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setUlica(ulica);
            }

            organizacijaBean.getOrganizacija().setUlica(ulica);
            korHelper.updateOrganizacijaUlica(ulica, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }

        if (korisnikBean.getKorisnik().getTip() != 1) {
            elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
        }
        elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

        if (mestoValid && ulicaValid) {
            saveFieldJs = "closeField('MestoUlica')";
        }

    }

    public boolean telefoniValidacija() {
        if (telefoni.isEmpty()) {
            telefonGreska = "Morate navesti makar jedan kontakt telefon.";
            saveFieldJs = "";
            return false;
        }

        telefonGreska = "";
        saveFieldJs = "closeField('Telefoni')";
        return true;
    }

    public void sacuvajTelefone() {
        if (telefoniValidacija()) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();

            String telefoniOrg = "";

            for (int i = 0; i < telefoni.size(); i++) {
                telefoniOrg += telefoni.get(i);
                if (i != (telefoni.size() - 1)) {
                    telefoniOrg += ", ";
                }
            }

            KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");

            if (korisnikBean.getKorisnik().getTip() != 1) {
                korisnikBean.getKorisnik().getOrganizacije().setTelefoni(telefoniOrg);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);
            }

            OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
            organizacijaBean.getOrganizacija().setTelefoni(telefoniOrg);
            elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

            korHelper.updateOrganizacijaTelefoni(telefoniOrg, organizacijaBean.getOrganizacija().getKorisnickoIme());
        }
    }

    public boolean staraLozinkaValidacija() {
        if (staraLozinka.isEmpty()) {
            staraLozinkaGreska = "Polje 'Stara lozinka' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
        Korisnici korisnik = korisnikBean.getKorisnik();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(korisnik.getSalt());
            byte[] hashedPassword = md.digest(staraLozinka.getBytes(StandardCharsets.UTF_8));

            if (!Arrays.equals(hashedPassword, korisnik.getLozinka())) {
                staraLozinkaGreska = "Lozinka koju ste uneli je neispravna.";
                saveFieldJs = "";
                return false;
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(IzmenaPodataka.class.getName()).log(Level.SEVERE, null, ex);
        }

        staraLozinkaGreska = "";
        return true;
    }

    public boolean novaLozinkaValidacija() {
        if (novaLozinka.isEmpty()) {
            novaLozinkaGreska = "Polje 'Nova lozinka' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(novaLozinka);
        if (matcher.find()) {
            novaLozinkaGreska = "Nova lozinka ne sme sadržati blanko karaktere.";
            saveFieldJs = "";
            return false;
        }

        if (novaLozinka.length() < 8) {
            novaLozinkaGreska = "Nova lozinka mora biti minimalne dužine od 8 karaktera.";
            saveFieldJs = "";
            return false;
        }

        if (!novaLozinka.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*(_|[^\\w])).+$")) {
            novaLozinkaGreska = "Nova lozinka mora sadržati makar jedno veliko slovo, makar 1 malo slovo, makar jedan numerik i makar jedan specijalan karakter.";
            saveFieldJs = "";
            return false;
        }

        novaLozinkaGreska = "";
        return true;
    }

    public boolean ponovljenaNovaLozinkaValidacija() {
        if (ponovljenaNovaLozinka.isEmpty()) {
            ponovljenaNovaLozinkaGreska = "Polje 'Ponovljena nova lozinka' ne sme ostati prazno.";
            saveFieldJs = "";
            return false;
        }

        if (!novaLozinka.equals(ponovljenaNovaLozinka)) {
            ponovljenaNovaLozinkaGreska = "Nova lozinka i ponovljena nova lozinka se ne poklapaju.";
            saveFieldJs = "";
            return false;
        }

        ponovljenaNovaLozinkaGreska = "";
        return true;
    }

    public void sacuvajLozinku() {
        boolean staraLozinkaValid = staraLozinkaValidacija();
        boolean novaLozinkaValid = novaLozinkaValidacija();
        boolean ponovljenaNovaLozinkaValid = ponovljenaNovaLozinkaValidacija();

        if (staraLozinkaValid && novaLozinkaValid && ponovljenaNovaLozinkaValid) {
            saveFieldJs = "closeField('Lozinka')";

            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(salt);

                byte[] hashedPassword = md.digest(novaLozinka.getBytes(StandardCharsets.UTF_8));

                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
                korisnikBean.getKorisnik().setLozinka(hashedPassword);
                korisnikBean.getKorisnik().setSalt(salt);
                elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);

                korHelper.updateOrganizacijaLozinka(hashedPassword, korisnikBean.getKorisnik().getKorisnickoIme());
                korHelper.updateOrganizacijaSalt(salt, korisnikBean.getKorisnik().getKorisnickoIme());

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(IzmenaPodataka.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            staraLozinka = "";
            novaLozinka = "";
            ponovljenaNovaLozinka = "";
        }
    }

    public String getSaveFieldJs() {
        return saveFieldJs;
    }

    public void setSaveFieldJs(String saveFieldJs) {
        this.saveFieldJs = saveFieldJs;
    }

    public String getStaraLozinka() {
        return staraLozinka;
    }

    public void setStaraLozinka(String staraLozinka) {
        this.staraLozinka = staraLozinka;
    }

    public String getNovaLozinka() {
        return novaLozinka;
    }

    public void setNovaLozinka(String novaLozinka) {
        this.novaLozinka = novaLozinka;
    }

    public String getPonovljenaNovaLozinka() {
        return ponovljenaNovaLozinka;
    }

    public void setPonovljenaNovaLozinka(String ponovljenaNovaLozinka) {
        this.ponovljenaNovaLozinka = ponovljenaNovaLozinka;
    }

    public String getStaraLozinkaGreska() {
        return staraLozinkaGreska;
    }

    public void setStaraLozinkaGreska(String staraLozinkaGreska) {
        this.staraLozinkaGreska = staraLozinkaGreska;
    }

    public String getNovaLozinkaGreska() {
        return novaLozinkaGreska;
    }

    public void setNovaLozinkaGreska(String novaLozinkaGreska) {
        this.novaLozinkaGreska = novaLozinkaGreska;
    }

    public String getPonovljenaNovaLozinkaGreska() {
        return ponovljenaNovaLozinkaGreska;
    }

    public void setPonovljenaNovaLozinkaGreska(String ponovljenaNovaLozinkaGreska) {
        this.ponovljenaNovaLozinkaGreska = ponovljenaNovaLozinkaGreska;
    }

}
