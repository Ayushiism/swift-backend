package com.example.Swift_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "location_name")
    private String location_name;

    //foreign key
    @OneToMany(cascade= CascadeType.ALL)

    @JoinColumn(name = "theater_id", referencedColumnName = "id")
    private Set<Theatre> theatre;
}
