package com.example.Swift_backend.model;

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
@Table(name = "show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "time")
    private Time time;

    @Column(name = "booked_seats")
    private List<String> booked_seats;

    @Column(name = "seats_on_hold")
    private List<String> seats_on_hold;

    private Set<Theatre> theatre = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

//    @OneToMany(mappedBy="cart")
//    private Set<User> users;

}
