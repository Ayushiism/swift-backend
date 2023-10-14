package com.example.Swift_backend.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "presentRating")
    private long presentRating;

    @Column(name = "sampleSpace")
    private long samplespace;

    @OneToOne(mappedBy = "rating")
    private Movie movie;

}
