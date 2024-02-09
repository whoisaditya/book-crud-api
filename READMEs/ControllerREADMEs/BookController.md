## Book Controller

This controller manages CRUD (Create, Read, Update, Delete) operations for books in the application's database.

### Endpoints

#### Create or Update Book
- **HTTP Method:** PUT
- **URL:** `/books/{isbn}`
- **Description:** Creates or updates a book with the given ISBN.
- **Path Parameter:** `isbn` - ISBN of the book.
- **Request Body:** JSON representing the book details.
- **Response:** Returns the created or updated book details.
- **Response Status Code:** 201 (Created) if created, 200 (OK) if updated.

```json
{
  "isbn": "1234567890",
  "title": "Example Book",
  "author": "John Doe"
}
```

#### List Books
- **HTTP Method:** GET
- **URL:** `/books/`
- **Description:** Retrieves a list of all books.
- **Response:** Returns a list of book details.
- **Response Status Code:** 200 (OK)

```json
[
  {
    "isbn": "1234567890",
    "title": "Example Book",
    "author": "John Doe"
  },
  {
    "isbn": "0987654321",
    "title": "Another Book",
    "author": "Jane Doe"
  }
]
```

#### Get Book by ISBN
- **HTTP Method:** GET
- **URL:** `/books/{isbn}`
- **Description:** Retrieves details of a specific book by ISBN.
- **Path Parameter:** `isbn` - ISBN of the book.
- **Response:** Returns the book details if found.
- **Response Status Code:** 200 (OK) if found, 404 (Not Found) if not found.

```json
{
  "isbn": "1234567890",
  "title": "Example Book",
  "author": "John Doe"
}
```

#### Partial Update Book
- **HTTP Method:** PATCH
- **URL:** `/books/{isbn}`
- **Description:** Partially updates details of a specific book by ISBN.
- **Path Parameter:** `isbn` - ISBN of the book.
- **Request Body:** JSON representing the partial book details to be updated.
- **Response:** Returns the updated book details.
- **Response Status Code:** 200 (OK) if updated, 404 (Not Found) if book with the given ISBN doesn't exist.

```json
{
  "author": "Updated Author"
}
```

#### Delete Book
- **HTTP Method:** DELETE
- **URL:** `/books/{isbn}`
- **Description:** Deletes a specific book by ISBN.
- **Path Parameter:** `isbn` - ISBN of the book.
- **Response:** No content.
- **Response Status Code:** 204 (No Content) if successfully deleted, 404 (Not Found) if book with the given ISBN doesn't exist.

### Dependencies

- **BookService:** Responsible for managing book data and business logic.
- **Mapper:** Maps entities to DTOs and vice versa.
- **Spring Boot:** Provides the framework for building the RESTful API.

### Usage

1. Ensure the application is running.
2. Make HTTP requests to the specified endpoints to interact with the book data.

Feel free to explore and modify the endpoints as needed for your application.