package com.magellan.model;

import java.util.List;

public class Movies {
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    private List<Movie> movies;
}
