package com.nouvelles.iwa.repository;

import com.nouvelles.iwa.model.Nouvelle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NouvelleRepository extends ReactiveMongoRepository<Nouvelle, String> {
    // Vous pouvez définir ici des méthodes de requête personnalisées si nécessaire
    Flux<Nouvelle> findAllByAuteurId(String auteurId);
}
