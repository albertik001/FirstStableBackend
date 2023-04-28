# FirstStableBackend

This repository contains a Java-based backend application using the Spring Boot framework. The application is designed to demonstrate the implementation of simple HTTP requests, integration with MySQL, and the use of custom error responses.

## Features

- Simple HTTP request handling (GET, POST, PUT, DELETE)
- MySQL database integration
- Custom error responses

## Requirements

- Java 17
- Oracle JDK 19
- MySQL Server
- Maven (optional, for building and running the project)

## Getting Started

1. Clone the repository:

   ```
   git clone https://github.com/albertik001/FirstStableBackend.git
   cd FirstStableBackend
   ```

2. Configure your MySQL database by updating the `application.properties` file located in the `src/main/resources` directory with your own MySQL server settings:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Build the project:

    - If you have Maven installed:

      ```
      mvn clean install
      ```

    - If you don't have Maven installed, use the included Maven Wrapper:

        - For Linux/Mac:

          ```
          ./mvnw clean install
          ```

        - For Windows:

          ```
          mvnw.cmd clean install
          ```

4. Run the application:

    - If you have Maven installed:

      ```
      mvn spring-boot:run
      ```

    - If you don't have Maven installed, use the included Maven Wrapper:

        - For Linux/Mac:

          ```
          ./mvnw spring-boot:run
          ```

        - For Windows:

          ```
          mvnw.cmd spring-boot:run
          ```

5. The application will start and be available at `http://localhost:8080`.

## API Endpoints

- **GET** `/api/v1/resource`: Retrieve all resources.
- **POST** `/api/v1/resource`: Create a new resource.
- **PUT** `/api/v1/resource/{id}`: Update an existing resource with the specified ID.
- **DELETE** `/api/v1/resource/{id}`: Delete a resource with the specified ID.

## Contributing

Feel free to submit issues or pull requests to improve the project. If you have any questions or suggestions, please open an issue.

## License

This project is released under the [MIT License](LICENSE).