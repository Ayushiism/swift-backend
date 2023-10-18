package com.example.Swift_backend.controller;

import com.example.Swift_backend.service.LocationServiceImplementation;
import com.example.Swift_backend.service.MovieServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
