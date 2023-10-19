package com.example.Swift_backend.model;

import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "theatre")

public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "theaterName")
    private String theaterName;

    @Column(name = "theaterAddress")
    private String theaterAddress;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "theatre")
    private Set<Show> show;

}
