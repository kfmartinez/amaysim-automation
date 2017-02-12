@my_settings @ms007
Feature: MS007 - My Settings - Premium SMS Limit

	Background:
	
		Given that the user wants to check out his Premium SMS Limit in My Settings menu
		When clicks on edit Premium SMS Limit
	
	##
	# I've noticed that when changing, there is no successful message being brought up
	# I don't know if this is a bug, because this has to be a consistency issue
	##
	@ms007_01
	Scenario Outline: The user edits his/her Premium SMS Limit
		
		And the user changes his/her PremiumSMS limit to "<new_premium_sms_limit>"
		Then the user should see the "<new_premium_sms_limit>" has been updated
		
		Examples:
		
		| new_premium_sms_limit |
		| OFF                   |
		| $100                  |
		
	@ms007_02
	Scenario: The user plans to edit his/her Premium SMS Limit then cancels it
	
		And clicks on the cancel button
		Then the user should be redirected to the My Settings menu page
