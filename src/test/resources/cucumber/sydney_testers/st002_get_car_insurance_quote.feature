@sanity_test @st002
Feature: ST002 - Get Car Insurance Quote

	##
	# Objective:
	# - Create scenarios that will test the full functionality of Get Car Insurance Quote
	#
	#
	# Check all expected field formats
	##
	Background:

		Given that the user wants to have a car insurance quote
		When the user clicks on "Get Car Quote" button
	##
	# Bugs:
	#
	# No bugs identified
	##
	@st002_01
	Scenario: The user accesses the get car insurance quote functionality
		
		Then the ajax will be executed and a form will be available to fill up
		And Make field is a drop down
		And Year field is a text field
		And Driver's Age field is a text field
		And Driver's Gender field is a radio button
		And State field is a drop down
		And Email field is a text field

	##
	# Note:
	#
	# I don't know if 025 is a valid age, but it is technically valid
	# It fails when inputted in the text field
	# 
	# Bugs:
	#
	# 1. Rows should be organized, make > year > age > gender > state > email
	#	 not age > email > gender > make > year > state
	##
	@st002_02
	Scenario Outline: The user inputs all the fields with valid test data (id: quoteform)

		And the user inputs <make>, <year>, <age>, <gender>, <state> and <email>
		And clicks on "Get Quote" button
		Then a new form is available with the monthly premium available
		And a "Buy Insurance" button available
		And clicks on "Get Quote" button
		And the user should see an organized rows based on the form completed (ids: premiumform, premiumResultform)
		And the user clicks "Buy Insurance" button
		And the user is redirected to (id: ccForm)

		Examples:
		| make | year | age | gender | state           | email 			|
		| Audi | 1992 | 25	| Male	 | New South Wales | test@gmail.com |

	##
	# Note:
	#
	# Year Field: 
	# 
	# I think it shouldn't accept years that even
	# the car manufacturers themselves doesn't exist at that time.
	# The year field currently accepts negative values, values less that let's say 1700 
	# and values greater than current year
	# that are obviously wrong manufacturing years so it should fail
	#
	# Age:
	#
	# Even the age field accepts negative numbers, and zero. This should fail and shouldn't accept
	# ages less than the legal age (PH legal age is 18)
	#
	# Email:
	#	
	# Email should only accept valid email addresses accepted as industry standard.
	# This field shouldn't accept many special characters. Please see test data below
	#
	# Bugs:
	#
	# 1. Year Field: should not accept negative values and obviously wrong years that doesn't have cars
	# 2. Year Field: alphabetic input shows "The year has to be a number bigger than zero" as error message
	# 3. Year Field: should not be able to type '.' and other special characters to avoid technicalities (ex. 1994.0) 
	#				 although there is an error message prompted - restrict input fields to valid regex
	# 4. Year Field: should not accept manufacturing year greater than current year
	# 5. Year Field: there's no limit in inputting numbers
	# 6. Age Field: should not accept negative values
	# 7. Age Field: should not be able to type '.' and other special characters to avoid technicalities (ex. 1994.0) 
	#				although there is an error message prompted - restrict input fields to valid regex
	# 8. Age Field: should not accept obviously wrong age (greater than 150 or less than legal age 18)
	# 9. Email Field: should only accept valid email addresses accepted as industry standard
	##
	@st002_03
	Scenario Outline: The user inputs all the fields with invalid test data (id: quoteform)

		And the user inputs <make>, <year>, <age>, <gender>, <state> and <email>
		And clicks on "Get Quote" button
		Then specific <errors> will be thrown on certain fields

		Examples:
		| make | year   | age   | gender | state           | email 			 | errors 			                                        				|
		| BMW  | null   | null	| Male	 | Victoria        | null            | year has to be bigger number than zero, age is invalid, email is invalid |
		| Audi | -1     | -1	| Male	 | New South Wales | test@gmail.com  | year has to be bigger number than zero, age is invalid 					|
		| Audi | 20000  | 500	| Male	 | New South Wales | test@gmail.com  | year is invalid, age invalid                      						|
		| Audi | a      | a	    | Male	 | New South Wales | test@gmail.com  | year is invalid, age is invalid                     						|
		| Audi | 1994.0 | 25	| Male	 | New South Wales |  test@gmail.com | (the user cannot type '.')             									|
		| Audi | 2000   | 25	| Male	 | New South Wales | .!$@gmail@a.com | email is not valid  	                  									|
	##
	# Bugs:
	#
	# 1. "Get Quote" button is disabled although test data are all valid
	##
	@st002_06
	Scenario: The user buys the insurance based on the quote (ids: premiumform, premiumResultform)

		When the user inputs all valid fields
		And clicks "Get Quote" button
		And sees an organized rows based on the form completed
		And clicks "Buy Insurance" button
		And the user should be redirected to another form
		And the user clicks back button
		Then the "Get Quote" button should be enabled
