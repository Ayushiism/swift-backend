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
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    //foreign key
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name = "t_id", referencedColumnName = "id")
    private Theatre theatre;
}
