import model.ContactsData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactsCreationTests extends TestBase {

    @Test
    public void canCreateContacts() {
        openContactsPage();
        createContacts(new ContactsData("firstname", "lastname", "address", "mobile", "email"));
    }

    @Test
    public void canCreateContactsWithEmptyFirstName() {
        openContactsPage();
        createContacts(new ContactsData());
    }

    @Test
    public void canCreateContactsWithFirstNameOnly() {
        openContactsPage();
        var emptyContacts = new ContactsData();
        var contactsWithFirstName = emptyContacts.withFirstName("some firstname");
        createContacts(contactsWithFirstName);
    }
}
