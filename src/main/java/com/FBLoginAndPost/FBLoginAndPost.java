package com.FBLoginAndPost;

import com.FbUtils.utils.Base;

import java.util.NoSuchElementException;

public class FBLoginAndPost extends Base {

    private static FBLoginAndPost_ObjectRepository fbl;

    public FBLoginAndPost(){fbl = new FBLoginAndPost_ObjectRepository(driver);}

    public boolean enter_Email(String str) {
        try {

            if (FBLoginAndPost_ObjectRepository.emailId.isDisplayed() || FBLoginAndPost_ObjectRepository.emailId.isEnabled()) {
                FBLoginAndPost_ObjectRepository.emailId.clear();
                FBLoginAndPost_ObjectRepository.emailId.sendKeys(str);
                System.out.println(" CORRECT---------------->Email Id Entered is: " + FBLoginAndPost_ObjectRepository.emailId);
                return true;
            } else {
                System.out.println("INCORRECT -X-> Email Id Not Found");
                return false;
            }
        } catch (NoSuchElementException ignored) {
            System.out.println("INCORRECT---- X-->Not Found");
            return false;
        }
    }


    public boolean enter_password(String str){
        try{
            if(FBLoginAndPost_ObjectRepository.password.isDisplayed() || FBLoginAndPost_ObjectRepository.password.isEnabled()){
                FBLoginAndPost_ObjectRepository.password.clear();
                FBLoginAndPost_ObjectRepository.password.sendKeys(str);
                System.out.println("CORRECT---------- Password Entered is: "+ FBLoginAndPost_ObjectRepository.password);
                return true;
            } else{
                System.out.println("INcorrect----- X-> Password Field Not Found");
                return false;
            }
        } catch (NoSuchElementException e){
            System.out.println("INCORRECT--------X-> Not Found");
            return false;
        }


    }


    public Boolean click_Login_Button()
    {
        try
        {
            if (FBLoginAndPost_ObjectRepository.clickloginbutton.isDisplayed() || (FBLoginAndPost_ObjectRepository.clickloginbutton.isEnabled()))
            {

                FBLoginAndPost_ObjectRepository.clickloginbutton.click();
                Thread.sleep(10000);
                System.out.println("Login Button Displayed and Clicked");
                System.out.println("LOGIN Successfully-------------");
                sleep(10000);

            }
            else
            {
                System.out.println("Email Id Not Found");
            }

        }
        catch (Exception e)
        {
            System.out.println("Login Button Not Found");

        }
        return null;

    }

    public boolean myFirstPost(){

        if(isElementVisible(FBLoginAndPost_ObjectRepository.post)){

            FBLoginAndPost_ObjectRepository.post.click();
            waitUntilElementIsVisible(FBLoginAndPost_ObjectRepository.post_Area);
            FBLoginAndPost_ObjectRepository.post_Area.sendKeys("Hello World");
            isElementVisible(FBLoginAndPost_ObjectRepository.post_button);
            FBLoginAndPost_ObjectRepository.post_button.click();

        }
        return true;
    }

}
