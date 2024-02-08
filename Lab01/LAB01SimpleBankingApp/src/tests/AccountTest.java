package tests;

import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {
	/* Set Up */
	static String test_account_number = "101";
	static String test_username_of_account_holder = "Mike";
	static String test_account_type = "Savings";
	static Date test_account_opening_date = new Date();

	/* Runs object under test(constructor) */
	static Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type,
			test_account_opening_date);

	public static void main(String[] args) {
		testAccountConstructor();
		testAccountSetters();
	}

	public static void testAccountConstructor() {

		/* Verification */
		System.out.println("Starting the assertions of the test method: testAccountConstructor");

		// TC1 - Account Number
		if (testAccount.getAccount_number() == test_account_number) {
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC1 - getAccount_Number - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(
					TestUtils.TEXT_COLOR_RED + "TC1 - getAccount_Number - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// TC2 - Username of Account Holder
		if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2 - getUsername_of_account_holder - PASSED"
					+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2 - getUsername_of_account_holder- FAILED"
					+ TestUtils.TEXT_COLOR_RESET);
		}

		// TC3 - Account Type
		if (testAccount.getAccount_type() == test_account_type) {
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC3 - getAccount_type - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out
					.println(TestUtils.TEXT_COLOR_RED + "TC3 - getAccount_type - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// TC4 - Account Opening Date
		if (testAccount.getAccount_opening_date() == test_account_opening_date) {
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC4 - getAccount_opening_date - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(
					TestUtils.TEXT_COLOR_RED + "TC4 - getAccount_opening_date - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
	}

	public static void testAccountSetters() {
		/* Assertions */
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;

		System.out.println("All Java assertions in the test suite passed (none failed)");

	}

}
