package com.example.monprojet.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  // Annotation JPA pour spécifier que cette classe est une entité
@Getter   // Génère les getters pour les attributs
@Setter   // Génère les setters pour les attributs
@NoArgsConstructor  // Génère un constructeur sans argument
public class AuteurLivre {
    @EmbeddedId
    private AuteurLivrePK id;

    @ManyToOne
    @MapsId("auteurId")
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;

    @ManyToOne
    @MapsId("livreId")
    @JoinColumn(name = "livre_id")
    private Livre livre;

    public AuteurLivre(Auteur auteur, Livre livre) {
        this.auteur = auteur;
        this.livre = livre;
    }
}