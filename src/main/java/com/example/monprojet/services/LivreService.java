package com.example.monprojet.services;

import com.example.monprojet.entities.Auteur;
import com.example.monprojet.entities.AuteurLivre;
import com.example.monprojet.entities.AuteurLivrePK;
import com.example.monprojet.entities.Livre;
import com.example.monprojet.repositories.AuteurLivreRepository;
import com.example.monprojet.repositories.AuteurRepository;
import com.example.monprojet.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private AuteurRepository auteurRepository;

    @Autowired
    private AuteurService auteurService;

    public List<Livre> findAllBooks() {
        return (List<Livre>) livreRepository.findAll();
    }

    public Livre findBookById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    public List<Auteur> findAllAuthors() {
        return (List<Auteur>) auteurRepository.findAll();
    }

    public Livre saveBook(Livre livre, Long[] auteurIds, String[] nouveauxNoms, String[] nouvellesBiographies, String imageUrl) {
        List<AuteurLivre> auteurLivres = new ArrayList<>();

        // Ajouter les auteurs existants sélectionnés
        if (auteurIds != null) {
            for (Long auteurId : auteurIds) {
                Auteur auteurExistant = auteurRepository.findById(auteurId).orElse(null);
                if (auteurExistant != null) {
                    auteurLivres.add(createAuteurLivreAssociation(livre, auteurExistant));
                }
            }
        }

        // Ajouter les nouveaux auteurs
        if (nouveauxNoms != null && nouvellesBiographies != null) {
            for (int i = 0; i < nouveauxNoms.length; i++) {
                String nom = nouveauxNoms[i];
                String biographie = nouvellesBiographies[i];

                if (nom != null && !nom.trim().isEmpty() && biographie != null && !biographie.trim().isEmpty()) {
                    Auteur nouvelAuteur = new Auteur();
                    nouvelAuteur.setNom(nom);
                    nouvelAuteur.setBiographie(biographie);
                    auteurRepository.save(nouvelAuteur);

                    auteurLivres.add(createAuteurLivreAssociation(livre, nouvelAuteur));
                }
            }
        }
        // Mettre à jour l'URL de l'image
        if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            livre.setImageUrl(imageUrl); // Utilisez imageUrl à la place de imageData
        } else
            livre.setImageUrl("https://cdn.vectorstock.com/i/preview-1x/92/18/old-closed-book-wisdom-or-education-concept-vector-43289218.jpg");

        //s'assurer que le livre est associé a au moins un auteur
        if (auteurLivres.isEmpty()) {
            throw new IllegalArgumentException("Veuillez sélectionner ou ajouter au moins un auteur.");
        }
        //sauvegarder le livre dans la bd
        livre.setAuteursLivres(auteurLivres);
        return livreRepository.save(livre);
    }

    public Livre updateBook(Long livreId, Livre livreData, Long[] auteurIds, String[] nouveauxNoms, String[] nouvellesBiographies, Long[] auteursASupprimer, String imageUrl) {
        Livre livre = livreRepository.findById(livreId).orElseThrow(() -> new IllegalArgumentException("Livre non trouvé"));

        // Mettre à jour les attributs du livre
        livre.setTitre(livreData.getTitre());
        livre.setGenre(livreData.getGenre());
        livre.setDatePublication(livreData.getDatePublication());

        // Récupérer la liste actuelle des associations AuteurLivre
        List<AuteurLivre> auteurLivres = new ArrayList<>(livre.getAuteursLivres());

        // Supprimer les auteurs spécifiés
        if (auteursASupprimer != null) {
            for (Long auteurId : auteursASupprimer) {
                auteurLivres.removeIf(assoc -> assoc.getAuteur().getId().equals(auteurId));
                auteurService.verifierEtSupprimerAuteursOrphelins();
            }
        }

        // Ajouter les auteurs existants sélectionnés
        if (auteurIds != null) {
            for (Long auteurId : auteurIds) {
                Auteur auteurExistant = auteurRepository.findById(auteurId).orElse(null);
                if (auteurExistant != null) {
                    auteurLivres.add(createAuteurLivreAssociation(livre, auteurExistant));
                }
            }
        }

        // Ajouter de nouveaux auteurs
        if (nouveauxNoms != null && nouvellesBiographies != null) {
            for (int i = 0; i < nouveauxNoms.length; i++) {
                String nom = nouveauxNoms[i];
                String biographie = nouvellesBiographies[i];
                if (nom != null && !nom.trim().isEmpty() && biographie != null && !biographie.trim().isEmpty()) {
                    Auteur nouvelAuteur = new Auteur();
                    nouvelAuteur.setNom(nom);
                    nouvelAuteur.setBiographie(biographie);
                    auteurRepository.save(nouvelAuteur);

                    auteurLivres.add(createAuteurLivreAssociation(livre, nouvelAuteur));
                }
            }
        }
        // Mettre à jour l'URL de l'image
        if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            livre.setImageUrl(imageUrl); // Utilisez imageUrl à la place de imageData
        }


        // Vérification qu'il y a au moins un auteur
        if (auteurLivres.isEmpty()) {
            throw new IllegalArgumentException("Veuillez sélectionner ou ajouter au moins un auteur.");
        }

        // Mise à jour de la collection d'auteurs de manière sécurisée
        livre.getAuteursLivres().clear();  // Vider la liste existante
        livre.getAuteursLivres().addAll(auteurLivres);  // Ajouter les nouveaux éléments

        // Sauvegarder le livre mis à jour
        return livreRepository.save(livre);
    }


    public void deleteBook(Long id) {
        Livre livre = livreRepository.findById(id).orElse(null);
        if (livre != null) {
            livre.getAuteursLivres().clear(); // Supprime les associations AuteurLivre
            livreRepository.delete(livre);    // Supprime le livre
        }
    }

    private AuteurLivre createAuteurLivreAssociation(Livre livre, Auteur auteur) {
        AuteurLivre auteurLivre = new AuteurLivre();
        AuteurLivrePK pk = new AuteurLivrePK();
        pk.setAuteurId(auteur.getId());
        auteurLivre.setId(pk);
        auteurLivre.setLivre(livre);
        auteurLivre.setAuteur(auteur);
        return auteurLivre;
    }

    public List<Livre> findBooksByTitleStartingWith(String search) {
        return livreRepository.findByTitreStartingWith(search);
    }


}
