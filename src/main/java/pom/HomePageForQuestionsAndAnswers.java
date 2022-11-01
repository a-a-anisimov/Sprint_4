package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageForQuestionsAndAnswers {
    private WebDriver driver;

    private By elementQandA = By.xpath("//div[text() = 'Вопросы о важном']"); //элемент "Вопросы о важном" для скролла

    private By questions = By.xpath(".//div[@data-accordion-component = 'AccordionItemButton']"); //список Вопросов

    private By answers = By.xpath(".//div[@data-accordion-component = 'AccordionItemPanel']"); //список Ответов


    public HomePageForQuestionsAndAnswers(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToAccordeon() { //скролл до аккордеона
        WebElement element = driver.findElement(elementQandA);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public List<WebElement> getQuestionAccordeon() { //получение списка с вопросами
        return driver.findElements(questions);
    }
    public List<WebElement> getAnswersAccordeon() { //получение списка с ответами
        return driver.findElements(answers);
    }
    public void clickQuestionAccordeon(int index) { //клик по конкретному вопросу
        driver.findElements(questions).get(index).click();
    }
}