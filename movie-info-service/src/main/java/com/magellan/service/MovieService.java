package com.magellan.service;

import com.magellan.db.MoviesDAO;
import com.magellan.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieService<Movies> {

    @Resource
    MoviesDAO moviesDAO;

    @Autowired
    com.magellan.model.Movies movies;

    /**
     * Returns list of all movies
     * @return list of all movies
     */
    public com.magellan.model.Movies getAllMovies(String name, String director, String movieId){
         List<Movie> moviesList = moviesDAO.getAllMovies(name,director,movieId);
         movies.setMovies(moviesList);
         return movies;
    }

    /**
     *Adds a movie
     * @param movie movie
     */
    public void addMovie(Movie movie){
        moviesDAO.addMovie(movie);
    }

    /**
     * Updates a movie
     * @param movie movie
     */
    public void updateMovie(Movie movie){
        moviesDAO.updateMovie(movie);
    }

    /**
     * Deletes a movie
     */
    public void deleteMovie(Movie movie){
        moviesDAO.deleteMovie(movie);
    }

    /**
     * Returns Movie corresponding to the movie id
     * @param movieId movieId
     * @return movie
     */
    public Movie getMovie(String movieId) {
        List<Movie> movies = moviesDAO.getMovie(movieId);
            if(movies.size()!=0)
            return movies.get(0);
        return new Movie();
    }
}
