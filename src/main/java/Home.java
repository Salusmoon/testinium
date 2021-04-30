import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Home extends Page{


    public Home(WebDriver driver) {
        super(driver);
    }

    // get page adress
    public void getPage(String site) throws InterruptedException {
        driver.get(site);
        Thread.sleep(2000);
    }

    // find login button and click
    public void loginButton(String tag, String tag2) throws InterruptedException {
        Actions action = new Actions(driver);
        //var buttonSgn= (driver.findElement(By.className(tag)));
        var buttonSgn = (driver.findElement(By.className(tag)));
        action.moveToElement(buttonSgn).build().perform();
        Thread.sleep(1000);

        var buttonSgnIn= driver.findElement(new By.ByCssSelector(tag2));
        buttonSgnIn.click();
        Thread.sleep(2000);
    }

    public Login submit(){
        return new Login(driver);
    }
}
