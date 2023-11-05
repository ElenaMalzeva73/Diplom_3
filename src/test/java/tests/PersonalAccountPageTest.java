package tests;
import data.CreateUser;
import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import data.UserGenerator;
import io.restassured.response.Response;
import pageobject.LoginPage;
import pageobject.PersonaAreaPage;

public class PersonalAccountPageTest extends BaseData {
    CreateUser createUser;
    LoginPage loginPage;
    PersonaAreaPage personaAreaPage;

    @Before
    @Step("Вход в аккаунт")
    public void loginToAccount() {
            createUser = new CreateUser();
            user = UserGenerator.randomUser();
            mainPage.clickLoginButtonLocator();
        Response response = createUser.create(user);
        token = response.then().extract().path("accessToken").toString();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.inputMakeOrderButtonLocator();
    }
    @Test
    @DisplayName("Переход на страницу аккаунта по  клику на 'Личный кабинет'")
    public void LoginToYourAccountViaPersonalAccountTest(){
        personaAreaPage = new PersonaAreaPage(webDriver);
        mainPage.clickPersonalButtonLocator();
        personaAreaPage.inputPagePersonaArea();
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void fromYourPersonalAccountToTheDesignerTest(){
        personaAreaPage = new PersonaAreaPage(webDriver);
        mainPage.clickPersonalButtonLocator();
        personaAreaPage.inputPagePersonaArea();
        personaAreaPage.clickConstructorButtonLocator();
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Логотип'")
    public void fromYourPersonalAccountToTheLogoTest(){
        personaAreaPage = new PersonaAreaPage(webDriver);
        mainPage.clickPersonalButtonLocator();
        personaAreaPage.inputPagePersonaArea();
        personaAreaPage.clickLogoLocator();
    }
    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void exitPersonalAccountTest(){
        personaAreaPage = new PersonaAreaPage(webDriver);
        mainPage.clickPersonalButtonLocator();
        personaAreaPage.inputPagePersonaArea();
        personaAreaPage.clickExitButtonLocator();
    }
}
