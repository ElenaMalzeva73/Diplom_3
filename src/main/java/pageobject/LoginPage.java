package pageobject;

import io.qameta.allure.Step;
import  org.junit.Assert.*;
import org.junit.Assert;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Локатор кнопки "Войти"
    private final By signInButtonLocator = By.xpath("//button[text()='Войти']");
    // Локатор поле email
    private final By emailFieldLocator = By.xpath("//input[@name='name']");
    //Локатор поле "Пароль"
    private final By passwordFieldLocator = By.xpath("//input[@name='Пароль']");
    // Локатор поле "Вход"
    private final By inputFieldLocator = By.xpath("//div[@class = 'Auth_login__3hAey']");

    WebDriver webDriver;
    boolean isDisplayed;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка перехода на страницу'Вход'")
    public void inputPage() {
        isDisplayed = webDriver.findElement(inputFieldLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @Step("Авторизация")
    public void fillLoginForm(String email, String password) {
        webDriver.findElement(emailFieldLocator).sendKeys(email);
        webDriver.findElement(passwordFieldLocator).sendKeys(password);
    }
    @Step("клик на кнопку 'Войти'")
    public void clickSignInButtonLocator(){
        webDriver.findElement(signInButtonLocator).click();
    }


   @Step("Проверка перехода на страницу'Вход'")
    public void passwordRecoveryPage() {
        isDisplayed = webDriver.findElement(inputFieldLocator).isDisplayed();
       Assert.assertTrue(isDisplayed);
    }
}

