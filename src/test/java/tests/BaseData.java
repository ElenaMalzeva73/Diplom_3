package tests;
import java.util.concurrent.TimeUnit;
import data.User;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import data.CreateUser;
import pageobject.MainPage;
import static data.WebDriverFactopy.createDriver;


public class BaseData {

    WebDriver webDriver;
    public CreateUser createUser;
    public User user;
    public MainPage mainPage;
    public String token;

    @Before
    public void setUp() {
       webDriver = createDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.inputPageStellarBurgers();

    }

    @After
    public void tearDown() {
        createUser.userDelete(token);
        webDriver.quit();
    }
}



