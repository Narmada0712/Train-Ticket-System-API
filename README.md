# Train Ticket Booking API

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
- [Features](#features)
- [API Endpoints](#api-endpoint)
   - [Purchase a Ticket](#purchase-a-ticket)
   - [View Receipt](#view-receipt)
   - [View Users and Seats](#view-users-and-seats)
   - [Remove User](#remove-user)
   - [Modify User's Seat](#modify-user's-seat)

## Introduction
This project is a simple Java-based API for booking train tickets from London to France. It uses Spring MVC for handling HTTP requests and MySQL for storing user and seat allocation information.

## Technology Used
## Java: The core programming language used for developing the backend logic.
### Spring MVC: A framework for building Java-based enterprise applications, utilized for handling HTTP requests and managing the application's architecture.
### MySQL: A relational database management system used for storing user and seat allocation information.
### Maven: A build automation tool used for managing project dependencies and building the project.
### Git: Version control system for tracking changes in the source code.
### GitHub: The platform used for hosting and version control of the project repository.

## Getting Started
### Prerequisites
Java 8: Make sure you have Java 8 installed on your machine.
MySQL Database: Set up a MySQL database and note down the connection details (e.g., URL, username, password).
Maven: Install Maven to manage project dependencies.
Git: Ensure Git is installed on your machine for version control.

# Features
Purchase a train ticket from London to France.
Generate a receipt with details such as From, To, User information, and the price paid.
Allocate users a seat in either section A or B of the train.
View details of the receipt for a user.
View a list of users and their allocated seats based on the requested section.
Remove a user from the train.
Modify a user's seat.

# API Endpoints
All the API will be accessible at http://localhost:8080 by default.
### Purchase a Ticket
Endpoint: /purchase
Method: POST
Request Body:
json
Copy code
{
  "from": "London",
  "to": "France",
  "user": {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
  }
}
Response:
json
Copy code
{
  "from": "London",
  "to": "France",
  "user": "John Doe",
  "pricePaid": 20.0,
  "seatSection": "A",
  "seatNumber": 1
}
### View Receipt
Endpoint: /receipt/{userId}
Method: GET
Response:
json
Copy code
{
  "from": "London",
  "to": "France",
  "user": "John Doe",
  "pricePaid": 20.0,
  "seatSection": "A",
  "seatNumber": 1
}
### View Users and Seats
Endpoint: /users/{section}
Method: GET
Response:
json
Copy code
[
  {
    "user": "John Doe",
    "seatSection": "A",
    "seatNumber": 1
  },
  {
    "user": "Jane Doe",
    "seatSection": "B",
    "seatNumber": 2
  }
  // ...
]
### Remove User
Endpoint: /remove/{userId}
Method: DELETE
Response:
json
Copy code
{
  "message": "User John Doe removed successfully."
}
### Modify User's Seat
Endpoint: /modify/{userId}
Method: PUT
Request Body:
json
Copy code
{
  "seatSection": "B",
  "seatNumber": 3
}
Response:
json
Copy code
{
  "message": "User John Doe seat modified successfully."
}


