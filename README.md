# spring-boot-rest-mongodb
CRUD REST API Using Spring Boot, Spring Data and MongoDB

Read full article on my blog http://bhupeshpadiyar.com

https://bhupeshpadiyar.com/2019/08/crud-rest-api-using-spring-boot-spring-data-and-mongodb/

## Prerequisite
1. JDK 1.8 or above
2. MongoDB 4.0.1
3. Apache Maven 3
4. IDE - STS (Spring Tool Suite preferred)


## Application Stracture
1. Database - MongoDB NoSQL database to store and retrieve data.
2. RestController Layer - To control requests and responses.
3. Repository Layer - To store and retrieve data from database.
4. Client - The client that want to access the API resource.


Below is the diagram shows the high level architecture of the application

![alt text](https://raw.githubusercontent.com/bhupeshpadiyar/spring-boot-rest-mongodb/master/src/main/resources/static/spring-boot-mongodb-application.png)

## Steps to Run the project 

## Step 1: Create database and collection in MongoDB

 ```
      use users_db
 ```
 
 Create collection in the DB
 
 
 ```
      db.createCollection("users");
 ```
 
 Insert some data to collection users
 
 ```
    {
  "firstName" : "Adam",
  "lastName" : "Gilchrist",
  "email" : "adam@xyz.com",
  "age": "40",
  "address": "Mont Kiara, Malaysia",
  "createdOn" : ISODate("2003-08-31T00:00:00Z"),
  "updatedOn" : ISODate("2019-08-31T00:00:00Z")
}
 ```
 
 ## Step 2: Download and run the project
 
1. Download The Project
2. Go to the project folder
3. Run following command
      ```
      mvn eclipse:eclipse
      ```
      ```
      mvn clean compile
      ```
      ```
      mvn spring-boot:run
      ```
      
## Step 3: Test GET/POST/PUT/DELETE REST endpoints
# TODO - Add request/responses


 
 
 
