package tests;

import model.ContactsData;
import org.junit.jupiter.api.Test;

public class ContactsRemovalTests extends TestBase {

    @Test
    public void canRemoveContacts() {
        if (!app.contacts().isContactsPresent()) {
            app.contacts().createContacts(new ContactsData("firstname", "lastname", "address", "mobile", "email"));
        }
        app.contacts().removeContacts();
    }


}
