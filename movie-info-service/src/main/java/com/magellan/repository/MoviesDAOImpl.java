package com.magellan.repository;

import com.magellan.db.MovieRowMapper;
import com.magellan.db.MoviesDAO;
import com.magellan.model.Movie;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MoviesDAOImpl implements MoviesDAO {
    NamedParameterJdbcTemplate template;

    public MoviesDAOImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    @Override
    public List<Movie> getAllMovies(String name, String director, String movieId) {
        StringBuilder sql = new StringBuilder("select * from movies");

        if(!StringUtils.isEmpty(name)){ sql.append(" where name=:name"); };
        if(!StringUtils.isEmpty(director)) { sql.append(" where director=:director");};
        if(!StringUtils.isEmpty(movieId)) { sql.append(" where movieId=:movieId");};
            
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("movieId",movieId)
                .addValue("name", name)
                .addValue("director",director);
        return template.query(sql.toString(),param,new MovieRowMapper());
    }

    @Override
    public void addMovie(Movie movie) {
        final String sql = "insert into movies(movieId,name,description,director) values" +
                "(:movieId,:name,:description,:director)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("movieId", movie.getMovieId())
                .addValue("name", movie.getName())
                .addValue("description",movie.getDescription())
                .addValue("director",movie.getDirector());
        template.update(sql,param, holder);
    }

    @Override
    public void updateMovie(Movie movie) {
        final String sql = "update movies set name=:name,description=:description,director=:director where movieId=:movieId";
        Map<String,Object> map= new HashMap<>();
        map.put("movieId", movie.getMovieId());
        map.put("name",movie.getName());
        map.put("description",movie.getDescription());
        map.put("director",movie.getDirector());
        template.execute(sql,map, (PreparedStatementCallback<Object>) PreparedStatement::executeUpdate);
    }

    @Override
    public void deleteMovie(Movie movie) {
        final String sql = "delete from movies where movieId=:movieId";
        Map<String,Object> map=new HashMap<>();
        map.put("movieId", movie.getMovieId());
        template.execute(sql,map, (PreparedStatementCallback<Object>) PreparedStatement::executeUpdate);
    }

    @Override
    public List<Movie> getMovie(String movieId) {
        final String sql = "select * from movies where movieId =:movieId";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("movieId", movieId);
        return template.query(sql,param,new MovieRowMapper());
    }
}
