package com.example.myrestcommerce.dao.entity;

import com.example.myrestcommerce.controller.model.MovieResponse;
import com.example.myrestcommerce.controller.model.UserResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Person{

    private boolean susbrib;

    @OneToMany
    private List<Movie> movies;

    public User() {}

    public User(String firstName, String lastName, boolean susbrib) {
        super(firstName, lastName);
        this.susbrib = susbrib;
        this.movies = new ArrayList<>();
    }

    public UserResponse toDTO(){
        UserResponse u = new UserResponse();
        u.setId(this.getId());
        u.setFirstName(this.getFirstName());
        u.setLastName(this.getLastName());
        u.setSusbrib(this.susbrib);
        u.setMovieResponses(this.toDTO().getMovieResponses());
        return u;
    }

    public boolean isSusbrib() {
        return susbrib;
    }

    public void setSusbrib(boolean susbrib) {
        this.susbrib = susbrib;
    }
}
