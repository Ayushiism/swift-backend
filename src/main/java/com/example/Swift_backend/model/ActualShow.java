package com.example.Swift_backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actualshow")
public class ActualShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "show_id")
    private long show_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id" , referencedColumnName = "id")
    private Show show;


    @Column(name= "date")
    private Date date;

    @Column(name = "booked_seats")
    private List<String> booked_seats;

    @Column(name = "held_seats")
    private List<String> held_seats;
}
