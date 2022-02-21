package de.tekup.intellighire.controllers;

import de.tekup.intellighire.entities.cvEntity;
import de.tekup.intellighire.reposotries.CvRepository;
import de.tekup.intellighire.services.CalculScrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CalculScrController {
    @Autowired
    private CalculScrService calculscr;




    @RequestMapping("/score/{id}")
    public void Calcul(@PathVariable int id ){

        calculscr.CalculScore(id);
    }
}
