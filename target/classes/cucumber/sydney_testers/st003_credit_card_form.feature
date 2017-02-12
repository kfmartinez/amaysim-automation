@sanity_test @st003
Feature: ST003 - Get Car Insurance Quote - Pay Now

	Background:

		Given that the user wants to have a car insurance quote
		When the user clicks on "Get Car Insurance Quote" button
		And populates (id: quoteform) with valid test data
		And redirects to (ids: premiumform, premiumResultform)
		And clicks on "Buy Insurance" button
		And the user is redirected to (id: ccForm)

	##
	# Bugs:
	#
	# 1. Email/Username has no immediate validation
	# 2. Password has no immediate validation
	# 3. Email/Username and password can be "" text
	# 4. Expiration date has no immediate validation
	# 5. There is no checking on excessive spaces and '-' in card number field
	##
	@st003_01
	Scenario Outline: The user wants to pay now using Credit Card with valid test data

		When the user inputs <name_on_card>, <email_username>, <password>, <card_number>, <expiry_date>, <card_cvv>
		And clicks on "Pay Now" button
		Then the user should be redirected to a page with a successful confirmation

	Examples:

		| name_on_card | email_username | password | card_number         | expiry_date | card_cvv |
		| Test         | test@gmail.com | pa$w0rd  | 4111 1111 1111 1111 | 01/2013     | 111      |
	##
	# Bugs:
	#
	# 1. Email/Username has no immediate validation
	# 2. Password has no immediate validation
	# 3. Email/Username and password can be "" text
	# 4. Expiry date has no immediate validation
	# 5. There is no checking on excessive spaces and '-' in card number field
	# 6. Special characters are not an industry standard in name on card field
	# 7. Card number has an invalid regex checking on its inputs
	##
	@st003_02
	Scenario Outline: The user inputs the fields in (id: ccForm) with invalid test data

		When the user inputs <name_on_card>, <email_username>, <password>, <card_number>, <expiry_date>, <card_cvv>
		And clicks on "Pay Now" button
		Then the user should be redirected to a page with an <error_messages>

	Examples:

		| name_on_card | email_username | password | card_number                                  | expiry_date    | card_cvv | error_messages         |
		| null         | null           | null     | null                                         | Month/2013     | null     | <field> is required and cannot be 																														  empty                  |

#		| !@#$%^&*()   | null 			| null	   | 4111-      1111-      -  1111-  - -     1111 | Month/2013     | 111      | invalid name on card,  |
#																															    invalid email/username |
#																															    invalid password       |
#																															    invalid card number    |
#																															    invalid expiry date    |