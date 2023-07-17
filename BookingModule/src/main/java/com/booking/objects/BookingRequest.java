package com.booking.objects;

import java.util.List;

public class BookingRequest {
    private String showId;
    private String customerId;
    private List<Seat> selectedSeats;

    private BookingRequest() {}

    public String getShowId() {
        return showId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Seat> getSelectedSeats() {
        return selectedSeats;
    }

    public static class Builder {
        private String showId;
        private String customerId;
        private List<Seat> selectedSeats;

        public Builder setShowId(String showId) {
            this.showId = showId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setSelectedSeats(List<Seat> selectedSeats) {
            this.selectedSeats = selectedSeats;
            return this;
        }

        public BookingRequest build() {
            BookingRequest bookingRequest = new BookingRequest();
            bookingRequest.showId = this.showId;
            bookingRequest.customerId = this.customerId;
            bookingRequest.selectedSeats = this.selectedSeats;
            return bookingRequest;
        }
    }
}
