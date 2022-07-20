Feature: Login into application

@Smoke
Scenario Outline: Positive test validating login
Given Initialize browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on Login link in home page to land on secure sign in page
When User enters <username> and <password> and logs in
Then Verify that the user is successfully logged in 
And close Browsers

Examples:
|username                    |password      |
|jadhavviraj96@gmail.com     |Barcelona10!  |
|nasvdnhv@gmail.com          |hfwjhj        |
