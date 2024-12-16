package Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

	// Initialize value for current ID number
	int curIdNum = 0;

	// Initialize new list to hold contact information objects
	public static List<Contact> contactList = new ArrayList<Contact>();

	public void addContact(String firstName, String lastName, String phoneNumber, String address) {

		// Assign curId to the ID of the contact being created
		String newId = Integer.toString(curIdNum);

		// Compile information into one object and add this to the contact list.
		Contact newContact = new Contact(newId, firstName, lastName, phoneNumber, address);
		contactList.add(newContact.getContactId(), newContact);

		// Increment the curIdNum for the next contact to be entered.
		curIdNum++;
	}

	public void delContact(String delId) {
		// Convert string to int
		int intDelId = Integer.valueOf(delId);

		// Loop through contactList to find correct id to remove
		for (int i = 0; i < ContactService.contactList.size(); i++) {
			if (ContactService.contactList.get(i).getContactId() == intDelId) {
				contactList.remove(i);
			}
		}
	}

	// Look through contacts by ID using an "enhanced for loop" and change the first
	// name of the object using the methods created in Contact.java
	public void editFirstName(String tarId, String firstName) {
		for (Contact contact : contactList) {
			if (contact.getContactId() == Integer.valueOf(tarId)) {
				contact.setFirstName(firstName);
			}
		}
	}

	public void editLastName(String tarId, String lastName) {
		for (Contact contact : contactList) {
			if (contact.getContactId() == Integer.valueOf(tarId)) {
				contact.setLastName(lastName);
			}
		}
	}

	public void editPhone(String tarId, String phone) {
		for (Contact contact : contactList) {
			if (contact.getContactId() == Integer.valueOf(tarId)) {
				contact.setPhoneNumber(phone);
			}
		}
	}

	public void editAddress(String tarId, String address) {
		for (Contact contact : contactList) {
			if (contact.getContactId() == Integer.valueOf(tarId)) {
				contact.setAddress(address);
			}
		}
	}
}
