
{{ template:logo }}

{{ template:title }}

{{ template:badges }}

## Tech Stack  ![tech-stack](https://img.shields.io/badge/-Java-green?style=social&logo=Java) ![tech-stack](https://img.shields.io/badge/-Spring-green?style=social&logo=Spring) ![tech-stack](https://img.shields.io/badge/-GithubActions-green?style=social&logo=GitHub+Actions) ![tech-stack](https://img.shields.io/badge/-CircleCI-green?style=social&logo=CircleCI)

Spring Boot application that uses WebClient and Spring Security's Oauth 2 support to access to a secured REST API. The REST API is secured using KeyCloak 

## Installing and running this project
<details>
  <summary>Accompanying Blog Post</summary>
  <BR>

  The blog post accompanying this repository is available [here](https://www.todaystechnology.org/post/secure-spring-rest-api-using-openid-connect-and-keycloak-part-4)
  
</details>


<details>
  <summary>Run this Spring Application</summary>
  <BR>

  This project is best tested by running the below command

  ```bash
  mvn clean package
  ```
 
 This should build the project and run the testcase which uses a webclient to make a secured call to a mock api. The test case starts up two servers:
 * A mock Oauth2 service for creating tokens
 * A mock http server that acts as our api server

 The testcase creates a webclient which:
 1. Invokes the mock Oauth2 server and retrieve a token
 2. Invokes the mock api server with the token and executes an REST operation on the api

</details>

