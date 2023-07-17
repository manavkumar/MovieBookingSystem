package com.movie.objects;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private TheatreShow theatre;

    private LocalDateTime showTime;
    private int seatCapacity;

    // Constructors, getters, and setters
}
