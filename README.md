# Vulnerability Viewer

A RESTful Spring boot server that serves three resources:

 - `/api/v1/project`
    - GET `/{projectId}/`
       - find and return a project with the given id
    - PUT `/`
       - take a ProjectDto and upsert it in the database
    - PUT `{projectId}/user/{userId}/`
       - add the user with the given userId to the project with the given projectId
 - `/api/v1/user`
    - GET `/{userId}/`
       - find and return a user with the given id
    - GET `/project/{projectId}/`
       - finds all users that belong to the given project
    - PUT `/`
       - Take a UserDto and upsert it in the database
 - `/api/v1//vulnerability`
    - GET `/{vulnerabilityId}/`
       - find and return a project with the given id
    - GET `/project/{projectId}/`
       - find and return all vulnerabilities that belong to the given project
    - GET `/user/{userId}/`
       - find and return all vulnerabilities that are visible to the given user
    - PUT `/`
       - take a VulnerabilityDto and upsert it in the database

## Model Definitions
 
The models returned are:

 - Project
    - id: UUID
    - title: String
    - users: Set\<UUID\>

 - User
    - id: UUID
    - email: String
    - firstName: String
    - lastName: String
    - projectIds: Set\<UUID\>
    - roles: Set\<String\>
    
 - Vulnerability
    - id: UUID
    - title: String
    - projectId: UUID
    - file: String
    - lineNumber: long
    - riskRating: String

## Model Relationships

The relationships between these models are:

 - Project (many) <--> User (many)
 - Project (one)  <--> Vulnerability (many)

## To run:

`mvn spring-boot:run`
