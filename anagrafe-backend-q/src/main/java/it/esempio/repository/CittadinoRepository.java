package it.esempio.repository;

import it.esempio.model.Cittadino;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CittadinoRepository implements PanacheRepository<Cittadino> {
    // Non serve scrivere nulla qui per le operazioni CRUD base!
}