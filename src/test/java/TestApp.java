
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestApp {

    @Test
    public void start() throws InterruptedException {

        WebDriver driver = FunctionalTest.setUp();

        //home page
        Home home = new Home(driver);
        home.getPage("https://www.gittigidiyor.com");
        home.loginButton("gekhq4-6",".qjixn8-0[data-cy='header-login-button']");

        // login
        Login login = home.submit();
        login.loginPorofile("test58@gmail.com", "123456789a","L-UserNameField","sifre"  );
        login.loginButton("//*[@id='gg-login-enter']");
        while(!login.loginControl()){
            home.getPage("https://www.gittigidiyor.com");
            home.loginButton("gekhq4-6",".qjixn8-0[data-cy='header-login-button']");

            login.loginPorofile("test58@gmail.com", "123456789a","L-UserNameField","sifre"  );
            login.loginButton("//*[@id='gg-login-enter']");
        }

        // home page search
        Search search = login.submit();
        search.itemSearch("bilgisayar", "sc-4995aq-0",".qjixn8-0[data-cy=search-find-button]");
        search.nextPage("2");
        search.searchControl();
        search.selectItem();

        // product
        Item item = search.submit();
        String item_value = item.AddItem("add-to-basket","//*[@id='sp-price-discountPrice']");
        item.getBasket("header-cart-hidden-link");

        // basket
        Basket basket = item.submit();
        String basket_item = basket.itemPrice("real-discounted-price");  ////*[@id="cart-price-container"]/div[3]/p
        if( item_value.equals(basket_item)){
            System.out.println("fiyatlar doğru.");
            basket.addItem("//div[4]/div/div[2]/select", "2");
        }else{
            System.out.println("fiyatlar farklı");
        }
        basket.deleteItem("//i[@class='gg-icon gg-icon-bin-medium']");
        if (basket.basketControl("//*[@id='cart-items-container']/div/div[6]")){
            System.out.println("Sepetinizde ürün bulunmamaktadır");
        }
    }
}

