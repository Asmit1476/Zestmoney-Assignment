package com.FbUtils.utils;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.Platform;

import java.io.File;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import java.util.HashMap;

public class InitiateDriver {

    private RemoteWebDriver driver;
    private HashMap<String,String> getProperties;



    public InitiateDriver()
    {
        try
        {
            getProperties = PropertyReader.getPropValues("config.properties");
            String runOn = System.getProperty("runOn") == null ? getProperties.get("RUN_ON") : System.getProperty("runOn");
            String platform = System.getProperty("platform") == null ? getProperties.get("PLATFORM") : System.getProperty("platform");
            String url = System.getProperty("url") == null ? getProperties.get("SELENIUMSERVERURL") : System.getProperty("url");
            String mUrl =System.getProperty("mUrl") == null ? getProperties.get("mURL") : System.getProperty("mUrl");

            String browser = null;

            if(platform.equalsIgnoreCase("WINDOWS"))
            {
                if (runOn.equalsIgnoreCase("WEBSITE"))
                {
                    browser = System.getProperty("browser") == null ? getProperties.get("BROWSER") : System.getProperty("browser");
                    System.out.println(url);
                    driver = new RemoteWebDriver(new URL(url), getBrowserCapabilities(browser, runOn));
                    System.out.println("Driver is: "+driver);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                }
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public RemoteWebDriver getDriver()
    {
        if(driver==null)
            throw new RuntimeException("Driver has not been Instantiated");

        return driver;
    }



    private DesiredCapabilities getBrowserCapabilities(String browser, String runOn)
    {
        DesiredCapabilities capabilities = null;
        String appName = System.getProperty("appName") == null ? getProperties.get("AppName") : System.getProperty("appName");
        String appPath =System.getProperty("appPath") == null ? getProperties.get("AppPath") : System.getProperty("appPath");

        try
        {
            if (runOn.equalsIgnoreCase("WEBSITE") && browser.equalsIgnoreCase("Firefox"))
            {

                System.setProperty("webdriver.gecko.driver","C:\\webdriver\\geckodriver-v0.20.1-win64\\geckodriver.exe");

                capabilities = DesiredCapabilities.firefox();

                capabilities.setCapability("firefox_binary",
                        new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe").
                                getAbsolutePath());

                capabilities.setCapability("marionette",true);

                FirefoxOptions options = new FirefoxOptions();
                WebDriver driver = new FirefoxDriver(options);



                capabilities.setBrowserName("firefox");

                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setPlatform(Platform.ANY);


            }

            else if (runOn.equalsIgnoreCase("WEBSITE") && browser.equalsIgnoreCase("Chrome"))
            {



                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                
                capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                        UnexpectedAlertBehaviour.IGNORE);
                 options.addArguments("--disable-notifications");
                 
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("–no-sandbox");

                capabilities.setBrowserName("chrome");

                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setPlatform(Platform.ANY);
            }

            else
            {
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(Platform.ANY);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return capabilities;
    }
}
