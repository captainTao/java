package work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    private final String username;
    private final String userpassword;

    public App(String name, String password){
        this.username = name;
        this.userpassword = password;
    }

    private static final Logger logger = LogManager.getLogger(App.class);

    public String selenium() throws InterruptedException {
        logger.info("=================程序开始运行=================");
        String re;
        logger.debug("启动chromedriver");
        System.setProperty("webdriver.chrome.driver", "/Users/captain/Downloads/pkg/chromedriver");
        WebDriver driver = new ChromeDriver();
        logger.debug("发送请求");
        String url = "https://login.sina.com.cn/signup/signin.php";
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(this.username);
        driver.findElement(By.id("password")).sendKeys(this.userpassword);
        driver.findElement(By.className("btn_mod")).click();
        driver.findElement(By.xpath("//*[@id=\"vForm\"]/div[2]/div/ul/li[7]/div[1]/input")).click();
        Thread.sleep(3000);
        logger.debug("找寻结果类判断");
        re = driver.findElement(By.id("message_sms_login")).getText();
        driver.close();
        logger.info("=================程序结束运行=================");
        return re;
    }
}
