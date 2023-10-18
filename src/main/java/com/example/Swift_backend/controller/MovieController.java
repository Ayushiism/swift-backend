package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.Movie;
import com.example.Swift_backend.service.MovieServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/customer")
public class MovieController {

    @Autowired
    private MovieServiceImplementation movieServiceImplementation;

    @GetMapping("/movies")
    public Map<String, Object> getMovies() {

        Map<String, Object> response = new HashMap<String, Object>();

        response.put("movieDetail", movieServiceImplementation.getAllMovies()==null?"":movieServiceImplementation.getAllMovies());
        return response;
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieServiceImplementation.saveMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }
}