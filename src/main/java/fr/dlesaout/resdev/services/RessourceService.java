package fr.dlesaout.resdev.services;

import fr.dlesaout.resdev.entities.Ressource;
import fr.dlesaout.resdev.repositories.RessourceRepository;
import org.springframework.http.ResponseEntity;
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

    @Transactional
    public ResponseEntity<Ressource> saveRessource(Ressource ressource) {
        if (
                ressource == null
                        || ressource.getNom().length() > 255
                        || ressource.getUrl().length() > 255
                        || ressource.getDescription().length() > 1000
                        || ressource.getUtilisation().length() > 1000
                        || ressource.getCategories() == null
        ) {
            return ResponseEntity.badRequest().build();
        }
        Ressource newRessource = Ressource.builder()
                .nom(ressource.getNom())
                .url(ressource.getUrl())
                .description(ressource.getDescription())
                .utilisation(ressource.getUtilisation())
                .categories(ressource.getCategories())
                .build();
        ressourceRepository.save(newRessource);
        return ResponseEntity.ok(newRessource);
    }

    @Transactional
    public ResponseEntity<Ressource> updateRessource(Integer id, Ressource ressource) {
        Optional<Ressource> ressourceToUpdate = ressourceRepository.findById(id);
        if(ressourceToUpdate.isEmpty() || ressource == null) {
            return ResponseEntity.badRequest().build();
        }
        Ressource updatedRessource = Ressource.builder()
                .id(id)
                .nom(ressource.getNom())
                .url(ressource.getUrl())
                .description(ressource.getDescription())
                .utilisation(ressource.getUtilisation())
                .categories(ressource.getCategories())
                .build();
        Ressource savedRessource = ressourceRepository.save(updatedRessource);
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
