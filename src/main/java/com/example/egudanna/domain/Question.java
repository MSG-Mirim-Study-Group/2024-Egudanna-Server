package com.example.egudanna.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="questions")
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="questionId", nullable = false)
    private Long id;

    @Column(name="question", nullable = false)
    private String question;

    @Column(name = "answer")
    private String answer;


}
