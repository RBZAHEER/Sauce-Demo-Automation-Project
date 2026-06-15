    package org.example.base;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.example.utils.ConfigReader;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;

    import java.io.FileNotFoundException;
    import java.util.HashMap;
    import java.util.Map;

    public class BaseTest {

        public WebDriver driver;
        WebDriverWait wait;

        @BeforeMethod
        public void setup() throws FileNotFoundException {
            String browser = ConfigReader.getProperty("browser");
            if(browser.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put(
                        "profile.password_manager_enabled",
                        false
                );
                prefs.put(
                        "profile.password_manager_leak_detection",
                        false
                );

                co.setExperimentalOption(
                        "prefs",
                        prefs
                );

                driver = new ChromeDriver(co);


            } else if (browser.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equals("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else{
                throw new RuntimeException("Invalid browser name :(");
            }
            driver.manage().window().maximize();
            driver.get(ConfigReader.getProperty("url"));
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }
