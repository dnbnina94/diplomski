/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Korisnici;
import db.Organizacije;
import db.ZaboravljeneLozinke;
import db.helpers.KorisniciHelper;
import db.helpers.ZaboravljeneLozinkeHelper;
import helpers.EmailHelper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nina
 */
public class Prijava {

    private String korIme;
    private String lozinka;
    private String korImeGreska = "";
    private String lozinkaGreska = "";

    private String email = "";
    private String emailGreska = "";

    private KorisniciHelper korisniciHelper = new KorisniciHelper();
    private ZaboravljeneLozinkeHelper zaboravljeneLozinkeHelper = new ZaboravljeneLozinkeHelper();
    private EmailHelper emailHelper = new EmailHelper();

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public Prijava() {
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getKorImeGreska() {
        return korImeGreska;
    }

    public void setKorImeGreska(String korImeGreska) {
        this.korImeGreska = korImeGreska;
    }

    public String getLozinkaGreska() {
        return lozinkaGreska;
    }

    public void setLozinkaGreska(String lozinkaGreska) {
        this.lozinkaGreska = lozinkaGreska;
    }

    public void login() {
        boolean valid = true;

        if (korIme == null || korIme.isEmpty()) {
            valid = false;
            korImeGreska = "Polje 'Korisničko ime' ne sme ostati prazno.";
        }

        if (lozinka == null || lozinka.isEmpty()) {
            valid = false;
            lozinkaGreska = "Polje 'Lozinka' ne sme ostati prazno.";
        }

        if (valid) {
            Korisnici korisnik = korisniciHelper.getKorisnikByKorisnickoIme(korIme);

            if (korisnik == null) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pogrešno ste uneli korisničko ime i/ili lozinku.", null);
                FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return;
            }

            if (!korisnik.isOdobren()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Administrator još uvek nije odobrio Vaš zahtev za registraciju. Molimo pokušajte kasnije.", null);
                FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return;
            }

            try {
                boolean resetovanaLozinka = false;

                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(korisnik.getSalt());
                byte[] hashedPassword = md.digest(lozinka.getBytes(StandardCharsets.UTF_8));

                //if (!(new String(hashedPassword)).equals(korisnik.getLozinka())) {
                if (!Arrays.equals(hashedPassword, korisnik.getLozinka())) {

                    ZaboravljeneLozinke request = zaboravljeneLozinkeHelper.getRequest(korIme);
                    if (request != null) {

                        md = MessageDigest.getInstance("SHA-512");
                        md.update(request.getSalt());
                        hashedPassword = md.digest(lozinka.getBytes(StandardCharsets.UTF_8));

                        if (!Arrays.equals(hashedPassword, request.getNovaLozinka())) {
                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pogrešno ste uneli korisničko ime i/ili lozinku.", null);
                            FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                            return;
                        } else {
                            Date danas = new Date();
                            Date datumRequesta = request.getDatum();

                            long diff = danas.getTime() - datumRequesta.getTime();
                            long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

                            if (minutes > 30) {
                                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaša nova lozinka je istekla. Molimo Vas da pošaljete zahtev za resetovanje lozinke, kako bismo Vam poslali novu lozinku.", null);
                                FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                                return;
                            } else {
                                resetovanaLozinka = true;
                                
                                korisnik.setLozinka(request.getNovaLozinka());
                                korisnik.setSalt(request.getSalt());
                                zaboravljeneLozinkeHelper.deleteRequest(request);
                                korisniciHelper.updateKorisnik(korisnik);
                                
                            }

                        }

                    } else {
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pogrešno ste uneli korisničko ime i/ili lozinku.", null);
                        FacesContext.getCurrentInstance().addMessage("prijava:growl-error", message);
                        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                        return;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Prijava.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (korisnik.getTip() == 2) {
                    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                    OrganizacijaBean organizacijaBean = (OrganizacijaBean) elContext.getELResolver().getValue(elContext, null, "organizacijaBean");
                    organizacijaBean.setOrganizacija(korisnik.getOrganizacije());
                    elContext.getELResolver().setValue(elContext, null, "organizacijaBean", organizacijaBean);

                    KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
                    korisnikBean.setKorisnik(korisnik);
                    elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);

                    FacesContext.getCurrentInstance().getExternalContext().redirect("organizacija.xhtml");
                    FacesContext.getCurrentInstance().responseComplete();
                }
                if (korisnik.getTip() == 1) {
                    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                    KorisnikBean korisnikBean = (KorisnikBean) elContext.getELResolver().getValue(elContext, null, "korisnikBean");
                    korisnikBean.setKorisnik(korisnik);
                    elContext.getELResolver().setValue(elContext, null, "korisnikBean", korisnikBean);

                    FacesContext.getCurrentInstance().getExternalContext().redirect("adminKorisnici.xhtml");
                    FacesContext.getCurrentInstance().responseComplete();
                }
            } catch (IOException ex) {
                Logger.getLogger(Prijava.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean emailValidacija() {
        if (email.isEmpty()) {
            emailGreska = "Polje 'Email adresa' ne sme ostati prazno.";
            return false;
        }

        if (!email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+")) {
            emailGreska = "Email adresa koju ste uneli ne odgovara email formatu.";
            return false;
        }

        Organizacije org = korisniciHelper.getOrganizacijaByEmail(email);
        if (org == null) {
            emailGreska = "Email adresa koju ste uneli ne postoji u sistemu.";
            return false;
        } else {
            ZaboravljeneLozinke zaboravljeneLozinke = zaboravljeneLozinkeHelper.getRequest(org.getKorisnickoIme());

            if (zaboravljeneLozinke != null) {
                Date danas = new Date();
                Date datumRequesta = zaboravljeneLozinke.getDatum();

                long diff = danas.getTime() - datumRequesta.getTime();
                long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

                if (minutes < 30) {
                    emailGreska = "Novi zahtev za resetovanje lozinke možete poslati nakon 30 minuta od slanja poslednjeg zahteva.";
                    return false;
                }
            }

        }

        emailGreska = "";
        return true;
    }

    public String generateNewPassword() {
        int passwordLength = 10;

        StringBuilder returnValue = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }

    public void resetPassword() {
        boolean valid = true;

        if (!emailValidacija()) {
            valid = false;
        }

        if (valid) {

            try {
                Organizacije org = korisniciHelper.getOrganizacijaByEmail(email);
                ZaboravljeneLozinke request = zaboravljeneLozinkeHelper.getRequest(org.getKorisnickoIme());

                String novaLozinka = generateNewPassword();

                SecureRandom random = new SecureRandom();
                byte[] salt = new byte[16];
                random.nextBytes(salt);

                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(salt);

                byte[] hashedPassword = md.digest(novaLozinka.getBytes(StandardCharsets.UTF_8));

                if (request == null) {

                    request = new ZaboravljeneLozinke();
                    request.setKorisnickoIme(org.getKorisnickoIme());
                    request.setKorisnici(org.getKorisnici());
                    request.setDatum(new Date());
                    request.setNovaLozinka(hashedPassword);
                    request.setSalt(salt);

                    zaboravljeneLozinkeHelper.insertRequest(request);

                } else {

                    request.setDatum(new Date());
                    request.setNovaLozinka(hashedPassword);
                    request.setSalt(salt);

                    zaboravljeneLozinkeHelper.updateRequest(request);

                }
                
                email = "";
                emailGreska = "";

                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno ste poslali zahtev za resetovanje lozinke. Nova lozinka je poslata na Vašu email adresu.", null);
                FacesContext.getCurrentInstance().addMessage("prijava:growl-success", message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

                emailHelper.forgottenPasswordSend(org.getEmail(), novaLozinka, request.getKorisnickoIme());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Prijava.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }

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

}
