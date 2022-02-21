package de.tekup.intellighire.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private  cvEntity cv;

    private int scoreQuiz;

}
