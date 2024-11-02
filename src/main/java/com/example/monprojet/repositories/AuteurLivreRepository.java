package com.example.monprojet.repositories;

import com.example.monprojet.entities.Auteur;
import com.example.monprojet.entities.AuteurLivre;
import com.example.monprojet.entities.AuteurLivrePK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurLivreRepository extends CrudRepository<AuteurLivre, AuteurLivrePK> {
    // Méthodes CRUD déjà disponibles
}
