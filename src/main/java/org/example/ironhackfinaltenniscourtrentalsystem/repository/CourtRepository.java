package org.example.ironhackfinaltenniscourtrentalsystem.repository;

import org.example.ironhackfinaltenniscourtrentalsystem.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourtRepository extends JpaRepository<Court, Long> {

    Optional<Court> findByCourtNumber(String courtNumber);


}
