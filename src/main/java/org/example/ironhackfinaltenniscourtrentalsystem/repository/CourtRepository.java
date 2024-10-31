package org.example.ironhackfinaltenniscourtrentalsystem.repository;

import org.example.ironhackfinaltenniscourtrentalsystem.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourtRepository extends JpaRepository<Court, Long> {

    Optional<Court> findByCourtNumber(String courtNumber);


}
