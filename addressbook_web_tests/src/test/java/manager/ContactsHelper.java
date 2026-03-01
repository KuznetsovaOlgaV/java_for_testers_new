package manager;

import model.ContactsData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("Number of results"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }

    public void openContactsPage2() {
        if (!manager.isElementPresent(By.name("Number of results")) && !manager.isElementPresent(By.name("selected[]"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }

    public boolean isContactsPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContacts(ContactsData contacts) {
        openContactsPage();
        manager.driver.findElement(By.name("theform")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contacts.firstname());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contacts.lastname());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contacts.address());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contacts.mobile());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contacts.email());
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContacts() {
        openContactsPage2();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }
}
