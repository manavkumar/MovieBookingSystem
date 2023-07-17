package com.movie.clients;

import com.theatre.objects.Show;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${feign.name : /theatres}", url = "${feign.url:https://localhost:8080}")
public interface TheatreServiceClient {
    @GetMapping(value = "/shows")
    public List<Show> getShow();
}
