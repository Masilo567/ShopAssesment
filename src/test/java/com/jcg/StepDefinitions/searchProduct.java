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


public class ilabApplyAuto{

    WebDriver driver = null;

    @Given("^I open chrome browser$")
    public void iOpenFirefoxBrowser()  {
         System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
         driver = new ChromeDriver();
        driver.get(DriverInitializer.getProperty("ilaburl"));
    }

    @When("^I maximize browser$")
    public void iNavigateToLoginHtmlPage()  {
       driver.manage().window().maximize();
    }

    @When("^I click search product$")
    public void iProvideUsernameAsHiAndPasswordAsHi()  {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

       driver.findElement(By.id("js-site-search-input")).sendKeys("Cenplast Plastic Juice Bottle 350ml"+Keys.ENTER);
       // driver.findElement(By.id("js-site-search-input")).sendKeys("trevor");
    }

   @When("^I click on product$")
    public void iClickOnLoginButton()  {
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//img[contains(@title,'Cenplast Plastic Juice Bottle 350ml')]")).click();


  }

  @Then("^I verify product$")
 public void hiShouldBeName()  {
    //  driver.findElement(By.xpath("/html/body/googletagmanager:iframe/main/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/span")).click();
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,350)", "");

    //  Assert.assertEquals("R8", driver.findElement(By.xpath("/html/body/googletagmanager:iframe/main/div[4]/div[2]/div/div[2]/div[1]/div[2]/h1")).getText());

      }



}







