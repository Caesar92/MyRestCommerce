package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Movie;
import org.w3c.dom.ls.LSInput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserResponse extends Person implements Serializable  {

    private boolean susbrib;

    private List<MovieResponse> movieResponses;

    public UserResponse() {}

    public boolean isSusbrib() {
        return susbrib;
    }

    public void setSusbrib(boolean susbrib) {
        this.susbrib = susbrib;
    }

    public List<MovieResponse> getMovieResponses() {
        return movieResponses;
    }

    public void setMovieResponses(List<MovieResponse> movieResponses) {
        this.movieResponses = movieResponses;
    }
}

