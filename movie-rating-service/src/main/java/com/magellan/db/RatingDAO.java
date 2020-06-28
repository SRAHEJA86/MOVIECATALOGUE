package com.magellan.db;

import com.magellan.model.Rating;

import java.util.List;

public interface RatingDAO {

    /**
     * Get all rating
     * @return
     */
    List<Rating> getRating(String rating);
    /**
     * Inserts a rating corresponding to a movieID
     * @param rating
     */
    void insertRating(Rating rating);

    /**
     *Updates a rating corresponding to a movieID
     * @param rating
     */
    void updateRating(Rating rating);

    /**
     * deletes a rating corresponding to a movieID
     * @param rating
     */
    void deleteRating(Rating rating);

    /**
     * gets rating for all the movies
     */
    List<Rating> getAllRating();
}
