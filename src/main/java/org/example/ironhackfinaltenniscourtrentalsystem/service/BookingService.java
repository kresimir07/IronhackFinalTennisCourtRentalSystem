package org.example.ironhackfinaltenniscourtrentalsystem.service;

import org.example.ironhackfinaltenniscourtrentalsystem.model.Booking;
import org.example.ironhackfinaltenniscourtrentalsystem.model.User;
import org.example.ironhackfinaltenniscourtrentalsystem.repository.BookingRepository;
import org.example.ironhackfinaltenniscourtrentalsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookingRepository.findByUser(user);
    }

    public List<Booking> getBookingByUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Bookings for user with email " + email + " not found"));
        return bookingRepository.findByUser(user);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        bookingRepository.delete(booking);
    }

//    TODO Fix getBookingByUser
//    TODO fix deletBookingbyEmail

}
