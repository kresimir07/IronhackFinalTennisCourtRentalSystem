package org.example.ironhackfinaltenniscourtrentalsystem.repository;

import org.example.ironhackfinaltenniscourtrentalsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   // To add queries to search for users by email
}
