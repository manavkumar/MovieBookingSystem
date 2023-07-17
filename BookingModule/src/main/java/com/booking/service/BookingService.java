package com.booking.service;

import com.booking.objects.Booking;
import com.booking.objects.BookingRequest;
import com.booking.objects.Seat;
import com.booking.objects.Show;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<Show> searchShows(String city, Date date, String movieId, String theatreId);
    Booking bookTicket(String showId, String customerId, List<Seat> selectedSeats);
    void cancelBooking(String bookingId);
    List<Booking> bulkBookTickets(List<BookingRequest> bookingRequests);
}
