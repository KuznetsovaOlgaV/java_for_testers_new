package tests;

import model.ContactsData;
import org.junit.jupiter.api.Test;

public class ContactsRemovalTests extends TestBase {

    @Test
    public void canRemoveContacts() {
        app.openContactsPage2();
        if (!app.isContactsPresent()) {
            app.createContacts(new ContactsData("firstname", "lastname", "address", "mobile", "email"));
        }
        app.removeContacts();
    }


}
