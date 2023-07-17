package com.booking.objects;

import javax.persistence.*;
@Entity
public class TheatreShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;

    // Constructors, getters, and setters
}
