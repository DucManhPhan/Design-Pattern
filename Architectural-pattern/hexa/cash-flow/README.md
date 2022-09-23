
# Some thought about this implementation of Hexagonal Architecture

1. Domain Model

    Use entity as domain model. We don't apply DDD in this project.

2. core layer

    It only defines some services that wrap the repositories.
    

<br>

## Wrapping up

In summary, from my point of view, this is not Hexagonal Architecture. It follows the Layered architecture.

It defines some classes with the name "Port" and "Adapter" to pretend it as Hexagonal Architecture.


<br>

Reference:

[Hexagonal Architecture Pattern with Spring Boot example](https://azeynalli1990.medium.com/hexagonal-architecture-pattern-with-spring-boot-example-d6a26b466ecc)

