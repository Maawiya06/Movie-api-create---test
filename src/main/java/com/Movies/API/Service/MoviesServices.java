package com.Movies.API.Service;

import com.Movies.API.Entities.Movies;
import com.Movies.API.dao.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServices {

    @Autowired
    private MoviesRepository moviesRepository;

    // get all movies
    public List<Movies> getAllMovies(){
        List<Movies> list = (List<Movies>) this.moviesRepository.findAll();
        return list;
    }

    // get single Movie by id
    public Movies getMoviesbyId(int id){

        Movies movie = null;
        try{
            movie = this.moviesRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return movie;
    }

    // adding the movies
    public Movies addMovies(Movies m){
        Movies result = moviesRepository.save(m);
        return result;
    }

    // deleteting
    public void deleteData(int bid){
        moviesRepository.deleteById(bid);
    }

    // update the book
    public void updatedata(Movies movies, int mid){
        movies.setId(mid);
        moviesRepository.save(movies);
    }
}
