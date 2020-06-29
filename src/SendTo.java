import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;


public class SendTo {

    //constructor
    public SendTo(AndroidDriver driver){
        Test.driver = driver;
        PageFactory.initElements(driver,this);
    }//end of constructor

    //send to mail
    public void sendViaMail(){
        General.tapByCoordinates(969,1653);
        //mail
        MobileElement eMail = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().text(\"מייל:\"))"));
        General.userText("234234fdgd3fg243@walla.co.il",eMail);

        //next
        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))")).click();
    }//end of sendViaMail
}//end of SendTo
