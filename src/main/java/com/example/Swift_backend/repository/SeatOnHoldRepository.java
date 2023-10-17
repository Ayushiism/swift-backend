package com.example.Swift_backend.repository;


import com.example.Swift_backend.model.SeatOnHolds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SeatOnHoldRepository extends JpaRepository<SeatOnHolds, Long> {

    @Query("SELECT s FROM SeatOnHolds s WHERE s.seat_id = :seat_id")
    List<SeatOnHolds> listOfHoldSeats(@Param("seat_id") long seat_id);
}
