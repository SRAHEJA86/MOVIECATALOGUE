package com.magellan.repository;


import com.magellan.db.RatingRowMapper;
import com.magellan.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class RatingDAOImplTest {
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Mock
    NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    public void whenMockJdbcTemplate_thenGetCorrectRating() {
        String sql = "select * from rating where rating =:rating or rating >:rating";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("rating", "3");
        List<Rating> ratingList = Arrays.asList(
                new Rating("100","3"),
                new Rating("200","5"),
                new Rating("300","4"));

        RatingDAOImpl ratingDAOImpl = new RatingDAOImpl(jdbcTemplate);
        Mockito.when(jdbcTemplate.query(sql,param,new RatingRowMapper())).thenReturn(ratingList);
        assertEquals(3,ratingDAOImpl.getRating("3").size());
    }

    @Test
    void whenMockJdbcTemplate_thenGetAllCorrectRating() {
        final String sql = "select * from rating";
        List<Rating> ratingList = Arrays.asList(
                new Rating("100","3"),
                new Rating("200","5"),
                new Rating("300","4"));
        RatingDAOImpl ratingDAOImpl = new RatingDAOImpl(jdbcTemplate);
        Mockito.when(jdbcTemplate.query(sql,new RatingRowMapper())).thenReturn(ratingList);
        assertEquals(3,ratingDAOImpl.getAllRating().size());
    }

    @Test
    void whenMockJdbcTemplate_thenInsertCorrectRating() {
        final String sql = "insert into rating(movieId,rating) values(:movieId,:rating)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("movieId", "400")
                .addValue("rating", "3");
        Mockito.when(jdbcTemplate.update(sql,param, holder));
        RatingDAOImpl ratingDAOImpl = new RatingDAOImpl(jdbcTemplate);
        Rating rating = new Rating("400","3");
        Mockito.verify(jdbcTemplate);
    }
}