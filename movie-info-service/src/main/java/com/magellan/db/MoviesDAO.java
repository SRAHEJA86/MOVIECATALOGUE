package com.magellan.db;

import com.magellan.model.Movie;

import java.util.List;

public interface MoviesDAO {

    /**
     * Get list of all movies
     * @return
     */
    List<Movie> getAllMovies(String name, String director, String movieId);

    /**
     *Adds a movie
     * @param movie
     */
    void addMovie(Movie movie);

    /**
     * Updates a movie
     * @param movie
     */
    void updateMovie(Movie movie);

    /**
     *Deletes a movie
     * @param movie
     */
    void deleteMovie(Movie movie);

    /**
     * Returns movie based on movieId and
     * @param movieId
     * @return
     */
    List<Movie> getMovie(String movieId);
}
