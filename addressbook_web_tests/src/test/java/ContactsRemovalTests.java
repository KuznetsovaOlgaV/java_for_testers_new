import model.ContactsData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactsRemovalTests extends TestBase {

    @Test
    public void canRemoveContacts() {
        openContactsPage2();

//        if (!isElementPresent(By.name("Number of results"))) {
//            if (!isElementPresent(By.name("selected[]"))) {
//                driver.findElement(By.linkText("add new")).click();
//            }
//        }
        if (!isContactsPresent()) {
            createContacts(new ContactsData("firstname", "lastname", "address", "mobile", "email"));
        }
        removeContacts();
    }


}
