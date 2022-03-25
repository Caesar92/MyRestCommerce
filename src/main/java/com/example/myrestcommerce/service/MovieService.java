package com.example.myrestcommerce.service;

import com.example.myrestcommerce.controller.model.MovieResponse;
import com.example.myrestcommerce.controller.model.UpdateMovie;
import com.example.myrestcommerce.dao.DaoFactory;
import com.example.myrestcommerce.dao.base.MovieDao;
import com.example.myrestcommerce.dao.entity.Movie;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MovieService {

    public static MovieDao movieDao = DaoFactory.getMovieDao();

    public List<MovieResponse> fetchAll(){
        return movieDao.getAll().stream()
                .map(m -> m.toDTO())
                .collect(Collectors.toList());
    }

    public MovieResponse fetchById(long id){
        return movieDao.findById(id).toDTO();
    }

    public Long create(Movie movieToCreate){
        return movieDao.add(movieToCreate);
    }

    public void update(Long id, UpdateMovie um){
        Movie m = new Movie(um.getTitle(),um.getDuration(),um.getReleaseDate());
        m.setId(id);
        movieDao.update(m);
    }

    public void delete(Long id){
        movieDao.remove(id);
    }

    public void delete(Movie movieToDelete){
        movieDao.remove(movieToDelete);
    }

}
