import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;
import pom.OrderFormPage;

import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)

public class TestOrderForm {
    private WebDriver driver;

    private final int index; //точка входа (верхняя или нижняя кнопка Закзать)
    private final String name;
    private final String surname;
    private final String adress;
    private final String metroStation;
    private final String phoneNumber;
    private final String when;

    private final String period;
    private final String color;
    private final String comment;


    public TestOrderForm(int index, String name, String surname, String adress, String metroStation, String phoneNumber, String when, String period, String color, String comment) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.when = when;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }


    @Parameterized.Parameters
    public static Object[][] fieldData() {
        return new Object[][]{
                {0, "Андрей", "Анисмов", "Санкт-Петербург", "ВДНХ", "89999999999", "10.11.2022", "сутки", "Чёрный", "Юху"},
                {1, "Семён", "Семёнов", "Псков", "Люблино", "89991234567", "10.12.2022", "семеро суток", "Серый", "0000000"},
        };
    }

    @Before
    public void setUp() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver(); //выбран брузер Chrome
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testMakeOrder() {

        HomePage homePage = new HomePage(driver);
        homePage.getButtonOrder();
        homePage.chooseButtonOrder(index); //выбор точки входа (верхняя или нижняя кнопка Заказать)

        OrderFormPage orderFormPage = new OrderFormPage(driver);
        orderFormPage.sendNameField(name);
        orderFormPage.sendSurnameField(surname);
        orderFormPage.sendAdressField(adress);
        orderFormPage.sendMetroStationField(metroStation);
        orderFormPage.sendPhoneNumberField(phoneNumber);
        orderFormPage.clickButtonNext();
        orderFormPage.sendWhenField(when);
        orderFormPage.sendPeriod(period);
        orderFormPage.clickColorField(color);
        orderFormPage.sendCommentField(comment);
        orderFormPage.clickFinalButtonOrder();
        orderFormPage.clickYesButtonOrder();
        orderFormPage.clickCheckButtonStatusOrder(); //проверка доступностью клика по кнопке Посмотреть статус
    }
    @After
    public void teardown() {
        driver.quit();
    }
}

