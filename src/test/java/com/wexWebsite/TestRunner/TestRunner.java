package com.wexWebsite.TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:WexWebsiteFeatures\\WexSearch.feature", glue="com.stepDefinitions.steps",  plugin= {"html:target/test-output"})
public class TestRunner {
	
	
	

}
