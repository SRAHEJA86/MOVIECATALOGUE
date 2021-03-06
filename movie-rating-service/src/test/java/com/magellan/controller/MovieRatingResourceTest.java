package com.magellan.controller;

import com.magellan.MovieRatingApplication;
import com.magellan.MovieRatingConfig;
import com.magellan.db.RatingDAO;
import com.magellan.service.RatingService;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MovieRatingApplication.class)
@ContextConfiguration(classes = {MovieRatingConfig.class})
class MovieRatingResourceTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @BeforeEach
    void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Ignore
    @Test
    void testGetMovieRating() {
        String url = "/rating/ABC";
        try {
            mockMvc.perform(get(url))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    //.andExpect(MockMvcResultMatchers.content().json(jsonResponseForUsersInAndAroundLondon))
                    .andDo(print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Ignore
    @Test
    void testGetAllRating() {
        String url = "/ratings";
        try {
            mockMvc.perform(get(url))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    //.andExpect(MockMvcResultMatchers.content().json(jsonResponseForUsersInAndAroundLondon))
                    .andDo(print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}