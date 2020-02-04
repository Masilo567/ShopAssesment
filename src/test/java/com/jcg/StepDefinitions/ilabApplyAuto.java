package com.jcg.StepDefinitions;
import com.jcg.PageObjectModel.DriverInitializer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;



public class ilabApplyAuto {

    WebDriver driver = null;

    @Given("^I open chrome browser$")
    public void iOpenFirefoxBrowser()  {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daniel\\Documents\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.get(DriverInitializer.getProperty("ilaburl"));
    }

    @When("^I maximize browser$")
    public void iNavigateToLoginHtmlPage()  {
       driver.manage().window().maximize();
    }

    @When("^I click on career link$")
    public void iProvideUsernameAsHiAndPasswordAsHi()  {
        driver.findElement(By.linkText("CAREERS")).click();
    }

    @When("^I choose South Africa")
    public void iClickOnLoginButton()  {
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[3]/a")).click();

    }

    @Then("^I should choose first job$")
    public void hiShouldBeName() throws Throwable {
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/span[1]/a")).click();
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
        Assert.assertEquals(DriverInitializer.getProperty("expected"), driver.findElement(By.className("wpjb-errors")).getText());
      //  driver.close();
    }


}







