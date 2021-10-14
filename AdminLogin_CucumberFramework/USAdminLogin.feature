Feature: LoginAdmin

Background:
Given user is on admin login page

Scenario Outline: Correct Admin login
When user enters correct "<username>" and "<password>" and clicks login
Then Admin homepage should be loaded successfully

Examples:
|username|password|
|admin   |admin@123|
|admin   |aaa|

#Scenario:Search
#When user enters correct credentials and clicks login
#Then Admin homepage should be loaded successfully
#And user gives search for a word
#|item1 |
#And clicks search button
#Then Search result should be seen
