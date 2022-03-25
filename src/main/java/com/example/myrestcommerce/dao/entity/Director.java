package com.example.myrestcommerce.dao.entity;

import com.example.myrestcommerce.controller.model.DirectorResponse;
import com.example.myrestcommerce.controller.model.MovieResponse;
import com.example.myrestcommerce.controller.model.UserResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Director extends Person{

    @OneToMany
    private List<Movie> movies;

    public Director() {}

    public Director(String firstName, String lastName) {
        super(firstName, lastName);
        this.movies = new ArrayList<>();
    }

    public DirectorResponse toDTO(){
        DirectorResponse d = new DirectorResponse();
        d.setId(this.getId());
        d.setFirstName(this.getFirstName());
        d.setLastName(this.getLastName());
        // Non fonctionnel
        /*List<MovieResponse> movies = new ArrayList<>();
        for(Movie m : this.getMovies())
            movies.add(m.toDTO());
        d.setMovies(movies);*/
        return d;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
