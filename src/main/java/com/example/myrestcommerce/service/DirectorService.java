package com.example.myrestcommerce.service;

import com.example.myrestcommerce.controller.model.DirectorResponse;
import com.example.myrestcommerce.controller.model.MovieResponse;
import com.example.myrestcommerce.controller.model.UpdateDirector;
import com.example.myrestcommerce.dao.DaoFactory;
import com.example.myrestcommerce.dao.base.DirectorDao;
import com.example.myrestcommerce.dao.entity.Director;
import com.example.myrestcommerce.dao.entity.Movie;


import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DirectorService {

    public static DirectorDao directorDao = DaoFactory.getDirectorDoa();

    public List<DirectorResponse> fetchAll(){
        System.out.println("RETOUR DE BASE : -----------");
        System.out.println(directorDao.getAll());
        System.out.println("---------------------------------");
        return directorDao.getAll().stream()
                .map(d -> d.toDTO())
                .collect(Collectors.toList());
    }

    public DirectorResponse fetchById(long id){
        return directorDao.findById(id).toDTO();
    }

    public Long create(Director cd){
         return directorDao.add(cd);
    }

    public void update(Long id, UpdateDirector ud){
        Director d = new Director(ud.getFirstName(), ud.getLastName());
        List<Movie> movies = new ArrayList<>();
        for(MovieResponse mr : ud.getMovies())
            movies.add(mr.toMovie());
        d.setMovies(movies);
        d.setId(id);
        directorDao.update(d);
    }

    public void delete(Long id){
        directorDao.remove(id);
    }

    public void delete(Director dd){
        directorDao.remove(dd);
    }

}
