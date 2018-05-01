# csye6225-fall2017

This is the starter web application in which we design & implemented APIs using Spring Boot with MySQL as the persistent backend data store for user account management.
```
RESTful API Endpoints Implemented
HTTP Method | End Point     | Funtion
GET         |   /           |Get the home page
POST        | /user/register|Create account for user
```
# Use cases Covered
```
As a user, We  created an account by providing following information.
Email Address
Password
As a user, I expect to use my email address as my username.
As a user, I want to navigate to home page (/). I expect the API to respond with current time if I provide the basic authentication headers. If I do not provide basic authentication headers, application can return a message saying I am not logged in.
As a user, if I try to create an account and it already exists, system should warn me that account already exists.
As a user, I expect my password to be stored securely using BCrypt password hashing scheme with salt.
As a user, I expect the code quality of the application is maintained to highest standards using unit and/or integration tests.
```



### Prerequisites

## System Requirements
```
By default, Spring Boot 1.5.7.RELEASE requires Java 7 and Spring Framework 4.3.11.RELEASE or above. You can use Spring Boot with Java 6 with some additional configuration. See Section 84.11, “How to use Java 6” for more details. Explicit build support is provided for Maven (3.2+), and Gradle 2 (2.9 or later) and 3.
```
### Build and deployment Requirements
```
The tomcat server should be configured for this particular project. If not go to the run configuration dropdown, 
click edit configuration and configure the tomcat local server from there.
```
```
build.gradle file should not have any errors and your project should be visible in the gradle window as well.
```
### Testing Requirements
```
Install postman and Apache Jmeter to perform the testing of the application.
```

### Build your application
```
The application is build using travis CI and the status of the build can be checked on the travis CI website. To check the status go to travis CI website, link your project there.
Everytime the project is build the status of that particular build will be available there. Also you can trigger build from the more options dropdown.
NOTE: Change the email ID to your ID in travis.yml file.
```
# Execution 

### Running your application

## Running from an IDE.
```
1. You can run a Spring Boot application from your IDE as a simple Java application, however, first you will need to import your project. Import steps will vary depending on your IDE and build system. Most IDEs can import Gradle projects directly, for example IntelliJ users can select Import… → Existing Maven Projects from the File menu.
2. After importing the project and completing all the pre-requisites, click on the run application button.
3. Once the server is started and application is deployed successfully, you should be able to see the webpage which says "you are not logged in".
4. Now to test the application Postman is used for which the intructions are mentioned below.
```
## Using the Gradle plugin
```
$ gradle bootRun

```
### Execute from postman
```
To execute and test the project from postman perform the below steps:
1. Create a get request for http://localhost:8080 url. In the select basic authentication and enter the 
valid credentials. You should be able to log in successfully.
2. Create a post request for http://localhost:8080/user/register url. Enter the user details in the body in
JSON format. Also add application/json content-type in the header.


```

# Integration Pipeline Using TravisCI
1. An TravisCI build is triggered on every pull request and commit.
2. TravisCI build will run all unit tests and build the artificat (.war)
3. An email notification is  sent when build is finished.

### Travis CI build link
https://s3.amazonaws.com/archive.travis-ci.com/jobs/92499108/log.txt?AWSAccessKeyId=AKIAIETBFLRWUUPRBPHA&Expires=1506623244&Signature=c9HLJxus3V5ImVHrauugjG5ydy4%3D

## Running the tests using Junit

To run the test cases just select RestAssuredDemoApiTest folder and run that folder for all test. The results of all test cases will be mentioned in the output window along with the reason for failed test cases.

### Break down into unit tests

JUnit test cases will check individual module which helps to find bugs easily. This will help to test criticle modules without checking all other functionalities.

```
In this application the critical functionality is register a user. So rather than checking all the functionalities
only a unit test can be created for registering a user.
```
### Load Test
The load testing is necessary to check the applications performance when lot of users hit the application URL.
```
Open Jmeter and import the Sample_Spring_Boot_Application.jmx file. Now check the thread users and
change it according to the requirement. Now just run the file and wait for the process to complete.Once
the process is over the response can be verified in View results tree.
```



## Built With
```
1. Spring Gradle Project 
2. Spring Boot 1.5.7 framework
3. Tomcat 8
4. Java 1.8.0
```
## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors
```
Rishabh Jain
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


