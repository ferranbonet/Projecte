/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

/**
 *
 * @author fbonet
 */
public class Serie {
    //
    //
    // Variables projecte
    //
    private String nom = "";
    private String genere = "";
    private String descripcio = "";
    private int numCapitols = 0;
    private int duracioCapitols = 0;
    private int anyEmissio = 0;
    private double nota = 0.0;
    private boolean acabat = false;
    private boolean omplert = false;
    private char acabatChar;
    //

    @Override
    public String toString() {
        return "\nNom: " + nom +
               "\nGènere: " + genere +
               "\nDescripció: " + descripcio +
               "\nNúmero de capítols: " + numCapitols +
               "\nDuració capítols: " + duracioCapitols +
               "\nAny d'emissió: " + anyEmissio +
               "\nNota: " + nota +
               (acabat?"\nAcabat":"\nNo acabat");
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getNumCapitols() {
        return numCapitols;
    }

    public void setNumCapitols(int numCapitols) {
        this.numCapitols = numCapitols;
    }

    public int getDuracioCapitols() {
        return duracioCapitols;
    }

    public void setDuracioCapitols(int duracioCapitols) {
        this.duracioCapitols = duracioCapitols;
    }

    public int getAnyEmissio() {
        return anyEmissio;
    }

    public void setAnyEmissio(int anyEmissio) {
        this.anyEmissio = anyEmissio;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isAcabat() {
        return acabat;
    }

    public void setAcabat(boolean acabat) {
        this.acabat = acabat;
    }

    public boolean isOmplert() {
        return omplert;
    }

    public void setOmplert(boolean omplert) {
        this.omplert = omplert;
    }

    public char getAcabatChar() {
        return acabatChar;
    }

    public void setAcabatChar(char acabatChar) {
        this.acabatChar = acabatChar;
    }
    //
}
