package com.example.monprojet.services;

import com.example.monprojet.entities.Auteur;
import com.example.monprojet.repositories.AuteurRepository;
import com.example.monprojet.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private AuteurLivreService auteurLivreService;

    public void verifierEtSupprimerAuteursOrphelins() {
        // Récupère tous les auteurs sans association dans LivreAuteur
        List<Auteur> auteursSansLivres = auteurRepository.findAuteursSansLivres();

        // Supprime chaque auteur sans livre
        auteursSansLivres.forEach(auteurRepository::delete);
    }
}
