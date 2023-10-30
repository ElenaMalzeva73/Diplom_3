package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class RegisterPage {
    //Локатор поле "Зарегистрироваться"
    private final By registerFieldLocator = By.xpath("//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //Поле "Восстановить пароль"
    private final By restorePasswordFieldLocator = By.xpath("//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]");
    // Локатор поля "Имя"
    private final By nameFieldLocator = By.xpath("//label[text()='Имя']/../input");
    // Локатор поле email
    private final By emailFieldLocator = By.xpath("//label[text()='Email']/../input");
    //Локатор поле "Пароль"
    private final By passwordFieldLocator = By.xpath("//label[text()='Пароль']/../input");
    //локатор поля "Регистрация"
    private final By registrationFieldLocator = By.xpath("//h2[text()='Регистрация']");
    //Локатор кнопки "Зарегистрироваться" страницы "Регистрация"
    private final By registerFieldLocatorBlockRegistration = By.xpath("//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']");
    //Локатор поля "Войти" страницы "Регистрация"
    private final By signInFieldLocator = By.xpath("//button[text()='Войти']");//"//a[@class = 'Auth_link__1fOlj' and text()='Войти']");
    //Локатор поля "Войти" страницы "Восстановление пароля"
    private final By signInFieldLocatorPasswordRecovery = By.xpath("//a[@class = 'Auth_link__1fOlj' and text()='Войти']");//"//button[text()='Войти']");//"//a[@class = 'Auth_link__1fOlj' and text()='Войти']");
    //Локатор надписи "Некорректный пароль"
    private final By incorrectPasswordFieldLocator = By.xpath("//p[@class='input__error text_type_main-default']");
    // Локатор логотипа "Stellar Burgers"
    private final By logoLocator = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");

    WebDriver webDriver;
    boolean isDisplayed;
    public RegisterPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    @Step("Проверка перехода на страницу'Регистрация'")
    public void registrationPage(){
        isDisplayed = webDriver.findElement(registrationFieldLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }


    @Step("Скролл до поля 'Зарегистрироваться' ")
    public void scrollToButton() {
        WebElement element = webDriver.findElement(registerFieldLocator);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
    @Step("клик на  поле 'Зарегистрироваться'страница 'Вход'")
    public void clickRegisterFieldLocator(){
        webDriver.findElement(registerFieldLocator).click();
    }
    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        webDriver.findElement(nameFieldLocator).sendKeys(name);
        webDriver.findElement(emailFieldLocator).sendKeys(email);
        webDriver.findElement(passwordFieldLocator).sendKeys(password);
    }
    @Step("клик на  поле 'Зарегистрироваться' страница 'Регистрация'")
    public void clickRegisterFieldLocatorBlockRegistration(){
        webDriver.findElement(registerFieldLocatorBlockRegistration).click();
    }
    @Step("клик на  поле 'Войти' ")
    public void clickSignInFieldLocatorPasswordRecovery() {
        webDriver.findElement(signInFieldLocatorPasswordRecovery).click();
    }
    @Step("Проверка появления поля 'Некорректный пароль'")
    public void checkIncorrectPasswordFieldLocator(){
        isDisplayed = webDriver.findElement(incorrectPasswordFieldLocator).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @Step("Клик по кнопке «Восстановление пароля» на  странице регистрации ")
    public void clickRestorePasswordFieldLocator() {
        webDriver.findElement(restorePasswordFieldLocator).click();
    }
    @Step("клик на  поле 'Войти' странице 'Восстановления пароля'")
    public void clickSignInFieldLocator() {
        webDriver.findElement(signInFieldLocator).click();
    }
    @Step("Скролл до поля 'Зарегистрироваться' ")
    public void scrollToLogo() {
        WebElement element = webDriver.findElement(logoLocator);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);

    }
    @Step("клик на  Логотип странице 'Зарегистрироваться'")
    public void clickLogoLocator() {
        webDriver.findElement(logoLocator).click();
    }

}
