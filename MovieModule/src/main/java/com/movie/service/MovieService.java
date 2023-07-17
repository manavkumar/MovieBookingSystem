package com.movie.service;


import com.movie.objects.Movie;
import com.movie.objects.TheatreShow;

import java.util.Date;
import java.util.List;

public interface MovieService {
    List<Movie> getMoviesByCity(String city);
    List<Movie> getMoviesByLanguage(String language);
    List<Movie> getMoviesByGenre(String genre);
    List<TheatreShow> getTheatreShowsByMovieAndDate(int movieId, Date date);
}
