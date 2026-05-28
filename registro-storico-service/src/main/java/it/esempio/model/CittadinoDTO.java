package it.esempio.model;

public class CittadinoDTO {
    private String nome;
    private String cognome;
    private String codiceFiscale;

    // Costruttore vuoto obbligatorio per Jackson
    public CittadinoDTO() {}

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getCodiceFiscale() { return codiceFiscale; }
    public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }
}