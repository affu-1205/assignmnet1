package com.company.com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/PostTest.feature"
		,glue={"com.company.com.stepDef"}
		)

public class TestRunner {

}
