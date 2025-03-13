Feature: User Authentication
  This feature ensures a seamless and secure experience for users during login and registration.
  It validates that users can successfully sign in and create new accounts while maintaining security and usability standards.


  # this is a kind of data driven approach for registration form (in 3rd step, it is List of Map with key and value)
  # this is more readable in terms of Key-value pair
  @adduser
  Scenario: Successful User Registration
    * Launch the Zepto application for new user registration
    * Complete the Registration on Account page
      | Username | Email   | Password   |
      | dynamic  | dynamic | Admin@1256 |
    * Navigate to Account page by register
    * Verify that user able to see a confirmation message on Account page

  #//a[text()='Logout']  -> check visible condition
  #(//a[@href='https://askomdch.com/account/edit-account/'])[2]  -> get the text ane verify  ->edit your password and account details



#  Scenario: Login with Valid Credentials
#    Given I navigate to the login page
#    When I enter valid credentials
#      | Email                | Password  |
#      | testuser@email.com   | Test@1234 |
#    And I click the "Login" button
#    Then I should be successfully logged in
#    And I should be redirected to the dashboard
#
#  Scenario: Login with Invalid Credentials
#    Given I navigate to the login page
#    When I enter invalid credentials
#      | Email               | Password  |
#      | wronguser@email.com | WrongPass |
#    And I click the "Login" button
#    Then I should see an error message "Invalid email or password"
#    And I should not be logged in