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
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long admin_id;

    @Column(name = "adminEmail")
    private String adminEmail;

    @Column(name = "adminPassword")
    private String adminPassword;

}
