package com.example.monprojet.controllers;

import com.example.monprojet.entities.Livre;
import com.example.monprojet.services.LivreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping
    public String getAllBooks(@RequestParam(value = "search", required = false) String search, Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("livres", livreService.findBooksByTitleStartingWith(search));
            model.addAttribute("isSearchActive", true); // Indicateur de recherche active
        } else {
            model.addAttribute("livres", livreService.findAllBooks());
            model.addAttribute("isSearchActive", false); // Pas de recherche active
        }
        return "livres-liste";
    }


    @GetMapping("/{id}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        model.addAttribute("livre", livreService.findBookById(id));
        return "livres-details";
    }

    @GetMapping("/ajouter")
    public String showAddBookForm(Model model) {
        model.addAttribute("livre", new Livre());
        model.addAttribute("auteurs", livreService.findAllAuthors());
        return "livres-ajouter";
    }

    @PostMapping("/ajouter")
    public String addBook(@Valid Livre livre, BindingResult result, Model model, Long[] auteurIds,
                          String[] nouveauxNoms, String[] nouvellesBiographies,String imageUrl) {
        if (result.hasErrors()) {
            model.addAttribute("auteurs", livreService.findAllAuthors());
            return "livres-ajouter";
        }
        try {
            // Passer l'URL de l'image à la méthode de service
            livreService.saveBook(livre, auteurIds, nouveauxNoms, nouvellesBiographies, imageUrl);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("auteurs", livreService.findAllAuthors());
            return "livres-ajouter";
        }

        return "redirect:/";
    }

    @GetMapping("/modifier/{id}")
    public String showUpdateBookForm(@PathVariable("id") long id, Model model) {
        Livre livre = livreService.findBookById(id);

        // Récupération de l'URL de l'image
        String imageUrl = livre.getImageUrl();
        model.addAttribute("imageUrl", imageUrl);
        model.addAttribute("livre", livre);
        model.addAttribute("auteurs", livreService.findAllAuthors());

        return "livres-modifier";
    }

    @PostMapping("/modifier/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid Livre livre, BindingResult result, Model model,
                             Long[] auteurIds, String[] nouveauxNoms, String[] nouvellesBiographies, Long[] auteursASupprimer,
                             @RequestParam("imageUrl") String imageUrl) {
        if (result.hasErrors()) {
            model.addAttribute("auteurs", livreService.findAllAuthors());
            return "livres-modifier";
        }
        try {
            // Mise à jour du livre, y compris l'URL de l'image
            livreService.updateBook(id, livre, auteurIds, nouveauxNoms, nouvellesBiographies, auteursASupprimer, imageUrl);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("auteurs", livreService.findAllAuthors());
            return "livres-modifier";
        }

        return "redirect:/";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        livreService.deleteBook(id);
        redirectAttributes.addFlashAttribute("successMessage", "Le livre a été supprimé avec succès.");
        return "redirect:/";
    }


    @GetMapping("/details/{id}")
    public String showBookDetails(@PathVariable Long id, Model model) {
        Livre livre = livreService.findBookById(id);
        model.addAttribute("livre", livre);
        return "livres-details";
    }

}
