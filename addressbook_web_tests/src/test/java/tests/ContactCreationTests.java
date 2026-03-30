package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "contact firstname")) {
            for (var lastname : List.of("", "contact lastname")) {
                for (var address : List.of("", "contact address")) {
                    for (var mobile : List.of("", "contact mobile")) {
                        for (var email : List.of("", "contact email")) {
                            result.add(new ContactData().withFirstName(firstname).withLastName(lastname).withAddress(address).withMobile(mobile).withEMail(email));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(randomString(i * 10))
                    .withLastName(randomString(i * 10))
                    .withAddress(randomString(i * 10))
                    .withMobile(randomString(i * 10))
                    .withEMail(randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCountContact();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "contact name'", "", "", "", "")));
             return result;
    }
    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getCountContact();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
