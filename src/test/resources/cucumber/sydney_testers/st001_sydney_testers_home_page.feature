@sanity_test @st001
Feature: ST001 - Sydney Testers Home Page

	##
	# Objective:
	# - Check if all the functionalities and resources 
	#   are available within http://sydneytesters.herokuapp.com/
	#
	# In this scenario, we've checked if the buttons and the header image are available
	# when the user accesses http://sydneytesters.herokuapp.com/
	#
	#
	# Notes:
	#
	# I've excluded "Already an user? Login here" button. But I just want to state that
	# its preferable to have "Already a user" instead of "Already an user"
	#
	# I've also noted that "Get Car Quote" and "Get Life Quote" are quite confusing,
	# have "Get Car Insurance Quote" and "Get Life Insurance Quote" instead
	#
	# Button description should be more clear and precise so that customers
	# could identify its functionality even without clicking on it
	#
	# I'll mark this one as failed but I'll assume the "Get Car Quote" and
	# "Get Life Quote" buttons to be correct on the following tests
	# so that I could proceed
	#
	# Bugs
	#
	# 1. "Get Car Quote" button should be "Get Car Insurance Quote" button
	# 2. "Get Insurance Quote" button should be "Get Insurance Quote" button
	##
	@st001_01
	Scenario: The user goes to http://sydneytesters.herokuapp.com/

		Given that the user wants to access "http://sydneytesters.herokuapp.com/" to get car and life insurance quotes
		When the user goes to site
		Then he should be able to see "Get Car Insurance Quote" button
		And the "Get Life Insurance Quote" button
		And the Header Image
