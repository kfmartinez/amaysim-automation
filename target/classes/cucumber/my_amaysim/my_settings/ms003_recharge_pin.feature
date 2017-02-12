@my_settings @ms003
Feature: MS003 - My Settings - Recharge PIN

	Background:
	
		Given that the user wants to checkout his Recharge PIN in My Settings menu
	
	@ms003_01
	Scenario Outline: The user edits Recharge PIN with valid data
	
		When the user clicks on edit Recharge PIN
		And changes to "<new_recharge_pin>"
		And clicks on the recharge pin save button
		Then the old recharge pin should be change to the "<new_recharge_pin>"
		
		Examples:
		| new_recharge_pin |
		| 1234			   |
		
	##
	# Note:
	# 
	# - "" can be saved as a new recharge pin. 
	# I don't know if this is really the proper behavior for this.
	# I've also noticed that having a ""/null recharge pin, when clicking on
	# edit, it will show "4321" (past entered recharge pin)
	# as a "suggested" recharge pin, again,
	# I don't know if this is really the proper behavior of this functionality
	# but for now will NOT mark it as a defect.
	#
	# Please take note that I've also discovered that the SIM Nickname also does
	# this.
	#
	# - I've also noted that entering a recharge pin less that 4 characters is still accepted
	# and is appended by a zero pre-char.
	# 
	# I think this is a defect and will cause a lot of confusion since the zeroes are not
	# displayed when saved
	#
	# - Also saving a ""/null value, going to another page, then going back to my settings
	# has a problem. It still saves the last valid/persisted test data. I'll create a test
	# scenario for this. This also happens in SIM Nickname
	##
	@ms003_02
	Scenario Outline: The user edits Recharge PIN with invalid data
	
		When the user clicks on edit Recharge PIN
		And changes to "<invalid_recharge_pin>"
		And clicks on the recharge pin save button
		Then there should be an recharge pin error message stating "Please enter a 4-digit top-up PIN number."
		
		Examples:
		| invalid_recharge_pin |
		| a			   	   	   |
		| $				       |
		| 123			       |
	
	@ms003_03
	Scenario Outline: The user edits Recharge PIN to null, goes to another page, then goes back to My Settings
	
		When the user clicks on edit Recharge PIN
		And changes to "<new_recharge_pin>"
		And clicks on the recharge pin save button
		And goes to "My Payments" menu page
		And goes back to "My Settings" menu page
		Then the "<new_recharge_pin>" is still the recharge pin entered earlier
		
		Examples:
		| new_recharge_pin |
		| null             |
		| 123              |
	
	@ms003_04
	Scenario Outline: The user edits Recharge PIN but decides to cancel it
	
		When the user clicks on edit Recharge PIN
		And changes to "<new_recharge_pin>"
		And clicks on the recharge pin cancel button
		Then the old recharge should be retained
		
		Examples:
		| new_recharge_pin |
		| 3333             |
