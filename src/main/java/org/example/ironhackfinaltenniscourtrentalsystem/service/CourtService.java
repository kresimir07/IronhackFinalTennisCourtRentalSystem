package org.example.ironhackfinaltenniscourtrentalsystem.service;

import org.example.ironhackfinaltenniscourtrentalsystem.model.Court;
import org.example.ironhackfinaltenniscourtrentalsystem.repository.CourtRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    private final CourtRepository courtRepository;
    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    public Optional<Court> getCourtByNumber(String courtNumber) {
        return courtRepository.findByCourtNumber(courtNumber);
    }

    public Court saveOrUpdateCourt(Court court) {
        return courtRepository.save(court);
    }

    public void deleteCourt(Court court) {
        courtRepository.delete(court);
    }
}
