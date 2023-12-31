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

    @ManyToMany
    @JoinTable(
            name = "theatre-show",
            joinColumns = @JoinColumn(
                    name = "theatre_id" , referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "show_id", referencedColumnName = "id"
            )
    )
    private Set<Show> show;

}
