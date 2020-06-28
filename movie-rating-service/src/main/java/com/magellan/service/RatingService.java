package com.magellan.service;

import com.magellan.db.RatingDAO;
import com.magellan.model.Rating;
import com.magellan.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RatingService {
    @Resource
    RatingDAO ratingDAO;

    @Autowired
    UserRating userRating;

    /**
     * Returns list of all movie ratings which are above or equal to the given rating
     * @return List of rating
     */
    public UserRating getRating(String rating){
        userRating.setRatings(ratingDAO.getRating(rating));
        return userRating;
    }

    /**
     *Inserts a new rating corresponding to a movie Id
     * @param rating
     */
    public void addRating(Rating rating){
        ratingDAO.insertRating(rating);
    }

    /**
     * Updates the rating corresponding to a movie ID
     */
    public void updateRating(Rating rating){
        ratingDAO.updateRating(rating);
    }

    /**
     * Deletes the rating corresponding to a movie ID
     */
    public void deleteRating(Rating rating){
        ratingDAO.deleteRating(rating);
    }

    /**
     * Get all rating for all the movies
     */
    public UserRating getAllRating() {
        userRating.setRatings(ratingDAO.getAllRating());
        return userRating;
    }
}
