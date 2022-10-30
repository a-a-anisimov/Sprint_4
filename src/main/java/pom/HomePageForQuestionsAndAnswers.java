package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class HomePageForQuestionsAndAnswers {
    private WebDriver driver;

    private By elementQandA = By.xpath("//div[text() = 'Вопросы о важном']"); //элемент "Вопросы о важном" для скролла

    private By elementQuestonsIndex0 = By.id("accordion__heading-0"); //"Вопрос" с индексом 0

    private By elementAnswersIndex0 = By.xpath(".//div[@id = 'accordion__panel-0']/p");  //"Ответа" с индексом 0

    private By elementQuestonsIndex1 = By.id("accordion__heading-1");

    private By elementAnswersIndex1 = By.xpath(".//div[@id = 'accordion__panel-1']/p");

    private By elementQuestonsIndex2 = By.id("accordion__heading-2");

    private By elementAnswersIndex2 = By.xpath(".//div[@id = 'accordion__panel-2']/p");

    private By elementQuestonsIndex3 = By.id("accordion__heading-3");

    private By elementAnswersIndex3 = By.xpath(".//div[@id = 'accordion__panel-3']/p");

    private By elementQuestonsIndex4 = By.id("accordion__heading-4");

    private By elementAnswersIndex4 = By.xpath(".//div[@id = 'accordion__panel-4']/p");

    private By elementQuestonsIndex5 = By.id("accordion__heading-5");

    private By elementAnswersIndex5 = By.xpath(".//div[@id = 'accordion__panel-5']/p");

    private By elementQuestonsIndex6 = By.id("accordion__heading-6");

    private By elementAnswersIndex6 = By.xpath(".//div[@id = 'accordion__panel-6']/p");

    private By elementQuestonsIndex7 = By.id("accordion__heading-7");

    private By elementAnswersIndex7 = By.xpath(".//div[@id = 'accordion__panel-7']/p");

    public HomePageForQuestionsAndAnswers(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToAccordeon() { //скролл до аккордеона
        WebElement element = driver.findElement(elementQandA);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void openAccordeon(String questions) { //действия с аккордеоном
        if (questions == "0") {
            driver.findElement(elementQuestonsIndex0).click();
            String good0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex0).getText(), good0);

        } else if (questions == "1") {
            driver.findElement(elementQuestonsIndex1).click();
            String good1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex1).getText(), good1);

        } else if (questions == "2") {
            driver.findElement(elementQuestonsIndex2).click();
            String good2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex2).getText(), good2);
        } else if (questions == "3") {
            driver.findElement(elementQuestonsIndex3).click();
            String good3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex3).getText(), good3);
        } else if (questions == "4") {
            driver.findElement(elementQuestonsIndex4).click();
            String good4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex4).getText(), good4);
        } else if (questions == "5") {
            driver.findElement(elementQuestonsIndex5).click();
            String good5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex5).getText(), good5);
        } else if (questions == "6") {
            driver.findElement(elementQuestonsIndex6).click();
            String good6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex6).getText(), good6);
        } else if (questions == "7") {
            driver.findElement(elementQuestonsIndex7).click();
            String good7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области..";
            Assert.assertEquals("Текс не совпадает с ОР: ", driver.findElement(elementAnswersIndex7).getText(), good7);
        } else {
            System.out.println("Такого вопроса не существует!");
        }
    }
}