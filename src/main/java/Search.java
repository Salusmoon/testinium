import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Search extends Page{


    public Search(WebDriver driver) {
        super(driver);
    }

    public void itemSearch(String item, String search_tag, String search_button) throws InterruptedException {
        driver.findElement(By.className(search_tag)).sendKeys(item);
        var buttonSearch = driver.findElement(new By.ByCssSelector(search_button));
        buttonSearch.click();
        Thread.sleep(2000);
    }

    public void nextPage(String page_number) throws InterruptedException {
        driver.findElement(By.xpath("//img[@src='//dbfukofby5ycr.cloudfront.net/m13/0/9/d2101/19bb1-close-icon-13612.png']")).click();
        driver.findElement(By.xpath("//span[@class='gg-icon gg-icon-close icon-close']")).click();
        driver.findElement(By.linkText(page_number)).click();
        Thread.sleep(2000);
    }

    public void selectItem() throws InterruptedException {
        Random random = new Random();
        int rand = random.nextInt(48) + 1; // ( 1 Sayfada = 48 Ürün )
        driver.findElement(By.xpath("//div[@class='clearfix']/ul[@class='catalog-view clearfix products-container']/li[" + rand + "]/a[@class='product-link']")).click();
        Thread.sleep(500);

    }
    public boolean searchControl(){

        String expectedUrl = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        try {
            Assert.assertEquals(actualUrl, expectedUrl);
            System.out.println("2. sayfadasınız");
            return true;
        } catch (Exception e) {
            System.out.println("2. sayfada değilsiniz");
            return false;
        }
    }
    public Item submit(){ return new Item(driver);}

}
