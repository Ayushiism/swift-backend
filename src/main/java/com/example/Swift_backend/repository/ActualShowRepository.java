package com.example.Swift_backend.repository;
import com.example.Swift_backend.model.ActualShow;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Swift_backend.model.Show;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;


@Repository
public interface ActualShowRepository extends JpaRepository<ActualShow, Long> {

    List<ActualShow> findByShowAndDate(Show show, Date date);
}

