package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//chay o dung dan naof , va file thuc hien ow package naof, muon tao bao cao dang html 
//khi theem tags ="@Regression" thif nos chir chayj file cos tags ="@Regression" 
//qua pom them file voo ,co the chayj bang terminal 
@CucumberOptions(features = "src/test/java/cucumber",glue = "h.stepDefinitions",monochrome = true,tags ="@Regression",plugin = {"html:target/cucumber.html"})

public class TestngTestRunner extends AbstractTestNGCucumberTests{

}
