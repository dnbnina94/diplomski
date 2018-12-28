/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Nina
 */
public class Telefoni implements java.io.Serializable {
    
    private int idTelefon;
    private Organizacije organizacije;
    private String telefon;
    
    public Telefoni() {
        
    }
    
    public Telefoni(int idTelefon, Organizacije organizacije, String telefon) {
        
        this.idTelefon = idTelefon;
        this.organizacije = organizacije;
        this.telefon = telefon;
        
    }
    
    public int getIdTelefon() {
        return idTelefon;
    }
    
    public void setIdTelefon(int idTelefon) {
        this.idTelefon = idTelefon;
    }
    
    public Organizacije getOrganizacije() {
        return organizacije;
    }
    
    public void setOrganizacije(Organizacije organizacije) {
        this.organizacije = organizacije;
    }
    
    public String getTelefon() {
        return telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
}
