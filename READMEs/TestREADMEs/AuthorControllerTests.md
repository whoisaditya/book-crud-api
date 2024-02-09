## Author Controller Integration Tests

These integration tests ensure the functionality of the `AuthorController` endpoints.

### Dependencies

- **MockMvc:** Provides mock implementations of Spring MVC components.
- **ObjectMapper:** Converts between Java objects and JSON.
- **AuthorService:** Manages author data and business logic.
- **TestDataUtil:** Provides utility methods for creating test data.
- **Spring Boot Test:** Provides support for testing Spring Boot applications.

### Test Cases

#### 1. Test Create Author Successfully Returns HTTP 201 Created
- **Description:** Tests that creating an author successfully returns HTTP 201 Created.
- **Expected Result:** HTTP status code 201.

#### 2. Test Create Author Successfully Returns Saved Author
- **Description:** Tests that creating an author successfully returns the saved author details.
- **Expected Result:** JSON representing the saved author details.

#### 3. Test List Authors Returns HTTP 200
- **Description:** Tests that listing authors returns HTTP 200 OK.
- **Expected Result:** HTTP status code 200.

#### 4. Test List Authors Returns List of Authors
- **Description:** Tests that listing authors returns a list of author details.
- **Expected Result:** JSON representing a list of authors.

#### 5. Test Get Author Returns HTTP 200 When Author Exists
- **Description:** Tests that getting an author returns HTTP 200 when the author exists.
- **Expected Result:** HTTP status code 200.

#### 6. Test Get Author Returns HTTP 404 When No Author Exists
- **Description:** Tests that getting an author returns HTTP 404 when no author exists.
- **Expected Result:** HTTP status code 404.

#### 7. Test Get Author Returns Author When Author Exists
- **Description:** Tests that getting an author returns the author details when the author exists.
- **Expected Result:** JSON representing the author details.

#### 8. Test Full Update Author Returns HTTP 200 When Author Exists
- **Description:** Tests that fully updating an author returns HTTP 200 when the author exists.
- **Expected Result:** HTTP status code 200.

#### 9. Test Full Update Author Returns HTTP 404 When No Author Exists
- **Description:** Tests that fully updating an author returns HTTP 404 when no author exists.
- **Expected Result:** HTTP status code 404.

#### 10. Test Full Update Returns Updated Author
- **Description:** Tests that fully updating an author returns the updated author details.
- **Expected Result:** JSON representing the updated author details.

#### 11. Test Partial Update Author Returns HTTP 200 When Author Exists
- **Description:** Tests that partially updating an author returns HTTP 200 when the author exists.
- **Expected Result:** HTTP status code 200.

#### 12. Test Partial Update Author Returns HTTP 404 When No Author Exists
- **Description:** Tests that partially updating an author returns HTTP 404 when no author exists.
- **Expected Result:** HTTP status code 404.

#### 13. Test Partial Update Author Returns Updated Author
- **Description:** Tests that partially updating an author returns the updated author details.
- **Expected Result:** JSON representing the updated author details.

#### 14. Test Delete Author Returns HTTP 200 When Author Exists
- **Description:** Tests that deleting an author returns HTTP 200 when the author exists.
- **Expected Result:** HTTP status code 200.

#### 15. Test Delete Author Returns HTTP 204 When No Author Exists
- **Description:** Tests that deleting an author returns HTTP 204 when no author exists.
- **Expected Result:** HTTP status code 204.

### Usage

1. Ensure the application is running.
2. Run the integration tests using a test runner.
3. Check the results to ensure the `AuthorController` endpoints function as expected.

Feel free to modify or expand these tests as needed to ensure thorough coverage of the `AuthorController` functionality.