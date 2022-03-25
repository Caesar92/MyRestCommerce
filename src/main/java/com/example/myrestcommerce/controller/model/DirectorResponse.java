package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DirectorResponse extends Person implements Serializable  {


    public DirectorResponse() {}

    public List<MovieResponse> movies = new ArrayList<>();

    public List<MovieResponse> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieResponse> movies) {
        this.movies = movies;
    }
}

