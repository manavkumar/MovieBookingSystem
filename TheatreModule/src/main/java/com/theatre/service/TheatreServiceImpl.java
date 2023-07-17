package com.theatre.service;


import com.theatre.objects.Show;
import com.theatre.repos.TheatreShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {
    private final TheatreShowRepository showRepository;

    public TheatreServiceImpl(TheatreShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Long createShow(Show show) {
        return showRepository.save(show).getId();
    }

    @Override
    public Long updateShow(Show show) {
        return showRepository.save(show).getId();
    }

    @Override
    public void deleteShow(String showId) {
        showRepository.deleteById(Long.valueOf(showId));
    }

    @Override
    public List<Show> getAllShows() {
       return showRepository.findAll();
    }

    @Override
    public Optional<Show> getShow(Long showId) {
        return showRepository.findById(showId);
    }
}
