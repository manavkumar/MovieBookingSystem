package com.movie.repos;


import com.theatre.objects.TheatreShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TheatreShowRepository extends JpaRepository<TheatreShow, Long> {

    List<com.movie.objects.TheatreShow> findByMovieIdAndShowDate(String movieId, Date date);
}
