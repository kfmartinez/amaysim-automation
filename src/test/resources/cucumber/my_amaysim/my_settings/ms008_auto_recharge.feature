@my_settings @ms008
Feature: MS008 - My Settings - Auto Recharge

	Background:
	
		Given that the user wants to check out his Auto Recharge settings in My Settings menu
		When the user clicks on edit Auto-Recharge
	
	@ms008_01		
	Scenario Outline: The user edits his/her Auto Recharge settings
		
		And the user changes "<balance_limit>" and "<recharge_sim>"
		Then the Auto-Recharge should be updated to "<balance_limit>" and "<recharge_sim>"
		
		Examples:
		| balance_limit | recharge_sim |
		| $10           | $50           |
	
	@ms008_02
	Scenario: The user disables his/her Auto Recharge settings
	
		And the user clicks on "No"
		Then the Auto-Recharge should be disabled
	
	##
	# Bugs:
	#
	# 1. When Auto Recharge is disabled (No) when clicking on edit 
	#    link text, it is set to 'Yes' as default
	##
	@ms008_03	
	Scenario: The user plans to edit his/her Auto Recharge settings then changes his/her mind
	
		Then the state should be whatever it is in. (if disabled, it should be on No, if not, then on Yes)
		
	@ms008_04
	Scenario: The user cancels Auto-Recharge settings edit
	
		And clicks on cancel button
		Then the user should be redirected to My Settings menu
