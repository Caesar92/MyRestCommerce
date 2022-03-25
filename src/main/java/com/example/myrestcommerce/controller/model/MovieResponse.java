package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class MovieResponse implements Serializable {

    private Long id;
    private String title;
    private  double duration;
    @JsonFormat(pattern = "dd-MM-yyyy")  //precisse le rendu du json
    private LocalDate releaseDate;
    private boolean available;

    public MovieResponse() {}

    public Movie toMovie(){
        Movie m = new Movie();
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

    @Override
    public String toString() {
        return "MovieResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", available=" + available +
                '}';
    }
}

