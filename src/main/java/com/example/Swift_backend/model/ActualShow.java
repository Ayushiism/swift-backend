package com.example.Swift_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

public class ActualShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "show_id")
    private long show_id;

    @Column(name= "date")
    private Date date;

    @Column(name = "booked_seats")
    private List<String> booked_seats;

    @Column(name = "held_seats")
    private List<String> held_seats;
}
