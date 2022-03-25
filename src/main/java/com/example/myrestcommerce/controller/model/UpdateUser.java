package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Movie;

import java.io.Serializable;
import java.util.List;

public class UpdateUser extends PersonWithoutID implements Serializable  {

    private boolean susbrib;
    private List<Movie> movies;

    public UpdateUser() {}

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
        return "UpdateUser{" +
                "susbrib=" + susbrib +
                ", movies=" + movies +
                '}';
    }
}

