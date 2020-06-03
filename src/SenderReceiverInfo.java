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


    public void chooseSenderAndReceiver(){
        MobileElement receier = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/toEditText\"))"));
        General.userText("you",receier);

        MobileElement event = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"android:id/text1\"))"));

        event.click();
        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"יום הולדת\")")).click();


        MobileElement bless = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/blessEditText\"))"));

        General.userText("happy birthday",bless);


        MobileElement sender = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/userFrom\"))"));

        General.userText("me",sender);

        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))")).click();
    }

}
