package de.tekup.intellighire.services;
import de.tekup.intellighire.entities.AnnonceEntity;
import de.tekup.intellighire.entities.cvEntity;
import de.tekup.intellighire.reposotries.AnnonceRepository;
import de.tekup.intellighire.reposotries.CvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculScrService {

    private CvRepository cvrepository;
    private AnnonceRepository annoncerepository;
    public void CalculScore(int id) {
       AnnonceEntity annonceentity=  annoncerepository.getById(id);

        for (cvEntity cventity: annonceentity.getCvs()) {


        String matching[] = cventity.getSkills().split("/");
        String matching1[] = annonceentity.getSkillsRequired().split("/");
        int score = 0;
        double scoreExperience =0 ;
        for (String anns : matching1) {
            for (String s : matching) {
                if (s.trim().equalsIgnoreCase(anns.trim())) {
                    score += 1;
                    break;
                }
            }
        }
        if (cventity.getExperience() >= annonceentity.getExperienceRequired())
        {
            scoreExperience = (cventity.getExperience()/annonceentity.getExperienceRequired())*100;}
        if (cventity.getExperience() <= annonceentity.getExperienceRequired())
        {
            scoreExperience = (cventity.getExperience()/annonceentity.getExperienceRequired())*100;}

        if (cventity.getExperience() == annonceentity.getExperienceRequired())
        {
            scoreExperience = (cventity.getExperience()/annonceentity.getExperienceRequired())*100;}
            cventity.setScoreExperience(scoreExperience);

        if (cventity.getJobTitle().equalsIgnoreCase(annonceentity.getJobTitle()))
            score += 1;

        cventity.setScore(score);
        for (int i = 0; i < matching.length; i++) {
            System.out.println(matching[i]);

        }
        System.out.println("***************************************************");
        for (int i = 0; i < matching1.length; i++) {
            System.out.println(matching1[i]);

        }
        System.out.println("score : " + score);

        cvrepository.save(cventity);
        }

    }

}
