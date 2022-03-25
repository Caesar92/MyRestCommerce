package com.example.myrestcommerce.dao.base;


import com.example.myrestcommerce.dao.entity.Movie;
import com.example.myrestcommerce.dao.entity.User;

public interface UserDao extends GenericDao<User, Long> {

    void borrowMovie(Movie movie);

    void returnMovie(Movie movie);
}
