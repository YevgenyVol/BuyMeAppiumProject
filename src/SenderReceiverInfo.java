import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class SenderReceiverInfo {

    //constructor
    public SenderReceiverInfo(AndroidDriver driver){
        Test.driver = driver;
        PageFactory.initElements(driver,this);
    }//end of constructor


    //sender and receiver info
    public void chooseSenderAndReceiver(){
        //receiver info
        MobileElement receiver = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/toEditText\"))"));
        General.userText("you",receiver);

        //event
        MobileElement event = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"android:id/text1\"))"));
        event.click();

        //chose birthday
        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"יום הולדת\")")).click();

        //bkess
        MobileElement bless = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/blessEditText\"))"));
        General.userText("happy birthday",bless);

        //sender info
        MobileElement sender = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/userFrom\"))"));
        General.userText("me",sender);

        //next page
        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))")).click();
    }//end of chooseSenderAndReceiver
}//end of SenderReceiverInfo
