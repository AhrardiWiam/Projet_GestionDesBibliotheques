package com.example.monprojet.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter   // Génère les getters pour les attributs
@Setter   // Génère les setters pour les attributs
@NoArgsConstructor  // Génère un constructeur sans argument
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le titre du livre est obligatoire")
    private String titre;
    @NotBlank(message = "Le genre du livre est obligatoire")
    private String genre;
    @Column(nullable = true)
    private String imageUrl;
    @NotNull(message = "La date de publication ne peut pas être vide")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePublication;

    @OneToMany(mappedBy = "livre",  cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE}, orphanRemoval = true)
    private List<AuteurLivre> auteursLivres;


}
