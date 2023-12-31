package com.example.Swift_backend.model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

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

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "description")
    private String description;

    @Column(name = "star_cast")
    private String star_cast;

    @Column(name = "poster")
    private String poster;

    @Column(name = "release_date")
    private Date release_date;

    @Column(name = "closing_date")
    private Date closing_date;

    @Column(name = "isBlockbuster")
    private Boolean isBlockbuster;

    @Column(name = "prerelease")
    private Boolean prerelease;

    //foreign key
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "movie")
    private Set<Show> show;
}
