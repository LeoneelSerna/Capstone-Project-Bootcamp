import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class ElementTest {
    WebDriver _driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver",
                "D:\\Bootcamp\\Bootcamp Project\\chromedriver.exe");
        this._driver = new ChromeDriver();
        this._driver.get("https://www.demoblaze.com/index.html");
    }
    @Test(description = "Test Correct URL")
    public void TestCorrectURL(){
        String Test1Name = "Test Correct URL";
        String expectedURL = "https://www.demoblaze.com/index.html";
        String ActualURL = _driver.getCurrentUrl();
        CustomAssertions.isValidURL(expectedURL, ActualURL);
        System.out.println(Test1Name + " - Pass");
    }

    @Test(description = "Test Correct Page Title")
    public void TestPageTitle(){
        String Test2Name = "Test Correct Page Title";
        String PageTitle = "STORE";
        String CurrentTitle = _driver.getTitle();
        CustomAssertions.isValidTitle(PageTitle, CurrentTitle);
        System.out.println(Test2Name + " - Pass");

    }

    @Test(description = "Verify Navigation Bar")
    public void VerifyNavigationBar(){
        String Test3Name = "Verify Navigation Bar";
        String IDNavigationBar = "narvbarx";
        String CurrentNavID = _driver.findElement(By.id("narvbarx")).getAttribute("id");
        CustomAssertions.isValidIDNavBar(IDNavigationBar, CurrentNavID);
        System.out.println(Test3Name + " - Pass");
    }

    @Test(description = "Verify Footer")
    public void VerifyFooter(){
        String Test4Name = "Verify Footer";
        String FooterText = "Copyright © Product Store 2017";
        String CurrentFooter = _driver.findElement(By.xpath("/html/body/footer/p")).getText();
        CustomAssertions.isValidFooter(FooterText, CurrentFooter);
        System.out.println(Test4Name + " - Pass");
    }

    @AfterMethod
    public void Close(){
        _driver.quit();
    }
}
