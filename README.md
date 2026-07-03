#Student Management REST API
A RESTful API built with Spring Boot that performs CRUD operations for student records. The project follows a layered architecture using 
Controller, Service, Repository, Entity, and DTO layers.

## Features
- Create a student
- Retrieve all students
- Retrieve a student by ID
- Update student details
- Partially update a student
- Delete a student
- Input validation
- Exception handling
- DTO mapping using ModelMapper

## Technologies Used
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- ModelMapper
- Lombok
- Jakarta Validation

## Tools Used
- IntelliJ IDEA
- DBeaver
- Postman
  
## Architecture
Client
↓
Controller
↓
Service
↓
Repository
↓
Database

## API Endpoints
| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get student by ID |
| POST | /api/students | Create student |
| PUT | /api/students/{id} | Update student |
| PATCH | /api/students/{id} | Partially update student |
| DELETE | /api/students/{id} | Delete student |

## Design Pattern
This project follows the layered architecture:

- Controller Layer
- Service Layer
- Repository Layer
- Entity Layer
- DTO Layer

## Future Improvements
- JWT Authentication
- Spring Security
- Swagger/OpenAPI
- Unit Testing
- Docker
- Pagination & Sorting
- Global Exception Handling
- Logging

## Author
Nikita Rai
