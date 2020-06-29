import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeScreeen {


    @FindBy (id = "il.co.mintapp.buyme:id/priceEditText")
    WebElement insertPrice;

    @FindBy (id = "il.co.mintapp.buyme:id/purchaseButton")
    WebElement chooseButton;

    //constructor
    public HomeScreeen(AndroidDriver driver){
        Test.driver = driver;
        PageFactory.initElements(driver,this);
    }//end of constructor

    public void chooseGift() throws InterruptedException {
        //choose fashion gift cards
        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().description(\"גיפט קארד למותגי אופנה\")")).click();

        Test.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"מגוון חנויות בקניוני עזריאלי\")")).click();

        //gift value
        General.userText("200",insertPrice);
        chooseButton.click();
    }

    public void mostExpensive() throws InterruptedException {
        //swap right
        General.horizontalSwipeByPercentage(0.8,0.1,0.9);
        General.horizontalSwipeByPercentage(0.8,0.1,0.9);

        //choose shop
        General.tapByCoordinates(556,1516);

        //list of price elements
        List<MobileElement> listOfElements = Test.driver.findElementsByAndroidUIAutomator("new UiSelector().textContains(\"₪\")");

        for (MobileElement element:
                listOfElements){ System.out.println(element.getLocation());
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
        System.out.println(Test.driver.getPageSource());
    }//end of most expensive



}//end of HomeScreen class
