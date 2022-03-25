package com.example.myrestcommerce.dao;

import com.example.myrestcommerce.dao.base.DirectorDao;
import com.example.myrestcommerce.dao.base.MovieDao;
import com.example.myrestcommerce.dao.base.UserDao;
import com.example.myrestcommerce.dao.jpa.JpaDirectorDao;
import com.example.myrestcommerce.dao.jpa.JpaMovieDao;
import com.example.myrestcommerce.dao.jpa.JpaUserDao;

public class DaoFactory {

    private DaoFactory(){};

    public static MovieDao getMovieDao() { return new JpaMovieDao(); }
    public static DirectorDao getDirectorDoa() { return  new JpaDirectorDao(); }
    public static UserDao getUserDoa() { return  new JpaUserDao(); }
}
