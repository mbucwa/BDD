package TestRunners;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"/Users/bongslushaba/Downloads/BDD/src/test/java/Features"},
        glue = {"StepDefinitions"},
        tags = "@login"

)


public class TestRunner {



}


