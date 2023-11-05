package data;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User randomUser(){
        return new User()
                .withEmail(RandomStringUtils.randomAlphabetic(8) + "@gmail.com")
                .withPassword(RandomStringUtils.randomAlphabetic(10))
                .withName(RandomStringUtils.randomAlphabetic(7));
    }
    public static User randomUserNoValidDate(){
        return new User()
                .withEmail(RandomStringUtils.randomAlphabetic(8) + "@gmail.com")
                .withPassword(RandomStringUtils.randomAlphabetic(5))
                .withName(RandomStringUtils.randomAlphabetic(8));
    }
}
