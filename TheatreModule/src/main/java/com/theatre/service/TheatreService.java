package com.theatre.service;


import com.theatre.objects.Show;

import java.util.List;
import java.util.Optional;

public interface TheatreService {
    Long createShow(Show show);
    Long updateShow(Show show);
    void deleteShow(String showId);
    Optional<Show> getShow(Long showId);
    List<Show> getAllShows();

}

