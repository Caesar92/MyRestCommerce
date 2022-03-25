package com.example.myrestcommerce.controller.model;
import com.example.myrestcommerce.dao.entity.Director;
import com.example.myrestcommerce.dao.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateMovie implements Serializable {

    private String title;
    private  double duration;
    @JsonFormat(pattern = "dd-MM-yyyy")  //precisse le rendu du json
    private LocalDate releaseDate;

    private Director director;
    private User user;

    public CreateMovie() {

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
        return "CreateMovie{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", director=" + director +
                ", user=" + user +
                '}';
    }
}

