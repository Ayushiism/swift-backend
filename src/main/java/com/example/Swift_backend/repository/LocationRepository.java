package com.example.Swift_backend.repository;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT l.theatre  FROM Location l WHERE l.id=?1")
    List<Theatre> findTheatresByLocationId(long id);
}
