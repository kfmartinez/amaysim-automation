@my_settings @ms001
Feature: MS001 - My Settings - SIM Nickname

	Background:
	
		Given that the user wants to checkout his SIM Nickname in My Settings menu
	
	@ms001_01
	Scenario Outline: The user edits SIM Nickname with valid data
	
		When the user clicks on edit SIM Nickname
		And changes the sim nickname value to "<new_sim_nickname>"
		And clicks on the sim nickname save button
		Then the old sim nickname should be changed to the "<new_sim_nickname>"
		
		Examples:
		| new_sim_nickname |
		| Kurt             |
		
	##
	# Bugs:
	#
	# 1. I assumed that giving a value of '' is an invalid test data
	##
	@ms001_02
	Scenario Outline: The user edits SIM Nickname with invalid data
	
		When the user clicks on edit SIM Nickname
		And changes the sim nickname value to "<invalid_sim_nickname>"
		And clicks on the sim nickname save button
		Then there should be an sim nickname error message stating "Please enter a valid SIM name."
		
		Examples:
		| invalid_sim_nickname |
		| $                    |
		| null                 |
		
	##
	# Bugs:
	#
	# 1. When sim nickname is null, then you try to edit it, then you cancel
	#    the value will be changed to the last value that persisted.
	##
	@ms001_03
	Scenario Outline: The user edits SIM Nickname but decides to cancel it
	
		When the user clicks on edit SIM Nickname
		And changes the sim nickname value to "<new_sim_nickname>"
		And clicks on the sim nickname cancel button
		Then the old nickname should be retained
		
		Examples:
		| new_sim_nickname |
		| Kurt             |
