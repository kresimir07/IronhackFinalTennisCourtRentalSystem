package org.example.ironhackfinaltenniscourtrentalsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


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


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SurfaceType surfaceType; //  "Clay", "Grass", "Hard" - will be probably created as Enum



    @Column(nullable = false)
    private boolean isIndoor; // True equals indoor, false equals outdoor

    @OneToMany(mappedBy = "court", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    public Court(String courtNumber, SurfaceType surfaceType, boolean isIndoor) {
        this.courtNumber = courtNumber;
        this.surfaceType = surfaceType;
        this.isIndoor = isIndoor;
    }

}
