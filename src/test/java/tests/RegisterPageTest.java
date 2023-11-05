package tests;

import data.CreateUser;
import data.User;
import data.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.RegisterPage;

public class RegisterPageTest extends BaseData {

    RegisterPage registerPage;
    CreateUser createUser;
    User user;
    @Test
    @DisplayName("регистрация с валидными значениями")
    public void registrationValidDataTest() {
        mainPage.clickPersonalButtonLocator();
        createUser = new CreateUser();
        user = UserGenerator.randomUser();
        registerPage = new RegisterPage(webDriver);
        registerPage.scrollToButton();
        registerPage.clickRegisterFieldLocator();
        registerPage.registrationPage();
        registerPage.fillRegistrationForm(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterFieldLocatorBlockRegistration();
    }
    @Test
    @DisplayName("регистрация с не валидными значениями")
    public void registrationNoValidDataTest() {
        mainPage.clickPersonalButtonLocator();
        createUser = new CreateUser();
        user = UserGenerator.randomUserNoValidDate();
        registerPage = new RegisterPage(webDriver);
        registerPage.scrollToButton();
        registerPage.clickRegisterFieldLocator();
        registerPage.registrationPage();
        registerPage.fillRegistrationForm(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterFieldLocatorBlockRegistration();
        registerPage.checkIncorrectPasswordFieldLocator();
    }
}