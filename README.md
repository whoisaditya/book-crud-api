## BookAPI

The BookAPI is a Spring Boot project designed to provide a robust backend system for managing authors and books. It offers RESTful APIs for CRUD operations on author and book entities, allowing users to create, read, update, and delete author and book records efficiently. The project utilizes Spring MVC architecture along with Spring Data JPA for data persistence and manipulation.

### Project Structure

The project is structured as follows:

- **Controllers:** Contains REST controllers for handling HTTP requests and responses.
- **Domain:** Includes DTOs (Data Transfer Objects) and entity classes representing author and book objects.
- **Mappers:** Provides mapper classes for converting between DTOs and entities.
- **Services:** Implements business logic and data operations for author and book entities.
- **Test Data Util:** Contains utility methods for generating test data.
- **Integration Tests:** Includes integration tests to verify the functionality of the REST endpoints.

### Documentation

This project's documentation is divided into the following sections:

1. [Author Controller Readme](./READMEs/ControllerREADMEs/AuthorController.md): Detailed readme for the `AuthorController` class, including its endpoints and integration tests.

2. [Book Controller Readme](./READMEs/ControllerREADMEs/BookController.md): Comprehensive readme for the `BookController` class, outlining its endpoints and integration tests.

3. [Author Controller Integration Tests Readme](./READMEs/TestREADMEs/AuthorControllerTests.md): Documentation for integration tests of the `AuthorController`, explaining each test case and its expected outcome.

4. [Book Controller Integration Tests Readme](./READMEs/TestREADMEs/BookControllerTests.md): Detailed guide to integration tests of the `BookController`, describing each test case and its expected result.

Please refer to the respective documents for more detailed information on the project components and testing procedures.