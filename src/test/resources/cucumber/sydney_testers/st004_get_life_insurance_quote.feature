@sanity_test @st004
Feature: ST004 - Get Life Insurance Quote
	
	##
	# Objective:
	# - Create scenarios that will test the full functionality of Get Life Insurance Quote
	#
	#
	# Check all expected field formats
	##
	Background:

		Given that the user wants to have a life insurance quote
		When the user clicks on "Get Life Insurance Quote" button

	##
	# Bugs:
	#
	# No bugs identified
	##
	@st004_01
	Scenario: The user accesses the get life insurance quote functionality
		
		Then the ajax will be executed and a form will be available to fill up
		And Age field is a drop down
		And Gender field is a text field
		And Occupation Category field is a text field
		And State field is a drop down
		And Email field is a text field

	##
	# Bugs:
	#
	# 1. Rows should be organized, age > gender > occupation_category > state > email
	#	 not age > email > gender > occupation_category > state
	##
	@st004_02
	Scenario Outline: The user inputs all the fields with valid test data (id: quoteform)

		And the user inputs <age>, <gender>, <occupation_category>, <state>, <email>
		And clicks on "Get Quote" button
		Then a new form is available with the monthly premium available
		And a "Buy Insurance" button available
		And clicks on "Get Quote" button
		And the user should see an organized rows based on the form completed (ids: premiumform, premiumResultform)
		And the user clicks "Buy Insurance" button
		And the user is redirected to (id: ccForm)

		Examples:
		| age  | gender | occupation_category   | state              | email           |
		| 25   | Male   | Low Risk	            | New South Wales	 | test@gmail.com  |

	##
	# Bugs:
	#
	# 1. Age Field: should not accept negative values
	# 2. Age Field: should not be able to type '.' and other special characters to avoid technecalities (ex. 1994.0) 
	#				although there is an error message prompted - restrict input fields to valid regex
	# 3. Age Field: should not accept obviously wrong age (greater than 150 or less than legal age 18)
	# 4. Email Field: should only accept valid email addresses accepted as industry standard
	##
	@st004_03
	Scenario Outline: The user inputs all the fields with invalid test data (id: quoteform)

		And the user inputs <make>, <year>, <age>, <gender>, <state> and <email>
		And clicks on "Get Quote" button
		Then specific <error_messages> will be thrown on certain fields

		Examples:
		| age       | gender | occupation_category   | state              | email            | error_messages                	|
		| -1   		| Female | Medium Risk			 | Victoria			  | .!$@gmail@a.com  | age is invalid, email is invalid |
		| 2000 		| Male   | High Risk             | Victoria           | test@gmail.com   | age is invalid                   |
		| a    		| Male   | High Risk             | Victoria           | test@gmail.com   | age is invalid                   |
		| 1994.0    | Male   | High Risk             | Victoria           | test@gmail.com   | (the user cannot type '.')       |
#		| null      | Male   | Low Risk	             | New South Wales	  | null  			 | The age is required. Numeric, 
#																							   bigger than zero., 
#																							   The email is required
#		
	
	##
	# Bugs:
	#
	# 1. "Get Quote" button is disabled although test data are all valid
	##
	@st004_05
	Scenario: The user buys the insurance based on the quote (ids: premiumform, premiumResultform)

		When the user inputs all valid fields
		And clicks "Get Quote" button
		And sees an organized rows based on the form completed
		And clicks "Buy Insurance" button
		And the user should be redirected to another form
		And the user clicks back button
		Then the "Get Quote" button should be enabled
		