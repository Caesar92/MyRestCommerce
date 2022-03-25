package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Movie;

import java.io.Serializable;
import java.util.List;

public class CreateDirector extends PersonWithoutID implements Serializable  {

    private List<Movie> movies;
    public CreateDirector() {}

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "CreateDirector{" +
                "movies=" + movies +
                '}';
    }
}

