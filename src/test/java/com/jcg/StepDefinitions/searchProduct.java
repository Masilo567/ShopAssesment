package com.jcg.StepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;


public class searchProduct {

    WebDriver driver = null;

    @Given("^I open chrome browser$")
    public void iOpenBrowser()  {
         System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
         driver = new ChromeDriver();
        driver.get(DriverInitializer.getProperty("shopurl"));
    }

    @When("^I maximize browser$")
    public void iNavigateToShopritePage()  {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       driver.manage().window().maximize();
    }

    @When("^I click search product$")
    public void iSearchProduct()  {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       driver.findElement(By.id("js-site-search-input")).sendKeys(DriverInitializer.getProperty("prodToSearch")+Keys.ENTER);

    }

   @When("^I click on product$")
    public void iClickOnProductButton()  {
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//img[contains(@title,'Cenplast Plastic Juice Bottle 350ml')]")).click();


  }

  @Then("^I verify product$")
 public void VerifyProduct()  {

      WebElement admi = driver.findElement(By.xpath("//span[contains(@class,'now')]  [contains(text(),' R8')]"));
      admi.getText();
      System.out.print(driver.findElement(By.xpath("//span[contains(text(),'R8')]")).getText().toString());
      Assert.assertEquals(DriverInitializer.getProperty("price"), driver.findElement(By.xpath("//span[contains(text(),'R8')]")).getText().toString());
      //System.out.print(driver.findElement(By.xpath("//sup[contains(text(),'.99')]")).getText().toString());
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,350)", "");



      }

    @Then("^I verify product information$")
    public void productInfo()  {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"accessibletabsnavigation0-1\"]/a")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertEquals("Cenplast", driver.findElement(By.xpath("//td[contains(text(),'Cenplast')]")).getText());


    }


}







