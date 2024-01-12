package Runnerfile;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features="src/test/java/features",
		glue="stepDefinition"
				
	)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
