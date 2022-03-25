package com.example.myrestcommerce.dao.entity;
import com.example.myrestcommerce.controller.model.MovieResponse;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  double duration;
    private LocalDate releaseDate;
    private boolean available;

    @ManyToOne
    private Director director;

    @ManyToOne
    private User user;

    public Movie() {

    }

    public Movie(String title, double duration, LocalDate releaseDate) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.available = true;
    }

    public MovieResponse toDTO(){
        MovieResponse m = new MovieResponse();
        m.setId(this.id);
        m.setTitle(this.title);
        m.setDuration(this.duration);
        m.setReleaseDate(this.releaseDate);
        m.setAvailable(this.available);
        return m;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", available=" + available +
                ", director=" + director +
                ", user=" + user +
                '}';
    }
}

