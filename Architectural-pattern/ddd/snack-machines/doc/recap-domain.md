

- First of all, we started with the core domain right away without modeling the UI or the database first.

    It's a good idea to always do this. We should always begin the project by experimenting with our domain model, as it's the most important part of our application.

- Secondly, always start with a single bounded context for all business logic in our application.

  Don't try to divide it into several pieces up front. While bounded contexts help reduce the complexity, but rather increase it instead.

- Thirdly, constantly evaluate our code and look for hidden abstractions.

  It's not always possible to identify the value objects such as Money in the most sophisticated situation.

  Nevertheless, if we see our code become awkward, we should test different approaches and examine if they fit our problem domain.
  It might be there is a hidden abstraction in our domain model that we didn't express just yet.