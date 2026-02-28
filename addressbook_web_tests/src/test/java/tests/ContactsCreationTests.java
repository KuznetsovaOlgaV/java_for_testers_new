package tests;

import model.ContactsData;
import org.junit.jupiter.api.Test;

public class ContactsCreationTests extends TestBase {

    @Test
    public void canCreateContacts() {
        app.openContactsPage();
        app.createContacts(new ContactsData("firstname", "lastname", "address", "mobile", "email"));
    }

    @Test
    public void canCreateContactsWithEmptyFirstName() {
        app.openContactsPage();
        app.createContacts(new ContactsData());
    }

    @Test
    public void canCreateContactsWithFirstNameOnly() {
        app.openContactsPage();
        var emptyContacts = new ContactsData();
        var contactsWithFirstName = emptyContacts.withFirstName("some firstname");
        app.createContacts(contactsWithFirstName);
    }
}
