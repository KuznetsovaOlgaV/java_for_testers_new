package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (!app.contact().isContactsPresent()) {
            app.contact().createContact(new ContactData("firstname", "lastname", "address", "mobile", "email"));
        }
        app.contact().modifyContact(new ContactData().withFirstName("modified firstname"));
    }
}
