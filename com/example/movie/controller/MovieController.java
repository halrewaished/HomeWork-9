package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }

    @PostMapping
    public ResponseEntity addMovies(@RequestBody Movie movie){
        movieService.addMovies(movie);
        return ResponseEntity.status(200).body("Movie is added");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
        movieService.updateMovies(movie,id);
        return ResponseEntity.status(200).body("Movie is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovies(id);
        return ResponseEntity.status(200).body("Movie is deleted");
    }

}
