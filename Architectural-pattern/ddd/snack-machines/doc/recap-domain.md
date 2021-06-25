


<br>

## Table of Contents
- [How to express Model-Driven Design](#how-to-express-model-driven-design)
- [About designing value objects](#about-designing-value-objects)
- [About JVM](#about-jvm)
- [Note about Entity and Value object base class](#note-about-entity-and-value-object-base-class)
- [Note about testing for Domain Model](#note-about-testing-for-domain-model)


<br>

## How to express Model-Driven Design

- First of all, we started with the core domain right away without modeling the UI or the database first.

    It's a good idea to always do this. We should always begin the project by experimenting with our domain model, as it's the most important part of our application.

- Secondly, always start with a single bounded context for all business logic in our application.

  Don't try to divide it into several pieces up front. While bounded contexts help reduce the complexity, but rather increase it instead.

- Thirdly, constantly evaluate our code and look for hidden abstractions.

  It's not always possible to identify the value objects such as Money in the most sophisticated situation.
  
  Nevertheless, if we see our code become awkward, we should test different approaches and examine if they fit our problem domain.
  It might be there is a hidden abstraction in our domain model that we didn't express just yet.
  
<br>

## About designing value objects

It's not always clear if a concept in our domain model is an entity or a value object, and unfortunately, there are no objective attributes we could use to get to know it.
Whether or not a notion is a value object fully depends on the problem domain.

A concept can be an entity in one domain model and a value object in another.

For example:
- In our system, the Money class is certainly a value object.
- At the same time, if we build a software for tracking the flow of the cash in the whole country, we do need to treat every single bill seperately, as we need to gather statistics for each of them.

  In this case, the notion of money would be an entity, although we would probably name it note or a bill.

**If we can safely replace an instance of a class with another one, which has the same set of attributes, that's a good sign this concept is a value object.**

Prefer value objects to entities:
- Value objects are light-weight.
- Put most of business logic to value objects.
- entities acts as wrappers.
- Should move logic from Entities to Value Objects.

A good approach for designing value object is to compare it to an integer. If they have essentially the same semantics, we can be sure the class we are looking at is a value object.

Value Objects are lightweight and therefore are extremely easy to maintain and reason about.

<br>

## About JVM

When we call the contains() method on the list of entities, JVM compares the objects inside the list with the target one by calling the equals() method.

The default equals() implementation gives us only reference equality.

<br>

## Note about Entity and Value object base class

1. Entity base class

  - Id property
  - Equality members

2. Value object base class

  - Don't have an Id property

    It also means that we can't place all code required for equality in the base class.    

  - Can't place equality members to the base class

    In order to implement structural equality, we need to know the internals of each value object class. Nevertheless, we can still gather some logic common to such classes.

<br>

## Note about testing for Domain Model

1. Code-first approach for experiments

2. Test-first approach after the experiments

3. Always cover the model with unit tests

<br>

References:

[Domain Driven Design with Spring Boot: Enterprise application from scratch by Ajay Kumar](https://www.amazon.com/Domain-Driven-Design-Spring-Boot-ebook/dp/B07K5W7CTZ)

[Domain Driven Design Distilled by Vernon Vaughn](https://www.amazon.com/Domain-Driven-Design-Distilled-Vaughn-Vernon-ebook/dp/B01JJSGE5S)

[Implementing Domain-Driven Design by Vernon Vaughn](https://www.amazon.com/Implementing-Domain-Driven-Design-Vaughn-Vernon-ebook/dp/B00BCLEBN8)

[Patterns, principles, and practices of Domain-Driven Design by Scott Millett](https://www.amazon.com/Patterns-Principles-Practices-Domain-Driven-Design-ebook/dp/B00XLYUA0W)

[Hands on Domain-Driven Design with .NET Core by Alexey Zimarev](https://www.amazon.com/Hands-Domain-Driven-Design-NET-ebook/dp/B07C5WSR9B)

[Domain-Driven Design: Tackling complexity in the Heart of Software by Evans Eric](https://www.amazon.com/Domain-Driven-Design-Tackling-Complexity-Software-ebook/dp/B00794TAUG)