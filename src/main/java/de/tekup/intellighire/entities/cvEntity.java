package de.tekup.intellighire.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="Cv")
@Data
public class cvEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String jobTitle;
    private String email;
    private double experience;
    private String skills;
    private double score;
    private double scoreExperience;
    @ManyToOne
    private AnnonceEntity annonce;



}
