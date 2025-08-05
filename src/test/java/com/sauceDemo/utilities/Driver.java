package com.sauceDemo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
                    break;
                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS does not support Edge");
                    }
                    driver = new EdgeDriver();
                    break;

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
