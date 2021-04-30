import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Item extends Page{


    public Item(WebDriver driver) {
        super(driver);
    }

    public String AddItem(String add_tag, String item_value_tag) throws InterruptedException {
        driver.findElement(By.id(add_tag)).click();
        WebElement webElement = driver.findElement(By.xpath(item_value_tag));
        String text = webElement.getText();
        Thread.sleep(2000);
        return text;
    }
    public void getBasket(String basket_tag) throws InterruptedException {
        driver.findElement(By.className(basket_tag)).click();
        Thread.sleep(2000);
    }

    public Basket submit(){ return new Basket(driver);}
}
