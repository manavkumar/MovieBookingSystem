package com.theatre.repos;

import com.theatre.objects.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TheatreShowRepository extends JpaRepository<Show, Long> {
    @Query("SELECT s FROM Show s WHERE s.theatre.city = :city AND DATE(s.showDateTime) = DATE(:date) AND (:movieId IS NULL OR s.movie.id = :movieId) AND (:theatreId IS NULL OR s.theatre.id = :theatreId)")
    List<Show> searchShows(@Param("city") String city, @Param("date") Date date, @Param("movieId") String movieId, @Param("theatreId") String theatreId);

}

