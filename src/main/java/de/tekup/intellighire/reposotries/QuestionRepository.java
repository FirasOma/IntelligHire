package de.tekup.intellighire.reposotries;

import de.tekup.intellighire.entities.JobExperience;
import de.tekup.intellighire.entities.Question;
import de.tekup.intellighire.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findAllByThemeAndJobExperience(Theme theme,JobExperience jobExperience);
}
