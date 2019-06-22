import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.findElement(By.className("ZFr60d CeoRYc")).click();
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
