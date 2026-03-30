package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Comparator;
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
        //
        var contactToRemove = oldContacts.get(index);
        //
        String idToRemove = contactToRemove.id();
        ///
        app.contacts().removeContact(contactToRemove);
//        app.contacts().removeContactById(idToRemove);

      //   app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
//
        expectedList.removeIf(contact -> contact.id().equals(idToRemove));
        //expectedList.remove(contactToRemove);
      //  expectedList.remove(index);
        ///
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
//        Comparator<ContactData> compareById = (o1, o2) ->
//                o1.id().compareTo(o2.id());
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

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
