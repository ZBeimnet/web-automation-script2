import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GmailScript {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();

        String baseUrl = "https://www.gmail.com";
        String myUsername = "zbeimnet@gmail.com";
        String myPassword = "157QwqEGH99gLbZ";

        driver.get(baseUrl);

        //signing into my email
        driver.findElement(By.id("identifierId")).sendKeys(myUsername);
        driver.findElement(By.id("identifierNext")).click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        WebElement elementpwd = driver.findElement(By.xpath("//input[@type='password']"));
        elementpwd.sendKeys(myPassword);
        driver.findElement(By.id("passwordNext")).click();
    }

    private static void writeToFile(String content) {
        String fileNameToStoreEmails = ".\\src\\Emails.txt";

        try {
            Writer writer = new FileWriter(fileNameToStoreEmails);
            writer.write(content);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
