package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	/* Set Up */
	static String test_username = "mike";
	static String test_password = "my_passwrd";
	static String test_first_name = "Mike";
	static String test_last_name = "Smith";
	static String test_mobile_number = "07771234567";

	/* Runs object under test(constructor) */
	static User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

	public static void main(String[] args) {
		/*
		 * OLD: Manual Testing User testUser = new User("mike", "my_passwd", "Mike",
		 * "Smith", "0777123456"); System.out.println(testUser);
		 */
		testUserConstructor();
		testUserSetters();

	}

	// Automated Testing

	/* Verification */
	public static void testUserConstructor() {
		System.out.println("Starting the assertions of the test method: testUserConstructor");

		// TC1 - Username
		if (testUser.getUsername() == test_username) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1 - getUsername - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1 - getUsername - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// TC2 - Password
		if (testUser.getPassword() == test_password) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2 - getPassword - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2 - getPassword - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// TC3 - First Name
		if (testUser.getFirst_name() == test_first_name) {
			System.out
					.println(TestUtils.TEXT_COLOR_GREEN + "TC3 - getFirst_name - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3 - getFirst_name - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// TC4 - Last Name
		if (testUser.getLast_name() == test_last_name) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4 - getLast_name - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4 - getLast_name - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// TC5 - Last Name
		if (testUser.getMobile_number() == test_mobile_number) {
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC5 - getMobile_number - PASSED" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC5 - getMobile_number - FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
	}

	/* Assertions */
	public static void testUserSetters() {

		// assert 1==2; -> test assertion
		assert testUser.getUsername() == test_username;
		assert testUser.getPassword() == test_password;
		assert testUser.getFirst_name() == test_first_name;
		assert testUser.getLast_name() == test_last_name;
		assert testUser.getMobile_number() == test_mobile_number;

		System.out.println("All Java assertions in the test suite passed (none failed)");
	}

}
