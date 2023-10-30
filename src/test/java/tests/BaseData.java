package tests;
import java.util.concurrent.TimeUnit;
import data.User;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import data.CreateUser;
import pageobject.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseData {
    protected WebDriver webDriver;
    public CreateUser createUser;
     public User user;
    public MainPage mainPage;
    public String token;
    @Before
    public void setUp() {
        //Yandex browser
        /*System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\User\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);*/
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
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

