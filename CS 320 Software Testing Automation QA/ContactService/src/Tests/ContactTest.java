package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.Contact;

public class ContactTest {

	@DisplayName("Test of a good constructor")
	@Test
	public void testGoodConstructor() {
		String contactId = "1";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);

		assertEquals(1, testContact.getContactId());
		assertEquals(firstName, testContact.getFirstName());
		assertEquals(lastName, testContact.getLastName());
		assertEquals(phoneNumber, testContact.getPhoneNumber());
		assertEquals(address, testContact.getAddress());
	}

	@DisplayName("Test of a bad contact ID, more than 10 characters")
	@Test
	public void testBadContactId() {
		String contactId = "01234567890";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a null Contact ID")
	@Test
	public void testNullContactId() {
		String contactId = null;
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a first name over 10 characters")
	@Test
	public void testLongFirstName() {
		String contactId = "1";
		String firstName = "Christopher";
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a first name with null value")
	@Test
	public void testNullFirstName() {
		String contactId = "1";
		String firstName = null;
		String lastName = "Doe";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a last name over 10 characters")
	@Test
	public void testLongLastName() {
		String contactId = "1";
		String firstName = "John";
		String lastName = "Abatangelos";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a first name with null value")
	@Test
	public void testNullLastName() {
		String contactId = "1";
		String firstName = "John";
		String lastName = null;
		String phoneNumber = "1234567891";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a phone number that is too short")
	@Test
	public void testShortPhone() {
		String contactId = "1";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a phone number that is too long")
	@Test
	public void testLongPhone() {
		String contactId = "1";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "12345678912";
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of a phone number that has a null value")
	@Test
	public void testNullPhone() {
		String contactId = "1";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = null;
		String address = "123 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of an address that is too long")
	@Test
	public void testLongAddress() {
		String contactId = "1";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "12345678912";
		String address = "1234567890123456789 Main Street";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	@DisplayName("Test of an address that has a null value")
	@Test
	public void testNullAddress() {
		String contactId = "1";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "12345678912";
		String address = null;

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

}
