/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.*;

/**
 *
 * @author Nina
 */
public class EmailHelper {

    private String senderEmail = "kulturiska.org@gmail.com";
    private String senderPassword = "Kulturiska123!";

    public EmailHelper() {
    }

    public void forgottenPasswordSend(String recieverEmail, String novaLozinka, String korisnickoIme) {
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(senderEmail, senderPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(senderEmail);
            email.setSubject("Kulturiška - resetovanje lozinke");
            email.setMsg("Poštovani " + korisnickoIme + ",\n\nOvo je nova lozinka kojom se možete ulogovati:\n" + novaLozinka + 
                    "\n\nNovu lozinku možete iskoristiti u roku od 30 minuta. U slučaju da je ne iskorisitite, novi zahtev možete poslati tek nakon 30 minuta od slanja poslednjeg zahteva.\n\n"
                            + "Pozdrav,\nKulturiška");
            email.addTo(recieverEmail);
            email.setTLS(true);
            
            email.send();
            
        } catch (EmailException ex) {
            Logger.getLogger(EmailHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reportSend(String recieverEmail, File file) {
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(senderEmail, senderPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(senderEmail);
            email.setSubject("Kulturiška - izveštaj");
            email.setMsg("Poštovani,\n\nU prilogu se nalazi izveštaj administratora.\n\nPozdrav,\nKulturiška");
            email.addTo(recieverEmail);
            email.setTLS(true);
            
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(file.getAbsolutePath());
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Izveštaj");
            attachment.setName(file.getName());
            email.attach(attachment);
            
            email.send();
            
        } catch (EmailException ex) {
            Logger.getLogger(EmailHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
