package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("firstname", "lastname", "address", "mobile", "email"));
        }
        int contactCount = app.contacts().getCountContact();
        app.contacts().removeContact();
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

    @Test
    void canRemoveAllContactsAtOnce(){
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("firstname", "lastname", "address", "mobile", "email"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0,app.contacts().getCountContact());
    }
}
