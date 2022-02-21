package de.tekup.intellighire.controllers;

import de.tekup.intellighire.services.cvService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class cvController {
    @Autowired
    private cvService cvservice;
    @RequestMapping(path = "/cv")
    public void addCv() throws IOException {
         cvservice.ReadCv();
    }
}
