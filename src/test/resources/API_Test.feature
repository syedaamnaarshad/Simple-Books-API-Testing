Feature: API tests

  @getStatus
  Scenario: Get Simple Books API Status
    Given the valid endpoint to test
    When the get request is sent to the server with status path
    Then the response code received is 200 and body status is OK

  @postAuthentication
  Scenario: API Authentication
    Given the valid endpoint to test
    When the post request is sent to the server with the authentication path
    Then the response code received is 201 and body contains the accessToken

  @getListOfBooks
  Scenario: Get list of books
    Given the valid endpoint to test
    When the get request is sent to the server with the get list of books path
    Then the response code received is 200

  @getSingleBook
  Scenario: Get a single book
    Given the valid endpoint to test
    When the get request is sent to the server with the get a single book path
    Then the response code received is 200

  @postOrderBook
  Scenario: Order a book
    Given the valid endpoint to test
    When the post request is sent to the server with the order book path
    Then the response code received is 201

  @getAllBookOrders
  Scenario: Get all book orders
    Given the valid endpoint to test
    When the get request is sent to the server with the get orders path
    Then the response code received is 200

  @getSingleBookOrder
  Scenario: Get a single book order
    Given the valid endpoint to test
    When the get request is sent to the server with the get single order path
    Then the response code received is 200

  @patchUpdateBookOrder
  Scenario: Update a book order
    Given the valid endpoint to test
    When the patch request is sent to the server with the patch get single order path
    Then the response code received is 204


  @deleteBookOrder
  Scenario: Delete a book order
    Given the valid endpoint to test
    When the delete request is sent to the server with the delete get single order path
    Then the response code received is 204
