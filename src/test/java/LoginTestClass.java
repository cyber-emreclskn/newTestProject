import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTestClass {
    private WebDriver driver;
    final static Logger logger = Logger.getLogger(LoginTestClass.class);
    private static String url = "http://127.0.0.1:5500/login.html";

    @Before
    public void setUp(){
        logger.info("Test Başladı.");
        System.setProperty("webdriver.chrome.driver","C:/newChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Duration duration = Duration.ofSeconds(5);
        driver.manage().timeouts().pageLoadTimeout(duration);
    }

    @Test
    public void loginTest(){
        driver.navigate().to(url);
        logger.info("Test Edilecek Sayfa : " + driver.getTitle());
        driver.findElement(By.id("username")).sendKeys("asdgasd");
        driver.findElement(By.id("password")).sendKeys("asdasdf");
        logger.info("Test 1 Tamamlandı");
        String actResult = "Kullanıcı Girişi";
        //Assert.assertEquals(actResult,driver.getTitle());
    }

    @After
    public void tearDown(){
        driver.quit();
        logger.info("Test Bitti");
    }
}
