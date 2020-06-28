package com.magellan.model;

public class CatalogItem {

    private String name;
    private String description;
    private String directorName;
    private String rating;

    public CatalogItem(){

    }

    public CatalogItem (String name, String description, String directorName, String rating) {
        this.name = name;
        this.description = description;
        this.directorName = directorName;
        this.rating = rating;
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

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
