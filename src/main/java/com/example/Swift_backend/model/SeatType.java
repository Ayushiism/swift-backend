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
@Table(name = "SeatType")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "originalPrice")
    private long originalPrice;

    @Column(name = "lowerPrice")
    private long lowerPrice;

    @Column(name = "higherPrice")
    private long higherPrice;
}
