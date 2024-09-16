# Beer Adviser Web Application

## Overview

Exercise 1:
In this exercise, refactor the existing "Beer Advice" web application to remove all JSP scriptlet code and replace
it with JSTL (JavaServer Pages Standard Tag Library) tags. The application suggests beer styles based on user
preferences.

The key focus is on improving the maintainability and readability of the JSP pages by using the <c:forEach> tag to
iterate over a list of beer styles, eliminating the need for Java code directly in the JSP page.

Exercise 2:
This exercise involves creating a custom JSP tag <ct:currentDateTime> that dynamically prints the current date and
time on a JSP page with customizable color and size attributes. The tag accepts two attributes—color and size—that allow
the user to specify how the date and time should be displayed in HTML.

The goal is to learn how to create custom tags in JSP and use them to encapsulate logic, which can be reused across
multiple pages.

## Features

- Selection of beer types
- Display of beer recommendations based on user input
- Server-side processing using Java servlets
- Dynamic content generation using JSP
- Basic error handling for invalid inputs

## Technologies Used

- Java Servlets
- JavaServer Pages (JSP)
- HTML
- Maven (for build management)
- Docker & Apache Tomcat (for deployment)

## Project Structure

```
beer-adviser/
├── src/
│   └── main/
│       ├── java/
│       │     └── tags/
│       │          └── CurrentDateTime.java
│       │     └── web/
│       │          └── BeerSelect.java
│       │     └── model/
│       │          └── BeerExpert.java
│       │
│       └── resources/
│       └── webapp/
│           ├── WEB-INF/
│           │   └── tags.tld
│           │   └── web.xml
│           └── pages/
│               ├── selectBeer.jsp
│               └── result.jsp
├── pom.xml
└── README.md
```

## Setup and Running Locally

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven
- A servlet container like Apache Tomcat (optional if using Docker)
- Docker
- Docker Compose

## Docker Deployment

1. Build the project:
   ```
   mvn clean package
   ```

2. Build the Docker image:
   ```
   docker compose build
   ```

3. Run the container:
   ```
   docker compose up
   ```

4. Access the application at `http://localhost:8080/beer-adviser/pages/selectBeer.jsp`

## Notes

This lab was simple and took about an hour to complete. 
It showed how JSP makes creating dynamic web content easier 
compared to writing all the logic directly in servlets. 
Knowing how efficient JSP is will be useful for future web development projects.

