package fr.dlesaout.resdev.services;

import fr.dlesaout.resdev.entities.Etat;
import fr.dlesaout.resdev.repositories.EtatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatService {

    private final EtatRepository etatRepository;

    public EtatService(EtatRepository etatRepository) {
        this.etatRepository = etatRepository;
    }

    public ResponseEntity<List<Etat>> searchAllEtats() {
        List<Etat> etats = etatRepository.findAll();
        if (etats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(etats);
    }

    public ResponseEntity<Optional<Etat>> searchEtatById(Integer id) {
        Optional<Etat> etat = etatRepository.findById(id);
        if (etat.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(etat);
    }

    public ResponseEntity<Etat> saveEtat(Etat etat) {
        if(
                etat == null
                || etat.getNom().isEmpty()
        ) {
            return ResponseEntity.badRequest().build();
        }
        Etat newEtat = etatRepository.save(etat);
        return ResponseEntity.ok(newEtat);
    }
}
