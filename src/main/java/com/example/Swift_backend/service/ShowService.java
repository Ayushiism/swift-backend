package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Movie;
import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;

import java.util.List;

public interface ShowService {

//    Theatre getShowById(long id);

    List<Show> getShowsByTheaterId(long id);

    Show saveShow(Show show);

}
