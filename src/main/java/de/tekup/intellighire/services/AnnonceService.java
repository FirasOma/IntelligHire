package de.tekup.intellighire.services;

import de.tekup.intellighire.entities.AnnonceEntity;
import de.tekup.intellighire.reposotries.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {

     @Autowired
     private AnnonceRepository annoncerepository;

     public void addAnnonce(){
     AnnonceEntity annonceentity = new AnnonceEntity();
     annoncerepository.save(annonceentity);
     }
}
