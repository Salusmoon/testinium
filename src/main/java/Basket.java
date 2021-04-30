import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Basket extends Page{
    public Basket(WebDriver driver) {
        super(driver);
    }

    public String itemPrice(String price_tag) throws InterruptedException {
        WebElement webElement = driver.findElement(By.className(price_tag));
        String text = webElement.getText();
        Thread.sleep(1000);
        return text;
    }

    public void addItem(String count_tag, String count) throws InterruptedException {
        WebElement elem = driver.findElement(By.xpath(count_tag));
        new Select(elem).selectByVisibleText(count);
        Thread.sleep(2000);
    }
    public void deleteItem(String delete_tag) throws InterruptedException {
        driver.findElement(By.xpath(delete_tag)).click();
        Thread.sleep(2000);
    }

    public boolean basketControl(String tag){
        try {
            List<WebElement> basketlist = driver.findElement(By.xpath(tag)).findElements(By.className("product-group-box"));
            return true;
        }catch (Exception e){

            return false;
        }

    }
}
