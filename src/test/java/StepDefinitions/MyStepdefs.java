package StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    @Given("a user is on the home page")
    public void aUserIsOnTheHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        ExtentSparkReporter spark = new ExtentSparkReporter("/Users/bongslushaba/Downloads/BDD/Reports/reports.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        test = extent.createTest("Login");
    }

    @When("a user navigates to the Login page using {string}")
    public void aUserNavigatesToTheLoginPageUsing(String sURL) {
        driver.get(sURL);
        }

    @And("a user enter {string} and {string}")
    public void aUserEnterUsernameAndPassword(String sUsername, String sPassword) {
        driver.findElement(By.id("username")).sendKeys(sUsername);
        driver.findElement(By.id("password")).sendKeys(sPassword);
    }

    @And("a user clicks the login button")
    public void aUserClicksTheLoginButton() {
        driver.findElement(By.id("login")).click();
        test.pass("login button clicked");
    }

    @Then("a user is loggen in successfully")
    public void aUserIsLoggenInSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        if (!driver.findElement(By.id("location")).isDisplayed()){
            test.fail("Login unsuccessful");
            Assert.fail();
        }

        else{
            test.pass("Login is successful");
        }
        driver.quit();
        extent.flush();

    }

}
