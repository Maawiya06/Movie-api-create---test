package com.Movies.API.Controller;

import com.Movies.API.Entities.Movies;
import com.Movies.API.Service.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MoviesServices moviesServices;


    @GetMapping("/movies")


    //get all books
    public ResponseEntity<List<Movies>> getMovies(){
        List<Movies> list = moviesServices.getAllMovies();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // get single movies
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movies> getMovies(@PathVariable("id") int id){
        Movies movies = moviesServices.getMoviesbyId(id);

        if(movies == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(movies));
    }

    // post the books
    @PostMapping("/movies")
    public ResponseEntity<Movies> addMovies(@RequestBody Movies movies) {
        Movies m = null;

        try {
            m = this.moviesServices.addMovies(movies);
            return ResponseEntity.of(Optional.of(m));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // delete the data
    @DeleteMapping("/movies/{moviesId}")
    public ResponseEntity<Void> deletedata(@PathVariable("moviesId") int moviesId){
        try{
            this.moviesServices.deleteData(moviesId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // update
    @PutMapping("/movies/{moviesId}")
    public ResponseEntity<Movies> updatedata(@RequestBody Movies movies, @PathVariable("moviesId") int moviesId){

        try{
            this.moviesServices.updatedata(movies,moviesId);
            return ResponseEntity.ok().body(movies);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
