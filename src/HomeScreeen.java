import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class HomeScreeen {

//    @FindBy(id = "il.co.mintapp.buyme:id/skipButton")
//    WebElement loginButton;

    @FindBy (id = "il.co.mintapp.buyme:id/priceEditText")
    WebElement insertPrice;

    @FindBy (id = "il.co.mintapp.buyme:id/purchaseButton")
    WebElement chooseButton;

    @FindBy (id = "il.co.mintapp.buyme:id/giftPrice")
        WebElement price;

    @FindBy (id = "il.co.mintapp.buyme:id/i_shadow")
    WebElement adsad;




    //constructor
    public HomeScreeen(AndroidDriver driver){
        Test.driver = driver;
        PageFactory.initElements(driver,this);
    }//end of constructor

    public void chooseGift() throws InterruptedException {

        //choose fashion gift cards
        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().description(\"גיפט קארד למותגי אופנה\")")).click();

        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"מגוון חנויות בקניוני עזריאלי\")")).click();

        General.userText("200",insertPrice);

        chooseButton.click();


//        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//                + ".scrollIntoView(new UiSelector().description(\"קבוצת גולף - Golf\"))"));
    }

    public void mostExpensive() throws InterruptedException {
        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/i_background\")")).click();
//        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"מקס ברנר עד הבית \")")).click();
        Thread.sleep(2000);
        MobileElement event = Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().text(\"מקס ברנר עד הבית \"))"));

        event.click();




        List<MobileElement> listOfClickableElements = Test.driver.findElementsByAndroidUIAutomator("new UiSelector().textContains(\"₪\")");

        for (MobileElement element:
                listOfClickableElements){ System.out.println(element.getLocation());
            System.out.println(element.getId());
            System.out.println(element.getTagName());
            System.out.println(element.getText());
        }

        List<MobileElement> elementsTwo = Test.driver.findElementsByXPath("//android.widget.TextView");;
        for (MobileElement element:
                elementsTwo){ System.out.println(element.getLocation());
            System.out.println(element.getId());
            System.out.println(element.getTagName());
            System.out.println(element.getText());
        }
    }



}//end of HomeScreen class
