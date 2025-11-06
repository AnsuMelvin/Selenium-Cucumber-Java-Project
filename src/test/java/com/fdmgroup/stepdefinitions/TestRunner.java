package com.fdmgroup.stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",         
    glue = "com.fdmgroup.stepdefinitions",            
    plugin = {
        "pretty",                                     
        "json:Report/cucumber.json",
		"json:Report/cucumber.junit",
		"html:Report/cucumber.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true  ,
    publish = true 
)
public class TestRunner {
  
}

