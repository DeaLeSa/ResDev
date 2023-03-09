package fr.dlesaout.resdev.repositories;

import fr.dlesaout.resdev.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Integer> {

}
