package org.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
下载谷歌驱动“chromedriver.exe”
下载地址：https://npm.taobao.org/mirrors/chromedriver/
java+selenium元素定位和元素操作
https://www.cnblogs.com/peachh/p/9740001.html

   driver.get(Url);//启动浏览器打开url
   driver.manage().window().maximize(); //浏览器最大化
　　driver.navigate().to("http://www.baidu.com"); //打开百度
　　driver.navigate().refresh();//刷新浏览器
　　driver.navigate().back();//浏览器后退
　　driver.navigate().forward();//浏览器前进
　　driver.close();//关闭当前页面
　　driver.quit();//关闭所有窗口

    getText(): 获取元素的visible内嵌文字。
    getAttribute(String name)：获取元素中名为name的属性的值。
      <input attr1='a'>foo</input>
    getAttribute(attr1) 你得到’a’
    getText() 没有参数，你只能得到’foo’
* */
public class seleniumDemo {
    private static final Logger logger = LogManager.getLogger(seleniumDemo.class);

    public static void main(String[] args) throws InterruptedException {
//        testSelenium();
        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.error("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");
    }

    public static String testSelenium() throws InterruptedException {
        String re;
        System.setProperty("webdriver.chrome.driver", "/Users/captain/Downloads/pkg/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "http://www.baidu.com";
        driver.get(url);
        driver.findElement(By.id("kw")).sendKeys("渣男");
        driver.findElement(By.id("su")).click();
        Thread.sleep(3);
        re = driver.findElement(By.xpath("//*[@id=\"u\"]/a[3]")).getAttribute("href");
        Thread.sleep(3000);
        driver.close();
        driver.quit();
        return re;
    }
}
