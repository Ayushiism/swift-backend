package com.example.Swift_backend.repository;


import com.example.Swift_backend.model.SeatOnHolds;
import org.aspectj.weaver.ast.And;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface SeatOnHoldRepository extends JpaRepository<SeatOnHolds, Long> {

    @Query("SELECT s FROM SeatOnHolds s WHERE s.movie_id = :movie_id AND s.theater_id = :theater_id AND s.show_id=:show_id AND s.date=:date")
    List<SeatOnHolds> listOfHoldSeats(@Param("movie_id") long movie_id , @Param("theater_id") long theater_id, @Param("show_id") long show_id , @Param("date")Date date);
}
