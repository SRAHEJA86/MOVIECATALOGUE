package com.magellan.controller;

import com.magellan.model.CatalogItem;
import com.magellan.model.Movie;
import com.magellan.model.Rating;
import com.magellan.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/catalog")
public class CatalogResource {

    @Autowired
    CatalogService catalogService;

    /**
     * Returns the catalog of movies
     * @param movieId movie Id
     * @param name movie name
     * @return the list of movie catalog
     */
    @GetMapping("/movies")
    public List<CatalogItem> getCatalog(@RequestParam(required = false) String movieId,
                                        @RequestParam(required = false) String name){

       return catalogService.getCatalog(movieId,name);
    }

    /**
     * Returns the catalog of movies above certain rating
     * @param rating movie rating
     * @return the list of movie catalog
     */
    @GetMapping("/movies/ratings/{rating}")
    public List<Rating> getCatalogRatings(@PathVariable("rating") String rating){
        return catalogService.getCatalogRatingAbove(rating);
    }

    /**
     *Adds the rating of a movie
     * @param rating rating
     */
    @PostMapping("/movies/rating")
    public void addCatalogRating(@RequestBody Rating rating){
        catalogService.addCatalogRating(rating);
    }

    /**
     * Adds a catalog item to the catalog
     * @param movie movie
     */
    @PostMapping("/movies")
    public void addCatalogMovie(@RequestBody Movie movie){
        catalogService.addCatalogMovie(movie);
    }

    /**
     * Updates the catalog based on name,director name, rating
     * @param rating rating
     */
    @PutMapping("/movies/rating")
    public void updateCatalogRating(@RequestBody Rating rating){
        catalogService.updateCatalogRating(rating);
    }

    /**
     * Updates the catalog based on movie name,director name, description
     */
    @PutMapping("/movies")
    public void updateCatalogMovie(@RequestBody Movie movie){
        catalogService.updateCatalogMovie(movie);
    }


    /**
     * Deletes movies in the catalog
     * @param movie movie
     */
    @DeleteMapping("/movies")
    public void deleteCatalogMovie(@RequestBody Movie movie){
        catalogService.deleteCatalogMovie(movie);
    }

    /**
     * Deletes rating of a movie in the catalog
     * @param rating rating
     */
    @DeleteMapping("/movies/rating")
    public void deleteCatalogRating(@RequestBody Rating rating){
        catalogService.deleteCatalogRating(rating);
    }

}
