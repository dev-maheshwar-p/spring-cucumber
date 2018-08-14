//package com.test;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@CucumberOptions(features = "src/test/resources")
////@ContextConfiguration(classes = AppConfig.class)
////public class CucumberIntegrationTest extends AbstractTestNGCucumberTests {
////    public class CucumberIntegrationTest extends AbstractTestNGSpringContextTests {
//    public class CucumberIntegrationTest_Backup {
//
//
//
//
////    TestContextManager testContextManager;
////
////
////
////    Logger logger = Logger.getLogger(CucumberIntegrationTest.class);
////
////    private String k8Box;
////    private TestNGCucumberRunner testNGCucumberRunner;
////
////    @BeforeClass(alwaysRun = true)
////    public void setUpClass() throws Exception {
////        System.out.println("********** In the before Class ******************");
////    }
////
////
//////    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
////    @Test
////    public void feature(CucumberFeatureWrapper cucumberFeature) {
////
////        if(isRunnableEnv(k8Box)) {
////            beforeFeature();
////            testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
////            afterFeature();
////        }else {
////            return;
////        }
////
////    }
////
////
////    private boolean isRunnableEnv(String k8Box) {
////        return true;
////    }
////
////
////    private void afterFeature() {
////        System.out.println("************ This line is printed after a feature *************");
////    }
////
////
////    private void beforeFeature() {
////        System.out.println("************* This line is printed before a feature *********");
////    }
////
////
////    @DataProvider
////    public Object[][] features() {
////
////        return testNGCucumberRunner.provideFeatures();
////    }
////
////    @AfterClass(alwaysRun = true)
////    public void tearDownClass() throws Exception {
////        testNGCucumberRunner.finish();
////    }
//
//}