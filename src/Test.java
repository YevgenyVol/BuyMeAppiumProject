import io.appium.java_client.MobileBy;
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



    @org.junit.Test
    //Login
    public void test01_Login() throws Exception {

        //start test
        myTests = extent.startTest("Login");
        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");

        //login to app
        login = new Login(driver);
        login.loginToWeb();

        //login check
        try {
            if (Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/tab_title\")")).isDisplayed()) {
                myTests.log(LogStatus.PASS, name.getMethodName() + ". Login completed");
                myTests.log(LogStatus.PASS, "", myTests.addScreenCapture(General.takeScreenShot(imagePath + "\\" + System.currentTimeMillis(), driver)));
            }
            else {
                myTests.log(LogStatus.FAIL, name.getMethodName() + ". Login failed");
                myTests.log(LogStatus.FAIL, "", myTests.addScreenCapture(General.takeScreenShot(imagePath + "\\" + System.currentTimeMillis(),driver)));
            }
        }
        catch (Exception a){
            myTests.log(LogStatus.FAIL, name.getMethodName() + ". Login failed");
            myTests.log(LogStatus.FAIL, "", myTests.addScreenCapture(General.takeScreenShot(imagePath + "\\" + System.currentTimeMillis(), driver)));
        }//end try-catch
    }//end test01



    @org.junit.Test
    public void test02_HomeScreen() throws InterruptedException {
        //start test
        myTests = extent.startTest("Choose Gift");
        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");

        //choose gift
        gift = new HomeScreeen(driver);
        gift.chooseGift();
    }//end test 02


    @org.junit.Test
    public void test03_SenderAndReceiver() throws InterruptedException {
        //start test
        myTests = extent.startTest("Login");
        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");

        //sender and receiver info
        giftInfo = new SenderReceiverInfo(driver);
        giftInfo.chooseSenderAndReceiver();
    }//end test03


    @org.junit.Test
    public void test04_SenderViaEmail() throws InterruptedException {
        //start test
        myTests = extent.startTest("Login");
        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");

        //send to info
        finalizeSend = new SendTo(driver);
        finalizeSend.sendViaMail();
    }//end test04

    @org.junit.Test
    //max price
    public void test05_MaxPrice() throws InterruptedException {
        myTests = extent.startTest("Login");
        myTests.log(LogStatus.INFO, "Test '" + name.getMethodName() + "' started");

        //back to main page
        MobileElement back = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().description(\"נווט למעלה\")"));
        for (int i = 0 ;  i < 4 ; i++)
        {
            back.click();
        }

        //max price
        gift = new HomeScreeen(driver);
        gift.mostExpensive();
    }//end test05
}
