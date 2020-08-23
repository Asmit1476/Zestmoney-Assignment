package com.FBLoginAndPost;

import com.FbUtils.utils.ObjectsBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class FBLoginAndPost_ObjectRepository extends ObjectsBase {

    public FBLoginAndPost_ObjectRepository(RemoteWebDriver driver){super(driver);}

    @FindBy(xpath = "//input[@placeholder='Email address or phone number']") static protected WebElement emailId;

    @FindBy(xpath = "//input[@placeholder='Password']") static protected WebElement password;

    @FindBy(xpath = "//button[text()='Log In' or @name='login']") static protected WebElement clickloginbutton;

    @FindBy(xpath = "//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7' or contains(@xpath,'1')]") static protected WebElement post;
    @FindBy(xpath = "//div[@class='rq0escxv datstx6m k4urcfbm a8c37x1j']//div[@class='_5rp7']//div[@class='_5rpb']//div[@class='notranslate _5rpu']//div//div//div[@class='_1mf _1mj']") static protected WebElement post_Area;

    @FindBy(xpath = "//div[text()='Post']") static protected WebElement post_button;

    @FindBy(xpath = "//i[@class='hu5pjgll lzf7d6o1 sp_Osp8PMBw1xR_1_5x sx_c81236']") static protected WebElement post_Type;

    @FindBy(xpath = "//i[@class='hu5pjgll m6k467ps sp_Osp8PMBw1xR_1_5x sx_a46db8']") static protected WebElement onlyMe_PostType;
}
