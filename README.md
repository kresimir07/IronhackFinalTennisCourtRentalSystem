# ***TENNIS COURT RENTAL SYSTEM***

____




### PROJECT IDEA

Hey everyone! I’d like to introduce you to my project: a Tennis Court Rental System.
This app is designed to make booking tennis courts simple, organized, and user-friendly. 
Here’s the basic idea. 
Imagine a local tennis club where members can : 
- View available courts
- Book time slots, and manage their reservations from one easy-to-use app. 
- It’s especially helpful for clubs that want to streamline their process and keep everything digital.

This system will manage the booking and rental of tennis courts. It includes functionalities to create, 
update, view, and delete bookings for courts. Users (customers) will need to log in to make reservations, 
and they can view available courts, schedule their bookings, and check their reservation status. 
The backend will provide all necessary RESTful endpoints, use JPA for data persistence, 
and secure the application using JWT for authentication.

___

### MAIN FEATURES

User Management
Our users are divided into two types: Admins and Customers.

Customers can register, log in, and book courts. They’ll have profiles with details like 
membership level and booking history.
Admins can manage the courts, handle bookings, and even add new members.
I’m using Java’s JPA inheritance to set this up, so Admin and Customer both extend a general User class, 
with each type having unique characteristics.

Booking System

The core feature is booking tennis courts! Users can:
View available courts, check court types (like clay or grass), and see pricing.
Select a date and time for their booking, and confirm the reservation.
Modify or cancel bookings if something comes up.
Database Management (Using MySQL) All our data—users, courts, and bookings—will be stored in a MySQL database. 
This keeps everything well-organized and easy to access. We’re also using JPA to manage how data is stored and retrieved, 
so we can focus more on building the features rather than worrying about raw SQL.

Secure Access For security, I’ll be using Bearer Token. When users log in, they get a token, which they use for 
secure access to their account and booking features. 

This means:
Only authenticated users can book or view their reservations.
Admin-only areas are protected, so no one without the right permissions can access sensitive actions.

Rest API Structure Since this is a backend-focused project, I’ll be setting up a REST API that follows best practices:

For each of our entities — Users, Courts, and Bookings—there’ll be routes to Create, Read, Update, and Delete.<br><br>

For example:

GET /courts to list available courts <br>
POST /bookings to make a reservation <br>
PUT /bookings/{id} to modify a booking <br>
DELETE /bookings/{id} to cancel a booking. 
---
### WHY THIS PROJECT ?

A Tennis Court Rental System covers a lot of key skills in backend development:

We’re handling user authentication, managing data relationships, creating secure API routes, and organizing complex data.

This project is also a great example of how backend logic meets real-world application needs. In the end, 
the project will be a reliable, organized way to manage tennis court bookings, 
whether it’s for a small club or a larger facility looking to digitize their reservations.
---
### FUTURE IMPLEMENTATION 

- Payment options
- New user group - "Club members"
- Creation of tou
- Ranking system
---

# UML CLASS DIAGRAM


### User (Abstract Class) Attributes:  <br>
   id: Long <br>
   name: String <br>
   email: String <br>
   password: String <br>
   role: Role <br>

   Methods: <br>
   login() <br>
   logout() <br>
   viewBookings() <br>

### Customer (Subclass of User)  
   Attributes:  <br>
   membershipLevel: String <br>
   bookings: List<Booking> <br>
   Methods: <br>
   register() <br>
   bookCourt(court: Court, date: Date, timeSlot: String) <br>
### Admin (Subclass of User)
   Attributes: <br>
   adminPrivileges: String <br>
   Methods: <br>
   addCourt(court: Court) <br>
   removeCourt(courtId: Long) <br>
   viewAllBookings() <br>
### Court
   Attributes: <br>
   id: Long <br>
   courtNumber: String <br>
   type: String (e.g., clay, grass) <br>
   pricePerHour: Double <br>
   availability: Boolean <br>
   Methods: <br>
   checkAvailability(date: Date, timeSlot: String) <br>
   calculatePrice(duration: int): Double <br>

### Booking
   Attributes: <br>
   id: Long <br>
   date: Date <br>
   timeSlot: String <br>
   duration: int <br>
   totalCost: Double <br>
   customer: Customer <br>
   court: Court <br>
   Methods: <br>
   calculateTotalCost() <br>

###   Relationships
   User (parent class) has a one-to-many relationship with Booking (through Customer), 
   where each Customer can have multiple Booking entries. <br> <br>
   Admin has a many-to-many relationship with Court in terms of managing courts, though the 
   Admin is not directly tied to the booking of a court. <br> <br>
   Court has a one-to-many relationship with Booking, where a court can have multiple bookings (but only one per time slot).
   Booking has a many-to-one relationship with both Customer and Court.




