package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Rating;
import com.example.Swift_backend.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingImplementation implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating updateConsolidatedRating(Rating rating){
        rating.setConsolidatedRating(rating.getPresentRating());
        ratingRepository.save(rating);
        return rating;
    }
}
