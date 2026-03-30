package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("", "firstname", "lastname", "address", "mobile", "email"));
        }

        var oldContacts = app.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getListContact();
        var expectedListContact = new ArrayList<>(oldContacts);
        expectedListContact.remove(index);
        Assertions.assertEquals(newContacts, expectedListContact);


    }


    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("", "firstname", "lastname", "address", "mobile", "email"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCountContact());
    }
}
