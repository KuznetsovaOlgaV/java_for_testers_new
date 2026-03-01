package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
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

    public void createContact(ContactData contacts) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contacts);
        submitContactCreation();
        returnToContactsPage();
    }

    public void removeContact() {
        openContactsPage2();
        selectContact();
        removeSelectedContacts();
        returnToContactsPage();
    }

    public void modifyContact(ContactData modifiedContacts) {
        openContactsPage2();
        selectContact();
        initContactModification();
        fillContactForm(modifiedContacts);
        submitContactModification();
        returnToContactsPage();
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void initContactCreation() {
        click(By.name("theform"));
    }

    private void removeSelectedContacts() {
        click(By.name("delete"));
    }

    private void returnToContactsPage() {
        click(By.linkText("home page"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.email());
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

}
