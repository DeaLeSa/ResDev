package fr.dlesaout.resdev.services;

import fr.dlesaout.resdev.entities.Etat;
import fr.dlesaout.resdev.repositories.EtatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EtatService {

    private final EtatRepository etatRepository;

    public EtatService(EtatRepository etatRepository) {
        this.etatRepository = etatRepository;
    }

    public List<Etat> searchAllEtats() {
        List<Etat> etats = etatRepository.findAll();
        if (etats.isEmpty()) {
            return Collections.emptyList();
        }
        return etats;
    }

    public ResponseEntity<Optional<Etat>> searchEtatById(Integer id) {
        Optional<Etat> etat = etatRepository.findById(id);
        if (etat.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(etat);
    }

    public Optional<Etat> saveEtat(Etat etat) {
        Etat newEtat = etatRepository.save(etat);
        return etatRepository.findById(newEtat.getId());
    }

}
