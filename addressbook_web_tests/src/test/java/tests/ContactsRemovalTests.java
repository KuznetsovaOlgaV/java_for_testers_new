package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactsRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contact().isContactsPresent()) {
            app.contact().createContact(new ContactData("firstname", "lastname", "address", "mobile", "email"));
        }
        app.contact().removeContact();

    }
}
