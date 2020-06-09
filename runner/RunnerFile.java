package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= "src/main/java/features/trivago.feature",
							glue="steps" ,monochrome= true)

public class RunnerFile extends AbstractTestNGCucumberTests {

	 

	}


