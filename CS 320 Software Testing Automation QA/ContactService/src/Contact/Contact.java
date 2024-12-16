package Contact;

public class Contact {

	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	// Helper functions to validate that correct information formatting is followed.
	private final boolean validId(String contactId) {
		if (contactId == null || contactId.length() > 10) {
			return false;
		}
		return true;
	}

	private final boolean validFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			return false;
		}
		return true;
	}

	private final boolean validLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			return false;
		}
		return true;
	}

	private final boolean validPhone(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() != 10) {
			return false;
		}
		return true;
	}

	private final boolean validAddress(String address) {
		if (address == null || address.length() > 30) {
			return false;
		}
		return true;
	}

	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {

		// Data entered is checked before it is entered to make sure it meets the
		// requirements, if not an error is thrown.
		if (!this.validId(contactId)) {
			throw new IllegalArgumentException("Invalid contact ID");
		}

		if (!this.validFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}

		if (!this.validLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}

		if (!this.validPhone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}

		if (!this.validAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}

		// After validation information passed into the function is entered as new data
		// on an object
		this.contactId		= contactId;
		this.firstName		= firstName;
		this.lastName		= lastName;
		this.phoneNumber	= phoneNumber;
		this.address		= address;
	}

	// Function to retrieve contact ID.
	public int getContactId() {
		return Integer.valueOf(this.contactId);
	}

	// Normally a "setter" function would go here for contactId, but because this
	// will not be updated it was removed.

	public String getFirstName() {
		return firstName;
	}

	// Functions to set values for other parts of contact are validated before they
	// are changed to make sure it matches the criteria given.
	// The same format is carried out for the remaining values.
	public void setFirstName(String firstName) {
		if (!this.validFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (!this.validLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (!this.validPhone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (!this.validAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}

}
