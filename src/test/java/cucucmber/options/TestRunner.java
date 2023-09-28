package cucucmber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",plugin="json:target/jsonReports/cucucmber-report.json",glue= {"stepDefinations"})

public class TestRunner {
	//,tags= "@DeletePlace"

}
