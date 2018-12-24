/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nina
 */
public class Registracija {

    private List<String> telefoni;
    private String telefon;
    private String telefonGreska = "";

    private int nextIndex = 0;
    private String script = "";

    private String nazivOrg;
    private String nazivOrgGreska = "";

    private String opisOrg;
    private String opisOrgGreska = "";

    private String oblastDelovanja;
    private String oblastDelovanjaGreska = "";

    private String webStranica;
    private String webStranicaGreska = "";

    private String mestoOrg;
    private String mestoGreska = "";

    private String ulicaOrg;
    private String ulicaGreska = "";

    private String kontaktOsoba;
    private String kontaktOsobaGreska = "";

    private String email;
    private String emailGreska = "";

    private String korIme;
    private String korImeGreska = "";

    private String lozinka;
    private String lozinkaGreska = "";

    private String ponovljenaLozinka;
    private String ponovljenaLozinkaGreska = "";

    public Registracija() {
        telefoni = new ArrayList<String>();
        nextIndex = 0;
    }

    public List<String> getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(List<String> telefoni) {
        this.telefoni = telefoni;
    }

    public void addTelefon() {
        boolean valid = telefonValidacija(telefon);

        if (valid) {
            telefoni.add(telefon);
            telefon = "";
        }

        mestoValidacija();
        ulicaValidacija();
        kontaktOsobaValidacija();
    }

    public void removeTelefon(int status) {
        telefoni.remove(status);

        mestoValidacija();
        ulicaValidacija();
        kontaktOsobaValidacija();
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public void prethodnaStavka() {
        if (nextIndex > 0) {
            nextIndex--;
            script = "$('.wizardPseudoClass').carousel(" + nextIndex + ");$('.wizardPseudoClass').carousel('pause');";
        }
    }

    public boolean nazivOrgValidacija() {
        if (nazivOrg.isEmpty()) {
            nazivOrgGreska = "Polje 'Naziv organizacije' ne sme ostati prazno.";
            return false;
        }

        nazivOrgGreska = "";
        return true;
    }

    public boolean opisOrgValidacija() {
        if (opisOrg.isEmpty()) {
            opisOrgGreska = "Polje 'Opis organizacije' ne sme ostati prazno.";
            return false;
        }

        opisOrgGreska = "";
        return true;
    }

    public boolean oblastDelovanjaValidacija() {
        if (oblastDelovanja.isEmpty()) {
            oblastDelovanjaGreska = "Polje 'Oblast delovanja' ne sme ostati prazno.";
            return false;
        }

        oblastDelovanjaGreska = "";
        return true;
    }

    public boolean webStranicaValidacija() {
        if (webStranica.isEmpty()) {
            webStranicaGreska = "Polje 'Web stranica organizacije' ne sme ostati prazno.";
            return false;
        }

        webStranicaGreska = "";
        return true;
    }

    public boolean mestoValidacija() {
        if (mestoOrg.isEmpty()) {
            mestoGreska = "Polje 'Mesto' ne sme ostati prazno.";
            return false;
        }

        mestoGreska = "";
        return true;
    }

    public boolean ulicaValidacija() {
        if (ulicaOrg.isEmpty()) {
            ulicaGreska = "Polje 'Ulica' ne sme ostati prazno.";
            return false;
        }

        ulicaGreska = "";
        return true;
    }

    public boolean kontaktOsobaValidacija() {
        if (kontaktOsoba.isEmpty()) {
            kontaktOsobaGreska = "Polje 'Kontakt osoba' ne sme ostati prazno.";
            return false;
        }

        kontaktOsobaGreska = "";
        return true;
    }

    public boolean telefoniValidacija() {
        if (telefoni.isEmpty()) {
            telefonGreska = "Morate navesti makar jedan kontakt telefon.";
            return false;
        }

        telefonGreska = "";
        return true;
    }

    public boolean telefonValidacija(String tel) {
        if (tel.length() < 7 || tel.length() > 15 || !tel.matches("[0-9]+")) {
            telefonGreska = "Telefon mora sadržati između 7 i 15 numeričkih karaktera.";
            return false;
        }

        telefonGreska = "";
        return true;
    }

    public boolean emailValidacija() {
        if (email.isEmpty()) {
            emailGreska = "Polje 'Email adresa' ne sme ostati prazno.";
            return false;
        }

        emailGreska = "";
        return true;
    }

    public boolean korImeValidacija() {
        if (korIme.isEmpty()) {
            korImeGreska = "Polje 'Korisničko ime' ne sme ostati prazno.";
            return false;
        }

        korImeGreska = "";
        return true;
    }

    public boolean lozinkaValidacija() {
        if (lozinka.isEmpty()) {
            lozinkaGreska = "Polje 'Lozinka' ne sme ostati prazno.";
            return false;
        }

        lozinkaGreska = "";
        return true;
    }

    public boolean ponovljenaLozinkaValidacija() {
        if (ponovljenaLozinka.isEmpty()) {
            ponovljenaLozinkaGreska = "Polje 'Ponovljena lozinka' ne sme ostati prazno.";
            return false;
        }

        ponovljenaLozinkaGreska = "";
        return true;
    }

    public void narednaStavka() {
        boolean valid = true;
        
        nazivOrgGreska = "";
        opisOrgGreska = "";
        oblastDelovanjaGreska = "";
        webStranicaGreska = "";
        
        mestoGreska = "";
        ulicaGreska = "";
        telefonGreska = "";
        kontaktOsobaGreska = "";
        emailGreska = "";
        
        korImeGreska = "";
        lozinkaGreska = "";
        ponovljenaLozinkaGreska = "";

        if (nextIndex == 0) {
            if (!nazivOrgValidacija()) {
                valid = false;
            }
            if (!opisOrgValidacija()) {
                valid = false;
            }
            if (!oblastDelovanjaValidacija()) {
                valid = false;
            }
            if (!webStranicaValidacija()) {
                valid = false;
            }

            if (!valid) {
                script = "$('.wizardPseudoClass').carousel(0);$('.wizardPseudoClass').carousel('pause');";
            }
        }
        if (nextIndex == 1) {
            if (!mestoValidacija()) {
                valid = false;
            }
            if (!ulicaValidacija()) {
                valid = false;
            }
            if (!kontaktOsobaValidacija()) {
                valid = false;
            }
            if (!telefoniValidacija()) {
                valid = false;
            }
            if (!emailValidacija()) {
                valid = false;
            }

            if (!valid) {
                script = "$('.wizardPseudoClass').carousel(1);$('.wizardPseudoClass').carousel('pause');";
            }
        }
        if (nextIndex == 2) {
            if (!korImeValidacija()) {
                valid = false;
            }
            if (!lozinkaValidacija()) {
                valid = false;
            }
            if (!ponovljenaLozinkaValidacija()) {
                valid = false;
            }

            if (!valid) {
                script = "$('.wizardPseudoClass').carousel(2);$('.wizardPseudoClass').carousel('pause');";
            }
        }

        if (nextIndex < 2) {
            if (valid) {
                nextIndex++;
                script = "$('.wizardPseudoClass').carousel(" + nextIndex + ");$('.wizardPseudoClass').carousel('pause');";
            }
        }
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getNazivOrg() {
        return nazivOrg;
    }

    public void setNazivOrg(String nazivOrg) {
        this.nazivOrg = nazivOrg;
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
        this.opisOrg = opisOrg;
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
        this.oblastDelovanja = oblastDelovanja;
    }

    public String getOblastDelovanjaGreska() {
        return oblastDelovanjaGreska;
    }

    public void setOblastDelovanjaGreska(String oblastDelovanjaGreska) {
        this.oblastDelovanjaGreska = oblastDelovanjaGreska;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }

    public String getWebStranicaGreska() {
        return webStranicaGreska;
    }

    public void setWebStranicaGreska(String webStranicaGreska) {
        this.webStranicaGreska = webStranicaGreska;
    }

    public String getMestoOrg() {
        return mestoOrg;
    }

    public void setMestoOrg(String mestoOrg) {
        this.mestoOrg = mestoOrg;
    }

    public String getMestoGreska() {
        return mestoGreska;
    }

    public void setMestoGreska(String mestoGreska) {
        this.mestoGreska = mestoGreska;
    }

    public String getUlicaOrg() {
        return ulicaOrg;
    }

    public void setUlicaOrg(String ulicaOrg) {
        this.ulicaOrg = ulicaOrg;
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
        this.kontaktOsoba = kontaktOsoba;
    }

    public String getKontaktOsobaGreska() {
        return kontaktOsobaGreska;
    }

    public void setKontaktOsobaGreska(String kontaktOsobaGreska) {
        this.kontaktOsobaGreska = kontaktOsobaGreska;
    }

    public String getTelefonGreska() {
        return telefonGreska;
    }

    public void setTelefonGreska(String telefonGreska) {
        this.telefonGreska = telefonGreska;
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

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getKorImeGreska() {
        return korImeGreska;
    }

    public void setKorImeGreska(String korImeGreska) {
        this.korImeGreska = korImeGreska;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getLozinkaGreska() {
        return lozinkaGreska;
    }

    public void setLozinkaGreska(String lozinkaGreska) {
        this.lozinkaGreska = lozinkaGreska;
    }

    public String getPonovljenaLozinka() {
        return ponovljenaLozinka;
    }

    public void setPonovljenaLozinka(String ponovljenaLozinka) {
        this.ponovljenaLozinka = ponovljenaLozinka;
    }

    public String getPonovljenaLozinkaGreska() {
        return ponovljenaLozinkaGreska;
    }

    public void setPonovljenaLozinkaGreska(String ponovljenaLozinkaGreska) {
        this.ponovljenaLozinkaGreska = ponovljenaLozinkaGreska;
    }

}
