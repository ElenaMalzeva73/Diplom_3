package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class BurgerConstructorTest extends BaseData {
    @Test
    @DisplayName("проверка активности копки 'Булки'")
    public void bunsButtonActivityTest(){
        mainPage.clickButtonBun();
    }
    @Test
    @DisplayName("проверка активности копки 'Соусы'")
    public void saucesButtonActivityTest(){
        mainPage.clickButtonSauces();
    }
    @Test
    @DisplayName("проверка активности копки 'Начинка'")
    public void fillingsButtonActivityTest(){
        mainPage.clickButtonFillings();
    }
}
