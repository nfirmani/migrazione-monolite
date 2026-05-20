package it.esempio.service;

import it.esempio.model.CittadinoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class NotificaConsumer {

    @Incoming("cittadini-in")
    public void riceviEvento(CittadinoDTO cittadino) {
        // Qui in un'app reale invieremmo un'email o un SMS.
        // Per ora simuliamo il processo con un bel log visibile.
        System.out.println("=========================================");
        System.out.println("🔔 NUOVO EVENTO RICEVUTO DA KAFKA!");
        System.out.println("Preparazione invio welcome-kit a: " + cittadino.toString());
        System.out.println("=========================================");
    }
}