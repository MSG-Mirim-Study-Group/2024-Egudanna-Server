package com.example.egudanna.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@DynamicUpdate
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId", updatable = false, nullable = false)
    private Long id;

    @Column(name = "genre", nullable = false)
    private String genre;
}
