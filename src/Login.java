import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
//     AndroidDriver<MobileElement> driver;

     //login
    @FindBy (id = "il.co.mintapp.buyme:id/skipButton")
        WebElement loginButton;
    //google button
    @FindBy (id = "il.co.mintapp.buyme:id/googleButton")
        WebElement googleButton;
    //choose user
    @FindBy (id = "com.google.android.gms:id/container")
        WebElement chooseUser;





    //constructor
    public Login(AndroidDriver driver){
        Test.driver = driver;
        PageFactory.initElements(driver,this);
    }//end of constructor

    public void loginToWeb(){
        //login
        loginButton.click();
        //google
        googleButton.click();
        //user
        chooseUser.click();
    }

}
