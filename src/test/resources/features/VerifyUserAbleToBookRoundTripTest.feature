Feature: Breeze Airways - Round Trip Booking Test Feature

@UI
Scenario Outline: Verify User Able to Book Flight Tickets Successfully
	Given I Launch Application with "<url>" as URL in Browser
	Then I Verify Home Page Loaded Successfully
	When I Enter Source City as "<SourceCity>" in From Searchbox Field; in Home Page
	When I Enter Destination City as "<DestinationCity>" in From Searchbox Field; in Home Page
	When I Enter Departure and Return Dates; in Home Page
	When I Click On Search Button; in Home Page
	When I Select First Outbound Flight; in Search Page 
	When I Select First Inbound Flight; in Search Page
	When I Click On Login Later Link; in Search Page
	When I Select First Available Seat for Outbound Flight; in Seat Selection Page
	When I Click On Continue To Return Flight Seat booking Button; in Seat Selection Page
	When I Select First Available Seat for Inbound Flight; in Seat Selection Page
	Then I Verify Seats Selection Successfully; in Seat Selection Page

@Prod
Examples: 
  | url                            | SourceCity | DestinationCity |
  | https://www.flybreeze.com/home | Akron      | Charleston      |