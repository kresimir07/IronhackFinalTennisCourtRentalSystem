package org.example.ironhackfinaltenniscourtrentalsystem.repository;

import org.example.ironhackfinaltenniscourtrentalsystem.model.Booking;
import org.example.ironhackfinaltenniscourtrentalsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


      List<Booking>findByUser(User user);



//    TODO find by start date
}
