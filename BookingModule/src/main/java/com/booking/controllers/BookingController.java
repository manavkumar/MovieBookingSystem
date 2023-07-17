package com.booking.controllers;

import com.booking.objects.Booking;
import com.booking.objects.BookingRequest;
import com.booking.objects.Show;
import com.booking.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/search")
    public List<Show> searchShows(@RequestParam String city, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                  @RequestParam(required = false) String movieId, @RequestParam(required = false) String theatreId) {
        return bookingService.searchShows(city, date, movieId, theatreId);
    }

    @PostMapping("/book")
    public Booking bookTicket(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest.getShowId(), bookingRequest.getCustomerId(), bookingRequest.getSelectedSeats());
    }

    @PostMapping("/cancel/{bookingId}")
    public void cancelBooking(@PathVariable String bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    @PostMapping("/bulk-book")
    public List<Booking> bulkBookTickets(@RequestBody List<BookingRequest> bookingRequests) {
        return bookingService.bulkBookTickets(bookingRequests);
    }
}
