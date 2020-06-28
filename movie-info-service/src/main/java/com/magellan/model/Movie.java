package com.magellan.model;

public class Movie {

    private String name;
    private String description;
    private String director;
    private String movieId;

    public Movie(){

    }

    public Movie(String movieId,String movieName, String description, String director){
        this.movieId = movieId;
        this.name = movieName;
        this.description = description;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
