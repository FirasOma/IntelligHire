package de.tekup.intellighire.controllers;

import de.tekup.intellighire.services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AnnonceController {

    @Autowired
    private AnnonceService annonceservice;

    @RequestMapping(path = "/annonce")
    public void addCv() throws IOException {
        annonceservice.addAnnonce();
    }

}
