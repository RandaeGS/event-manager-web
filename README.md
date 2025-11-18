# Event Manager

This project develops an efficient digital system for managing event reservations, such as conferences, educational workshops, or corporate meetings. 

It is meant as a project to showcase my technical expertise, not a complete solution. However, if you want to use it, you are free to do so in any way you would like.

# Technologies

- Java 25
- Quarkus
- Hibernate
- Postgresql
- Flyway
- Hibernate Envers
- Vue
- PrimeVue
- Docker Compose
- CI/CD Pipelines

# Functional Requirements

- Authentication and user management
  - User registration via form with email validation
  - Credential based authentication
  - Organizers and Attendees roles
  - Basic password recovery via temporary email link
- Event Management
  - Event Creation by organizers
  - Event editing and deletion, with restrictions
  - Search, listing and filtering of events
- Reservation System
  - Real-time availability check during booking
  - Reservation processing, generating a unique confirmation code and qr
  - Reservation cancellation by users, with notification to the organizer
- Notifications and Comunication
  - Email confirmations and reminders
 
# Non-Functional Requirements

- Performance and Efficiency
  - Compilation to native images using GraalVM
  - Support for at least 500 concurrent users
- Scalability and High Availability
  - Load balancing with multiple docker containers
  - Horizontal scalability
- Security
  - HTTPS in production via Let`s Encrypt free certificate
  - Input validation and use of Quarkus Security
- Testing and Quality
  - Unit tests covering at least 80% of the code
  - Integration tests for API endpoints using REST Assured
  - E2E tests to ensure frontend quality
  - Acceptation tests using Cucumber
- Automation and Deployment
  - CI/CD pipeline with Github Actions. Stages for build, tests, Docker packaging and automated deployment
  - Deployment to AWS EC2 instance
