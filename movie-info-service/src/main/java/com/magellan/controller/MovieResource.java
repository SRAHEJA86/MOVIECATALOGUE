package com.magellan.controller;

import com.magellan.model.Movie;
import com.magellan.model.Movies;
import com.magellan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    MovieService movieService;

    @GetMapping("/{movieId}")
    public Movie getMovies(@PathVariable("movieId") String movieId) {
        return movieService.getMovie(movieId);
    }

    @GetMapping
    public Movies getAllMovies(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String director,
                               @RequestParam(required = false) String movieId) {
        return movieService.getAllMovies(name,director,movieId);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @PutMapping
    public void updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
    }

    @DeleteMapping
    public void deleteMovie(@RequestBody Movie movie) {
        movieService.deleteMovie(movie);
    }

}
