## Author Controller

This controller manages CRUD (Create, Read, Update, Delete) operations for authors in the application's database.

### Endpoints

#### Create Author
- **HTTP Method:** POST
- **URL:** `/authors/`
- **Description:** Creates a new author.
- **Request Body:** JSON representing the author details.
- **Response:** Returns the created author details.
- **Response Status Code:** 201 (Created)

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe"
}
```

#### List Authors
- **HTTP Method:** GET
- **URL:** `/authors/`
- **Description:** Retrieves a list of all authors.
- **Response:** Returns a list of author details.
- **Response Status Code:** 200 (OK)

```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Doe"
  }
]
```

#### Get Author by ID
- **HTTP Method:** GET
- **URL:** `/authors/{id}`
- **Description:** Retrieves details of a specific author by ID.
- **Path Parameter:** `id` - ID of the author.
- **Response:** Returns the author details if found.
- **Response Status Code:** 200 (OK) if found, 404 (Not Found) if not found.

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe"
}
```

#### Full Update Author
- **HTTP Method:** PUT
- **URL:** `/authors/{id}`
- **Description:** Updates details of a specific author by ID.
- **Path Parameter:** `id` - ID of the author.
- **Request Body:** JSON representing the updated author details.
- **Response:** Returns the updated author details.
- **Response Status Code:** 200 (OK) if updated, 404 (Not Found) if author with the given ID doesn't exist.

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Updated"
}
```

#### Partial Update Author
- **HTTP Method:** PATCH
- **URL:** `/authors/{id}`
- **Description:** Partially updates details of a specific author by ID.
- **Path Parameter:** `id` - ID of the author.
- **Request Body:** JSON representing the partial author details to be updated.
- **Response:** Returns the updated author details.
- **Response Status Code:** 200 (OK) if updated, 404 (Not Found) if author with the given ID doesn't exist.

```json
{
  "lastName": "Updated"
}
```

#### Delete Author
- **HTTP Method:** DELETE
- **URL:** `/authors/{id}`
- **Description:** Deletes a specific author by ID.
- **Path Parameter:** `id` - ID of the author.
- **Response:** No content.
- **Response Status Code:** 204 (No Content) if successfully deleted, 404 (Not Found) if author with the given ID doesn't exist.

### Dependencies

- **AuthorService:** Responsible for managing author data and business logic.
- **Mapper:** Maps entities to DTOs and vice versa.
- **Spring Boot:** Provides the framework for building the RESTful API.

### Usage

1. Ensure the application is running.
2. Make HTTP requests to the specified endpoints to interact with the author data.

Feel free to explore and modify the endpoints as needed for your application.