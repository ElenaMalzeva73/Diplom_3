package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonaAreaPage  {
    // Локатор логотипа "Stellar Burgers"
    private final By logoLocator = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");
    // Локатор кнопки "Конструктор"
    private final By constructorButtonLocator = By.xpath("//p[text()='Конструктор']");//("//li[@class = 'AppHeader_header__linkText__3q_va ml-2' end text() = 'Конструктор']");
    // Локатор кнопки "Выход"
    private final By exitButtonLocator = By.xpath("//button[text()='Выход']");//("//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");//"//a[@href='/account/profile']");//("//li[(@class = 'Account_listItem__35dAP' end text() = 'Профиль')]");
    // Локатор поле "Соберите бургер"
    private final By assembleTheBurgerFieldLocator = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");
    WebDriver webDriver;
    boolean isDisplayed;
    public PersonaAreaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Проверка перехода на страницу'Persona Area'")
    public void inputPagePersonaArea() {
        isDisplayed = webDriver.findElement(exitButtonLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @Step("клик на кнопку 'Stellar Burgers', проверка перехода на главную страницу")
    public void clickLogoLocator() {
        webDriver.findElement(logoLocator).click();
        isDisplayed = webDriver.findElement(assembleTheBurgerFieldLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("клик на кнопку 'Конструктор', проверка перехода на главную страницу ")
    public void clickConstructorButtonLocator() {
        webDriver.findElement(constructorButtonLocator).click();
        isDisplayed = webDriver.findElement(assembleTheBurgerFieldLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("клик на кнопку 'Выход', проверка перехода на главную страницу")
    public void clickExitButtonLocator() {
        webDriver.findElement(exitButtonLocator).click();
        isDisplayed = webDriver.findElement(logoLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}
