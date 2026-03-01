package tests;

import model.ContactsData;
import org.junit.jupiter.api.Test;

public class ContactsCreationTests extends TestBase {

    @Test
    public void canCreateContacts() {
        app.contacts().createContacts(new ContactsData("firstname", "lastname", "address", "mobile", "email"));
    }

    @Test
    public void canCreateContactsWithEmptyFirstName() {
        app.contacts().createContacts(new ContactsData());
    }

    @Test
    public void canCreateContactsWithFirstNameOnly() {
        app.contacts().createContacts(new ContactsData().withFirstName("some firstname"));
    }
}
