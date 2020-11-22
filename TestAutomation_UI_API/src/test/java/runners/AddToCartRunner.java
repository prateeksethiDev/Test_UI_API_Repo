package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/Features/addToCart.feature",glue= {"StepDefinations","test.hooks"},monochrome=true,
plugin={"pretty","html:target/HTMLReports/reports.html"})

public class AddToCartRunner  extends AbstractTestNGCucumberTests{

}
