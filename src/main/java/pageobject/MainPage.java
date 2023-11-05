package pageobject;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constant.Constant.BASE_URL;

public class MainPage {
    //Локатор кнопки "Войти в аккаунт"
    private final By loginButtonLocator = By.xpath("//button[text()='Войти в аккаунт']");
    //Локатор кнопки "Личный кабинет"
    private final By personalButtonLocator = By.xpath(".//p[text()='Личный Кабинет']");
    //Локатор кнопки "Оформить заказ"
    private final By makeOrderButtonLocator = By.xpath(".//button[contains(text(),'Оформить заказ')]");
    //Локатор кнопки "Булки"
    private final By bunsButtonLocator = By.xpath("//div[span[text()='Булки']]");
    //Локатор кнопки "Булки" активная
    private final By activeBunsButtonLocator = By.xpath("//span[text()='Булки']");
    //Локатор кнопки "Соусы"
    private final By saucesButtonLocator = By.xpath("//div[span[text()='Соусы']]");
    //Локатор кнопки "Соусы" активная
    private final By activeSaucesButtonLocator = By.xpath("//span[text()='Соусы']");
    //Локатор кнопки "Начинки" активная
     private final By activeFillingsButtonLocator = By.xpath("//span[text()='Начинки']");
    //Локатор кнопки "Начинки"
    private final By fillingsButtonLocator = By.xpath("//*[text()='Начинки']");
    // Локатор логотипа "Stellar Burgers"
    private final By logoLocator = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");
     WebDriver webDriver;
    boolean isDisplayed;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Открыть главную страницу")
    public void open() {
        webDriver.get(BASE_URL);
    }

    @Step("Проверка перехода на страницу'Stellar Burgers'")
    public void inputPageStellarBurgers() {
        isDisplayed = webDriver.findElement(logoLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("клик на кнопку 'Личный кабинет'")
    public void clickPersonalButtonLocator() {
        webDriver.findElement(personalButtonLocator).click();
    }

    @Step("клик на кнопку 'Войти в аккаунт'")
    public void clickLoginButtonLocator() {
        webDriver.findElement(loginButtonLocator).click();
    }

    @Step("Проверка входа в аккаунт")
    public void inputMakeOrderButtonLocator() {
        isDisplayed = webDriver.findElement(makeOrderButtonLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Проверка кнопки 'Булки'")
    public void clickButtonBun() {
        webDriver.findElement(saucesButtonLocator).click();
        webDriver.findElement(bunsButtonLocator).click();
        isDisplayed = webDriver.findElement(activeBunsButtonLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @Step("Проверка кнопки 'Соусы'")
    public void clickButtonSauces() {
        webDriver.findElement(saucesButtonLocator).click();
        isDisplayed = webDriver.findElement(activeSaucesButtonLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @Step("Проверка кнопки 'Начинки'")
    public void clickButtonFillings() {
        webDriver.findElement(fillingsButtonLocator).click();
        isDisplayed = webDriver.findElement(activeFillingsButtonLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}
