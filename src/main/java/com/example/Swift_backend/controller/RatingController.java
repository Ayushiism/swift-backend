package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.Rating;
import com.example.Swift_backend.service.RatingImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("rating")
public class RatingController {

    @Autowired
    private RatingImplementation ratingImplementation;

    @PostMapping("/add-user-rating")
    public Rating addUserRating(@RequestBody Map<String, String> request) {

        Rating response = ratingImplementation.addNewRating(Long.parseLong(request.get("ratingId")),Integer.parseInt(request.get("userRating")));
        return response;
    }
}
