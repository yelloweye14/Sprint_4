package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage {

    private static final By UP_BUTTON_ORDER = By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/button[1]"); //Верхняя кнопка заказа

    private static final By DOWN_BUTTON_ORDER = By.className("Button_UltraBig__UU3Lp");  //Нижняя кнопка заказа
    private static final By NAME_ORDER = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input"); //Имя
    private static final By SURNAME_ORDER = By.xpath("//div[2]/input"); //Фамилия
    private static final By ADDRESS_ORDER = By.xpath("//div[3]/input"); //адрес
    private static final By METRO_ORDER = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input"); //метро
    private static final By PHONE_ORDER = By.xpath("//div[5]/input"); //телефон
    private static final By NEXT_PAGE_ORDER = By.className("Button_Middle__1CSJM"); //кнопка Далее
    private static final By DATE_ORDER = By.className("Input_Responsible__1jDKN"); //дата
    private static final By ORDER_PERIOD = By.className("Dropdown-placeholder"); //период аренды
    private static final By BLACK_COLOR_SCOOTER = By.className("Checkbox_Input__14A2w"); //черный цвет самоката
    private static final By GREY_COLOR_SCOOTER = By.id("grey"); //серый цвет самоката
    private static final By COMMENT_ORDER = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    private static final By SUBMIT_ORDER_BUTTON = By.xpath("/html/body/div[1]/div/div[2]/div[3]/button[2]"); //Оформить заказ
    private static final By SUBMIT_ORDER_BUTTON_YES = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); //Подтверждение оформления
    private static final By SUCCESSFULLY_ORDER_TEXT = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]"); //Модальное окно с текстом подтверждения

    private final WebDriver driver;
    private int date;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение первой страницы заказа
    public void enterDataFirstPageOrder(String name, String surname, String address, int metro, String phoneNumber) {
        driver.findElement(UP_BUTTON_ORDER).click();
        driver.findElement(NAME_ORDER).sendKeys(name);
        driver.findElement(SURNAME_ORDER).sendKeys(surname);
        driver.findElement(ADDRESS_ORDER).sendKeys(address);
        driver.findElement(METRO_ORDER).click();
        By allMetroStation = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
        List<WebElement> elements = driver.findElements(allMetroStation); //список из 255 станций метро
        elements.get(metro - 1).click();
        driver.findElement(PHONE_ORDER).sendKeys(phoneNumber);
        driver.findElement(NEXT_PAGE_ORDER).click();
    }

    public void enterDataSecondPageOrder(String color, String date, int rentalDays, String comment) {
        if ("черный".equals(color)) {
            driver.findElement(BLACK_COLOR_SCOOTER).click();
        }
        if ("серый".equals(color)) {
            driver.findElement(GREY_COLOR_SCOOTER).click();
        }
        driver.findElement(DATE_ORDER).sendKeys(date); //ввод даты в формате "dd.MM.yyyy"
        driver.findElement(DATE_ORDER).sendKeys(Keys.RETURN);
        driver.findElement(ORDER_PERIOD).click();
        By allDayForOrder = By.className("Dropdown-option");
        List<WebElement> elements = driver.findElements(allDayForOrder); //список из 7 дней аренды
        elements.get(rentalDays - 1).click();
        driver.findElement(COMMENT_ORDER).sendKeys(comment);
        driver.findElement(SUBMIT_ORDER_BUTTON).click();
        driver.findElement(SUBMIT_ORDER_BUTTON_YES).click();
    }
    //Подтверждения оформления заказа
    public boolean successfullyText() {
        String successfullOrder = driver.findElement(SUCCESSFULLY_ORDER_TEXT).getText();
        return successfullOrder.contains("Заказ оформлен");
    }
}







