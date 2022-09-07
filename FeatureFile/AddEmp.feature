Feature: Add Employee
@MultipleData
Scenario Outline:
Validate add emp with multiple data
Given user navigates url "http://orangehrm.qedgetech.com/"
When user logs as username "Admin" and logs as password "Qedge123!@#"
When user click login button
When user click pim button
When user click add button
When user Enter "<FirstName>" and "<MiddleNname>" and "<LastName>"
When user capture emid
When user click save button
When user capture emid after save
Then user valid emid
Then user close Browser
Examples:
|FirstName|MiddleNname|LastName|
|Ranga1|Selenium1|Testing1|
|Ranga2|Selenium2|Testing5|
|Ranga7|Selenium9|Testin6|
|Ranga8|Selenium10|Testing111|
