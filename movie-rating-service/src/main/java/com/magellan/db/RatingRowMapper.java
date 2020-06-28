package com.magellan.db;

import com.magellan.model.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingRowMapper implements RowMapper<Rating> {

    @Override
    public Rating mapRow(ResultSet resultSet, int i) throws SQLException {
        Rating rating = new Rating();
        rating.setMovieId(resultSet.getString("movieId"));
        rating.setRating(resultSet.getString("rating"));
        return rating;
    }
}
