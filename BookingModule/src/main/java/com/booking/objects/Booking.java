package com.booking.objects;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    private LocalDateTime bookingTime;

    private int seats;

    // Constructors, getters, and setters
}
