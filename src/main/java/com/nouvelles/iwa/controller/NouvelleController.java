package com.nouvelles.iwa.controller;

import com.nouvelles.iwa.model.Nouvelle;
import com.nouvelles.iwa.repository.NouvelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/nouvelles")
public class NouvelleController {

    private final NouvelleRepository nouvelleRepository;

    @Autowired
    public NouvelleController(NouvelleRepository nouvelleRepository) {
        this.nouvelleRepository = nouvelleRepository;
    }

    // Récupère toutes les nouvelles
    @GetMapping
    public Flux<Nouvelle> getAllNouvelles() {
        return nouvelleRepository.findAll();
    }

    // Crée une nouvelle nouvelle
    @PostMapping
    public Mono<Nouvelle> createNouvelle(@RequestBody Nouvelle nouvelle) {
        return nouvelleRepository.save(nouvelle);
    }

    // Récupère les nouvelles en flux continu
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Nouvelle> streamNouvelles() {
        return nouvelleRepository.findAll();
    }

    // Récupère une nouvelle spécifique par son ID
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Nouvelle>> getNouvelleById(@PathVariable String id) {
        return nouvelleRepository.findById(id)
                .map(nouvelle -> ResponseEntity.ok(nouvelle))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Supprime une nouvelle par son ID
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteNouvelle(@PathVariable String id) {
        return nouvelleRepository.findById(id)
                .flatMap(existingNouvelle ->
                        nouvelleRepository.delete(existingNouvelle)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Met à jour une nouvelle spécifique
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Nouvelle>> updateNouvelle(@PathVariable(value = "id") String id, @RequestBody Nouvelle nouvelle) {
        return nouvelleRepository.findById(id)
                .flatMap(existingNouvelle -> {
                    existingNouvelle.setTitre(nouvelle.getTitre());
                    existingNouvelle.setContenu(nouvelle.getContenu());
                    existingNouvelle.setAuteurId(nouvelle.getAuteurId());
                    return nouvelleRepository.save(existingNouvelle);
                })
                .map(updatedNouvelle -> ResponseEntity.ok(updatedNouvelle))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
