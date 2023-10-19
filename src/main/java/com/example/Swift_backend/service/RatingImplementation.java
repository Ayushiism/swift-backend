package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Rating;
import com.example.Swift_backend.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

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

    @Override
    public Rating addNewRating(long ratingId, int userRating){

        Rating rating = ratingRepository.getReferenceById(ratingId);
        Float newCurrentRating = (rating.getPresentRating()*rating.getSamplespace() + userRating)/(rating.getSamplespace()+1);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        rating.setPresentRating(Float.valueOf(decimalFormat.format(newCurrentRating)));
        rating.setSamplespace(rating.getSamplespace()+ 1);

        ratingRepository.save(rating);
        return rating;
    }
}
