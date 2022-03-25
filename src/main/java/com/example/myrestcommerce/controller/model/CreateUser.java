package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Movie;

import java.io.Serializable;
import java.util.List;

public class CreateUser extends PersonWithoutID implements Serializable  {

    private boolean susbrib;
    private List<Movie> movies;

    public CreateUser() {}

    public boolean isSusbrib() {
        return susbrib;
    }

    public void setSusbrib(boolean susbrib) {
        this.susbrib = susbrib;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "CreateUser{" +
                "susbrib=" + susbrib +
                ", movies=" + movies +
                '}';
    }
}

