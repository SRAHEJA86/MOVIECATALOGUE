package com.magellan.service;

import com.magellan.model.CatalogItem;
import com.magellan.model.Movie;
import com.magellan.model.Rating;
import com.magellan.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogService {

    @Autowired
    RestTemplate restTemplate;
    private final String ratingUrl = "http://localhost:8183/ratings";
    private final String movieUrl = "http://localhost:8184/movies";

    public List<CatalogItem> getCatalog(String movieId, String director){
        // get all rated movie Ids

        UserRating userRating = restTemplate.getForObject(ratingUrl, UserRating.class);

        return userRating.getRatings().stream().map(
                ratingItem -> {
                    Movie movie = restTemplate.getForObject(movieUrl +"/"+ratingItem.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(),movie.getDescription(),movie.getDirector(),
                            ratingItem.getRating());
                }
           ).collect(Collectors.toList());

    }

    /**
     * Updates the catalog
     * @param movie movie
     */
    public void updateCatalogMovie(Movie movie) {
        restTemplate.put(movieUrl,movie);
    }

    /**
     * Deletes the catalog movie
     * @param movie movie
     */
    public void deleteCatalogMovie(Movie movie) {
                restTemplate.exchange(movieUrl,
                        HttpMethod.DELETE,
                        new HttpEntity<>(movie),
                        String.class,
                        movie.getMovieId());
    }

    /**
     * Adds a movie to the catalog
     * @param movie movie
     */
    public void addCatalogMovie(Movie movie) {
        restTemplate.postForObject(movieUrl,movie,String.class);
    }

    /**
     * Adds rating to a movie
     * @param rating rating
     */
    public void addCatalogRating(Rating rating) {
        restTemplate.postForObject(ratingUrl,rating,String.class);
    }

    /**
     *Updates the rating for a movie
     * @param rating rating
     */
    public void updateCatalogRating(Rating rating) {
        restTemplate.put(ratingUrl,rating);
    }

    /**
     * Deletes rating of a movie in a catalog
     * @param rating rating
     */
    public void deleteCatalogRating(Rating rating) {
         restTemplate.exchange(ratingUrl,
                        HttpMethod.DELETE,
                        new HttpEntity<>(rating),
                        String.class,
                        rating.getMovieId());
    }

    /**
     * Returns all movies above a certain rating
     * @param rating rating
     * @return movies
     */
    public List<Rating> getCatalogRatingAbove(String rating) {
        UserRating userRating = restTemplate.getForObject(ratingUrl+"/"+rating, UserRating.class);
        assert userRating != null;
        return userRating.getRatings();
    }
}
