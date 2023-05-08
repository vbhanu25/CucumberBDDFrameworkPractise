package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    private By homeBoxHeaders = By.xpath("//*[@class='homeBoxHeader']");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public int getTechnologiesCount(){
        return driver.findElements(homeBoxHeaders).size();
    }

    public List<String> getHomePageHeaderName(){
        List<String> pageBoxlist = new ArrayList<>();
        List<WebElement> pageHeaderList = driver.findElements(homeBoxHeaders);
        for(WebElement e : pageHeaderList){
            String text = e.getText();
            System.out.println("technologies avilable in the page" + text);
            pageBoxlist.add(text);
        }
        return pageBoxlist;
    }
}
