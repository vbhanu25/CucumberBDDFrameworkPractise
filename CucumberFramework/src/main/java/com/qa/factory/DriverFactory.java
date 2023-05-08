package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;
    // To execute parellel mode
    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_Browser(String browser){
        System.out.println(browser + "Got initialized ");
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());
        } else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            tldriver.set(new EdgeDriver());
        }else if(browser.equalsIgnoreCase("safari")){
            WebDriverManager.firefoxdriver().setup();
            tldriver.set(new FirefoxDriver());
        } else{
            System.out.println(browser + "not recognized ");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized  WebDriver getDriver(){
        return tldriver.get();
    }
}
