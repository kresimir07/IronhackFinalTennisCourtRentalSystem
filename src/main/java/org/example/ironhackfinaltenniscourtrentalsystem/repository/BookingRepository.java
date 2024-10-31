package org.example.ironhackfinaltenniscourtrentalsystem.repository;

import org.example.ironhackfinaltenniscourtrentalsystem.model.Booking;
import org.example.ironhackfinaltenniscourtrentalsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

//    List<Booking>findByUser(User user);

//    Optional<User> findByEmail(String email);



//    TODO find by start date
}
