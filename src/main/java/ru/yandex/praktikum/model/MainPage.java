package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class MainPage {

    private final WebDriver driver;

    //Локаторы вопросов
    public final static By FIRST_QUESTION = By.id("accordion__heading-0"); //первый вопрос
    public final static By SECOND_QUESTION = By.id("accordion__heading-1"); //второй вопрос
    public final static By THIRD_QUESTION = By.id("accordion__heading-2"); //третий вопрос
    public final static By FOURTH_QUESTION = By.id("accordion__heading-3"); //четвертый вопрос
    public final static By FIFTH_QUESTION = By.id("accordion__heading-4"); //пятый вопрос
    public final static By SIXTH_QUESTION = By.id("accordion__heading-5"); //шестой вопрос
    public final static By SEVENTH_QUESTION = By.id("accordion__heading-6"); //седьмой вопрос
    public final static By EIGHT_QUESTION = By.id("accordion__heading-7"); //восьмой вопрос
    //Локаторы ответов
    private final static By FIRST_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p"); //первый ответ
    private final static By SECOND_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p"); //второй ответ
    private final static By THIRD_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p"); //третий ответ
    private final static By FOURTH_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p"); //четвертый ответ
    private final static By FIFTH_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p"); //пытый ответ
    private final static By SIXTH_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p"); //шестой ответ
    private final static By SEVENTH_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p"); //седьмой ответ
    private final static By EIGHT_ANSWER = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p"); //восьмой ответ

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    //Мапа ключ/значение вопрос/ответ
    static HashMap<By, By> map = new HashMap<>();

    static {
        map.put(FIRST_QUESTION, FIRST_ANSWER);
        map.put(SECOND_QUESTION, SECOND_ANSWER);
        map.put(THIRD_QUESTION, THIRD_ANSWER);
        map.put(FOURTH_QUESTION, FOURTH_ANSWER);
        map.put(FIFTH_QUESTION, FIFTH_ANSWER);
        map.put(SIXTH_QUESTION, SIXTH_ANSWER);
        map.put(SEVENTH_QUESTION, SEVENTH_ANSWER);
        map.put(EIGHT_QUESTION, EIGHT_ANSWER);
    }

    //прокрутить главную страницу до первого вопроса
    public void scrollMainPageQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.id("accordion__heading-0")));
    }

    //Раскрыть элемент списка вопросов, подождать появление текста овтета и его получить
    public String getAnswer(By id) {
        driver.findElement(id).click();
            new WebDriverWait(driver, 15).until(driver -> (driver.findElement(map.get(id)).getText() != null
                    && !driver.findElement(map.get(id)).getText().isEmpty()));
        return driver.findElement(map.get(id)).getText();
    }
}



