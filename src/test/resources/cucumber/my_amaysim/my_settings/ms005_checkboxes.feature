@my_settings @ms005
Feature: MS005 - My Settings - Checkboxes

	Background:
	
		Given that the user wants to checkout his/her Call Waiting in My Settings menu
		
	@ms005_01
	Scenario: The user decides to change his Caller ID
	
		When the user tries to change the edit caller id button, depending on its current state, if selected
		Then there will be a success message stating "We have successfully updated your SIM settings."
	
	@ms005_02
	Scenario: The user decides to change his Call Waiting
	
		When the user tries to change the edit call waiting button, depending on its current state, if selected
		Then there will be a success message stating "We have successfully updated your SIM settings."
	
	@ms005_03
	Scenario: The user decides to change his Voice Mail
	
		When the user tries to change the edit voice mail button, depending on its current state, if selected
		Then there will be a success message stating "We have successfully updated your SIM settings."
