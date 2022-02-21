package de.tekup.intellighire.controllers;

import de.tekup.intellighire.dtos.QuestionDto;
import de.tekup.intellighire.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizConroller {

    @Autowired
     private QuizService quizservice;



    @GetMapping("/quiz/{id}")
   public List<QuestionDto> getQuiz (@PathVariable int id){
   return  quizservice.generateQuiz(id);
   }
}

