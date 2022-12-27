package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String Status ="OK";

        //Init WebDriver
        System.setProperty("webdriver.chrome.driver",
                "D:\\Bootcamp\\Bootcamp Project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Set URL
        driver.get("https://www.demoblaze.com/index.html");

        //Get Page Title
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);

        //SR-12111 - When opening home page (https://www.demoblaze.com/), there must be three categories displayed in the left
        System.out.println("--------------------------------------------------------------");
        System.out.println("SR-12111");

        //Check if Element Categories Exists
        String cat = driver.findElement(By.id("cat")).getText();
        System.out.println(cat);
        TimeUnit.SECONDS.sleep(3);

        //Verify if Exists
        List<WebElement> verify = driver.findElements(By.id("itemc"));
        for (WebElement present : verify){

          if(present.getText().contains("Phones")){
              System.out.println("Phones Exist");
          }
          if(present.getText().contains("Laptops")){
              System.out.println("Laptops Exist");
          }
          if(present.getText().contains("Monitors")){
              System.out.println("Monitors Exist");
          }
        }

        //SR-12120 - Clicking any of the products in the catalog displayed in the homepage
        System.out.println("--------------------------------------------------------------");
        System.out.println("SR-12120");
        System.out.println("Click on Samsung galaxy s6");
        WebElement S6 = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
        S6.click();
        TimeUnit.SECONDS.sleep(3);

        //Product Name
        String PName = "Samsung galaxy s6";
        WebElement DName = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        if(PName.equals(DName.getText()))
        {
            System.out.println("Product Name Found");
        }

        //Product Desc
        String PDesc = "Product description";
        WebElement DDes = driver.findElement(By.xpath("//*[@id=\"more-information\"]/strong"));
        if(PDesc.equals(DDes.getText())) {
            System.out.println("Product description Found");
        }

        //Price
        String PPrice = "$360 *includes tax";
        WebElement DPrice = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3"));
        if(PPrice.equals(DPrice.getText())) {
        System.out.println("Product Price Found");
        }

        //Image
        WebElement Image = driver.findElement(By.xpath("//*[@id=\"imgp\"]/div/img"));
        if(Image.isDisplayed()){
            System.out.println("Product Image Found");
        }

        //Cart Button
        String PButton = "Add to cart";
        WebElement DButton = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
        if(PButton.equals(DButton.getText())){
            System.out.println("Product Button Found");
        }

        //SR-12121 - Clicking add to cart button will display browser alert
        System.out.println("--------------------------------------------------------------");
        System.out.println("SR-12121");
        DButton.click();

        //Wait to Alert
        TimeUnit.SECONDS.sleep(2);
        String Alert = driver.switchTo().alert().getText();
        System.out.println("Alert Text: " + Alert);
        driver.switchTo().alert().accept();
        System.out.println("Close Alert");


        //SR-12130 - Clicking the cart link will display below information
        System.out.println("--------------------------------------------------------------");
        System.out.println("SR-12130");
        driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();
        System.out.println("Click on Cart");
        TimeUnit.SECONDS.sleep(2);

        //Get Cart Elements
        //Product Picture
        WebElement PPicture = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[1]/img"));
        if(PPicture.isDisplayed()) {
            System.out.println("Cart: Product Image");
        }

        //Product Title
        WebElement CartTitle = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
        System.out.println("Cart: "+ CartTitle.getText());

        //Product Price
        WebElement CartPrice = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]"));
        System.out.println("Cart: "+ CartPrice.getText());

        //Product Delete
        WebElement CartDelete = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a"));
        System.out.println("Cart: "+ CartDelete.getText());

        //Total Price
        WebElement CartTotal = driver.findElement(By.xpath("//*[@id=\"totalp\"]"));
        System.out.println("Total: "+ CartTotal.getText());

        //Place Order
        WebElement CartOrder = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
        CartOrder.click();

        //Verify with Place Order Modal
        TimeUnit.SECONDS.sleep(2);
        WebElement ModalVisible = driver.findElement(By.xpath("//*[@id=\"orderModal\"]"));
        if(ModalVisible.isDisplayed()) {
            System.out.println("Order Placed");
            driver.quit();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Finished");
        }
        else {
            driver.quit();
            System.out.println("----------------------------------------------------------------");
            System.out.println("Order not finished");
        }
    }
}