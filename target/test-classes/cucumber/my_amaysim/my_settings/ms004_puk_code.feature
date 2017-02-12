@my_settings @ms004
Feature: MS004 - My Settings - PUK Code

	@ms004_01
	Scenario: The user views his/her PUK Code

		Given that the user wants to checkout his PUK Code
		When the user goes to PUK Code My Settings menu
		Then the user should visibly view the PUK Code
