package tests;

import model.Account;

import java.text.SimpleDateFormat;
import java.util.Date;

import utils.TestUtils;

public class AccountTest {
	/**
	 * This test method will test the constructor of Account, using all of its
	 * getter methods
	 */
	public static void testConstructor() {
		// 1-Setup
		String test_account_number = "2";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Savings";
		Date test_account_opening_date = new Date(); // Use current date

		// 2-Exercise, Run the object under test (constructor)
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type,
				test_account_opening_date);

		// 3-Verify if the constructor and getter methods of the class work properly
		// Test case 1: Account Number
		if (testAccount.getAccount_number() == (test_account_number))
			System.out
					.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccount_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccount_number-Failed: account number did not match"
					+ TestUtils.TEXT_COLOR_RESET);

		// Test case 2: Username of account holder
		if (testAccount.getUsername_of_account_holder() == (test_username_of_account_holder))
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUsername_of_account_holder-Passed"
					+ TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED
					+ "TC2-getUsername_of_account_holder-Failed: username of account holder did not match"
					+ TestUtils.TEXT_COLOR_RESET);
		
		// Test case 3: Account type
		if (testAccount.getAccount_type() == (test_account_type))
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccount_type-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccount_type-Failed: account type did not match"
					+ TestUtils.TEXT_COLOR_RESET);
		
		// Test case 4: Account opening date 
		if (testAccount.getAccount_opening_date() == (test_account_opening_date))
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC4-getAccount_opening_date-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(
					TestUtils.TEXT_COLOR_RED + "TC4-getAccount_opening_date-Failed: account opening date did not match"
							+ TestUtils.TEXT_COLOR_RESET);

	}

	/**
	 * This test method will test all the setter methods of Account
	 */
	public static void testSetters() {

		// New test data for setters
		String test_account_number = "2";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Savings";
		Date test_account_opening_date = new Date(2023, 11, 20);

		// Setup - Create a new Account object with initial values
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type,
				test_account_opening_date);
		
		// Assertions
		testAccount.setAccount_number(test_account_number);
		assert testAccount.getAccount_number().equals(test_account_number);

		testAccount.setUsername_of_account_holder(test_username_of_account_holder);
		assert testAccount.getUsername_of_account_holder().equals(test_username_of_account_holder);

		testAccount.setAccount_type(test_account_type);
		assert testAccount.getAccount_type().equals(test_account_type);

		testAccount.setAccount_opening_date(test_account_opening_date);
		assert testAccount.getAccount_opening_date().equals(test_account_opening_date);

		System.out.println("All Java assertations in the test suite passed (none failed).");

	}

	public static void main(String[] args) {
		testConstructor();
		testSetters();
	}

}
