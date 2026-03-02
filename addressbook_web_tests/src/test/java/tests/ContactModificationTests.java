package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("firstname", "lastname", "address", "mobile", "email"));
        }
        app.contacts().modifyContact(new ContactData().withFirstName("modified firstname"));
    }
}
