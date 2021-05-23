<!-- ⚠️ This README has been generated from the file(s) "blueprint.md" ⚠️-->
<p align="center">
  <img src="https://github.com/SpringSecurity-Keycloak/Spring-5-Security-OAuth-2-Client-Credentials/blob/master/documentation/spring-5-security-oauth-2-client-logo.png" alt="Logo" width="150" height="auto" />
</p>

<h1 align="center">spring-5-security-oauth-2-client-credentials</h1>

<p align="center">
		<a href="https://github.com/SpringSecurity-Keycloak/Spring-5-Security-OAuth-2-Client-Credentials/actions/workflows/build.yml"><img alt="Build" src="https://github.com/SpringSecurity-Keycloak/Spring-5-Security-OAuth-2-Client-Credentials/actions/workflows/build.yml/badge.svg" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials"><img alt="Coverage" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials&metric=coverage" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials"><img alt="Quality Gate Status" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials&&metric=alert_status" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials"><img alt="Reliability Rating" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials&&metric=reliability_rating" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials"><img alt="Security Rating" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials&&metric=security_rating" height="20"/></a>
<a href="https://sonarcloud.io/dashboard?id=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials"><img alt="Vulnerabilities" src="https://sonarcloud.io/api/project_badges/measure?project=SpringSecurity-Keycloak_Spring-5-Security-OAuth-2-Client-Credentials&&metric=vulnerabilities" height="20"/></a>
	</p>



[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#tech-stack--tech-stackhttpsimgshieldsiobadge-java-greenstylesociallogojava-tech-stackhttpsimgshieldsiobadge-spring-greenstylesociallogospring-tech-stackhttpsimgshieldsiobadge-githubactions-greenstylesociallogogithubactions-tech-stackhttpsimgshieldsiobadge-circleci-greenstylesociallogocircleci)

## ➤ Tech Stack  ![tech-stack](https://img.shields.io/badge/-Java-green?style=social&logo=Java) ![tech-stack](https://img.shields.io/badge/-Spring-green?style=social&logo=Spring) ![tech-stack](https://img.shields.io/badge/-GithubActions-green?style=social&logo=GitHub+Actions) ![tech-stack](https://img.shields.io/badge/-CircleCI-green?style=social&logo=CircleCI)

Spring Boot application that uses WebClient and Spring Security's Oauth 2 support to access to a secured REST API. The REST API is secured using KeyCloak 


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#installing-and-running-this-project)

## ➤ Installing and running this project
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

