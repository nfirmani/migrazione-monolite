package it.esempio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cittadini")
public class Cittadino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public String nome;
    public String cognome;
    public String codiceFiscale;

    public Cittadino() {}

    // Aggiungi questi per rendere felice Jackson (il parser JSON)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    
    public String getCodiceFiscale() { return codiceFiscale; }
    public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }
}