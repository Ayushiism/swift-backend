package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Movie;
import com.example.Swift_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}

