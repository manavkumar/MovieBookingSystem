package com.movie.contollers;

import com.movie.objects.Movie;
import com.movie.objects.TheatreShow;
import com.movie.service.MovieService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/city/{city}")
    public List<Movie> getMoviesByCity(@PathVariable String city) {
        return movieService.getMoviesByCity(city);
    }

    @GetMapping("/language/{language}")
    public List<Movie> getMoviesByLanguage(@PathVariable String language) {
        return movieService.getMoviesByLanguage(language);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("/{movieId}/shows")
    public List<TheatreShow> getTheatreShowsByMovieAndDate(@PathVariable int movieId,
                                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return movieService.getTheatreShowsByMovieAndDate(movieId, date);
    }
}
