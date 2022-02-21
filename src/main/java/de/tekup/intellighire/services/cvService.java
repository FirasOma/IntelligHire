package de.tekup.intellighire.services;

import de.tekup.intellighire.entities.AnnonceEntity;
import de.tekup.intellighire.entities.cvEntity;
import de.tekup.intellighire.reposotries.CvRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class cvService {
    @Autowired
    private CvRepository cvrepository ;



    public void ReadCv() throws IOException {
        PDDocument document = PDDocument.load(new File("C:/Users/Dell/Desktop/AntonyDeepakThomas.pdf"));
        try  {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                 cvEntity cventity = new cvEntity();
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                cventity.setName(lines[1]);
                cventity.setJobTitle(lines[2]);
                cventity.setEmail(lines[3]);
                for (String line : lines) {
                    System.out.println(line);
                }
                System.out.println("*****************************");
               int nbyears =  Arrays.asList(lines).stream().filter(s -> (s.contains("years") || s.contains("year")) &&(s.contains("months") || s.contains("month")))
                                .map(s -> s.substring(s.indexOf("(")+1,s.indexOf(")")))
                        .map(s -> s.split(" " )[0])
                        .mapToInt(s -> Integer.parseInt(s))
                .sum();
                int nbmonth =  Arrays.asList(lines).stream().filter(s -> (s.contains("years") || s.contains("year")) &&(s.contains("months") || s.contains("month")))
                        .map(s -> s.substring(s.indexOf("(")+1,s.indexOf(")")))
                        .map(s -> s.split(" " )[2])
                        .mapToInt(s -> Integer.parseInt(s))
                        .sum();
                nbyears += nbmonth / 12;
                nbmonth = nbmonth % 12;
                System.out.println(nbmonth +" " +nbyears);
                cventity.setExperience(nbyears + nbmonth / 12.0);
                /** Converting array of data to list of data **/
                List cvList = Arrays.asList(lines);
                /**Declaring a list to extract skills from cv and insert into this list **/
                List skillsList = new ArrayList<String>();


                /** Inserting skills into our list nammed skillsList **/
                    for (int j = cvList.indexOf("Skills & Expertise")+1; j < cvList.indexOf("Languages")-1 ; j++) {
                        skillsList.add(cvList.get(j));
                        System.out.println(cvList.get(j));

                    }
                  /** Converting our result list to string to insert data to our database **/
                String result = (String) skillsList.stream().
                        map(i -> String.valueOf(i)).
                        collect(Collectors.joining("/"));
                    cventity.setSkills(result);
                System.out.println("*****************************************");


            cvrepository.save(cventity);

            }
        }catch (IOException e ){
            e.printStackTrace();
        }

    }
}