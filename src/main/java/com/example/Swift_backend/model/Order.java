package com.example.Swift_backend.model;

import com.couchbase.client.core.deps.com.google.type.DateTime;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "seat")
    private List<String> seat;

    @Column(name = "price")
    private  long price;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "timeStamp")
    private DateTime timeStamp;



}

