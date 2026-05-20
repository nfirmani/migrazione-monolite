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

    
}