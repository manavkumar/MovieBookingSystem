package com.movie.repos;

import com.movie.objects.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByCity(String city);
    List<Movie> findByLanguage(String language);
    List<Movie> findByGenre(String genre);
}

