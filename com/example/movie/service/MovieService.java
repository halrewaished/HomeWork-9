package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repositroy.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addMovies(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovies(Movie movie, Integer id) {
        Movie oldMovie = movieRepository.findById(id).get();
        oldMovie.setName(movie.getName());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setGenre(movie.getGenre());
        //oldMovie.setLunchDate(movie.getLunchDate());
        oldMovie.setRating(movie.getRating());

        movieRepository.save(oldMovie);
    }

    public void deleteMovies(Integer id) {
        movieRepository.deleteById(id);
    }
}
