package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinations"},monochrome=true,
plugin={"pretty","html:target/HTMLReports/reports.html"})

public class LoginRunner extends AbstractTestNGCucumberTests{

}
