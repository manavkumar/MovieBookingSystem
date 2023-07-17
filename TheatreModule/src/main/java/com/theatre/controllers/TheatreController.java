package com.theatre.controllers;

import com.google.gson.Gson;
import com.theatre.objects.LoginRequest;
import com.theatre.objects.Movie;
import com.theatre.objects.Show;
import com.theatre.objects.TheatreShow;
import com.theatre.service.TheatreService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/theatres")
public class TheatreController {
    private final TheatreService theatreService;

    @Autowired
    private AuthenticationManager authenticationManager;
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/shows")
    public Long createShow(@RequestBody Show show) {
        return theatreService.createShow(show);
    }

    @PutMapping("/shows")
    public Long updateShow(@RequestBody Show show) {

        return theatreService.updateShow(show);
    }

    @DeleteMapping("/shows/{showId}")
    public void deleteShow(@PathVariable String showId) {
        theatreService.deleteShow(showId);
    }

    @GetMapping("/shows")
    public List<Show> getShow(@RequestBody LoginRequest loginRequest) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPwd()));
        System.out.println("===>"+authenticate.isAuthenticated());
        return theatreService.getAllShows();
    }

    @GetMapping("/shows/")
    public List<Show> searchShow() {
        return theatreService.getAllShows();
    }
}
