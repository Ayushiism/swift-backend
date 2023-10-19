package com.example.Swift_backend.repository;

import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Query("SELECT t.show  FROM Theatre t WHERE t.id=?1")
    List<Show> findShowsByTheatreId(long id);
}
