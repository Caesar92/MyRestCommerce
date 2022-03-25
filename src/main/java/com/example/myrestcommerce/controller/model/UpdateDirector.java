package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UpdateDirector extends PersonWithoutID implements Serializable  {

    private List<MovieResponse> movies = new ArrayList<>();

    public UpdateDirector() {}

    public List<MovieResponse> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieResponse> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "UpdateDirector{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", movies=" + movies +
                '}';
    }
}

