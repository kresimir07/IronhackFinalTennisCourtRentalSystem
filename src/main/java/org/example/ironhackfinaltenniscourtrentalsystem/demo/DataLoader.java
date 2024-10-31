package org.example.ironhackfinaltenniscourtrentalsystem.demo;


import org.example.ironhackfinaltenniscourtrentalsystem.model.Court;
import org.example.ironhackfinaltenniscourtrentalsystem.model.SurfaceType;
import org.example.ironhackfinaltenniscourtrentalsystem.model.User;
import org.example.ironhackfinaltenniscourtrentalsystem.model.UserRole;
import org.example.ironhackfinaltenniscourtrentalsystem.service.CourtService;
import org.example.ironhackfinaltenniscourtrentalsystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final CourtService courtService;

    public DataLoader(UserService userService, CourtService courtService) {
        this.userService = userService;
        this.courtService = courtService;
    }

    @Override

    public void run(String... args) {
        if (userService.getAllUsers().isEmpty()) {
            User user1 = new User("mario.maric@gmail.com", "password123", "Mario Maric", UserRole.USER);
            User user2 = new User("ivanatomic@gmail.com", "123password", "Ivana Tomic", UserRole.ADMIN);
            User user3 = new User("jane.smith@yahoo.com", "password456", "Jane Smith", UserRole.USER);
            User user4 = new User("john.doe@example.com", "456password", "John Doe", UserRole.USER);

            userService.registerUser(user1);
            userService.registerUser(user2);
            userService.registerUser(user3);
            userService.registerUser(user4);

        }

        if (courtService.getAllCourts().isEmpty()) {
            Court court1 = new Court("Nadal's court", SurfaceType.CLAY,true);
            Court court2 = new Court("Murray's court", SurfaceType.GRASS, true);
            Court court3 = new Court("Roger's court", SurfaceType.HARD, false);
            Court court4 = new Court("Novak's court", SurfaceType.CARPET, true);

            courtService.saveOrUpdateCourt(court1);
            courtService.saveOrUpdateCourt(court2);
            courtService.saveOrUpdateCourt(court3);
            courtService.saveOrUpdateCourt(court4);

        }

    }
}
