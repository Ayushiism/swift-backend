package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

}