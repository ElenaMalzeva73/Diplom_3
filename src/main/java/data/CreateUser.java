package data;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static constant.Constant.*;
import static io.restassured.RestAssured.given;
public class CreateUser {
    @Step("Создание пользователя")
    public static Response create(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post( BASE_URL + "/api/auth/register");
    }

    @Step("Удаление пользователя")
    public static void userDelete(String token) {
        if (token != null) {
            given()
                    .header("Authorization", token)
                    .delete(BASE_URL + DELETE_USER);

        }

    }
}

