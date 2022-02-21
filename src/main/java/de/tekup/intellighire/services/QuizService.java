package de.tekup.intellighire.services;

import de.tekup.intellighire.dtos.QuestionDto;
import de.tekup.intellighire.entities.*;
import de.tekup.intellighire.reposotries.AnnonceRepository;
import de.tekup.intellighire.reposotries.CvRepository;
import de.tekup.intellighire.reposotries.QuestionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizService {

    private ModelMapper mapper;

    @Autowired
    private QuestionRepository questionrepository;

    @Autowired
    private AnnonceRepository annoncerepository;



    public List<QuestionDto> generateQuiz(int id) {
        AnnonceEntity annonce = annoncerepository.getById(id);
        List<Theme> annoncethemes = annonce.getAllTheme();
        JobExperience experience = annonce.getJobExperience();
        List<Question> quiz = new ArrayList<>();

        quiz=annoncethemes.stream()
                .map(t-> questionrepository.findAllByThemeAndJobExperience(t,experience))
                .flatMap(lq->lq.stream())
                .collect(Collectors.toList());

        Collections.shuffle(quiz);
        quiz = quiz.stream().limit(20).collect(Collectors.toList());
       List<QuestionDto> quiz1 = quiz.stream().map(q -> {QuestionDto questionDto = mapper.map(q,QuestionDto.class); return questionDto;}).collect(Collectors.toList());
       // for (QuestionDto q : quiz1) {
           // System.out.println(q);
        //}

        return quiz1;
    }
}
