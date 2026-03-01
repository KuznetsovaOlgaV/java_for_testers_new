package manager;

import model.ContactsData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("Number of results"))) {
            click(By.linkText("add new"));
        }
    }

    public void openContactsPage2() {
        if (!manager.isElementPresent(By.name("Number of results")) && !manager.isElementPresent(By.name("selected[]"))) {
            click(By.linkText("add new"));
        }
    }

    public boolean isContactsPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContacts(ContactsData contacts) {
        openContactsPage();
        initContactsCreation();
        fillContactsForm(contacts);
        submitContactsCreation();
        returnToContactsPage();
    }

    public void removeContacts() {
        openContactsPage2();
        selectContacts();
        removeSelectedContacts();
        returnToContactsPage();
    }

    public void modifyContacts(ContactsData modifiedContacts) {
        openContactsPage2();
        selectContacts();
        initContactsModification();
        fillContactsForm(modifiedContacts);
        submitContactsModification();
        returnToContactsPage();
    }

    private void submitContactsCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void initContactsCreation() {
        click(By.name("theform"));
    }

    private void removeSelectedContacts() {
        click(By.name("delete"));
    }

    private void returnToContactsPage() {
        click(By.linkText("home page"));
    }

    private void submitContactsModification() {
        click(By.name("update"));
    }

    private void fillContactsForm(ContactsData contacts) {
        type(By.name("firstname"), contacts.firstname());
        type(By.name("lastname"), contacts.lastname());
        type(By.name("address"), contacts.address());
        type(By.name("mobile"), contacts.mobile());
        type(By.name("email"), contacts.email());
    }

    private void initContactsModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    private void selectContacts() {
        click(By.name("selected[]"));
    }

}
