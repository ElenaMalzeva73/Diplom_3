package tests;

import data.UserGenerator;
import io.restassured.response.Response;
import org.junit.Before;
import data.CreateUser;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pageobject.LoginPage;
import pageobject.RegisterPage;

public class CheckingUserRegistrationTest extends BaseData {
    LoginPage loginPage;
    RegisterPage registerPage;

    @Before
    public void userCreate(){
        createUser = new CreateUser();
        user = UserGenerator.randomUser();
        Response response = createUser.create(user);
        token = response.then().extract().path("accessToken").toString();
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void LoginButtonOnTheMainPageTest() {
        mainPage.clickLoginButtonLocator();
        loginPage = new LoginPage(webDriver);
        loginPage.passwordRecoveryPage();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.inputMakeOrderButtonLocator();
    }
    @Test
    @DisplayName("Вход по кнопке «Личный кабинет» на главной странице")
    public void LoginUsingThePersonalAccountButtonTest() {
        mainPage.clickPersonalButtonLocator();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.inputMakeOrderButtonLocator();
    }
    @Test
    @DisplayName("Вход по кнопке «Войти» на  странице регистрации")
    public void LoginViaButtonOnRegistrationPageTest() {
        mainPage.clickPersonalButtonLocator();
        registerPage = new RegisterPage(webDriver);
        registerPage.scrollToButton();
        registerPage.clickSignInFieldLocator();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.inputMakeOrderButtonLocator();
    }
    @Test
    @DisplayName("Вход по кнопке «Восстановление пароля» на  странице регистрации")
    public void loginUsingThePasswordRecoveryButtonTest() {
        mainPage.clickPersonalButtonLocator();
        registerPage = new RegisterPage(webDriver);
        registerPage.scrollToButton();
        registerPage.clickRestorePasswordFieldLocator();
        registerPage.clickSignInFieldLocatorPasswordRecovery();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.inputMakeOrderButtonLocator();
    }
}

