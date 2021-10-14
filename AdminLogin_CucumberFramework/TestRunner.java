package TestRunners;


import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( glue = {"StepDefs"}, 
				  plugin = {"html:target/cucumber-reports/USAdminLogin/cucumber-pretty","json:target/json-cucumber-reports/USAdminLogin/cukejson.json",
		"testng:target/xmlreports/USAdminLogin.xml" }, 
				  features = {"src/test/resources/features/USAdminLogin.feature"}
				 
			    )

public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}
