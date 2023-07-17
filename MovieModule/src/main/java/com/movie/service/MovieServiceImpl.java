package com.movie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.clients.TheatreServiceClient;
import com.movie.objects.Movie;
import com.movie.objects.TheatreShow;
import com.movie.repos.MovieRepository;
import com.movie.repos.TheatreShowRepository;
import com.theatre.objects.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private TheatreServiceClient serviceClient;
    private final ObjectMapper mapper = new ObjectMapper();
    @Cacheable(value = "moviesByCity", key = "#city", unless = "#result == null")
    public List<Movie> getMoviesByCity(String city) {
        // Implementation to get movies by city
        List<Show> listOFShows = serviceClient.getShow();
        List<Movie> movies = new ArrayList<>();
        for (Show show : listOFShows) {
            if(show.getTheatre().getCity().equalsIgnoreCase(city)){
                movies.add(mapper.convertValue(show.getMovie(),Movie.class));
            }
        }
        return movies;
    }

    @Cacheable(value = "moviesByLanguage", key = "#language", unless = "#result == null")
    public List<Movie> getMoviesByLanguage(String language) {
        // Implementation to get movies by language
        List<Show> listOFShows = serviceClient.getShow();
        List<Movie> movies = new ArrayList<>();
        for (Show show : listOFShows) {
            if(show.getMovie().getLanguage().equalsIgnoreCase(language)){
                movies.add(mapper.convertValue(show.getMovie(),Movie.class));
            }
        }
        return movies;
    }

    @Cacheable(value = "moviesByGenre", key = "#genre", unless = "#result == null")
    public List<Movie> getMoviesByGenre(String genre) {
        // Implementation to get movies by genre
        List<Show> listOFShows = serviceClient.getShow();
        List<Movie> movies = new ArrayList<>();
        for (Show show : listOFShows) {
            if(show.getMovie().getGenre().equalsIgnoreCase(genre)){
                movies.add(mapper.convertValue(show.getMovie(),Movie.class));
            }
        }
        return movies;
    }

    @Cacheable(value = "theatreShowsByMovieAndDate", key = "#movieId + '-' + #date", unless = "#result == null")
    public List<TheatreShow> getTheatreShowsByMovieAndDate(int movieId, Date date) {
        // Implementation to get theatre shows by movie and date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Show> listOFShows = serviceClient.getShow();
        List<TheatreShow> theatreShows = new ArrayList<>();
        for (Show show : listOFShows) {
            if(show.getMovie().getId()==movieId && Instant.from(LocalDate.parse(show.getShowDateTime(),formatter))
                    .isAfter(date.toInstant())){
                theatreShows.add(mapper.convertValue(show,TheatreShow.class));
            }
        }
        return theatreShows;
    }
}
