@my_settings @ms002
Feature: MS002 - My Settings - Plan Settings

	Background:
	
		Given that the user wants to check out his Plan Settings in My Settings menu
	
	@ms002_01		
	Scenario: the user checks out payment type details using plan settings
	
		When the user clicks on "Prepaid, BPay" in the Payment Type
		Then the user is redirected to "My Payment" menu page
	