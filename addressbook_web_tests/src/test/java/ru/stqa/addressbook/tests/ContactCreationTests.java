package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "contact firstname")) {
            for (var lastname : List.of("", "contact lastname")) {
                for (var address : List.of("", "contact address")) {
                    for (var mobile : List.of("", "contact mobile")) {
                        for (var email : List.of("", "contact email")) {
                            for (var photo : List.of("", randomFile("src/test/resources/images/avatar.png"))) {
                                result.add(new ContactData().withFirstName(firstname).withLastName(lastname).withAddress(address).withMobile(mobile).withEMail(email).withPhoto(photo));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(CommonFunctions.randomString(i * 10))
                    .withLastName(CommonFunctions.randomString(i * 10))
                    .withAddress(CommonFunctions.randomString(i * 10))
                    .withMobile(CommonFunctions.randomString(i * 10))
                    .withEMail(CommonFunctions.randomString(i * 10))
                    .withPhoto(randomFile("src/test/resources/images"))
            );
        }
        return result;
    }

    @Test
    void CreateOneContact() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().create(contact);
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getListContact();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getListContact();

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedListContact = new ArrayList<>(oldContacts);
        expectedListContact.add(contact.withId(newContacts.get(newContacts.size() - 1).id())
//                .withLastName("")
                        .withAddress("")
                        .withMobile("")
                        .withEMail("")
                        .withPhoto(randomFile(""))
        );
        expectedListContact.sort(compareById);
        Assertions.assertEquals(newContacts, expectedListContact);

    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "contact name'", "", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        var oldContacts = app.contacts().getListContact();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getListContact();
        Assertions.assertEquals(newContacts, oldContacts);
    }
}
