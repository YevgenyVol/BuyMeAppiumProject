import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)

public class Test {
    @Rule
    //get method name
    public TestName name = new TestName();
    //driver
    static AndroidDriver<MobileElement> driver;
    //extent report
    private static ExtentReports extent;
    private static ExtentTest myTests;
    //screenshot path
    static String imagePath = "E:\\intellij\\BuyMeAppiumProject\\screenshot";
    static String appConfigXML = "E:\\intellij\\BuyMeAppiumProject\\BuymeAppData.xml";


    private Login login;
    private HomeScreeen gift;
    private SenderReceiverInfo giftInfo;
    private SendTo finalizeSend;



    @BeforeClass
    //setup
    public static void setUp() throws Exception {

        extent = new ExtentReports(General.readFromFile("reportPath",appConfigXML));                          //report html path
        extent.loadConfig(new File(General.readFromFile("reportConfig",appConfigXML)));                       //xml report config path

        //android capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("platformVersion", "9");


        capabilities.setCapability("appPackage", General.readFromFile("appPackage",appConfigXML));
        capabilities.setCapability("appActivity",General.readFromFile("appActivity",appConfigXML));

        URL url = new URL("http://0.0.0.0:4723/wd/hub/");       //appium
        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }//end setup


    @After
    //finish test
    public void closeTest(){
        myTests.log(LogStatus.INFO, "", "Test Finished");
        extent.endTest(myTests);
    }//end of closeTest


    @AfterClass
    //close app, save report
    public static void closeDriver(){
        //TODO app exit from account

        extent.flush();
//        driver.closeApp();
//        driver.quit();
    }



//    @org.junit.Test
//    //Login
//    public void test01_Login() throws Exception {
////        Thread.sleep(1000);
//        //start test
//        myTests = extent.startTest("Login");
//        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");
//
//        login = new Login(driver);
//        login.loginToWeb();




//        List<MobileElement> listOfClickableElements = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
//        for (MobileElement element:
//                listOfClickableElements){ System.out.println(element.getLocation());
//            System.out.println(element.getId());
//            System.out.println(element.getTagName());
//        }




//        //Assert results
//        double actualResult = Double.parseDouble(actualResultString);
//        double expectedResult = firstNumber + secondNumber;
//        myTests.log(LogStatus.INFO, "numbers are " + firstNumber + " and " + secondNumber);
//        try {
//            Assert.assertEquals(expectedResult, actualResult, 0.001);
//            myTests.log(LogStatus.PASS, name.getMethodName() + ". calculation completed, result is correct");
//            myTests.log(LogStatus.PASS, "", myTests.addScreenCapture(GeneralFunc.takeScreenShot(imagePath + "\\" + System.currentTimeMillis(), driver)));
//        }
//        catch (AssertionError a){
//            myTests.log(LogStatus.FAIL, name.getMethodName() + ". calculation failed, wrong result. Expected was: " + expectedResult + " actual is: " + actualResult);
//            myTests.log(LogStatus.FAIL, "", myTests.addScreenCapture(GeneralFunc.takeScreenShot(imagePath + "\\" + System.currentTimeMillis(), driver)));
//        }//end try-catch
//    }//end test01

//    @org.junit.Test
//    public void test02_HomeScreen() throws InterruptedException {
//        //start test
//        myTests = extent.startTest("Login");
//        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");
//
//        gift = new HomeScreeen(driver);
//        gift.chooseGift();
//    }//end test 02
//
//
//    @org.junit.Test
//    public void test03_SenderAndReceiver() throws InterruptedException {
//        //start test
//        myTests = extent.startTest("Login");
//        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");
//
//        giftInfo = new SenderReceiverInfo(driver);
//        giftInfo.chooseSenderAndReceiver();
//    }//end test03
//
//
//    @org.junit.Test
//    public void test04_SenderViaEmail() throws InterruptedException {
//        //start test
//        myTests = extent.startTest("Login");
//        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");
//
//        finalizeSend = new SendTo(driver);
//        finalizeSend.sendViaMail();
//
//    }//end test03

    @org.junit.Test
    public void test05_MaxPrice() throws InterruptedException {
        myTests = extent.startTest("Login");
        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");
        login = new Login(driver);
        login.loginToWeb();
        gift = new HomeScreeen(driver);
        gift.mostExpensive();
    }

}
