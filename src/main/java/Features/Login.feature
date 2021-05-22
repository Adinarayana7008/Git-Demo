Feature: Facebook Account Login

Scenario Outline: Login for a facebook account from the fb home page

Given User has already opened the browser window
When Browser is visible to user
Then Enter the url and press enter
And Login page of facebook should appear
Then Enter "<Phonenumber>" "<password>" in Loginform
Then I click "Login"

Examples:
| Phonenumber | password | 
| 9505215538  | 9704323434 | 