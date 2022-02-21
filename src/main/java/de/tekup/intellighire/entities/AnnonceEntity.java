package de.tekup.intellighire.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="Annonce")
@Data
public class AnnonceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String jobTitle ;
    private double experienceRequired ;
    @Enumerated(EnumType.STRING)
    private JobExperience  jobExperience;
    private String skillsRequired ;
    @Enumerated(EnumType.STRING)
    private Theme theme1;
    @Enumerated(EnumType.STRING)
    private Theme theme2;

    @OneToMany(mappedBy = "annonce")
    private List<cvEntity> cvs;

    public List<Theme> getAllTheme(){
       return  Arrays.asList(theme1,theme2).stream()
                .filter(t->t!=null)
                .collect(Collectors.toList());
    }
}
