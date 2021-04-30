import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    protected WebDriver driver ;

    public Page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

}
