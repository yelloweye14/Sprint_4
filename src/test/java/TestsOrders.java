import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.OrderPage;

import java.util.concurrent.TimeUnit;

public class TestsOrders {

    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,
                TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void testOrderingScooterOne() {
        OrderPage orderTrue = new OrderPage(driver);
        orderTrue.enterDataFirstPageOrder("Андрей", "Артамонов", "Волгоград", 21, "+79965647444");
        orderTrue.enterDataSecondPageOrder("черный", "02.10.2022", 7, "Оставьте у подъезда");
        Assert.assertTrue(orderTrue.successfullyText());
    }

    @Test
    public void testOrderingScooterTwo() {
        OrderPage orderTrue = new OrderPage(driver);
        orderTrue.enterDataFirstPageOrder("Александр", "Богатырёв", "Москва", 14, "+9996667766");
        orderTrue.enterDataSecondPageOrder("серый", "11.10.2022", 3, "Не оставляйте у подезда!");
        Assert.assertTrue(orderTrue.successfullyText());
    }

    @Test
    public void testOrderingScooterThree() {
        OrderPage orderTrue = new OrderPage(driver);
        orderTrue.enterDataFirstPageOrder("Нина", "Вознесенская", "Петербург", 55, "+79977664446");
        orderTrue.enterDataSecondPageOrder("черный", "15.11.2022", 5, "");
        Assert.assertTrue(orderTrue.successfullyText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

