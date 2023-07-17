package com.booking.service;

import com.booking.clients.TheatreServiceClient;
import com.booking.exceptions.NotFoundException;
import com.booking.objects.*;
import com.booking.repos.BookingRepository;
import com.booking.repos.ShowRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    private TheatreServiceClient serviceClient;

    private final ObjectMapper mapper = new ObjectMapper();

    public BookingServiceImpl(ShowRepository showRepository, BookingRepository bookingRepository) {
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Show> searchShows(String city, Date date, String movieId, String theatreId) {
        return showRepository.searchShows(city, date, movieId, theatreId);
    }

    @Transactional
    @Override
    public Booking bookTicket(String showId, String customerId, List<Seat> selectedSeats) {
        Booking booking;
        Optional<Show> show = serviceClient.getShow(Long.valueOf(showId));
        if(show.isPresent()){
            Show selectedShow = mapper.convertValue(show.get(), Show.class);
            if(selectedShow.getSeatCapacity() > selectedSeats.size()){
                BigDecimal ticketPrice = calculateTicketPrice(selectedShow, selectedSeats.size());

                // Apply discounts
                if (selectedSeats.size() % 3 == 0) {
                    ticketPrice = ticketPrice.multiply(BigDecimal.valueOf(0.5)); // 50% discount on the third ticket
                }
                if (selectedShow.getShowTime().getHour() >= 12 && selectedShow.getShowTime().getHour() <= 17) {
                    ticketPrice = ticketPrice.multiply(BigDecimal.valueOf(0.8)); // 20% discount for afternoon shows
                }
                User user = User.builder().id(Long.valueOf(customerId)).build();
                booking = Booking.builder().show(selectedShow).user(user).seats(selectedSeats.size()).build();
            } else {
                throw new NotFoundException("Seats not available");
            }


        } else {
            throw new NotFoundException("Show not found");
        }
        // Call payment solution for payment if success then save otherwise return with payment exception
        return bookingRepository.save(booking);
    }

    private BigDecimal calculateTicketPrice(Show selectedShow, int size) {
        return new BigDecimal(188.56);
    }

    @Transactional
    @Override
    public void cancelBooking(String bookingId) {
        bookingRepository.deleteById(Long.valueOf(bookingId));
    }

    @Transactional
    @Override
    public List<Booking> bulkBookTickets(List<BookingRequest> bookingRequests) {
        // Perform bulk booking logic
        // ...
        List bookings = Arrays.asList();
        return bookingRepository.saveAll(bookings);
    }
}
