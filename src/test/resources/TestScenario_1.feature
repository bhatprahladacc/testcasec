#Author: Prahlad 
#Code: Cucumber Test Case Scenario 1

Feature: Registration Functionality with Cucumber 
  Testing Registration of TestMeApp and also login included


 Scenario: Register with valid credentials 
  
 
    Given The user is at the Registration page of TestMeApp
 
    When The user aheres to valid credentials which are 
    |username||firstname||lastname||password||cpassword||number||emid||addr||dtob||ansr| 
    |theunamei13||myfname||mylname||password12||password12||9999988888||email@email.com||Dharwad, Karnataka||19/02/2003||red|
   
    Then The user is redirected to login page with success intimation
    
Scenario Outline: Login with valid credentials

	 Given The User is at Login page

	 When The user enters "<username>" and "<password>"
	 
	 Then The user is redirected to home page  
	 
	 Examples: 
	 |username||password|
	 |Lalitha||Password123|  
	 
Scenario: The user searches for a specific product headphone after login 

	 Given The User is at home page after login

	 When The user enters the product he wants "<product>" with suggestions 
	 			|products|
	 			|Head|
	 
	 Then The user is redirected to the results of the search
	 
Scenario: The user moves to cart without adding any items 

	 Given The user Alex is registered into TestMeApp 

	 When The user Alex is at home page after login and Searches the "<product>" he wants like Headphone  
	 			|products|
	 			|Headphone|

	 And The user Alex tries to proceed with an empty cart 
	 
	 Then The The TestMeApp does not display the cart icon
