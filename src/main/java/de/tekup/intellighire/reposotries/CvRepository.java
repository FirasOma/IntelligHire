package de.tekup.intellighire.reposotries;

import de.tekup.intellighire.entities.cvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<cvEntity,Integer> {


}
