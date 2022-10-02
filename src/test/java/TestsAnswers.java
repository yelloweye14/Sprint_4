import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.model.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.model.MainPage.*;

public class TestsAnswers {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3,
                TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkFirstAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                mainpage.getAnswer(FIRST_QUESTION));
    }

    @Test
    public void checkSecondAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                        "можете просто сделать несколько заказов — один за другим.",
                mainpage.getAnswer(SECOND_QUESTION));
    }

    @Test
    public void checkThirdAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                mainpage.getAnswer(THIRD_QUESTION));
    }

    @Test
    public void checkFourthAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                mainpage.getAnswer(FOURTH_QUESTION));
    }

    @Test
    public void checkFifthAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                        "в поддержку по красивому номеру 1010.",
                mainpage.getAnswer(FIFTH_QUESTION));
    }

    @Test
    public void checkSixthAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                        "даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                mainpage.getAnswer(SIXTH_QUESTION));
    }

    @Test
    public void checkSeventhAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, " +
                        "объяснительной записки тоже не попросим. Все же свои.",
                mainpage.getAnswer(SEVENTH_QUESTION));
    }

    @Test
    public void checkEighthAnswer() {
        MainPage mainpage = new MainPage(driver);
        mainpage.scrollMainPageQuestions();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                mainpage.getAnswer(EIGHT_QUESTION));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}






