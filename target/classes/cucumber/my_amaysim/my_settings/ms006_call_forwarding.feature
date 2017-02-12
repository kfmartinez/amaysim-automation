@my_settings @ms006
Feature: MS006 - My Settings - Call Forwarding

	Background:
	
		Given that the user wants to check out his Call Forwarding in My Settings menu
	
	@ms006_01
	Scenario Outline: The user edits his/her Call Forwarding settings with valid data
	
		When the user clicks on the edit call forwarding button
		And clicks on confirm in the confirmation screen
		And changes Forward Calls To to "<new_aus_number>"
		And clicks on save button
		Then there should be a successful message screen
		And the Forward Calls To should be updated to "<new_aus_number>" 
		
		Examples:
		
		| new_aus_number |
		| 0487654321     |
	
	##
	# Bugs
	#
	# 1. Text field also accepts non australian numbers
	##
	@ms006_02
	Scenario Outline: The user edits his/her Call Forwarding settings with invalid data
	
		When the user clicks on the edit call forwarding button
		And clicks on confirm in the confirmation screen
		And changes Forward Calls To to "<invalid_aus_number>"
		And clicks on save button
		Then there should be an "<error_message>"
		
		Examples:
		
		| invalid_aus_number | error_message 								           |
		| null               | Please enter a valid Australian mobile number.          |
		| asdf               | Please enter your phone number in the following format: |
		| 123                | Please enter your phone number in the following format: |
		| 0312 123 123       | Please enter your phone number in the following format: |
		
	@ms006_03
	Scenario: The user edits his/her Call Forwarding settings to disable Call Forwarding
	
		When the user clicks on the edit call forwarding button
		And clicks on confirm in the confirmation screen
		And clicks on the "No" radio button
		And clicks on save button
		Then there should be a successful message screen
		And the Call Forwarding should be disabled
		
	@ms006_04
	Scenario: The user cancels on the confirmation screen
	
		When the user clicks on the edit call forwarding button
		And clicks on cancel in the confirmation screen
		Then the user should be redirected to the My Settings page
		
	##
	# Bugs:
	#
	# 1. When the call forwarding is set to 'No' when clicking on edit, the default radio button
	#    selected is still selected as 'Yes'
	##
	@ms006_05
	Scenario: The user cancels on upon clicking confirm on the confirmation screen
	
		When the user clicks on the edit call forwarding button
		And clicks on confirm in the confirmation screen
		Then the radio button should be selected depending on the current settings
		And the user should be redirected to the My Settings page
