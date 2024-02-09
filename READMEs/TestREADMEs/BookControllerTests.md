## Book Controller Integration Tests

These integration tests ensure the functionality of the `BookController` endpoints.

### Dependencies

- **MockMvc:** Provides mock implementations of Spring MVC components.
- **ObjectMapper:** Converts between Java objects and JSON.
- **BookService:** Manages book data and business logic.
- **TestDataUtil:** Provides utility methods for creating test data.
- **Spring Boot Test:** Provides support for testing Spring Boot applications.

### Test Cases

1. **Test Create Book Successfully Returns HTTP 201 Created**
    - **Description:** Tests that creating a book successfully returns HTTP 201 Created.
    - **Expected Result:** HTTP status code 201.

2. **Test Update Book Successfully Returns HTTP 200 OK**
    - **Description:** Tests that updating a book successfully returns HTTP 200 OK.
    - **Expected Result:** HTTP status code 200.

3. **Test Create Book Successfully Returns Saved Book**
    - **Description:** Tests that creating a book successfully returns the saved book details.
    - **Expected Result:** JSON representing the saved book details.

4. **Test Update Book Successfully Returns Updated Book**
    - **Description:** Tests that updating a book successfully returns the updated book details.
    - **Expected Result:** JSON representing the updated book details.

5. **Test List Books Returns HTTP 200**
    - **Description:** Tests that listing books returns HTTP 200 OK.
    - **Expected Result:** HTTP status code 200.

6. **Test List Books Returns List of Books**
    - **Description:** Tests that listing books returns a list of book details.
    - **Expected Result:** JSON representing a list of books.

7. **Test Get Book Returns HTTP 200 When Book Exists**
    - **Description:** Tests that getting a book returns HTTP 200 when the book exists.
    - **Expected Result:** HTTP status code 200.

8. **Test Get Book Returns HTTP 404 When No Book Exists**
    - **Description:** Tests that getting a book returns HTTP 404 when no book exists.
    - **Expected Result:** HTTP status code 404.

9. **Test Get Book Returns Book When Book Exists**
    - **Description:** Tests that getting a book returns the book details when the book exists.
    - **Expected Result:** JSON representing the book details.

10. **Test Partial Update Book Returns HTTP 200 When Book Exists**
    - **Description:** Tests that partially updating a book returns HTTP 200 when the book exists.
    - **Expected Result:** HTTP status code 200.

11. **Test Partial Update Book Returns HTTP 404 When No Book Exists**
    - **Description:** Tests that partially updating a book returns HTTP 404 when no book exists.
    - **Expected Result:** HTTP status code 404.

12. **Test Partial Update Book Returns Updated Book**
    - **Description:** Tests that partially updating a book returns the updated book details.
    - **Expected Result:** JSON representing the updated book details.

13. **Test Delete Returns HTTP 204 When Book Exists**
    - **Description:** Tests that deleting a book returns HTTP 204 when the book exists.
    - **Expected Result:** HTTP status code 204.

14. **Test Delete Returns HTTP 204 When No Book Exists**
    - **Description:** Tests that deleting a book returns HTTP 204 when no book exists.
    - **Expected Result:** HTTP status code 204.

### Usage

1. Ensure the application is running.
2. Run the integration tests using a test runner.
3. Check the results to ensure the `BookController` endpoints function as expected.

Feel free to modify or expand these tests as needed to ensure thorough coverage of the `BookController` functionality.