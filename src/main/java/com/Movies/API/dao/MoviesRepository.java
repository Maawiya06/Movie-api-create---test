package com.Movies.API.dao;

import com.Movies.API.Entities.Movies;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    // by this we push data in database
    public Movies findById(int id);
}
