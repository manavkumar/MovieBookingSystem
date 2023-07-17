package com.booking.clients;

import com.booking.objects.Show;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(name = "${feign.name : /theatres}", url = "${feign.url:https://localhost:8080}")
public interface TheatreServiceClient {
    @GetMapping(value = "/shows")
    public Optional<Show> getShow(Long id);
}
