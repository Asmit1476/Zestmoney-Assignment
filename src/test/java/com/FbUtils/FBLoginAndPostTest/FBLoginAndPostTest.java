package com.FbUtils.FBLoginAndPostTest;

import com.FbUtils.Pages;
import com.FbUtils.TestBase;
import com.FbUtils.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class FBLoginAndPostTest extends TestBase{
    private HashMap<String,String> getCredentialsProperties;

    FBLoginAndPostTest()
    {
        getCredentialsProperties = PropertyReader.getPropValues("credentials.properties");
    }

    @Test
    public  void verifyFBLoginPage()
    {
        Pages.FBLoginAndPost().enter_Email(getCredentialsProperties.get("EMAIL"));
        Pages.FBLoginAndPost().enter_password(getCredentialsProperties.get("PASSWORD"));
        Pages.FBLoginAndPost().click_Login_Button();
        Assert.assertTrue(Pages.FBLoginAndPost().myFirstPost());



    }

}
