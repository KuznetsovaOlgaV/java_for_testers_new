package manager;

import model.ContactsData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;


    public void init() {
//        public void init(String browser) {
        if (driver == null) {
//            if ("firefox".equals(browser)) {
//                driver = new FirefoxDriver();
//            } else if ("chrome".equals(browser)) {
//                driver = new ChromeDriver();
//            } else {
//                throw new IllegalArgumentException(String.format("Unknown browser %s",browser));
//            }
            driver = new FirefoxDriver();
//            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
//            driver.get("http://localhost/addressbook/");
//            driver.manage().window().setSize(new Dimension(1811, 1077));
//            driver.findElement(By.name("user")).sendKeys("admin");
//            driver.findElement(By.name("pass")).sendKeys("secret");
//            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
//        }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(2199, 1180));
            session().login("admin", "secret");
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createContacts(ContactsData contacts) {
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contacts.firstname());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contacts.lastname());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contacts.address());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(contacts.mobile());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contacts.email());
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void openContactsPage() {
        if (!isElementPresent(By.name("Number of results"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    public void openContactsPage2() {
        if (!isElementPresent(By.name("Number of results")) && !isElementPresent(By.name("selected[]"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    public boolean isContactsPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void removeContacts() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("home page")).click();
    }
}
