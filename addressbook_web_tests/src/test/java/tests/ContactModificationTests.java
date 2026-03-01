package tests;

import model.ContactsData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContacts(){
        if (!app.contacts().isContactsPresent()) {
            app.contacts().createContacts(new ContactsData("firstname", "lastname", "address", "mobile", "email"));
        }
        app.contacts().modifyContacts(new ContactsData().withFirstName("modified firstname"));
    }
}
