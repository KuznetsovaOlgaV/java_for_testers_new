package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactsCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contact().createContact(new ContactData("firstname", "lastname", "address", "mobile", "email"));
    }

    @Test
    public void canCreateContactWithEmptyFirstName() {
        app.contact().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {
        app.contact().createContact(new ContactData().withFirstName("some firstname"));
    }
}
