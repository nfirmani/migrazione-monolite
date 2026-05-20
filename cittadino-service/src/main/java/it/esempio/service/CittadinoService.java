package it.esempio.service;

import it.esempio.model.Cittadino;
import it.esempio.repository.CittadinoRepository;

// Importazioni corrette per Quarkus 3 (Jakarta EE) e Kafka (MicroProfile)
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.List;

@ApplicationScoped
public class CittadinoService {

    @Inject
    CittadinoRepository repository;

    // Iniettiamo l'emitter agganciato al canale "cittadino-creato" definito nel properties
    @Inject
    @Channel("cittadino-creato")
    Emitter<Cittadino> emitter;

    public List<Cittadino> findAll() {
        return repository.listAll();
    }

    @Transactional
    public Cittadino create(Cittadino cittadino) {
        // 1. Salviamo sul DB H2 locale
        repository.persist(cittadino);
        
        // 2. Lanciamo l'evento in modo asincrono su Kafka
        emitter.send(cittadino); 
        
        return cittadino;
    }
}