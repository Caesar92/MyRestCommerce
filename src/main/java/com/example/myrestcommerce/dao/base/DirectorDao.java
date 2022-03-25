package com.example.myrestcommerce.dao.base;

import com.example.myrestcommerce.dao.entity.Director;
import com.example.myrestcommerce.dao.entity.Movie;
import com.example.myrestcommerce.dao.entity.Person;

public interface DirectorDao extends GenericDao<Director, Long> {

    Long realizeMovie(Movie movie);
}
