package com.magellan;

import com.magellan.model.UserRating;
import com.magellan.service.RatingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieRatingConfig {
    @Bean
    public RatingService getRatingService(){
        return new RatingService();
    }

    @Bean("Prototype")
    public UserRating getUserRating(){
        return new UserRating();
    }

}
