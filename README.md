# Employee Service API

A production-ready Spring Boot REST API demonstrating the Controller-Service-Repository architecture. It includes data persistence (H2 in-memory database), input validation, global exception handling, and Actuator endpoints for health monitoring.

## Directory Structure
```text
.
├── pom.xml
├── README.md
└── src
    └── main
        ├── resources
        │   └── application.yml
        └── java
            └── com
                └── example
                    └── api
                        ├── Application.java
                        ├── config
                        │   └── GlobalExceptionHandler.java
                        ├── controller
                        │   └── EmployeeController.java
                        ├── entity
                        │   └── Employee.java
                        ├── repository
                        │   └── EmployeeRepository.java
                        └── service
                            └── EmployeeService.java
