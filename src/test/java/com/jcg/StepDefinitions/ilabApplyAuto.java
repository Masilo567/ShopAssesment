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

import java.util.concurrent.TimeUnit;


public class ilabApplyAuto{

    WebDriver driver = null;

    @Given("^I open chrome browser$")
    public void iOpenFirefoxBrowser()  {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\TShikwambana\\Documents\\test\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.get(DriverInitializer.getProperty("ilaburl"));
    }

    @When("^I maximize browser$")
    public void iNavigateToLoginHtmlPage()  {
       driver.manage().window().maximize();
    }

    @When("^I click on career link$")
    public void iProvideUsernameAsHiAndPasswordAsHi()  {
        //driver.findElement(By.xpath("//*[@id=\"popmake-3738\"]/button")).click();
        //driver.findElement(By.xpath("//*[@id='menu-primary-right-menu-1']/li[5]/a")).click();

        WebElement element=driver.findElement(By.xpath("//*[@id='menu-primary-right-menu-1']/li[5]/a"));
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", element);

       // driver.findElement(By.linkText("CAREERS")).click();
    }

    @When("^I choose South Africa")
    public void iClickOnLoginButton()  {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a")).click();

    }

    @Then("^I should choose first job$")
    public void hiShouldBeName() throws Throwable {
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div[1]/a")).click();
        }


    @When("^I send keys$")
    public void iProvideUsernameAsAndPasswordAs(){
        driver.findElement(By.xpath("//*[@id=\"wpjb-scroll\"]/div[1]/a")).click();
        driver.findElement(By.id("applicant_name")).sendKeys(DriverInitializer.getProperty("name"));
        driver.findElement(By.id("email")).sendKeys(DriverInitializer.getProperty("email"));

    }

    @Then("^I should get message$")
    public void nameShouldBe() {
        int intEnd = 10;
        int intStart = 1;
        Random aRandom = new Random();
        long range = intEnd - (long) intStart + 1;
        int[] numbers = new int[10];
        for (int i = 1; i <= 10; i++) numbers[i - 1] = (int) (range * aRandom.nextDouble());
        driver.findElement(By.id("phone")).sendKeys(0 + "" + numbers[1] + "" + numbers[2] + " " + numbers[3] + numbers[4] + numbers[5] + " " + numbers[6] + numbers[7] + numbers[8] + numbers[9]);
        driver.findElement(By.id("wpjb_submit")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertEquals(DriverInitializer.getProperty("expected"), driver.findElement(By.xpath("//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul/li")).getText());
      //  driver.close();
    }


}







