package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("", "firstname", "lastname", "address", "mobile", "email"));
        }
        var oldContacts = app.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("modified first name");//.withLastName("modified last name");
        app.contacts().modifyContact(oldContacts.get(index), testData);

        var newContacts = app.contacts().getListContact();
        var expectedListContact = new ArrayList<>(oldContacts);
        expectedListContact.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedListContact.sort(compareById);
        Assertions.assertEquals(newContacts, expectedListContact);
    }
}
