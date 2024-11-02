package com.example.monprojet.entities;

import jakarta.persistence.*;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  // Annotation JPA pour spécifier que cette classe est une entité
@Getter   // Génère les getters pour les attributs
@Setter   // Génère les setters pour les attributs
@NoArgsConstructor  // Génère un constructeur sans argument
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'auteur est obligatoire")
    private String nom;
    @NotBlank(message = "La biographie de l'auteur est obligatoire")
    @Column(columnDefinition = "TEXT")
    private String biographie;

    @OneToMany(mappedBy = "auteur")
    private List<AuteurLivre> auteursLivres;

    public Auteur(String nom, String biographie) {
        this.nom = nom;
        this.biographie = biographie;
    }
}