package com.magellan.db;

import com.magellan.model.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(resultSet.getString("movieId"));
        movie.setDescription(resultSet.getString("description"));
        movie.setDirector(resultSet.getString("director"));
        movie.setName(resultSet.getString("name"));
        return movie;
    }
}
