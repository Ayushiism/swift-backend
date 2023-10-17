package com.example.Swift_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seatsonhold")
public class SeatOnHolds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "theater_id")
    private long theater_id;

    @Column(name = "movie_id")
    private long movie_id;

    @Column(name = "show_id")
    private long show_id;

    @Column(name= "date")
    private Date date;

    @Column(name = "seat_id")
    private long seat_id;

}
