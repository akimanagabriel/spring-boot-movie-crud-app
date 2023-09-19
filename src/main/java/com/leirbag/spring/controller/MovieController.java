package com.leirbag.spring.controller;

import com.leirbag.spring.entity.Movie;
import com.leirbag.spring.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {
    @Autowired
    MovieService service;

    @GetMapping
    public List<Movie> index() {
        return service.getAllMovies();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return service.createMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie getSingleMovieById(@PathVariable int id){
        return service.showMovie(id);
    }
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id){
        return service.deleteMovie(id);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable int id,@RequestBody Movie movie){
        return service.updateMovie(id,movie);
    }

}
