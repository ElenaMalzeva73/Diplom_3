package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import static constant.Constant.*;



public class WebDriverFactopy {
    public static WebDriver createDriver() {

        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }
        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }
        private static WebDriver createChromeDriver() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(options);
        }
        private static WebDriver createYandexDriver() {
            System.setProperty("webdriver.chrome.driver",CHROMEDRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            return new ChromeDriver(options);
        }
    }



