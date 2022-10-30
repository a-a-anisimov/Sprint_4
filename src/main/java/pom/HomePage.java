package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By topButtonOrder = By.className("Button_Button__ra12g"); //верхняя кнопка Заказать

    private By bottomButtonOrder = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']"); //нижняя кнопка Заказать

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseButtonOrder(String enterButtonOrder) { //метод для выбора точки входа
        if (enterButtonOrder == "top") {
            driver.findElement(topButtonOrder).click();
        } else if (enterButtonOrder == "bottom") {
            WebElement element = driver.findElement(bottomButtonOrder);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(bottomButtonOrder).click();
        } else {
            System.out.println("Такой кнопки не сущетсвует!");
        }
    }

}

