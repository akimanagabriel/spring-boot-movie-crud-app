package com.leirbag.spring.services;

import com.leirbag.spring.entity.Movie;
import com.leirbag.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Movie createMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie showMovie(int movieId) {
        return repository.findById(movieId).orElse(null);
    }

    public String deleteMovie(int id) {
        repository.deleteById(id);
        return "Movie deleted successfully";
    }

    public Movie updateMovie(int id, Movie movie) {
        Movie existMovie = repository.findById(id).orElse(null);
        if (existMovie == null) {
            return null;
        } else {
            existMovie.setGenre(movie.getGenre());
            existMovie.setTitle(movie.getTitle());
            existMovie.setStars(movie.getStars());
            existMovie.setPublished(movie.isPublished());
            return repository.save(existMovie);
        }
    }

}
