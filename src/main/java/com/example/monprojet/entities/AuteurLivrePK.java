package com.example.monprojet.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter   // Génère les getters pour les attributs
@Setter   // Génère les setters pour les attributs
@NoArgsConstructor  // Génère un constructeur sans argument
@Embeddable
public class AuteurLivrePK implements Serializable {


    private Long auteurId;
    private Long livreId;

    public AuteurLivrePK(Long auteurId, Long livreId) {
        this.auteurId = auteurId;
        this.livreId = livreId;
    }
}


