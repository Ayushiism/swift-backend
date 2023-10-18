package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Rating;

public interface RatingService {
    Rating updateConsolidatedRating(Rating rating);

    Rating addNewRating(long rating_id, int userRating);
}
