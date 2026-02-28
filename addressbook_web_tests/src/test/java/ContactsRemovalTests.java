import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;

public class ContactsRemovalTests extends TestBase {

    @Test
    public void canRemoveContacts() {

        if (!isElementPresent(By.name("Number of results")) && !isElementPresent(By.name("selected[]"))) {
            driver.findElement(By.linkText("add new")).click();
        }

//        if (!isElementPresent(By.name("Number of results"))) {
//            if (!isElementPresent(By.name("selected[]"))) {
//                driver.findElement(By.linkText("add new")).click();
//            }
//        }
        if (!isElementPresent(By.name("selected[]"))) {
            driver.findElement(By.name("theform")).click();
            driver.findElement(By.name("firstname")).click();
            driver.findElement(By.name("firstname")).sendKeys("first name");
            driver.findElement(By.name("lastname")).click();
            driver.findElement(By.name("lastname")).sendKeys("last name");
            driver.findElement(By.name("address")).click();
            driver.findElement(By.name("address")).sendKeys("address");
            driver.findElement(By.name("mobile")).click();
            driver.findElement(By.name("mobile")).sendKeys("mobile");
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).sendKeys("e-mail");
            driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
            driver.findElement(By.linkText("home page")).click();
        }

        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("home page")).click();
    }


}
