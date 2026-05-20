package it.esempio.service;

import it.esempio.model.Cittadino;
import it.esempio.repository.CittadinoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CittadinoService {

    @Inject
    CittadinoRepository repository;

    public List<Cittadino> findAll() {
        return repository.listAll();
    }

    @Transactional // Fondamentale per scrivere sul DB in Quarkus
    public Cittadino create(Cittadino cittadino) {
        repository.persist(cittadino);
        return cittadino;
    }
}