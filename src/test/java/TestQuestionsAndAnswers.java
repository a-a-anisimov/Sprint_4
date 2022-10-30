import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.HomePageForQuestionsAndAnswers;

import java.util.concurrent.TimeUnit;




    @RunWith(Parameterized.class)

    public  class TestQuestionsAndAnswers {
        private WebDriver driver;
        private final String questions;

        public TestQuestionsAndAnswers (String questions) {
            this.questions = questions;
        }

    @Parameterized.Parameters
    public static Object[][] questionsAndAnswers() {
        return new Object[][]{
                    {"0"},
                    {"7"},
            };
        }

    @Before
    public void setUp(){
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageForQuestionsAndAnswers homePageForQuestionsAndAnswers = new HomePageForQuestionsAndAnswers(driver);
        homePageForQuestionsAndAnswers.scrollToAccordeon();
    }

    @Test
    public void ceckQuestionsAndAnswers() {

        HomePageForQuestionsAndAnswers homePageForQuestionsAndAnswers = new HomePageForQuestionsAndAnswers(driver);
        homePageForQuestionsAndAnswers.openAccordeon(questions);
    }

}
