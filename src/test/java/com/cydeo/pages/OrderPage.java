package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "product")
    public WebElement productDropdown;


    @FindBy(name = "quantity")
    public WebElement quantityBox;

    @FindBy(name = "name")
    public WebElement customerNameBox;


    @FindBy(name = "street")
    public WebElement streetBox;


    @FindBy(name = "city")
    public WebElement cityBox;


    @FindBy(name = "state")
    public WebElement stateBox;

    @FindBy(name = "zip")
    public WebElement zipBox;

    @FindBy(name = "card")
    public List <WebElement> cardType;

    @FindBy(name = "cardNo")
    public WebElement cardNoBox;

    @FindBy(name = "cardExp")
    public WebElement cardExpBox;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;











}
