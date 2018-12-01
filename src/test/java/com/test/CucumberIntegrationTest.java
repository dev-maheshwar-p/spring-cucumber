package com.test;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.junit.JUnit4TestRunner;

@CucumberOptions(features = "src/test/resources")
@ContextConfiguration(classes = AppConfig.class)

    public class CucumberIntegrationTest{


    Logger logger = Logger.getLogger(CucumberIntegrationTest.class);

    private String k8Box;
    private TestNGCucumberRunner testNGCucumberRunner = new TestNGCucumberRunner(CucumberIntegrationTest.class);

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        System.out.println("********** In the before Class ******************");
    }


    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {

        if(isRunnableEnv(k8Box)) {
            beforeFeature();
            testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
            afterFeature();
        }else {
            return;
        }

    }


    private boolean isRunnableEnv(String k8Box) {
        return true;
    }


    private void afterFeature() {
        System.out.println("************ This line is printed after a feature *************");
    }


    private void beforeFeature() {
        System.out.println("************* This line is printed before a feature *********");
    }


    @DataProvider
    public Object[][] features() {

        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }



}