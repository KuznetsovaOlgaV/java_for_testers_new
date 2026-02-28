package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;//
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;//

public class TestBase {

    protected static ApplicationManager app;
    protected static WebDriver driver;

    protected static void removeContacts() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("home page")).click();
    }

//    @BeforeEach
//    public void setUp() {
//        if (app == null) {
//            app = new ApplicationManager();
//            app.init(System.getProperty("browser", "firefox"));
//        }
//
//    }

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1811, 1077));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void createContacts(String firstname, String lastname, String address, String mobile, String email) {
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("firstname");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("lastname");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("address");
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys("mobile");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("email");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    protected void openContactsPage() {
        if (!isElementPresent(By.name("Number of results"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    protected void openContactsPage2() {
        if (!isElementPresent(By.name("Number of results")) && !isElementPresent(By.name("selected[]"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    protected boolean isContactsPresent() {
        return isElementPresent(By.name("selected[]"));
    }
}
