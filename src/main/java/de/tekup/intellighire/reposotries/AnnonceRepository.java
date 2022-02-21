package de.tekup.intellighire.reposotries;

import de.tekup.intellighire.entities.AnnonceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<AnnonceEntity,Integer> {
}
