package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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

    public void createContact(ContactData contacts) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contacts);
        submitContactCreation();
        returnToContactsPage();
    }

    public void removeContact(ContactData contact) {
        openContactsPage2();
        selectContact(contact);
        removeSelectedContacts();
        returnToContactsPage();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactsPage2();
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
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

    private void initContactModification(ContactData contact) {
//        click(By.xpath("//img[@alt='Edit']"));
        click(By.xpath(String.format("//input[@value='%s']/ancestor::tr//img[@alt='Edit']", contact.id()))); //находит по нужному индексу, который ранее выбрали
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public int getCountContact() {
        openContactsPage2();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openContactsPage2();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<ContactData> getListContact() {
        openContactsPage2();
        var contacts = new ArrayList<ContactData>();
        var rows = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var row : rows) {
//            var firstname = row.getText();
//            var lastname = row.getText();
            var firstname = row.findElement(By.cssSelector("td:nth-child(3)"));
            var lastname = row.findElement(By.cssSelector("td:nth-child(2)"));
            var checkbox = row.findElement(By.name("selected[]"));
            var index = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(index)
                    .withFirstName(firstname.getText())
                    .withLastName(lastname.getText())
            );
        }
        return contacts;
    }

}
