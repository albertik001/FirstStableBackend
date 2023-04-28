package com.example.testbackendone.dataparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public List<String> parseDataWithSelenium(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        List<WebElement> articleTitles = driver.findElements(By.cssSelector("h2.entry-title > a"));
        List<String> parsedData = new ArrayList<>();

        for (WebElement articleTitle : articleTitles) {
            parsedData.add(articleTitle.getText());
        }

        driver.quit();
        return parsedData;
    }


    public List<String> parseData(String url, String cssSelector) {
        List<String> result = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select(cssSelector);

            for (Element element : elements) {
                result.add(element.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
