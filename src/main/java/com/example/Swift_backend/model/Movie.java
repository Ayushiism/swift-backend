package com.example.Swift_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "discription")
    private String discription;

    @Column(name = "starCast")
    private String starCast;

    @Column(name = "poster")
    private String poster;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "closingDate")
    private String closingDate;

    @Column(name = "isBlockbuster")
    private String isBlockbuster;

    @Column(name = "prerelease")
    private String prerelease;

    //foreign key
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "r_id", referencedColumnName = "id")
    private Rating rating;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "movie")
    private Set<Show> show = new HashSet<>();

}
