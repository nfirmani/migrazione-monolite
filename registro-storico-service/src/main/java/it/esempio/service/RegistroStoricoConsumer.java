package it.esempio.service;

import it.esempio.model.CittadinoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class RegistroStoricoConsumer {

    @Incoming("storico-in")
    public void registraAccesso(CittadinoDTO cittadino) {
        System.out.println("\n=========================================");
        System.out.println("📊 [REGISTRO STORICO] - Audit di Sicurezza");
        System.out.println("Tracciamento inserimento per: " + cittadino.getCognome().toUpperCase() + " " + cittadino.getNome());
        System.out.println("Codice Fiscale archiviato: " + cittadino.getCodiceFiscale());
        System.out.println("=========================================\n");
    }
}