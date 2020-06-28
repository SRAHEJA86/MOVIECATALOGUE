package com.magellan.controller;

import com.magellan.model.Rating;
import com.magellan.model.UserRating;
import com.magellan.service.RatingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ratings")
public class MovieRatingResource {
    @Resource
    RatingService ratingService;

    /**
     *
     * @param rating
     * @return
     */
    @GetMapping("/{rating}")
    public UserRating getRatingAbove(@PathVariable("rating") String rating){
        return ratingService.getRating(rating);
    }

    /**
     *
     * @param rating
     */
    @PostMapping
    public void addRating(@RequestBody Rating rating){
        ratingService.addRating(rating);
    }

    /**
     * Updates the rating
     * @param rating request body
     */
    @PutMapping
    public void updateRating(@RequestBody Rating rating){
        ratingService.updateRating(rating);
    }

    /**
     * Deletes a rating
     * @param rating request body
     */
    @DeleteMapping
    public void deleteRating(@RequestBody Rating rating){
        ratingService.deleteRating(rating);
    }

    /**
     *Returns rating for all the movies
     * @return the rating for a movie ID
     */
    @GetMapping
    public UserRating getAllRating(){
        return ratingService.getAllRating();
    }

}
