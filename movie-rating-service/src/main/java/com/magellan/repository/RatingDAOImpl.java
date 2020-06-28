package com.magellan.repository;

import com.magellan.db.RatingDAO;
import com.magellan.db.RatingRowMapper;
import com.magellan.model.Rating;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RatingDAOImpl implements RatingDAO {

    NamedParameterJdbcTemplate template;

    public RatingDAOImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    /**
     * Fetches list of all movies above certain rating from the db
     * @param rating rating
     * @return list of ratings
     */
    @Override
    public List<Rating> getRating(String rating) {
        final String sql = "select * from rating where rating =:rating or rating >:rating";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("rating", rating);
        return template.query(sql,param,new RatingRowMapper());
    }

    /**
     * Inserts a rating to the database
     * @param rating rating
     */
    @Override
    public void insertRating(Rating rating) {
        final String sql = "insert into rating(movieId,rating) values(:movieId,:rating)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("movieId", rating.getMovieId())
                .addValue("rating", rating.getRating());
        template.update(sql,param, holder);

    }

    /**
     * Updates the rating in the db
     * @param rating rating
     */
    @Override
    public void updateRating(Rating rating) {
        final String sql = "update rating set rating=:rating where movieId=:movieId";
        Map<String,Object> map= new HashMap<>();
        map.put("movieId", rating.getMovieId());
        map.put("rating",rating.getRating());
        template.execute(sql,map, (PreparedStatementCallback<Object>) PreparedStatement::executeUpdate);

    }

    /**
     * Deletes the rating from the db
     * @param rating rating
     */
    @Override
    public void deleteRating(Rating rating) {
        final String sql = "delete from rating where movieId=:movieId";
        Map<String,Object> map= new HashMap<>();
        map.put("movieId", rating.getMovieId());
        template.execute(sql,map, (PreparedStatementCallback<Object>) PreparedStatement::executeUpdate);
    }

    /**
     * Returns ratings for all the movies
     * @return list of ratings
     */
    @Override
    public List<Rating> getAllRating() {
        final String sql = "select * from rating";
        return template.query(sql,new RatingRowMapper());
    }
}
