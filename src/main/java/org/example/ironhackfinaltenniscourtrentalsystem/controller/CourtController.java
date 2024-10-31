package org.example.ironhackfinaltenniscourtrentalsystem.controller;


import org.example.ironhackfinaltenniscourtrentalsystem.model.Court;
import org.example.ironhackfinaltenniscourtrentalsystem.service.CourtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courts")

public class CourtController {

    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }
// Find all courts
    @GetMapping
    public ResponseEntity<List<Court>> getAllCourts() {
        List<Court> courts = courtService.getAllCourts();
        return ResponseEntity.ok(courts);
    }
// Find court by court number
    @GetMapping("/courtNumber")
    public ResponseEntity<Court> getCourtByNumber(@PathVariable String courtNumber) {
        return courtService.getCourtByNumber(courtNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    Add new court
    @PostMapping
    public ResponseEntity<Court> addCourt(@RequestBody Court court) {
        Court newCourt = courtService.saveOrUpdateCourt(court);
        return ResponseEntity.ok(newCourt);
    }

//    Update court details
    @PutMapping("/{courtNumber}")
    public ResponseEntity<Court> updateCourt(@PathVariable String courtNumber, @RequestBody Court updatedCourt) {
        return courtService.getCourtByNumber(courtNumber)
                .map(court ->{
                    court.setSurfaceType(updatedCourt.getSurfaceType());
                    court.setIndoor(updatedCourt.isIndoor());
                    Court savedCourt = courtService.saveOrUpdateCourt(court);
                    return ResponseEntity.ok(savedCourt);
                })
                .orElse(ResponseEntity.notFound().build());
    }

//    Delete court by ID

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourt(@PathVariable Court id) {
        courtService.deleteCourt(id);
        return ResponseEntity.ok("Court deleted with success!");
    }







}
