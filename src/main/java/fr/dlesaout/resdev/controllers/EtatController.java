package fr.dlesaout.resdev.controllers;

import fr.dlesaout.resdev.entities.Etat;
import fr.dlesaout.resdev.services.EtatService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/v1/etats", name = "etats")
public class EtatController {

    private final EtatService etatService;

    public EtatController(EtatService etatService) {
        this.etatService = etatService;
    }

    @GetMapping(value = "/all", name = "_all")
    public ResponseEntity<List<Etat>> allEtats() {
        return etatService.searchAllEtats();
    }

    @GetMapping(value = "/{id}", name = "_detail")
    public ResponseEntity<Optional<Etat>> etatById(@PathVariable Integer id) {
        return etatService.searchEtatById(id);
    }

    @PostMapping(value = "/create", name = "_create")
    public ResponseEntity<Etat> saveEtat(@RequestBody Etat etat) {
        return etatService.saveEtat(etat);
    }

}
