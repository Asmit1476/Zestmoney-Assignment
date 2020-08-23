package com.FbUtils;


import com.FbUtils.utils.Base;
import com.FbUtils.utils.InitiateDriver;
import com.FbUtils.utils.PropertyReader;
import org.openqa.selenium.remote.RemoteWebDriver;
import  org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.yandex.qatools.allure.annotations.Attachment;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;



public class TestBase implements IHookable {
    protected static RemoteWebDriver driver;
    public static HashMap<String,String> configProperties;
    public static HashMap<String,String> credentialsProperties;
    public static HashMap<String,String> getCredentialsProperties;




    public TestBase() {
        configProperties = PropertyReader.getPropValues("config.properties");
        credentialsProperties = PropertyReader.getPropValues("credentials.properties");
        getCredentialsProperties = PropertyReader.getPropValues("credentials.properties");

    }



    @BeforeTest(alwaysRun=true)
    public void setup()
    {
        String url = configProperties.get("URL");
        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        Base.driver = driver;
        System.out.println(url);
        driver.get(url);

    }



    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {

        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
//            try {
//                //takeScreenShot(testResult.getMethod().getMethodName());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    // Attach Screenshots taken to Allure report
    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName) throws IOException {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterTest(alwaysRun = true)
    public void teardownAndTakeScreenShot()
    {
        driver.quit();
    }

    public void sleep(int duration)
    {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(new Duration(duration, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
