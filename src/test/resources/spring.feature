Feature: the message can be retrieved

  Scenario: client makes call to GET /hello
    Given the client calls get allocations
    When the client receives status code of 200
    And Print the response contents to stdout


  Scenario: client makes call to GET /hello
    Given the client calls get allocations
    When the client receives status code of 200
    And Print the response contents to stdout

  Scenario: Connect to InMemory Mongo
    Given Start the InMemory MongoDB.
    Then Perform a basic insert into the sample collection.



