package com.magellan.model;

import java.util.List;

public class UserRating {
    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public UserRating(){

    }

    List<Rating> ratings;
}
