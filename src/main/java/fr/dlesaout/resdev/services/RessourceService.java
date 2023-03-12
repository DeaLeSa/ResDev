package fr.dlesaout.resdev.services;

import fr.dlesaout.resdev.entities.*;
import fr.dlesaout.resdev.repositories.RessourceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RessourceService {

    private final RessourceRepository ressourceRepository;

    public RessourceService(RessourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }

    public ResponseEntity<List<Ressource>> searchAllRessources() {
        List<Ressource> ressources = ressourceRepository.findAll();
        if (ressources.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ressources);
    }

    public ResponseEntity<Optional<Ressource>> searchRessourceById(Integer id) {
        Optional<Ressource> ressource = ressourceRepository.findById(id);
        if (ressource.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ressource);
    }

    public List<Ressource> searchRessourcesByEtat(Etat etat) {
        return ressourceRepository.findAllByEtat(etat);
    }

    public List<Ressource> searchRessourcesByCategories(List<Categorie> categories) {
        return ressourceRepository.findAllByCategoriesIn(categories);
    }

    @Transactional
    public ResponseEntity<Ressource> saveRessource(Ressource ressource) {

        if (
                ressource == null
                        || ressource.getNom().length() > 255
                        || ressource.getUrl().length() > 255
                        || ressource.getDescription().length() > 1000
                        || ressource.getUtilisation().length() > 1000
        ) {
            return ResponseEntity.badRequest().build();
        }

        Utilisateur author = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Ressource newRessource = Ressource.builder()
                .nom(ressource.getNom())
                .url(ressource.getUrl())
                .description(ressource.getDescription())
                .utilisation(ressource.getUtilisation())
                .categories(ressource.getCategories())
                .etat(ressource.getEtat())
                .utilisateur(author)
                .build();

        ressourceRepository.save(newRessource);
        return ResponseEntity.ok(newRessource);
    }

    @Transactional
    public ResponseEntity<Ressource> updateRessource(Integer id, Ressource ressource) {

        Optional<Ressource> ressourceToUpdate = ressourceRepository.findById(id);
        if (
                ressourceToUpdate.isEmpty()
                        || ressource == null
                        || !ressourceToUpdate.get().getUtilisateur().equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
        ) {
            return ResponseEntity.badRequest().build();
        }

        ressourceToUpdate.get().setNom(ressource.getNom());
        ressourceToUpdate.get().setUrl(ressource.getUrl());
        ressourceToUpdate.get().setDescription(ressource.getDescription());
        ressourceToUpdate.get().setUtilisation(ressource.getUtilisation());
        ressourceToUpdate.get().setCategories(ressource.getCategories());

        Ressource savedRessource = ressourceRepository.save(ressourceToUpdate.get());
        return ResponseEntity.ok(savedRessource);
    }

    @Transactional
    public ResponseEntity<Integer> deleteRessourceById(Integer id) {
        Integer numberOfDeletedRows = 0;
        Optional<Ressource> ressourceToDelete = ressourceRepository.findById(id);
        if (ressourceToDelete.isPresent()) {
            ressourceRepository.deleteById(ressourceToDelete.get().getId());
            numberOfDeletedRows++;
        }
        return ResponseEntity.ok(numberOfDeletedRows);
    }

}
