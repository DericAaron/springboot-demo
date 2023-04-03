# Spring Boot Demo
This is a simple Spring Boot project that provides a REST API Endpoint for retrieving a combined subset of user github data.

## Design and Architecture
The project is built using Spring Boot and follows a standard REST API architecture with the following layers:

### Controller: 
Handles incoming requests and maps them to the appropriate service method.

### Service: 
Provides methods for retrieving the data from the following github endpoints and combine them for the response object:
* https://api.github.com/users/{username}
* https://api.github.com/users/{username}/repos

### Additional Design decisions
* Global Controller Advice to handle the possible errors output by the service
* Utility Class to facilitate common functions, In this case a method to convert any object structure into a Map<K,V>

## Prerequisites
To build and run this project, you will need:

Java 8 or later
Gradle 7 or later

## Installation
Clone the repository:

```
git clone https://github.com/DericAaron/springboot-demo.git
cd springboot-demo
```

Build the project:

```
./gradlew build
```

This will build the project and run all tests.

Running the Service
To run the service, use the following command:

```
./gradlew bootRun
```

This will start the service on port 8080.

Using the Service
The service provides the following endpoints:

- GET /user/repos?username={username}: Retrieves the requested user and their public github repos.

To use the service, you can make HTTP requests to these endpoints using a tool like curl or an API client like Postman.

For example:
```
curl -X GET -H "Content-Type: application/json" http://localhost:8080/user/repos?username=octocat
```

Should return the following:

```
{
user_name: "octocat",
display_name: "The Octocat",
avatar: "https://avatars3.githubusercontent.com/u/583231?v=4", geo_location: "San Francisco",
email: null,
url: "https://github.com/octocat ",
created_at: "2011-01-25 18:44:36",
repos: [{
name: "boysenberry-repo-1",
url: "https://github.com/octocat/boysenberry-repo-1" }, ...
] }
```

Configuration
The project includes a application.properties file in the src/main/resources directory. This file contains configuration settings for the service, such as the port number and database connection details.

You can modify these settings to suit your needs.
