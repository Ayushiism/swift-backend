package com.example.Swift_backend.repository;

import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.model.SeatOnHolds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ActualShowRepository  extends JpaRepository<ActualShow, Long> {

    @Query("SELECT s FROM ActualShow s WHERE s.show_id = :seat_id AND s.date = :date AND s." )
    List<ActualShow> listOfActualShow(@Param("show_id") long show_id , @Param("date") Date date);
}