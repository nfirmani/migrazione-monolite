package it.esempio.model;

public class CittadinoDTO {
    public String nome;
    public String cognome;
    public String codiceFiscale;

    public CittadinoDTO() {}

    @Override
    public String toString() {
        return nome + " " + cognome + " (CF: " + codiceFiscale + ")";
    }
}