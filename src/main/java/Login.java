import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Page {

    protected Login(WebDriver driver) {
        super(driver);
    }

    public void loginPorofile(String email, String password, String email_tag1, String password_tag2) throws InterruptedException {
        driver.findElement(By.id(email_tag1)).sendKeys(email);
        Thread.sleep( 500);
        driver.findElement(By.name(password_tag2)).sendKeys(password);
        Thread.sleep(500);

    }
    public void loginButton(String button_tag3) throws InterruptedException {
        driver.findElement(By.xpath(button_tag3)).click();
        Thread.sleep( 1000);
    }
    public boolean loginControl() {
        String expectedUrl = driver.getCurrentUrl();
        driver.get("https://www.gittigidiyor.com/uye-girisi");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        try {
            Assert.assertEquals(actualUrl, expectedUrl);
            System.out.println("Giriş işlemi doğru yapıldı.");
            return true;
        } catch (Exception e) {
            System.out.println("Giriş işlemi hatalı geri yönlendiriliyorsunuz.");
            return false;
        }
    }
    public Search submit(){
        return new Search(driver);
    }

}
