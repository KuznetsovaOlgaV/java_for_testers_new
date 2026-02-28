import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactsCreationTests extends TestBase {

    @Test
    public void canCreateContacts() {
        openContactsPage();
        createContacts("firstname", "lastname", "address", "mobile", "email");
    }

    @Test
    public void canCreateContactsWithEmptyFirstName() {
        openContactsPage();
        createContacts("", "", "", "", "");
    }
}
