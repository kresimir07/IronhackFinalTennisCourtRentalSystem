package org.example.ironhackfinaltenniscourtrentalsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "courts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String courtNumber;

    @Column(nullable = false)
    private String surfaceType; //  "Clay", "Grass", "Hard" - will be probably created as Enum

    public Court(String courtNumber, String surfaceType, boolean isIndoor) {
        this.courtNumber = courtNumber;
        this.surfaceType = surfaceType;
        this.isIndoor = isIndoor;
    }

    @Column(nullable = false)
    private boolean isIndoor; // True equals indoor, false equals outdoor


}
