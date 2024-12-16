package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.ContactService;

public class ContactServiceTest {

	// Clear array after each test to start with fresh information
	@AfterEach
	void tearDown() {
		ContactService.contactList.clear();
	}

	// Test for adding new contact
	@DisplayName("Test addContact")
	@Test
	void testAddContact() {

		// Dummy information
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		// Create new ContactService instance
		ContactService test = new ContactService();

		// Verify that it is empty.
		assertTrue(ContactService.contactList.isEmpty());

		// Create new contact object by passing in dummy information.
		test.addContact(firstName, lastName, phoneNumber, address);

		// Verify that the contact list is not empty now.
		assertFalse(ContactService.contactList.isEmpty());

		// Verify that information matches what was passed in.
		assertEquals(0, ContactService.contactList.get(0).getContactId());
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		assertEquals(address, ContactService.contactList.get(0).getAddress());
	}

	// Test to delete contact
	// Will first create 3 objects then delete the first one by passing in 0 as the
	// target ID.
	@DisplayName("Test deleteContact")
	@Test

	void testDeleteContact() {
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		boolean idChecker = false;

		ContactService test = new ContactService();

		// First verify that there are no other objects already in the list.
		assertTrue(ContactService.contactList.isEmpty());

		// Add 3 duplicate objects, only difference will be the Contact ID that is
		// entered only by the system.
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);

		// Verify that there are now only 3 objects in contactList
		assertEquals(3, ContactService.contactList.size());

		// Remove first entry
		test.delContact("0");

		// Verify that there are now only 2 objects in contactList
		assertEquals(2, ContactService.contactList.size());

		// Verify that the correct object was removed by searching the ID
		for (int i = 0; i < ContactService.contactList.size(); i++) {
			if (ContactService.contactList.get(i).getContactId() == 0) {
				idChecker = true;
			}
		}
		assertFalse(idChecker);

	}

	// Test that contacts firstName can be edited by searching for them by id, and
	// providing updated information via string
	@DisplayName("test editFirstName")
	@Test
	void testEditFirstName() {
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		// New value entered as separate variables to prevent errors from mistyping.
		String newFirstName = "Jane";

		ContactService test = new ContactService();

		// Confirm that list starts out empty
		assertTrue(ContactService.contactList.isEmpty());

		// Populate list with dummy data
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);

		// Verify that correct number of items have been added.
		assertEquals(3, ContactService.contactList.size());

		// Update values for value 1 to be the values from the new variables for
		// respective variables.
		test.editFirstName("1", newFirstName);

		// Verify that updates were successful.
		assertEquals(newFirstName, ContactService.contactList.get(1).getFirstName());
	}

	// Test that contacts lastName can be edited by searching for them by id, and
	// providing updated information via string
	@DisplayName("test editLastName")
	@Test
	void testEditLastName() {
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		// New value entered as separate variables to prevent errors from mistyping.
		String newLastName = "Smith";

		ContactService test = new ContactService();

		// Confirm that list starts out empty
		assertTrue(ContactService.contactList.isEmpty());

		// Populate list with dummy data
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);

		// Verify that correct number of items have been added.
		assertEquals(3, ContactService.contactList.size());

		// Update values for value 1 to be the values from the new variables for
		// respective variables.
		test.editLastName("1", newLastName);

		// Verify that updates were successful.
		assertEquals(newLastName, ContactService.contactList.get(1).getLastName());
	}

	// Test that contacts phoneNumber can be edited by searching for them by id, and
	// providing updated information via string
	@DisplayName("test editPhoneNumber")
	@Test
	void testEditPhoneNumber() {
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		// New value entered as separate variables to prevent errors from mistyping.
		String newPhoneNumber = "9876543210";

		ContactService test = new ContactService();

		// Confirm that list starts out empty
		assertTrue(ContactService.contactList.isEmpty());

		// Populate list with dummy data
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);

		// Verify that correct number of items have been added.
		assertEquals(3, ContactService.contactList.size());

		// Update values for value 1 to be the values from the new variables for
		// respective variables.
		test.editPhone("1", newPhoneNumber);

		// Verify that updates were successful.
		assertEquals(newPhoneNumber, ContactService.contactList.get(1).getPhoneNumber());
	}

	// Test that contacts address can be edited by searching for them by id, and
	// providing updated information via string
	@DisplayName("test editAddress")
	@Test
	void testEditAddress() {
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		// New value entered as separate variables to prevent errors from mistyping.
		String newAddress = "987 Side Street";

		ContactService test = new ContactService();

		// Confirm that list starts out empty
		assertTrue(ContactService.contactList.isEmpty());

		// Populate list with dummy data
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);

		// Verify that correct number of items have been added.
		assertEquals(3, ContactService.contactList.size());

		// Update values for value 1 to be the values from the new variables for
		// respective variables.
		test.editAddress("1", newAddress);

		// Verify that updates were successful.
		assertEquals(newAddress, ContactService.contactList.get(1).getAddress());
	}

}
