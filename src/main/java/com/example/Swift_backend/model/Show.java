package com.example.Swift_backend.model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`show`")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "showTime")
    private Time showTime;


    @ManyToMany(mappedBy = "show")
    private Set<Theatre> theatre;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id" , referencedColumnName = "id")
    private Movie movie;

//
//    @OneToMany(mappedBy="show")

//    private Set<User> users;

}
