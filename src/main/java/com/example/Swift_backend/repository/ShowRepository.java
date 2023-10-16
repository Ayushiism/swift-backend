package com.example.Swift_backend.repository;

import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("SELECT s FROM Show s WHERE :theatre MEMBER OF s.theatre")
    List<Show> findShowsByTheatre(Theatre theatre);
}
